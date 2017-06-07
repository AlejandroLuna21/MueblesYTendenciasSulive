/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEJANDRO
 */
public class VentanaPedido extends JInternalFrame implements ActionListener{

    private JPanel jpBtn;
    private JButton btnSave;
    private JButton btnModify;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnUpdate;

    private JPanel jpTable;
    private JTextField txtBuscar;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;

    private JPanel jpLblyTxt;
    private JLabel lblTitulo;
    private JLabel lblMueble;
    private JLabel lblTipoM;
    private JLabel lblCant;
    private JLabel lblDesc;
    private JLabel lblEstado;
    private JLabel lblFP;
    private JLabel lblFE;
    private JLabel lblCliente;
    private JLabel lblPersonal;
    private JComboBox cbxMueble;
    private JComboBox cbxTipoM;
    private JTextField txtCant;
    private JTextField txtDesc;
    private JComboBox cbxEstado;
    private JDateChooser dateFP;
    private JDateChooser dateFE;
    private JComboBox cbxCliente;
    private JComboBox cbxPersonal;

    private ArrayList<Integer> idMueble;
    private ArrayList<Integer> idTipoM;
    private ArrayList<Integer> idCliente;
    private ArrayList<Integer> idPersonal;
    
    private Conexion cn;
    private Connection conn;
    private Statement stm;
    private ResultSet rs;

