/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author ALEJANDRO
 */
public class MenuPrincipal extends JFrame implements ActionListener {

    private JMenuBar mbPrincipal;

    private JMenu mOpciones;
    private JMenu mRPersona;
    private JMenu mRTransaccion;

    private JMenuItem miSalir;
    private JMenuItem miCerrarSecion;
    private JMenuItem miPersonal;
    private JMenuItem miCarpinteria;
    private JMenuItem miCliente;
    private JMenuItem miPedido;
    private JMenuItem miPedidoMade;

    private JDesktopPane contenedor;

    private VentanaPersonal vPersonal;
    private VentanaCliente vCliente;
    private VentanaCarpinteria vCarpinteria;
    public MenuPrincipal() {
        super();
        configurarVentana();
        inizializarcomponente();
    }

    private void configurarVentana() {
        this.setTitle("MUEBLES Y TENDENCIAS SULIVE");
//        this.setFont(new Font( "Helvetica", Font.BOLD, 40));
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inizializarcomponente() {
        mbPrincipal = new JMenuBar();
        this.setJMenuBar(mbPrincipal);

        contenedor = new JDesktopPane();
        contenedor.setBackground(Color.DARK_GRAY);
        this.setContentPane(contenedor);

        mOpciones = new JMenu("Opciones");
//        mOpciones.setIcon((Icon) new ImageIcon().getImage());
        miSalir = new JMenuItem("Salir");
//        miSalir.setIcon(getResource("/Imagenes/tools.png")));


        miCerrarSecion = new JMenuItem("Cerrar Cesion");
        mOpciones.add(miSalir);
        mOpciones.add(miCerrarSecion);
        mbPrincipal.add(mOpciones);

        mRPersona = new JMenu("Registrar Informacion");
        miPersonal = new JMenuItem("Registrar Personal");
        miPersonal.add(new JSeparator());
        miPersonal.addActionListener(this);
        miCarpinteria = new JMenuItem("Registrar Carpinteria");
        miCarpinteria.add(new JSeparator());
        miCarpinteria.addActionListener(this);
        miCliente = new JMenuItem("Registrar Cliente");
        miCliente.add(new JSeparator());
        miCliente.addActionListener(this);
        mRPersona.add(miPersonal);
        mRPersona.add(miCarpinteria);
        mRPersona.add(miCliente);
        mRPersona.add(new JSeparator());
        mbPrincipal.add(mRPersona);

        mRTransaccion = new JMenu("Registrar Transacciones");
        miPedido = new JMenuItem("Ingresar Pedido");
        miPedidoMade = new JMenuItem("Ingresar Pedido De Fabricacion");
        mRTransaccion.add(miPedido);
        mRTransaccion.add(miPedidoMade);
        mbPrincipal.add(mRTransaccion);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == miPersonal) {
                vPersonal = new VentanaPersonal();
                this.contenedor.add(vPersonal);
                vPersonal.show();
        }
        if (ae.getSource()== miCliente){
            vCliente = new VentanaCliente();
            this.contenedor.add(vCliente);
            vCliente.show();
        }
        if (ae.getSource()==miCarpinteria){
            vCarpinteria= new VentanaCarpinteria();
            this.contenedor.add(vCarpinteria);
            vCarpinteria.show();
            
        }
    }
}
