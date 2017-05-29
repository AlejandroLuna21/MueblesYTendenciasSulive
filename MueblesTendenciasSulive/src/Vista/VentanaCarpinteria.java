/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEJANDRO
 */
public class VentanaCarpinteria extends JInternalFrame{
    
    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblTin;
    private JLabel lblAddress;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtTin;
    private JTextField txtAddress;
    private JButton btnSave;
    private JButton btnCancel;
    
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JPopupMenu pEmergente;
    private JMenuItem mI;
    private JScrollPane scroll;
    private JPanel contenedor;
    private JButton btnModificar;
    private JButton btnEliminar;
    
    private JLabel lblTitulo;
    private JLabel lblNom;
    private JLabel lblTelf;
    private JLabel lblNit;
    private JLabel lblDir;
    private JTextField txtNom;
    private JTextField txtTelf;
    private JTextField txtNit;
    private JTextField txtDir;
    private JButton btnActualizar;
    private JButton btnCancelar;
    
    
    public VentanaCarpinteria(){
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("C A R P I N T E R I A");
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setClosable(true);
        this.setResizable(false);
    }

    private void inicializarComponentes() {
        
        lblTitle = new JLabel();
        lblTitle.setText("Registrar Nueva Carpinteria:");
        lblTitle.setBounds(50, 50, 150, 25);
        this.add(lblTitle);
        lblName = new JLabel();
        lblName.setText("Nombre:");
        lblName.setBounds(100, 100, 100, 25);
        this.add(lblName);
        lblPhone = new JLabel();
        lblPhone.setText("Telefono:");
        lblPhone.setBounds(100, 150, 100, 25);
        this.add(lblPhone);
        lblTin = new JLabel();
        lblTin.setText("NIT:");
        lblTin.setBounds(100, 200, 100, 25);
        this.add(lblTin);
        lblAddress = new JLabel();
        lblAddress.setText("Direccion:");
        lblAddress.setBounds(100, 250, 130, 25);
        this.add(lblAddress);
        txtName = new JTextField();
        txtName.setBounds(250, 100, 200, 25);
        this.add(txtName);
//        txtFLN = new JTextField();
//        txtFLN.setBounds(250, 150, 200, 25);
//        this.add(txtFLN);
//        txtSLN = new JTextField();
//        txtSLN.setBounds(250, 200, 200, 25);
//        this.add(txtSLN);
//        txtIc = new JTextField();
//        txtIc.setBounds(250, 250, 200, 25);
//        this.add(txtIc);
//        btnSave = new JButton();
//        btnSave.setText("GUARDAR");
//        btnSave.setBounds(50, 300, 180, 50);
//        this.add(btnSave);
//        btnCancel = new JButton();
//        btnCancel.setText("CANCELAR");
//        btnCancel.setBounds(270, 300, 180, 50);
//        this.add(btnCancel);
        
    }
}
