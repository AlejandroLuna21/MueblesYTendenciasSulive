/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JInternalFrame;

/**
 *
 * @author ALEJANDRO
 */
public class VentanaPedido extends JInternalFrame{
    
    
    public  VentanaPedido(){
        configurarVentana();
    }
    private void configurarVentana(){
        this.setTitle("P E D I D O");
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setClosable(true);
        this.setResizable(false);
    }
}
