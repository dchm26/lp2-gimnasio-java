/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author pseudocfoch
 */
public class Rol {

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    private int id;
    private String nombre;
    private List<Permiso> permisos;

    public Rol(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarPermiso(Permiso permiso) {
        if (this.tienePermiso(permiso))
            this.agregarPermiso(permiso);
    }
    
    public void borrarPermiso(Permiso permiso) {
        Permiso objetivo;
        objetivo = this.filtrarPermiso(permiso);
        if (objetivo != null)
            this.permisos.remove(objetivo);
    }
    
    public boolean tienePermiso(Permiso permiso) {
        return filtrarPermiso(permiso) != null;
    }

    private Permiso filtrarPermiso(Permiso permiso) {
        Permiso ret;

        ret = this.permisos.stream()
            .filter(p -> p.getId() == permiso.getId())
            .findAny()
            .orElse(null);

        return ret;
    }    
}
