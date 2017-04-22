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
public class ServicioXCliente {
    private int id;
    private Producto cliente;
    private Servicio servicio;
    private Date fechaCompra;

    public ServicioXCliente(Producto cliente, Servicio servicio, Date fechaCompra) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.fechaCompra = fechaCompra;
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
    public Producto getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Producto cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
