/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Carpinteria;
import Modelo.Conexion;
import Modelo.MetodoCarpinteria;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
public class VentanaCarpinteria extends JInternalFrame implements ActionListener {

    private JLabel lblTitle;
    public JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblTin;
    private JLabel lblAddress;
    private JLabel lblAoC;
    private JLabel lblAoCC;
    private JLabel lblNC;
    public JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtTin;
    private JTextField txtAoC;
    private JTextField txtAoCC;
    private JTextField txtNC;
    private JButton btnSave;
    private JButton btnCancel;

    private Object[] datos;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JPopupMenu pEmergente;
    private JMenuItem mIMod;
    private JMenuItem mIElim;
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

    private int id_aux;

    private Carpinteria c;
    private MetodoCarpinteria mC;

    private Conexion cn;
    private Connection conn;

    public VentanaCarpinteria() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("C A R P I N T E R I A");
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setClosable(true);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void inicializarComponentes() {

        lblTitle = new JLabel();
        lblTitle.setText("Registrar Nueva Carpinteria:");
        lblTitle.setBounds(50, 50, 200, 25);
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
        lblAoC = new JLabel();
        lblAoC.setText("Avenida o Calle:");
        lblAoC.setBounds(250, 250, 130, 25);
        this.add(lblAoC);
        lblAoCC = new JLabel();
        lblAoCC.setText("Avenida o Calle Colindantes");
        lblAoCC.setBounds(500, 250, 200, 25);
        this.add(lblAoCC);
        lblNC = new JLabel();
        lblNC.setText("Numero de Casa:");
        lblNC.setBounds(250, 300, 130, 25);
        this.add(lblNC);
        txtName = new JTextField();
        txtName.setBounds(250, 100, 200, 25);
        this.add(txtName);
        txtPhone = new JTextField();
        txtPhone.setBounds(250, 150, 200, 25);
        this.add(txtPhone);
        txtTin = new JTextField();
        txtTin.setBounds(250, 200, 200, 25);
        this.add(txtTin);
        txtAoC = new JTextField();
        txtAoC.setBounds(250, 270, 200, 25);
        this.add(txtAoC);
        txtAoCC = new JTextField();
        txtAoCC.setBounds(500, 270, 200, 25);
        this.add(txtAoCC);
        txtNC = new JTextField();
        txtNC.setBounds(250, 320, 200, 25);
        this.add(txtNC);
        btnSave = new JButton();
        btnSave.setText("GUARDAR");
        btnSave.setBounds(50, 400, 180, 50);
        btnSave.addActionListener(this);
        this.add(btnSave);
        btnCancel = new JButton();
        btnCancel.setText("CANCELAR");
        btnCancel.setBounds(270, 400, 180, 50);
        btnCancel.addActionListener(this);
        this.add(btnCancel);

        txtBuscar = new JTextField();
        txtBuscar.setBorder(BorderFactory.createTitledBorder("ingrese el id de la Carpinteria que desea buscar:"));
        txtBuscar.setBounds(750, 50, 470, 45);
        this.add(txtBuscar);
        btnBuscar = new JButton();
        btnBuscar.setText("B  U   S   C   A   R");
        btnBuscar.setBounds(750, 100, 470, 50);
        btnBuscar.addActionListener(this);
        this.add(btnBuscar);
        modelo = new DefaultTableModel();
        modelo.addColumn("Id_Carpinteria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("NIT");
        mIMod = new JMenuItem();
        mIMod.setText("Modificar");
        mIMod.addActionListener(this);
        mIElim = new JMenuItem();
        mIElim.setText("Eliminar");
        mIElim.addActionListener(this);
        pEmergente = new JPopupMenu();
        pEmergente.add(mIMod);
        pEmergente.add(mIElim);
        tabla = new JTable(modelo);
        tabla.setComponentPopupMenu(pEmergente);
        scroll = new JScrollPane(tabla);
        contenedor = new JPanel();
        contenedor.setBounds(720, 200, 530, 430);
        contenedor.add(scroll);
        this.add(contenedor);
        mostrarDatos(0);
        btnModificar = new JButton();
        btnModificar.setText("M O D I F I C A R");
        btnModificar.setBounds(760, 700, 200, 50);
        btnModificar.addActionListener(this);
        this.add(btnModificar);
        btnEliminar = new JButton();
        btnEliminar.setText("E L I M I N A R");
        btnEliminar.setBounds(1010, 700, 200, 50);
        btnEliminar.addActionListener(this);
        this.add(btnEliminar);

        lblTitulo = new JLabel();
        lblTitulo.setText("Actualizar Datos de Carpinteria:");
        lblTitulo.setBounds(1300, 50, 200, 25);
        this.add(lblTitulo);
        lblNom = new JLabel();
        lblNom.setText("Nombre:");
        lblNom.setBounds(1350, 100, 100, 25);
        this.add(lblNom);
        lblTelf = new JLabel();
        lblTelf.setText("Telefono:");
        lblTelf.setBounds(1350, 150, 100, 25);
        this.add(lblTelf);
        lblNit = new JLabel();
        lblNit.setText("NIT:");
        lblNit.setBounds(1350, 200, 100, 25);
        this.add(lblNit);
        lblDir = new JLabel();
        lblDir.setText("Direccion:");
        lblDir.setBounds(1350, 250, 130, 25);
        this.add(lblDir);
        txtNom = new JTextField();
        txtNom.setBounds(1450, 100, 200, 25);
        this.add(txtNom);
        txtTelf = new JTextField();
        txtTelf.setBounds(1450, 150, 200, 25);
        this.add(txtTelf);
        txtNit = new JTextField();
        txtNit.setBounds(1450, 200, 200, 25);
        this.add(txtNit);
        txtDir = new JTextField();
        txtDir.setBounds(1450, 250, 200, 40);
        this.add(txtDir);
        btnActualizar = new JButton();
        btnActualizar.setText("Actualizar");
        btnActualizar.setBounds(1300, 350, 180, 50);
        btnActualizar.addActionListener(this);
        this.add(btnActualizar);
        btnCancelar = new JButton();
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBounds(1500, 350, 180, 50);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(JTextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public JTextField getTxtTin() {
        return txtTin;
    }

    public void setTxtTin(JTextField txtTin) {
        this.txtTin = txtTin;
    }

    public JTextField getTxtAoC() {
        return txtAoC;
    }

    public void setTxtAoC(JTextField txtAoC) {
        this.txtAoC = txtAoC;
    }

    public JTextField getTxtAoCC() {
        return txtAoCC;
    }

    public void setTxtAoCC(JTextField txtAoCC) {
        this.txtAoCC = txtAoCC;
    }

    public JTextField getTxtNC() {
        return txtNC;
    }

    public void setTxtNC(JTextField txtNC) {
        this.txtNC = txtNC;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JPopupMenu getpEmergente() {
        return pEmergente;
    }

    public void setpEmergente(JPopupMenu pEmergente) {
        this.pEmergente = pEmergente;
    }

    public JMenuItem getmI() {
        return mIMod;
    }

    public void setmI(JMenuItem mI) {
        this.mIMod = mI;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getContenedor() {
        return contenedor;
    }

    public void setContenedor(JPanel contenedor) {
        this.contenedor = contenedor;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JTextField getTxtNom() {
        return txtNom;
    }

    public void setTxtNom(JTextField txtNom) {
        this.txtNom = txtNom;
    }

    public JTextField getTxtTelf() {
        return txtTelf;
    }

    public void setTxtTelf(JTextField txtTelf) {
        this.txtTelf = txtTelf;
    }

    public JTextField getTxtNit() {
        return txtNit;
    }

    public void setTxtNit(JTextField txtNit) {
        this.txtNit = txtNit;
    }

    public JTextField getTxtDir() {
        return txtDir;
    }

    public void setTxtDir(JTextField txtDir) {
        this.txtDir = txtDir;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public void clear() {
        txtName.setText("");
        txtPhone.setText("");
        txtTin.setText("");
        txtAoC.setText("");
        txtAoCC.setText("");
        txtNC.setText("");
        //Componentes 3
        txtNom.setText("");
        txtTelf.setText("");
        txtNit.setText("");
        txtDir.setText("");
    }
    public void actualizarTabla() {
        int sizeModel = modelo.getRowCount();
        System.out.println("Aqui no llego" + sizeModel);
        for (int i = 0; i < sizeModel; i++) {
            modelo.removeRow(0);
        }
    }

    public void getDatos() {
        c = new Carpinteria();
        mC = new MetodoCarpinteria();

        c.setNom(txtName.getText());
        c.setTelf(Integer.parseInt(txtPhone.getText()));
        c.setNit(Integer.parseInt(txtTin.getText()));
        c.setDir(txtAoC.getText() + " entre " + txtAoCC.getText() + " N° " + txtNC.getText());
        try {
            mC.dataSave(c);
            JOptionPane.showMessageDialog(null, "Se Guardo Correctamente los Datos");

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }

    }

    public void mostrarDatos(int id_carpinteria) {
        cn = new Conexion();
        conn = cn.getConnection();
        String consulta;
        if (id_carpinteria == 0) {
            consulta = "SELECT * FROM carpinteria";
        } else {
            consulta = "SELECT * FROM carpinteria WHERE id_carpinteria='" + id_carpinteria + "'";
        }

        datos = new Object[4];
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                datos[0] = (rs.getInt(1));
                datos[1] = (rs.getString(2));
                datos[2] = (rs.getInt(3));
                datos[3] = (rs.getInt(4));

                modelo.addRow(datos);
            }
            System.out.println("Por aqui paso");
            tabla.setModel(modelo);
        } catch (SQLException e) {

            System.out.println("Ocurrio un error al obtener los datos de personal" + e);
        }
    }

    public void getAndSet() {
        c = new Carpinteria();
        mC = new MetodoCarpinteria();
        int fila = tabla.getSelectedRow();
        try {
            if (fila >= 0) {
                id_aux = (int) tabla.getValueAt(fila, 0);
                c.setId_Carp((int) tabla.getValueAt(fila, 0));
                mC.dataSearch(c);
                txtNom.setText(c.getNom());
                txtTelf.setText(String.valueOf(c.getTelf()));
                txtNit.setText(String.valueOf(c.getNit()));
                txtDir.setText(c.getDir());
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error!!" + e);
        }
    }
    public void getAndSetActualizar(){
        c = new Carpinteria();
        mC = new MetodoCarpinteria();
        c.setId_Carp(id_aux);
        c.setNom(txtNom.getText());
        c.setTelf(Integer.parseInt(txtTelf.getText()));
        c.setNit(Integer.parseInt(txtNit.getText()));
        c.setDir(txtDir.getText());
        try {
            mC.dataUpdate(c);
            JOptionPane.showMessageDialog(null, "Se actualizo Correctamente los Datos");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos" + e);
        }
    }
    public void delete(){
        c = new Carpinteria();
        mC = new MetodoCarpinteria();
        int fila= tabla.getSelectedRow();
        try {
            if(fila>=0){
                c.setId_Carp((int) tabla.getValueAt(fila, 0));
                mC.dataDelete(c);
            }else{
                JOptionPane.showMessageDialog(null, "No selecciono ninguna fila");
            }
        } catch (HeadlessException e) {
            System.out.println("Algo Salio mal!!!" + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSave) {
            getDatos();
            clear();
            actualizarTabla();
            mostrarDatos(0);
            
        }
        if (ae.getSource()==btnCancel){
            clear();
        }
        if ((ae.getSource()==btnBuscar)&& (!txtBuscar.getText().equals(""))){
            actualizarTabla();
            mostrarDatos(Integer.parseInt(txtBuscar.getText()));
            txtBuscar.setText("");
        }
        if ((ae.getSource()==btnModificar)||(ae.getSource()==mIMod)){
            getAndSet();
            actualizarTabla();
            mostrarDatos(0);
        }
        if (ae.getSource()==btnActualizar){
            getAndSetActualizar();
            clear();
            actualizarTabla();
            mostrarDatos(0);
        }
        if ((ae.getSource()==btnEliminar)||(ae.getSource()==mIElim)){
            delete();
            actualizarTabla();
            mostrarDatos(0);
        }
        if (ae.getSource()== btnCancelar){
            clear();
        }
    }
}
