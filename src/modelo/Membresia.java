/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;

/**
 *
 * @author pseudocfoch
 */
public class Membresia {
    private int dni;
    private int freezingMaximo;
    private String descripcion;
    private int diasMembresia;
    private BigDecimal precio;

    public Membresia(int freezingMaximo, String descripcion,
            int diasMembresia) {
        this.freezingMaximo = freezingMaximo;
        this.descripcion = descripcion;
        this.diasMembresia = diasMembresia;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @return the freezingMaximo
     */
    public int getFreezingMaximo() {
        return freezingMaximo;
    }

    /**
     * @param freezingMaximo the freezingMaximo to set
     */
    public void setFreezingMaximo(int freezingMaximo) {
        this.freezingMaximo = freezingMaximo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the diasMembresia
     */
    public int getDiasMembresia() {
        return diasMembresia;
    }

    /**
     * @param diasMembresia the diasMembresia to set
     */
    public void setDiasMembresia(int diasMembresia) {
        this.diasMembresia = diasMembresia;
    }    
}
