/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import java.awt.event.ActionListener;

/**
 *
 * @author pseudocfoch
 */
public interface IVista <T> {
    public void agregarControlador(ActionListener controlador);
}
