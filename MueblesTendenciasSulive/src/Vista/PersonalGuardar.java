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
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Modelo.Conexion;

/**
 *
 * @author Alejandro Machaca Luna
 */
public class PersonalGuardar extends JPanel implements ActionListener {

    //  componentes de tipo JLabel en orden de aparicion
    private JLabel lblDPersonales;
//    private JLabel lblIdPersonal;
    private JLabel lblNombre;
    private JLabel lblApellidoPaterno;
    private JLabel lblApellidoMaterno;
    private JLabel lblNacimiento;
    private JLabel lblCi;
    private JLabel lblDireccion;
    private JLabel lblAoC;
    private JLabel lblAoCC;
    private JLabel lblND;
//    private JLabel lblZona;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblDLaborales;
    private JLabel lblTipoPersonal;
    private JLabel lblSueldo;
    private JLabel lblFechaInicio;
    private JLabel lblFechaFin;
//  componentes de tipo JTextField en orden de aparicion
//    private JTextField txtIdPersonal;
    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JDateChooser dcNacimiento;
    private JTextField txtCi;
    private JTextField txtAoC;
    private JTextField txtAoCC;
    private JTextField txtND;
//    private JTextField txtZona;
    private JTextField txtTelefono;
    private JTextField txtEmail;

    private JComboBox cbxCargo;

    private JTextField txtSueldo;
    private JDateChooser dcInicio;
//    private JDateChooser dcFin;

    private JButton btnGuardar;
    private JButton btnCancelar;

    private Personal p1;
    private MetodoPersonal mP1;
    private PersonalModificar pm;
    private PersonalEliminar pe;
    private VentanaPersonal p;
    private int anio;
    private int mes;
    private int dia;

    public PersonalGuardar() {
        configurarPanel();
        inicializarComponentes();

    }

    private void configurarPanel() {
        this.setLayout(null);
        this.setBackground(Color.lightGray);
    }

