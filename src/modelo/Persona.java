/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

/**
 *
 * @author pseudocfoch
 */
public class Persona extends Observable {
    private int id;
    private int dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String email;
    private String distrito;
    private Date fechaNacimiento;
    private String telefono;
    private String contrasena;
    private Sede sede;
    private List<Rol> roles;

    public Persona() {
        this.sede = null;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
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

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the distrito
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distrito to set
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the sede
     */
    public Sede getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    
    public void agregarRol(Rol rol) {
        if (this.filtrarRol(rol) == null)
            this.roles.add(rol);
    }
    
    public void quitarRol (Rol rol) {
        Rol objetivo;
        objetivo = this.filtrarRol(rol);
        this.roles.remove(objetivo);
    }
    
    private Rol filtrarRol (Rol rol) {
        Rol ret;
        ret = this.roles.stream()
                .filter(r -> r.getNombre() == rol.getNombre())
                .findAny()
                .orElse(null);
        return ret;
    }
    
    private Rol filtrarRolPorNombre (String rol) {
        Rol ret;
        ret = this.roles.stream()
                .filter(r -> r.getNombre().equals(rol))
                .findAny()
                .orElse(null);
        return ret;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = sha256Hex(contrasena);
    }
    
    public void setContrasenaEncriptada(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public boolean compararContrasena(String contrasena) {
        String contrasenaEntriptada;
        contrasenaEntriptada = sha256Hex(contrasena);
        return this.contrasena.equals(contrasenaEntriptada);
    }

    public boolean compararContrasenaEncriptada(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
}
