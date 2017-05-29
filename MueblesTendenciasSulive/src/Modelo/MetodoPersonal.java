/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEJANDRO
 */
public class MetodoPersonal {

    private Object[] datos;

    private final Conexion cn = new Conexion();
    Connection conn = cn.getConnection();

    //
    public MetodoPersonal() {

    }

    public void guardarDate(Personal p) {

        try {

            PreparedStatement pst = conn.prepareStatement("INSERT INTO personal("
                    + "nombre,apellido_paterno,apellido_materno,"
                    + "fecha_nacimiento,ci,direccion,telefono,"
                    + "email,sueldo,fecha_inicio_actividades,"
                    + "id_tipo_personal) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            pst.setString(1, p.getNombre());
            pst.setString(2, p.getAp());
            pst.setString(3, p.getAm());
            pst.setString(4, p.getFN());
            pst.setString(5, p.getCi());
            pst.setString(6, p.getDir());
            pst.setInt(7, p.getTel());
            pst.setString(8, p.getEmail());
            pst.setFloat(9, p.getSuel());
            pst.setString(10, p.getFI());
            pst.setInt(11, p.getIdTipPer());
            pst.executeUpdate();

            cn.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }
    }

    //Analizando
    public void buscarDate(Personal p) {
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personal WHERE id_personal='" + p.getIdPer() + "'");
            while (rs.next()) {

                p.setIdPer(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setAp(rs.getString(3));
                p.setAm(rs.getString(4));
                p.setFN(rs.getString(5));
                p.setCi(rs.getString(6));
                p.setDir(rs.getString(7));
                p.setTel(rs.getInt(8));
                p.setEmail(rs.getString(9));
                p.setSuel(rs.getFloat(10));
                p.setFI(rs.getString(11));
                p.setIdTipPer(rs.getInt(12));

            }
            System.out.println("Obtencion de datos exitosa!!!!");

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al obtener los datos de personal" + e);
        }

    }
    //Analizando

    public void actualizarDate(Personal p) {
        System.out.println(p.getIdPer());
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE personal SET nombre= '"
                    + p.getNombre() + "',apellido_paterno='" + p.getAp()
                    + "',apellido_materno='" + p.getAm() + "',fecha_nacimiento='"
                    + p.getFN() + "',ci='" + p.getCi() + "',direccion='"
                    + p.getDir() + "',telefono='" + p.getTel() + "',email='"
                    + p.getEmail() + "',sueldo='" + p.getSuel()
                    + "',fecha_inicio_actividades='" + p.getFI()
                    + "',id_tipo_personal='" + p.getIdTipPer()
                    + "'WHERE id_personal='" + p.getIdPer() + "'");
            
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }

    }
    public void eliminarDate(Personal p){
        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM personal WHERE id_personal='"+p.getIdPer()+"'");
            pst.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        
    }

    public void mostrarDatos(JList l) {
        l = new JList();
        DefaultListModel modelo = new DefaultListModel();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM personal");
            while (rs.next()) {

                modelo.addElement(rs.getString(2));
//                cbxCargo.addItem(rs.getString(2));
                l.setModel(modelo);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }

    }

    public ArrayList<String> mostrarelim() {
        ArrayList<String> list = new ArrayList<>();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM personal");
            while (rs.next()) {

                list.add(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "---" + rs.getString(4));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return list;
    }

    public ArrayList<Personal> cargarDatos() {
        ArrayList<Personal> list = new ArrayList<>();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM personal");
            while (rs.next()) {
                Personal p = new Personal();

                p.setIdPer(rs.getInt(1));
                p.setNameCom(rs.getString(2));

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrioo un error" + e);
        }

        return list;
    }

    public DefaultTableModel ObtenerDatos() {
        DefaultTableModel modelo2 = new DefaultTableModel();
        datos = new Object[4];
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personal");
            while (rs.next()) {
                datos[0] = (rs.getInt(1));
                datos[1] = (rs.getString(2));
                datos[2] = (rs.getString(3));
                datos[3] = (rs.getString(4));

                modelo2.addRow(datos);
            }
        } catch (SQLException e) {

            System.out.println("Ocurrio un error al obtner los datos de personal" + e);
        }
        return modelo2;
    }

}