    private void inicializarComponentes() {

        lblDPersonales = new JLabel();
        lblDPersonales.setText("DATOS PERSONALES:");
        lblDPersonales.setBounds(600, 20, 130, 25);
        this.add(lblDPersonales);
        lblNombre = new JLabel();
        lblNombre.setText("Nombre:");
        lblNombre.setBounds(650, 90, 90, 25);
        this.add(lblNombre);
        lblApellidoPaterno = new JLabel();
        lblApellidoPaterno.setText("Apellido Paterno:");
        lblApellidoPaterno.setBounds(650, 135, 120, 25);
        this.add(lblApellidoPaterno);
        lblApellidoMaterno = new JLabel();
        lblApellidoMaterno.setText("Apellido Materno:");
        lblApellidoMaterno.setBounds(650, 180, 120, 25);
        this.add(lblApellidoMaterno);
        lblNacimiento = new JLabel();
        lblNacimiento.setText("Fecha de Nacimiento:");
        lblNacimiento.setBounds(650, 225, 130, 25);
        this.add(lblNacimiento);
        lblCi = new JLabel();
        lblCi.setText("Celula de Indentidad");
        lblCi.setBounds(650, 270, 120, 25);
        this.add(lblCi);
        lblDireccion = new JLabel();
        lblDireccion.setText("Direccion:");
        lblDireccion.setBounds(650, 330, 90, 25);
        this.add(lblDireccion);
        lblAoC = new JLabel();
        lblAoC.setText("Avenida o Calle:");
        lblAoC.setBounds(800, 300, 90, 25);
        this.add(lblAoC);
        lblAoCC = new JLabel();
        lblAoCC.setText("Avenidas o Calles colindantes:");
        lblAoCC.setBounds(1020, 300, 180, 25);
        this.add(lblAoCC);
        lblND = new JLabel();
        lblND.setText("Numero de domicilio:");
        lblND.setBounds(800, 360, 120, 25);
        this.add(lblND);
        lblTelefono = new JLabel();
        lblTelefono.setText("Telefono:");
        lblTelefono.setBounds(650, 430, 90, 25);
        this.add(lblTelefono);
        lblEmail = new JLabel();
        lblEmail.setText("Email:");
        lblEmail.setBounds(650, 475, 90, 25);
        this.add(lblEmail);
        lblDLaborales = new JLabel();
        lblDLaborales.setText("DATOS LABORALES:");
        lblDLaborales.setBounds(600, 530, 120, 25);
        this.add(lblDLaborales);
        lblTipoPersonal = new JLabel();
        lblTipoPersonal.setText("Tipo de  Personal:");
        lblTipoPersonal.setBounds(650, 565, 120, 25);
        this.add(lblTipoPersonal);
        lblSueldo = new JLabel();
        lblSueldo.setText("Sueldo:");
        lblSueldo.setBounds(650, 620, 90, 25);
        this.add(lblSueldo);
        lblFechaInicio = new JLabel();
        lblFechaInicio.setText("Inicio de Actividades:");
        lblFechaInicio.setBounds(650, 665, 120, 25);
        this.add(lblFechaInicio);
        lblFechaFin = new JLabel();

        txtNombre = new JTextField();
        txtNombre.setBounds(800, 90, 200, 25);
        this.add(txtNombre);
        txtApellidoPaterno = new JTextField();
        txtApellidoPaterno.setBounds(800, 135, 200, 25);
        this.add(txtApellidoPaterno);
        txtApellidoMaterno = new JTextField();
        txtApellidoMaterno.setBounds(800, 180, 200, 25);
        this.add(txtApellidoMaterno);
        dcNacimiento = new JDateChooser();
        dcNacimiento.setBounds(800, 225, 200, 25);
        this.add(dcNacimiento);
        txtCi = new JTextField();
        txtCi.setBounds(800, 270, 200, 25);
        this.add(txtCi);
        txtAoC = new JTextField();
        txtAoC.setBounds(800, 320, 200, 25);
        this.add(txtAoC);
        txtAoCC = new JTextField();
        txtAoCC.setBounds(1020, 320, 200, 25);
        this.add(txtAoCC);
        txtND = new JTextField();
        txtND.setBounds(800, 380, 200, 25);
        this.add(txtND);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(800, 430, 200, 25);
        this.add(txtTelefono);
        txtEmail = new JTextField();
        txtEmail.setBounds(800, 475, 200, 25);
        this.add(txtEmail);
        cbxCargo = new JComboBox();
        cbxCargo.setBounds(800, 565, 200, 40);
        cbxCargo.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        setDatosCbx();
        cbxCargo.setSelectedItem(null);
        this.add(cbxCargo);
        txtSueldo = new JTextField();
        txtSueldo.setBounds(800, 620, 200, 25);
        this.add(txtSueldo);
        dcInicio = new JDateChooser();
        dcInicio.setBounds(800, 665, 200, 25);
        dcInicio.setDateFormatString("yyyy-MM-dd");
        this.add(dcInicio);
//        dcFin = new JDateChooser();
//        dcFin.setBounds(800, 550, 150, 25);
//////        dcFin.setDateFormatString("yyyy-MM-dd");
//        this.add(dcFin);
//
        btnGuardar = new JButton();
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBounds(600, 800, 200, 100);
        btnGuardar.addActionListener(this);
        this.add(btnGuardar);
        btnCancelar = new JButton();
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBounds(900, 800, 200, 100);
        btnCancelar.addActionListener(this);
        this.add(btnCancelar);
    }

    
    public void getDatos() {
        p1 = new Personal();
        mP1 = new MetodoPersonal();
//        p1.setIdPer(Integer.parseInt(txtIdPersonal.getText()));
        p1.setNombre(txtNombre.getText());
        p1.setAp(txtApellidoPaterno.getText());
        p1.setAm(txtApellidoMaterno.getText());
        anio = dcNacimiento.getCalendar().get(Calendar.YEAR);
        mes = dcNacimiento.getCalendar().get(Calendar.MONTH);
        dia = dcNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
        p1.setFN(anio + "-" + (mes + 1) + "-" + dia);
        p1.setCi(txtCi.getText());
        p1.setDir(txtAoC.getText() + " entre " + txtAoCC.getText() + " N° " + txtND.getText());
        p1.setTel(Integer.parseInt(txtTelefono.getText()));
        p1.setEmail(txtEmail.getText());
        p1.setSuel(Float.parseFloat(txtSueldo.getText()));
        anio = dcInicio.getCalendar().get(Calendar.YEAR);
        mes = dcInicio.getCalendar().get(Calendar.MONTH);
        dia = dcInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
        p1.setFI(anio + "-" + (mes + 1) + "-" + dia);
//        anio = dcFin.getCalendar().get(Calendar.YEAR);
//        mes = dcFin.getCalendar().get(Calendar.MONTH);
//        dia = dcFin.getCalendar().get(Calendar.DAY_OF_MONTH);
//        p1.setFF(anio + "-" + (mes + 1) + "-" + dia);
        p1.setIdTipPer((cbxCargo.getSelectedIndex() + 1));//Pendiente
        try {
            mP1.guardarDate(p1);
            System.out.println("Se Guardo Correctamente los Datos");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }

    }

    public void setDatosCbx() {
        try {
            Conexion cn = new Conexion();
            Connection conn = cn.getConnection();
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
//    txtIdPersonal.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        dcNacimiento.setCalendar(null);
        txtCi.setText("");
        txtAoC.setText("");
        txtAoCC.setText("");
        txtND.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        cbxCargo.setSelectedItem(null);
        txtSueldo.setText("");
        dcInicio.setCalendar(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnGuardar) {
            getDatos();
            clearComponentes();
            pe = new PersonalEliminar();
            pe.actualizarTabla();


        }
        if (ae.getSource() == btnCancelar) {
            clearComponentes();
            pe = new PersonalEliminar();
            pe.actualizarTabla();
        }
    }
}
