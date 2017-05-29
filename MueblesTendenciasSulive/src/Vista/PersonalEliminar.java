/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.MetodoPersonal;
import Controlador.Personal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Modelo.Conexion;
import java.awt.HeadlessException;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author ALEJANDRO
 */
public class PersonalEliminar extends JPanel implements ActionListener {

    private JTextField txtBuscar;
    private JButton btnBuscar;
    public JButton btnActualizarT;
    public JButton btnEliminar;
//    public JList lLista;
    private Object[] datos;
    //clases complento
    private MetodoPersonal mp;
    private Personal p;
    
    private JMenuItem mI;
    private JPopupMenu pEmergente;
    public JTable tabla;
    public JPanel contenedor;

    //implenetacion
    String column[] = new String[4];
    String filas[][] = new String[30][4];

    //implenetacion
    public DefaultTableModel modelo;
    public JScrollPane scroll;
    private Conexion cn;
    Connection conn;

    public PersonalEliminar() {
        super();
        configurarPanel();
        iniciarComponentes();
    }

    private void configurarPanel() {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
    }

    private void iniciarComponentes() {
        txtBuscar = new JTextField();
        txtBuscar.setBorder(BorderFactory.createTitledBorder("ingrese el id del personal que desea buscar:"));
        txtBuscar.setBounds(650, 50, 470, 45);
        this.add(txtBuscar);
        btnBuscar = new JButton();
        btnBuscar.setText("B  U   S   C   A   R");
        btnBuscar.setBounds(1200, 200, 280, 50);
        btnBuscar.addActionListener(this);
        this.add(btnBuscar);
        btnActualizarT = new JButton();
        btnActualizarT.setText("ACTUALIZAR TABLA");
        btnActualizarT.setBounds(1200, 300, 280, 50);
        btnActualizarT.addActionListener(this);
        this.add(btnActualizarT);
        btnEliminar = new JButton();
        btnEliminar.setText("E L I M I N A R");
        btnEliminar.setBounds(1200, 400, 280, 50);
        btnEliminar.addActionListener(this);
        this.add(btnEliminar);
//tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("Id_nombre");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Apellido Paterno");
        
        mI = new JMenuItem();
        mI.setText("Eliminar");
        mI.addActionListener(this);
        pEmergente = new JPopupMenu();
        pEmergente.add(mI);
        
        tabla = new JTable(modelo);
        tabla.setComponentPopupMenu(pEmergente);
        scroll = new JScrollPane(tabla);
        contenedor = new JPanel();
        contenedor.setBounds(650, 200, 470, 430);
        contenedor.add(scroll);
        mostrarDatos(0);
        this.add(contenedor);
    }

    public void mostrarDatos(int id_personal) {
        cn = new Conexion();
        conn = cn.getConnection();
        String consulta;
        if (id_personal==0){
            consulta="SELECT * FROM personal";
        }else{
          consulta= "SELECT * FROM personal WHERE id_personal='"+id_personal+"'";  
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
    
    public void eliminar(){
        p = new Personal();
        mp = new MetodoPersonal();
        int fila = tabla.getSelectedRow();
        try {
            if (fila >= 0) {
                p.setIdPer((int) tabla.getValueAt(fila, 0));
                mp.eliminarDate(p);
            }else {
                JOptionPane.showMessageDialog(null, "No selecciono ninguna fila");
            }
        } catch (HeadlessException e) {
            System.out.println("Algo Salio mal!!!" + e);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnActualizarT) {
            actualizarTabla();
            mostrarDatos(0);
        }
        if ((ae.getSource()==btnBuscar)&&(!txtBuscar.getText().equals(""))){
            actualizarTabla();
            mostrarDatos(Integer.parseInt(txtBuscar.getText()));
            txtBuscar.setText("");
        }
        if (ae.getSource()==mI){
            eliminar();
            actualizarTabla();
            mostrarDatos(0);
            
        }
        if (ae.getSource()==btnEliminar){
            eliminar();
            actualizarTabla();
            mostrarDatos(0);
        }
    }
}
