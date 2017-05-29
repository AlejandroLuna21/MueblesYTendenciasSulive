/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;



import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;


/**
 *
 * @author ALEJANDRO
 */
public class VentanaPersonal extends JInternalFrame {
    
    private PersonalGuardar p1;
    private PersonalModificar p2;
    private PersonalEliminar p3;
    
    private JTabbedPane pestanas;
    
    public VentanaPersonal() {
        super();
        configurarVentana();
        inicializarComponentes();
    }
    
    private void configurarVentana() {
        this.setTitle("PERSONAL DE LA EMPRESA");
        this.setSize(1920, 1080);
//        this.setLocationRelativeTo(null);
//        this.setLayout(null);    //no permite mostrar las pestanas, no se por que???

//        this.setLocation(400, 60);
        this.setClosable(true);
//        this.setMaximizable(true);
        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes() {
        p1 = new PersonalGuardar();
        p2 = new PersonalModificar();
        p3 = new PersonalEliminar();
        pestanas = new JTabbedPane();
        
        pestanas.add("Guardar", p1);
        pestanas.add("Modificar", p2);
        pestanas.add("Eliminar", p3);
        
        this.add(pestanas);
        
    }
}
