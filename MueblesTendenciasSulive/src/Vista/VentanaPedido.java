/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Pedido;
import Modelo.Conexion;
import Modelo.MetodoPedido;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
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
public class VentanaPedido extends JInternalFrame implements ActionListener {

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
    private int anio;
    private int mes;
    private int dia;
    private Object[] datos;

    private Pedido p;
    private MetodoPedido mp;

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
        btnSearch.addActionListener(this);
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
        mostrarDatos(null);
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
        cbxEstado.addItem("No Entregado");
        cbxEstado.addItem("Entregado");
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
                idCliente.add(rs.getInt(1));
                cbxCliente.addItem(rs.getString(2) + " " + rs.getNString(3) + " " + rs.getString(4));
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
            while (rs.next()) {
                idPersonal.add(rs.getInt(1));
                cbxPersonal.addItem(rs.getString(2) + " " + rs.getNString(3) + " " + rs.getString(4));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    public void getData() {
        p = new Pedido();
        mp = new MetodoPedido();
        try {
            p.setIdMueble(idMueble.get(cbxMueble.getSelectedIndex()));
            p.setIdTipoMat(idTipoM.get(cbxTipoM.getSelectedIndex()));
            p.setCatidad(Integer.parseInt(txtCant.getText()));
            p.setDescri(txtDesc.getText());
            p.setEstado(cbxEstado.getSelectedIndex());
            anio = dateFP.getCalendar().get(Calendar.YEAR);
            mes = dateFP.getCalendar().get(Calendar.MONTH);
            dia = dateFP.getCalendar().get(Calendar.DAY_OF_MONTH);
            p.setFechaP(anio + "-" + (mes + 1) + "-" + dia);
            anio = dateFE.getCalendar().get(Calendar.YEAR);
            mes = dateFE.getCalendar().get(Calendar.MONTH);
            dia = dateFE.getCalendar().get(Calendar.DAY_OF_MONTH);
            p.setFechaE(anio + "-" + (mes + 1) + "-" + dia);
            p.setIdCli(idCliente.get(cbxCliente.getSelectedIndex()));
            p.setIdPer(idPersonal.get(cbxPersonal.getSelectedIndex()));

            mp.dataSave(p);
            System.out.println("Se Guardo Correctamente los Datos");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }
    }

    public void mostrarDatos(String nombreCli) {
        cn = new Conexion();
        conn = cn.getConnection();
        String consulta;
        if (nombreCli == null) {
            consulta = "SELECT cliente.nombre_cliente,cliente.apellido_paterno,cliente.apellido_materno,mueble.nombre,tipo_material.tipo_material,cantidad,estado FROM cliente\n"
                    + "INNER JOIN pedido ON (cliente.id_cliente=pedido.id_cliente)\n"
                    + "INNER JOIN mueble ON (pedido.id_mueble=mueble.id_mueble)\n"
                    + "INNER JOIN tipo_material ON (pedido.id_tipo_material=tipo_material.id_tipo_material)";
        } else {
            consulta = "SELECT cliente.nombre_cliente,cliente.apellido_paterno,cliente.apellido_materno,mueble.nombre,tipo_material.tipo_material,cantidad,estado FROM cliente\n"
                    + "INNER JOIN pedido ON (cliente.id_cliente=pedido.id_cliente)\n"
                    + "INNER JOIN mueble ON (pedido.id_mueble=mueble.id_mueble)\n"
                    + "INNER JOIN tipo_material ON (pedido.id_tipo_material=tipo_material.id_tipo_material)\n"
                    + "WHERE cliente.nombre_cliente LIKE '" + nombreCli + "%'";
        }

        datos = new Object[7];
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                datos[0] = (rs.getString(1));
                datos[1] = (rs.getString(2));
                datos[2] = (rs.getString(3));
                datos[3] = (rs.getString(4));
                datos[4] = (rs.getString(5));
                datos[5] = (rs.getInt(6));
                datos[6] = (rs.getInt(7));

                modelo.addRow(datos);
            }
            System.out.println("Inner join exitosa!!!!");
            tabla.setModel(modelo);
        } catch (SQLException e) {

            System.out.println("Ocurrio un error al obtener los datos de personal" + e);
        }
    }
    public void actualizarTabla() {
        int sizeModel = modelo.getRowCount();
        System.out.println("Aqui no llego" + sizeModel);
        for (int i = 0; i < sizeModel; i++) {
            modelo.removeRow(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSave) {
            getData();
            actualizarTabla();
            mostrarDatos(null);
//            for( int dato :idPersonal){
//                System.out.println(dato);
//            }
        }
        if ((ae.getSource() == btnSearch)&& (!txtBuscar.getText().equals(""))) {
            actualizarTabla();
            mostrarDatos(txtBuscar.getText());
            txtBuscar.setText("");
        }
    }
}
