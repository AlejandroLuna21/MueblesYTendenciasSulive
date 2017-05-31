/*
 * Copyright (c) 2017 Alejandro Machaca Luna y VirtualEntertainmentCompany. Todos los derechos reservados.
 * ESTE SOFTWARE ES PROPORCIONADO POR LOS TITULARES DE COPYRIGHT Y CONTRIBUYENTES "COMO
 * ES "Y CUALQUIER GARANTÍA EXPRESA O IMPLÍCITA, INCLUYENDO, PERO SIN LIMITARSE A,
 * LAS GARANTÍAS IMPLÍCITAS DE COMERCIABILIDAD Y ADECUACIÓN PARA UN
 * EL PROPÓSITO SE RENUNCIA. EN NINGÚN CASO EL PROPIETARIO O
 * CONTRIBUYENTES SERÁN RESPONSABLES POR CUALQUIER DAÑO DIRECTO, INDIRECTO, INCIDENTAL, ESPECIAL,
 * DAÑOS EJEMPLARES O CONSECUENTES (INCLUYENDO, PERO SIN LIMITARSE A,
 * ADQUISICIÓN DE BIENES O SERVICIOS SUSTITUTOS; PÉRDIDA DE USO, DATOS O
 * BENEFICIOS; O INTERRUPCIÓN DEL NEGOCIO) SIN EMBARGO CAUSADO Y SOBRE CUALQUIER TEORÍA DE
 * RESPONSABILIDAD, YA SEA POR CONTRATO, RESPONSABILIDAD ESTRICTA, O AGRAVIO (INCLUYENDO
 * NEGLIGENCIA O DE OTRA MANERA) QUE SURJA EN CUALQUIER FORMA EL USO DE ESTE
 * SOFTWARE, INCLUSO SI SE ADVIERTE DE LA POSIBILIDAD DE DICHO DAÑO.
 */
package Vista;

import Controlador.Cliente;
import Modelo.Conexion;
import Modelo.MetodoCliente;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author Alejandro Machaca Luna
 */
public class VentanaCliente extends JInternalFrame implements ActionListener {

    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblFLN;
    private JLabel lblSLN;
    private JLabel lblIc;
    private JLabel lblAddress;
    private JTextField txtName;
    private JTextField txtFLN;
    private JTextField txtSLN;
    private JTextField txtIc;
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
    private JLabel lblNombre;
    private JLabel lblApP;
    private JLabel lblApM;
    private JLabel lblCi;
    private JLabel lblFechaN;
    private JLabel lblTelf;
    private JLabel lblDir;
    private JLabel lblAoC;
    private JLabel lblAoCC;
    private JLabel lblNC;
    private JLabel lblEmail;
    private JTextField txtNombre;
    private JTextField txtApP;
    private JTextField txtApM;
    private JTextField txtCi;
    private JDateChooser DteFechaN;
    private JTextField txtTelf;
    private JTextField txtDir;
    private JTextField txtEmail;
    private JButton btnActualizar;
    private JButton btnCancelar;

    private int id_aux;
    private SimpleDateFormat formato;
    private Date fechaN;

    private Cliente cl;
    private MetodoCliente mC;
    private Conexion cn;
    private Connection conn;

