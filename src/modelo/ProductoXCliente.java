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
public class ProductoXCliente {
    private int id;
    private Producto producto;
    private Cliente cliente;
    private int cantidadAdquirida;

    public ProductoXCliente(Producto producto, Cliente cliente,
            int cantidadAdquirida) {
        this.producto = producto;
        this.cliente = cliente;
        this.cantidadAdquirida = cantidadAdquirida;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
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
     * @return the cantidadAdquirida
     */
    public int getCantidadAdquirida() {
        return cantidadAdquirida;
    }

    /**
     * @param cantidadAdquirida the cantidadAdquirida to set
     */
    public void setCantidadAdquirida(int cantidadAdquirida) {
        this.cantidadAdquirida = cantidadAdquirida;
    }

}
