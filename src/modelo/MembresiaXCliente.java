/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author pseudocfoch
 */
public class MembresiaXCliente {
    private int id;
    private Cliente cliente;
    private Membresia membresia;
    private Date fechaInicioMembresia;
    private Date fechaFinMembresia;
    private int freezingRestante;
    private Date fechaCompra;

    public MembresiaXCliente(Cliente cliente, Membresia membresia,
            Date fechaInicioMembresia, Date fechaFinMembresia,
            int freezingRestante) {
        this.cliente = cliente;
        this.membresia = membresia;
        this.fechaInicioMembresia = fechaInicioMembresia;
        this.fechaFinMembresia = fechaFinMembresia;
        this.freezingRestante = freezingRestante;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the membresia
     */
    public Membresia getMembresia() {
        return membresia;
    }

    /**
     * @param membresia the membresia to set
     */
    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    /**
     * @return the fechaInicioMembresia
     */
    public Date getFechaInicioMembresia() {
        return fechaInicioMembresia;
    }

    /**
     * @param fechaInicioMembresia the fechaInicioMembresia to set
     */
    public void setFechaInicioMembresia(Date fechaInicioMembresia) {
        this.fechaInicioMembresia = fechaInicioMembresia;
    }

    /**
     * @return the fechaFinMembresia
     */
    public Date getFechaFinMembresia() {
        return fechaFinMembresia;
    }

    /**
     * @param fechaFinMembresia the fechaFinMembresia to set
     */
    public void setFechaFinMembresia(Date fechaFinMembresia) {
        this.fechaFinMembresia = fechaFinMembresia;
    }

    /**
     * @return the freezingRestante
     */
    public int getFreezingRestante() {
        return freezingRestante;
    }

    /**
     * @param freezingRestante the freezingRestante to set
     */
    public void setFreezingRestante(int freezingRestante) {
        this.freezingRestante = freezingRestante;
    }

    /**
     * @return the fechaCompra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