    public VentanaCliente() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("C L I E N T E");
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setClosable(true);
        this.setResizable(false);
    }

    private void inicializarComponentes() {

        lblTitle = new JLabel();
        lblTitle.setText("Registrar Nuevo Cliente:");
        lblTitle.setBounds(50, 50, 150, 25);
        this.add(lblTitle);
        lblName = new JLabel();
        lblName.setText("Nombre:");
        lblName.setBounds(100, 100, 100, 25);
        this.add(lblName);
        lblFLN = new JLabel();
        lblFLN.setText("Apellido Paterno:");
        lblFLN.setBounds(100, 150, 100, 25);
        this.add(lblFLN);
        lblSLN = new JLabel();
        lblSLN.setText("Apellido Materno:");
        lblSLN.setBounds(100, 200, 100, 25);
        this.add(lblSLN);
        lblIc = new JLabel();
        lblIc.setText("Celula de Identidad:");
        lblIc.setBounds(100, 250, 130, 25);
        this.add(lblIc);
        lblAddress = new JLabel();
        lblAddress.setText("Direccion:");
        lblAddress.setBounds(100, 300, 130, 25);
        this.add(lblAddress);
        lblAoC = new JLabel();
        lblAoC.setText("Avenida o Calle:");
        lblAoC.setBounds(250, 300, 130, 25);
        this.add(lblAoC);
        lblAoCC = new JLabel();
        lblAoCC.setText("Avenida o Calle Colindantes");
        lblAoCC.setBounds(500, 300, 200, 25);
        this.add(lblAoCC);
        lblNC = new JLabel();
        lblNC.setText("Numero de Casa:");
        lblNC.setBounds(250, 350, 130, 25);
        this.add(lblNC);
        txtName = new JTextField();
        txtName.setBounds(250, 100, 200, 25);
        this.add(txtName);
        txtFLN = new JTextField();
        txtFLN.setBounds(250, 150, 200, 25);
        this.add(txtFLN);
        txtSLN = new JTextField();
        txtSLN.setBounds(250, 200, 200, 25);
        this.add(txtSLN);
        txtIc = new JTextField();
        txtIc.setBounds(250, 250, 200, 25);
        this.add(txtIc);
        txtAoC = new JTextField();
        txtAoC.setBounds(250, 320, 200, 25);
        this.add(txtAoC);
        txtAoCC = new JTextField();
        txtAoCC.setBounds(500, 320, 200, 25);
        this.add(txtAoCC);
        txtNC = new JTextField();
        txtNC.setBounds(250, 370, 200, 25);
        this.add(txtNC);
        btnSave = new JButton();
        btnSave.setText("GUARDAR");
        btnSave.setBounds(50, 450, 180, 50);
        btnSave.addActionListener(this);
        this.add(btnSave);
        btnCancel = new JButton();
        btnCancel.setText("CANCELAR");
        btnCancel.setBounds(270, 450, 180, 50);
        btnCancel.addActionListener(this);
        this.add(btnCancel);

        txtBuscar = new JTextField();
        txtBuscar.setBorder(BorderFactory.createTitledBorder("ingrese el id del personal que desea buscar:"));
        txtBuscar.setBounds(750, 50, 470, 45);
        this.add(txtBuscar);
        btnBuscar = new JButton();
        btnBuscar.setText("B  U   S   C   A   R");
        btnBuscar.setBounds(750, 100, 470, 50);
        btnBuscar.addActionListener(this);
        this.add(btnBuscar);
        modelo = new DefaultTableModel();
        modelo.addColumn("Id_Cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Apellido Paterno");
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
        contenedor.setBounds(750, 200, 470, 430);
        contenedor.add(scroll);
        this.add(contenedor);
        mostrarDatos(0);
        btnModificar = new JButton();
        btnModificar.setText("M O D I F I C A R");
        btnModificar.setBounds(750, 700, 200, 50);
        btnModificar.addActionListener(this);
        this.add(btnModificar);
        btnEliminar = new JButton();
        btnEliminar.setText("E L I M I N A R");
        btnEliminar.setBounds(1015, 700, 200, 50);
        this.add(btnEliminar);

        lblTitulo = new JLabel();
        lblTitulo.setText("Actulizar Datos de Cliente:");
        lblTitulo.setBounds(1300, 50, 150, 25);
        this.add(lblTitulo);
        lblNombre = new JLabel();
        lblNombre.setText("Nombre:");
        lblNombre.setBounds(1350, 100, 100, 25);
        this.add(lblNombre);
        lblApP = new JLabel();
        lblApP.setText("Apellido Paterno:");
        lblApP.setBounds(1350, 150, 100, 25);
        this.add(lblApP);
        lblApM = new JLabel();
        lblApM.setText("Apellido Materno:");
        lblApM.setBounds(1350, 200, 100, 25);
        this.add(lblApM);
        lblCi = new JLabel();
        lblCi.setText("Celula de Identidad:");
        lblCi.setBounds(1350, 250, 130, 25);
        this.add(lblCi);
        lblFechaN = new JLabel();
        lblFechaN.setText("Fecha de Nacimiento:");
        lblFechaN.setBounds(1350, 300, 130, 25);
        this.add(lblFechaN);
        lblTelf = new JLabel();
        lblTelf.setText("Telefono:");
        lblTelf.setBounds(1350, 350, 100, 25);
        this.add(lblTelf);
        lblDir = new JLabel();
        lblDir.setText("Direccion:");
        lblDir.setBounds(1350, 400, 100, 25);
        this.add(lblDir);
        lblEmail = new JLabel();
        lblEmail.setText("Email:");
        lblEmail.setBounds(1350, 470, 100, 25);
        this.add(lblEmail);
        txtNombre = new JTextField();
        txtNombre.setBounds(1500, 100, 200, 25);
        this.add(txtNombre);
        txtApP = new JTextField();
        txtApP.setBounds(1500, 150, 200, 25);
        this.add(txtApP);
        txtApM = new JTextField();
        txtApM.setBounds(1500, 200, 200, 25);
        this.add(txtApM);
        txtCi = new JTextField();
        txtCi.setBounds(1500, 250, 200, 25);
        this.add(txtCi);
        DteFechaN = new JDateChooser();
        DteFechaN.setBounds(1500, 300, 200, 25);
        this.add(DteFechaN);
        txtTelf = new JTextField();
        txtTelf.setBounds(1500, 350, 200, 25);
        this.add(txtTelf);
        txtDir = new JTextField();
        txtDir.setBounds(1500, 400, 200, 40);
        this.add(txtDir);
        txtEmail = new JTextField();
        txtEmail.setBounds(1500, 470, 200, 25);
        this.add(txtEmail);
        btnActualizar = new JButton();
        btnActualizar.setText("ACTULIZAR");
        btnActualizar.setBounds(1350, 550, 180, 50);
        btnActualizar.addActionListener(this);
        this.add(btnActualizar);
        btnCancelar = new JButton();
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBounds(1615, 550, 180, 50);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtFLN() {
        return txtFLN;
    }

    public void setTxtFLN(JTextField txtFLN) {
        this.txtFLN = txtFLN;
    }

    public JTextField getTxtSLN() {
        return txtSLN;
    }

    public void setTxtSLN(JTextField txtSLN) {
        this.txtSLN = txtSLN;
    }

    public JTextField getTxtIc() {
        return txtIc;
    }

    public void setTxtIc(JTextField txtIc) {
        this.txtIc = txtIc;
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

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApP() {
        return txtApP;
    }

    public void setTxtApP(JTextField txtApP) {
        this.txtApP = txtApP;
    }

    public JTextField getTxtApM() {
        return txtApM;
    }

    public void setTxtApM(JTextField txtApM) {
        this.txtApM = txtApM;
    }

    public JTextField getTxtCi() {
        return txtCi;
    }

    public void setTxtCi(JTextField txtCi) {
        this.txtCi = txtCi;
    }

    public JDateChooser getDteFechaN() {
        return DteFechaN;
    }

    public void setDteFechaN(JDateChooser DteFechaN) {
        this.DteFechaN = DteFechaN;
    }

    public JTextField getTxtTelf() {
        return txtTelf;
    }

    public void setTxtTelf(JTextField txtTelf) {
        this.txtTelf = txtTelf;
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

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
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

    public void clearTxtSave() {
        txtName.setText("");
        txtFLN.setText("");
        txtSLN.setText("");
        txtIc.setText("");
        txtAoC.setText("");
        txtAoCC.setText("");
        txtNC.setText("");
    }

    public void actualizarTabla() {
        int sizeModel = modelo.getRowCount();
        System.out.println("Aqui no llego" + sizeModel);
        for (int i = 0; i < sizeModel; i++) {
            modelo.removeRow(0);
        }
    }

    public void getDatos() {
        cl = new Cliente();
        mC = new MetodoCliente();
        cl.setNom(txtName.getText());
        cl.setApP(txtFLN.getText());
        cl.setApM(txtSLN.getText());
        cl.setCi(txtIc.getText());
        cl.setDir(txtAoC.getText() + " entre " + txtAoCC.getText() + " N° " + txtNC.getText());
        try {
            mC.dataSave(cl);
            JOptionPane.showMessageDialog(null, "Se Guardo Correctamente los Datos");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }
    }

    public void mostrarDatos(int idCliente) {
        cn = new Conexion();
        conn = cn.getConnection();
        String consulta;
        if (idCliente == 0) {
            consulta = "SELECT * FROM cliente";
        } else {
            consulta = "SELECT * FROM cliente WHERE id_cliente='" + idCliente + "'";
        }

        datos = new Object[4];
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                datos[0] = (rs.getInt(1));
                datos[1] = (rs.getString(2));
                datos[2] = (rs.getString(3));
                datos[3] = (rs.getString(4));

                modelo.addRow(datos);
            }
            System.out.println("Por aqui paso");
            tabla.setModel(modelo);
        } catch (SQLException e) {

            System.out.println("Ocurrio un error al obtener los datos de personal" + e);
        }
    }

    public void getAndSet() {
        cl = new Cliente();
        mC = new MetodoCliente();
        formato = new SimpleDateFormat("yyyy-MM-dd");
        int fila = tabla.getSelectedRow();
        try {
            if (fila >= 0) {
                id_aux = (int) tabla.getValueAt(fila, 0);
                cl.setIdCli((int) tabla.getValueAt(fila, 0));
                mC.dataSearch(cl);
                txtNombre.setText(cl.getNom());
                txtApP.setText(cl.getApP());
                txtApM.setText(cl.getApM());
                txtCi.setText(cl.getCi());
                if (cl.getfN() != null) {
                    System.out.println("esto se obtubo: " + cl.getfN());
                    try {
                        fechaN = formato.parse(cl.getfN());
                        DteFechaN.setDate(fechaN);
                    } catch (ParseException e) {
                        System.out.println("No Ocurrio un error!!!!" + e);
                    }
                }
                if (cl.getTelf() != 0) {
                    txtTelf.setText(String.valueOf(cl.getTelf()));
                }
                txtDir.setText(cl.getDir());
                if (cl.getEmail() != null) {
                    txtEmail.setText(cl.getEmail());
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error!!!!" + e);
        }
    }

    public void getAndSetActualizar() {
        cl = new Cliente();
        mC = new MetodoCliente();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSave) {
            getDatos();
            clearTxtSave();
        }
        if (ae.getSource() == btnCancel) {
            clearTxtSave();
        }
        if ((ae.getSource() == btnBuscar) && (!txtBuscar.getText().equals(""))) {
            actualizarTabla();
            mostrarDatos(Integer.parseInt(txtBuscar.getText()));
            txtBuscar.setText("");
        }
        if ((ae.getSource() == btnModificar) || (ae.getSource() == mIMod)) {
            getAndSet();
            actualizarTabla();
            mostrarDatos(0);
        }
        if (ae.getSource() == btnActualizar) {

        }

    }
}
