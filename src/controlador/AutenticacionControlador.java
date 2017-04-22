/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PersonaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Persona;
import vista.VentanaAutenticacion;

/**
 *
 * @author pseudocfoch
 */
public class AutenticacionControlador implements ActionListener {
    private VentanaAutenticacion vista;
    Persona persona;
    private boolean esperando;
    
    public AutenticacionControlador(VentanaAutenticacion ventana) {
        this.persona = null;
        this.esperando = true;
        this.vista = ventana;
    }

    public AutenticacionControlador() {
        this.persona = null;
        this.esperando = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd;
        cmd = e.getActionCommand();
        if (cmd.equals(VentanaAutenticacion.Action.ENTRAR_CLICKED)) {
            PersonaDAO personaDAO;
            Persona persona = null;
            int login;
            final int loginF;
            String contrasena;
            
            // TODO
            // Lo veo poco elegante
            try {
                login = Integer.parseInt(getVista().getLogin());
            } catch (NumberFormatException exception) {
                login = -1;
            }
            contrasena = getVista().getConstrasena();

            personaDAO = new PersonaDAO();

            loginF = login;
            persona = personaDAO.read(login);
            if (persona == null) {
                ArrayList<Persona> personas;
                personas = personaDAO.readAll();
                persona = personas.stream()
                        .filter(p -> p.getDni() == loginF)
                        .findAny()
                        .orElse(null);
            }

            if (persona != null && persona.compararContrasena(contrasena)) {
                this.vista.mostrarDialogoExito();
                this.getVista().setVisible(false);
            } else {
                this.vista.mostrarDialogoError();
            }
        }
    }

    /**
     * @return the esperando
     */
    public boolean isEsperando() {
        return esperando;
    }

    /**
     * @param esperando the esperando to set
     */
    public void setEsperando(boolean esperando) {
        this.esperando = esperando;
    }

    /**
     * @return the vista
     */
    public VentanaAutenticacion getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(VentanaAutenticacion vista) {
        this.vista = vista;
    }
}
