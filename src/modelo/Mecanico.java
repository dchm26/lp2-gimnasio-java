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
public class Mecanico extends Empleado {
    private List<Maquina> maquinas;

    public void asignarMaquina(Maquina maquina) {
        if (this.filtrarMaquina(maquina) == null)
            this.maquinas.add(maquina);
    }
    
    public void quitarMaquina(Maquina maquina) {
        Maquina objetivo;
        objetivo = this.filtrarMaquina(maquina);
        if (objetivo != null)
            this.maquinas.remove(objetivo);
    }
    
    private Maquina filtrarMaquina(Maquina maquina) {
        Maquina ret;
        ret = this.maquinas.stream()
                .filter(m -> m.getId() == maquina.getId())
                .findAny()
                .orElse(null);
        return ret;
    }
}
