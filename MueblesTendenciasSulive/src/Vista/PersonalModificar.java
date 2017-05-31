/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.MetodoPersonal;
import Controlador.Personal;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Modelo.Conexion;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author ALEJANDRO
 */
public class PersonalModificar extends JPanel implements ActionListener {

    private JTextField txtBuscar;
    private JButton btnBuscar;
    public JList lLista;
    private JLabel lblDPersonales;
    private JLabel lblNombre;
    private JLabel lblApellidoPaterno;
    private JLabel lblApellidoMaterno;
    private JLabel lblNacimiento;
    private JLabel lblCi;
    private JLabel lblDireccion;
    private JLabel lblAoC;
    private JLabel lblAoCC;
    private JLabel lblND;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblDLaborales;
    private JLabel lblTipoPersonal;
    private JLabel lblSueldo;
    private JLabel lblFechaInicio;
    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JDateChooser dcNacimiento;
    private JTextField txtCi;
    private JTextField txtAoC;
    private JTextField txtAoCC;
    private JTextField txtND;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JComboBox cbxCargo;
    private JTextField txtSueldo;
    private JDateChooser dcInicio;
    private JButton btnActualizar;
    private JButton btnCancelar;
    private JButton btnActualizarT;

    //Nuevo
    private SimpleDateFormat formato;
    private Date fechaN;
    private Date fechaI;
    private int anio;
    private int mes;
    private int dia;
    private int id_aux;
    //

    private Personal p;
    private MetodoPersonal mp;
    private PersonalEliminar pe;

    //ElementosTabla
    private Object[] datos;
    public DefaultTableModel modelo;
    public JTable tabla;
    private JPopupMenu pEmergente;
    private JMenuItem mI;
    public JScrollPane scroll;
    public JPanel contenedor;

    //Conexion
    private Conexion cn;
    private Connection conn;

    public PersonalModificar() {
        super();
        configurarPanel();
        iniciarComponentes();

    }

    private void configurarPanel() {
        this.setLayout(null);
        this.setBackground(Color.lightGray);
    }

