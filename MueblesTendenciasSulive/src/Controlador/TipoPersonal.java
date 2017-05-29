/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author ALEJANDRO
 */
public class TipoPersonal {
    
    private int idTipoPersonal;
    private String tipoPersonal;
    
     public TipoPersonal(){
        
    }

    public void setIdTipPer(int idTipoPersonal) {
        this.idTipoPersonal = idTipoPersonal;
    }

    public void setTipPer(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }
    
    public int getIdTipPer(){
        return this.idTipoPersonal;
    }
    public String getTipPer(){
        return this.tipoPersonal;
    }
}