    public VentanaPedido() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("P E D I D O");
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setClosable(true);
        this.setBackground(Color.darkGray);
        this.setResizable(false);
    }

    private void inicializarComponentes() {
        jpBtn = new JPanel();
        jpBtn.setBackground(Color.LIGHT_GRAY);
        jpBtn.setBounds(1390, 15, 500, 965);
        jpBtn.setLayout(null);
        btnSave = new JButton();
        btnSave.setText("G U A R D A R");
        btnSave.setBounds(10, 50, 480, 100);
        btnSave.addActionListener(this);
        jpBtn.add(btnSave);
        btnSearch = new JButton();
        btnSearch.setText("B U S C A R");
        btnSearch.setBounds(10, 200, 480, 100);
        jpBtn.add(btnSearch);
        btnModify = new JButton();
        btnModify.setText("M O D I F I C A R");
        btnModify.setBounds(10, 350, 480, 100);
        jpBtn.add(btnModify);
        btnUpdate = new JButton();
        btnUpdate.setText("A C T U A L I Z A R");
        btnUpdate.setBounds(10, 500, 480, 100);
        jpBtn.add(btnUpdate);
        btnDelete = new JButton();
        btnDelete.setText("E L I M I N A R");
        btnDelete.setBounds(10, 650, 480, 100);
        jpBtn.add(btnDelete);
        this.add(jpBtn);

        jpTable = new JPanel();
        jpTable.setBackground(Color.LIGHT_GRAY);
        jpTable.setBounds(15, 15, 1350, 465);
        jpTable.setLayout(null);

        txtBuscar = new JTextField();
        txtBuscar.setBorder(BorderFactory.createTitledBorder("ingrese el nombre del cliente del que quiere ver sus pedidos:"));
        txtBuscar.setBounds(250, 20, 900, 60);
        jpTable.add(txtBuscar);
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Mueble");
        modelo.addColumn("Tipo de Material");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Estado");
        tabla = new JTable(modelo);
        scroll = new JScrollPane(tabla);
        scroll.setBounds(250, 80, 900, 350);
        jpTable.add(scroll);

        this.add(jpTable);

        jpLblyTxt = new JPanel();
        jpLblyTxt.setBackground(Color.LIGHT_GRAY);
        jpLblyTxt.setBounds(15, 500, 1350, 477);
        jpLblyTxt.setLayout(null);
        lblTitulo = new JLabel();
        lblTitulo.setText("Registro de Pedido:");
        lblTitulo.setBounds(50, 10, 130, 25);
        jpLblyTxt.add(lblTitulo);
        lblMueble = new JLabel();
        lblMueble.setText("Mueble:");
        lblMueble.setBounds(110, 70, 100, 25);
        jpLblyTxt.add(lblMueble);
        lblTipoM = new JLabel();
        lblTipoM.setText("Tipo De Material");
        lblTipoM.setBounds(110, 150, 100, 25);
        jpLblyTxt.add(lblTipoM);
        lblCant = new JLabel();
        lblCant.setText("Cantidad:");
        lblCant.setBounds(110, 215, 100, 25);
        jpLblyTxt.add(lblCant);
        lblDesc = new JLabel();
        lblDesc.setText("Descripcion:");
        lblDesc.setBounds(110, 280, 100, 25);
        jpLblyTxt.add(lblDesc);
        lblEstado = new JLabel();
        lblEstado.setText("Estado:");
        lblEstado.setBounds(110, 350, 100, 25);
        jpLblyTxt.add(lblEstado);
        lblFP = new JLabel();
        lblFP.setText("Fecha de Pedido:");
        lblFP.setBounds(700, 70, 130, 25);
        jpLblyTxt.add(lblFP);
        lblFE = new JLabel();
        lblFE.setText("Fecha de Entrega:");
        lblFE.setBounds(700, 150, 130, 25);
        jpLblyTxt.add(lblFE);
        lblCliente = new JLabel();
        lblCliente.setText("Cliente:");
        lblCliente.setBounds(700, 225, 100, 25);
        jpLblyTxt.add(lblCliente);
        lblPersonal = new JLabel();
        lblPersonal.setText("Personal:");
        lblPersonal.setBounds(700, 315, 100, 25);
        jpLblyTxt.add(lblPersonal);

        cbxMueble = new JComboBox();
        cbxMueble.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxMueble.setBounds(250, 50, 240, 60);
        jpLblyTxt.add(cbxMueble);
        setCbxMueble();
        cbxMueble.setSelectedItem(null);
        cbxTipoM = new JComboBox();
        cbxTipoM.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxTipoM.setBounds(250, 130, 240, 60);
        jpLblyTxt.add(cbxTipoM);
        setCbxTipoM();
        cbxTipoM.setSelectedItem(null);
        txtCant = new JTextField();
        txtCant.setBounds(250, 210, 240, 40);
        jpLblyTxt.add(txtCant);
        txtDesc = new JTextField();
        txtDesc.setBounds(250, 270, 240, 40);
        jpLblyTxt.add(txtDesc);
        cbxEstado = new JComboBox();
        cbxEstado.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxEstado.addItem("Entregado");
        cbxEstado.addItem("No Entregado");
        cbxEstado.setBounds(250, 335, 240, 60);
        jpLblyTxt.add(cbxEstado);
        cbxEstado.setSelectedItem(null);
        dateFP = new JDateChooser();
        dateFP.setBounds(840, 60, 240, 35);
        jpLblyTxt.add(dateFP);
        dateFE = new JDateChooser();
        dateFE.setBounds(840, 140, 240, 40);
        jpLblyTxt.add(dateFE);
        cbxCliente = new JComboBox();
        cbxCliente.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxCliente.setBounds(840, 210, 240, 60);
        jpLblyTxt.add(cbxCliente);
        setCbxCliente();
        cbxCliente.setSelectedItem(null);
        cbxPersonal = new JComboBox();
        cbxPersonal.setBorder(BorderFactory.createTitledBorder("Seleccione un Opcion:"));
        cbxPersonal.setBounds(840, 300, 240, 60);
        jpLblyTxt.add(cbxPersonal);
        setCbxPersonal();
        cbxPersonal.setSelectedItem(null);
        this.add(jpLblyTxt);

    }

    public void setCbxMueble() {
        idMueble = new ArrayList<>();
        try {
            cn = new Conexion();
            conn = cn.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM mueble");
            while (rs.next()){
                idMueble.add(rs.getInt(1));
                cbxMueble.addItem(rs.getString(2));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
    public void setCbxTipoM() {
        idTipoM = new ArrayList<>();
        try {
            cn = new Conexion();
            conn = cn.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM tipo_material");
            while (rs.next()){
                idTipoM.add(rs.getInt(1));
                cbxTipoM.addItem(rs.getString(2));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
     public void setCbxCliente() {
         idCliente = new ArrayList<>();
        try {
            cn = new Conexion();
            conn = cn.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM cliente");
            while (rs.next()){
                idCliente.add(rs.getInt(1));
                cbxCliente.addItem(rs.getString(2)+" "+rs.getNString(3)+" "+rs.getString(4));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
      public void setCbxPersonal() {
          idPersonal = new ArrayList<>();
        try {
            cn = new Conexion();
            conn = cn.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM personal WHERE id_tipo_personal=2");
            while (rs.next()){
                idPersonal.add(rs.getInt(1));
                cbxPersonal.addItem(rs.getString(2)+" "+rs.getNString(3)+" "+rs.getString(4));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== btnSave){
//            for( int dato :idPersonal){
//                System.out.println(dato);
//            }
        }
    }
}