    private void iniciarComponentes() {

        txtBuscar = new JTextField();
        txtBuscar.setBorder(BorderFactory.createTitledBorder("ingrese el id del personal que desea buscar:"));
        txtBuscar.setBounds(50, 50, 280, 45);
        this.add(txtBuscar);
        btnBuscar = new JButton();
        btnBuscar.setText("B  U   S   C   A   R");
        btnBuscar.setBounds(400, 50, 280, 50);
        btnBuscar.addActionListener(this);
        this.add(btnBuscar);
        btnActualizarT = new JButton();
        btnActualizarT.setText("ACTULIZAR   TABLA");
        btnActualizarT.setBounds(400, 130, 280, 50);
        btnActualizarT.addActionListener(this);
        this.add(btnActualizarT);

        pe = new PersonalEliminar();
        //Analizando
        modelo = new DefaultTableModel();
        modelo.addColumn("Id_nombre");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Apellido Paterno");

        mI = new JMenuItem();
        mI.setText("Modificar");
        mI.addActionListener(this);
        pEmergente = new JPopupMenu();
        pEmergente.add(mI);

        tabla = new JTable(modelo);
        tabla.setComponentPopupMenu(pEmergente);
        scroll = new JScrollPane(tabla);
        contenedor = new JPanel();
        contenedor.setBounds(100, 200, 470, 430);
        contenedor.add(scroll);
        this.add(contenedor);
        mostrarDatos(0);
        //Analizando

        lblDPersonales = new JLabel();
        lblDPersonales.setText("DATOS PERSONALES:");
        lblDPersonales.setBounds(1000, 20, 130, 25);
        this.add(lblDPersonales);
        lblNombre = new JLabel();
        lblNombre.setText("Nombre:");
        lblNombre.setBounds(1050, 90, 90, 25);
        this.add(lblNombre);
        lblApellidoPaterno = new JLabel();
        lblApellidoPaterno.setText("Apellido Paterno:");
        lblApellidoPaterno.setBounds(1050, 135, 120, 25);
        this.add(lblApellidoPaterno);
        lblApellidoMaterno = new JLabel();
        lblApellidoMaterno.setText("Apellido Materno:");
        lblApellidoMaterno.setBounds(1050, 180, 120, 25);
        this.add(lblApellidoMaterno);
        lblNacimiento = new JLabel();
        lblNacimiento.setText("Fecha de Nacimiento:");
        lblNacimiento.setBounds(1050, 225, 130, 25);
        this.add(lblNacimiento);
        lblCi = new JLabel();
        lblCi.setText("Celula de Indentidad");
        lblCi.setBounds(1050, 270, 120, 25);
        this.add(lblCi);
        lblDireccion = new JLabel();
        lblDireccion.setText("Direccion:");
        lblDireccion.setBounds(1050, 330, 90, 25);
        this.add(lblDireccion);
        //Esperando Modificacion
//        lblAoC = new JLabel();
//        lblAoC.setText("Avenida o Calle:");
//        lblAoC.setBounds(1200, 300, 90, 25);
//        this.add(lblAoC);
//        lblAoCC = new JLabel();
//        lblAoCC.setText("Avenidas o Calles colindantes:");
//        lblAoCC.setBounds(1420, 300, 180, 25);
//        this.add(lblAoCC);
//        lblND = new JLabel();
//        lblND.setText("Numero de domicilio:");
//        lblND.setBounds(1200, 360, 120, 25);
//        this.add(lblND);
        //Esperando Modificacion
        lblTelefono = new JLabel();
        lblTelefono.setText("Telefono:");
        lblTelefono.setBounds(1050, 430, 90, 25);
        this.add(lblTelefono);
        lblEmail = new JLabel();
        lblEmail.setText("Email:");
        lblEmail.setBounds(1050, 475, 90, 25);
        this.add(lblEmail);
        lblDLaborales = new JLabel();
        lblDLaborales.setText("DATOS LABORALES:");
        lblDLaborales.setBounds(1000, 530, 120, 25);
        this.add(lblDLaborales);
        lblTipoPersonal = new JLabel();
        lblTipoPersonal.setText("Tipo de  Personal:");
        lblTipoPersonal.setBounds(1050, 565, 120, 25);
        this.add(lblTipoPersonal);
        lblSueldo = new JLabel();
        lblSueldo.setText("Sueldo:");
        lblSueldo.setBounds(1050, 620, 90, 25);
        this.add(lblSueldo);
        lblFechaInicio = new JLabel();
        lblFechaInicio.setText("Inicio de Actividades:");
        lblFechaInicio.setBounds(1050, 665, 120, 25);
        this.add(lblFechaInicio);

        txtNombre = new JTextField();
        txtNombre.setBounds(1200, 90, 200, 25);
        this.add(txtNombre);
        txtApellidoPaterno = new JTextField();
        txtApellidoPaterno.setBounds(1200, 135, 200, 25);
        this.add(txtApellidoPaterno);
        txtApellidoMaterno = new JTextField();
        txtApellidoMaterno.setBounds(1200, 180, 200, 25);
        this.add(txtApellidoMaterno);
        dcNacimiento = new JDateChooser();
        dcNacimiento.setBounds(1200, 225, 200, 25);
        this.add(dcNacimiento);
        txtCi = new JTextField();
        txtCi.setBounds(1200, 270, 200, 25);
        this.add(txtCi);
        //Esperando Modificacion
        txtAoC = new JTextField();
        txtAoC.setBounds(1200, 320, 200, 90);
        this.add(txtAoC);
//        txtAoCC = new JTextField();
//        txtAoCC.setBounds(1420, 320, 200, 25);
//        this.add(txtAoCC);
//        txtND = new JTextField();
//        txtND.setBounds(1200, 380, 200, 25);
//        this.add(txtND);
        //Esperando Modificacion
        txtTelefono = new JTextField();
        txtTelefono.setBounds(1200, 430, 200, 25);
        this.add(txtTelefono);
        txtEmail = new JTextField();
        txtEmail.setBounds(1200, 475, 200, 25);
        this.add(txtEmail);
        cbxCargo = new JComboBox();
        cbxCargo.setBounds(1200, 565, 200, 40);
        cbxCargo.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxCargo.setSelectedItem(null);
        this.add(cbxCargo);
        setDatosCbx();
        cbxCargo.setSelectedItem(null);
        txtSueldo = new JTextField();
        txtSueldo.setBounds(1200, 620, 200, 25);
        this.add(txtSueldo);
        dcInicio = new JDateChooser();
        dcInicio.setBounds(1200, 665, 200, 25);
        dcInicio.setDateFormatString("yyyy-MM-dd");
        this.add(dcInicio);

        btnActualizar = new JButton();
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBounds(1000, 800, 200, 100);
        btnActualizar.addActionListener(this);
        this.add(btnActualizar);
        btnCancelar = new JButton();
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBounds(1300, 800, 200, 100);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);

    }

    public void mostrarDatos(int id_personal) {
        cn = new Conexion();
        conn = cn.getConnection();
        String consulta;
        if (id_personal == 0) {
            consulta = "SELECT * FROM personal";
        } else {
            consulta = "SELECT * FROM personal WHERE id_personal='" + id_personal + "'";
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

            System.out.println("Ocurrio un error al obtner los datos de personal" + e);
        }
    }

    public void actualizarTabla() {
        int sizeModel = modelo.getRowCount();
        System.out.println("Aqui no llego" + sizeModel);
        for (int i = 0; i < sizeModel; i++) {
            modelo.removeRow(0);
        }
    }

    public void mod() {
        p = new Personal();
        mp = new MetodoPersonal();
        formato = new SimpleDateFormat("yyyy-MM-dd");
        int fila = tabla.getSelectedRow();
        try {
            if (fila >= 0) {
                id_aux= (int) tabla.getValueAt(fila,0);
                p.setIdPer((int) tabla.getValueAt(fila, 0));
                System.out.println("su id es :" + p.getIdPer());
                mp.buscarDate(p);
                txtNombre.setText(p.getNombre());
                txtApellidoPaterno.setText(p.getAp());
                txtApellidoMaterno.setText(p.getAm());
                fechaN = formato.parse(p.getFN());
                dcNacimiento.setDate(fechaN);
                txtCi.setText(p.getCi());
                txtAoC.setText(p.getDir());
                txtTelefono.setText(String.valueOf(p.getTel()));
                txtEmail.setText(p.getEmail());
                txtSueldo.setText(String.valueOf(p.getSuel()));
                fechaI = formato.parse(p.getFI());
                dcInicio.setDate(fechaI);
                cbxCargo.setSelectedIndex((p.getIdTipPer() - 1));

//                txtSueldo.setText(p.getSuel());
//                System.out.println("formato" + p.getFN());
//                
//                Date fechaDate = formato.parse(p.getFN());
//                dcInicio.guardarDate(fechaDate);//Modificando
//                String fecha = "1995-11-12";
            } else {
                JOptionPane.showMessageDialog(null, "No selecciono ninguna fila");
            }
        } catch (ParseException e) {

            System.out.println("Algo Salio mal!!!" + e);
        }

    }

    public void actualizar() {
        p = new Personal();
        mp = new MetodoPersonal();
        p.setIdPer(id_aux);
        p.setNombre(txtNombre.getText());
        p.setAp(txtApellidoPaterno.getText());
        p.setAm(txtApellidoMaterno.getText());
        anio = dcNacimiento.getCalendar().get(Calendar.YEAR);
        mes = dcNacimiento.getCalendar().get(Calendar.MONTH);
        dia = dcNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
        p.setFN(anio + "-" + (mes + 1) + "-" + dia);
        p.setCi(txtCi.getText());
        p.setDir(txtAoC.getText());
        p.setTel(Integer.parseInt(txtTelefono.getText()));
        p.setEmail(txtEmail.getText());
        p.setSuel(Float.parseFloat(txtSueldo.getText()));
        anio = dcInicio.getCalendar().get(Calendar.YEAR);
        mes = dcInicio.getCalendar().get(Calendar.MONTH);
        dia = dcInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
        p.setFI(anio + "-" + (mes + 1) + "-" + dia);
        p.setIdTipPer((cbxCargo.getSelectedIndex() + 1));//Pendiente
        try {
            mp.actualizarDate(p);
            System.out.println("Se actualizo Correctamente los Datos");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos" + e);
        }
    }

    public void setDatosCbx() {
        try {
            cn = new Conexion();
            conn = cn.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tipo_personal");
            while (rs.next()) {

                cbxCargo.addItem(rs.getString(2));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    public void clearComponentes() {
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        dcNacimiento.setCalendar(null);
        txtCi.setText("");
        txtAoC.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        cbxCargo.setSelectedItem(null);
        txtSueldo.setText("");
        dcInicio.setCalendar(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == btnActualizarT) {
            actualizarTabla();
            mostrarDatos(0);
        }
        if ((ae.getSource() == btnBuscar) && (!txtBuscar.getText().equals(""))) {
            actualizarTabla();
            mostrarDatos(Integer.parseInt(txtBuscar.getText()));
            txtBuscar.setText("");
        }
        if (ae.getSource() == mI) {
            mod();
        }

        if (ae.getSource() == btnActualizar) {
            actualizar();
            clearComponentes();
            actualizarTabla();
            mostrarDatos(0);
        }
        if(ae.getSource()==btnCancelar){
            clearComponentes();
        }
    }
}
