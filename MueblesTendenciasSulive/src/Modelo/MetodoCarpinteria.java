/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Carpinteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ALEJANDRO
 */
public class MetodoCarpinteria {

    private final Conexion cn = new Conexion();
    Connection conn = cn.getConnection();
    PreparedStatement pst;
    
    
    public void dateSave(Carpinteria c){
        try {
            pst = conn.prepareStatement("INSERT INTO carpinteria(nombre,telefono,nit,direccion) VALUES(?,?,?,?)");
            pst.setString(1, c.getNom());
            pst.setInt(2, c.getTelf());
            pst.setInt(3, c.getNit());
            pst.setString(4, c.getDir());
            pst.executeUpdate();
            
            cn.desconectar();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }
    }
    public void dateBuscar(Carpinteria c){
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM carpinteria WHERE id_carpinteria='" + c.getId_Carp() + "'");
            while (rs.next()) {

                c.setId_Carp(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setTelf(rs.getInt(3));
                c.setNit(rs.getInt(4));
                c.setDir(rs.getString(5));

            }
            System.out.println("Obtencion de datos exitosa!!!!");

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al obtener los datos de personal" + e);
        }
    }
     public void actualizarDate(Carpinteria c){
         try {
            pst = conn.prepareStatement("UPDATE carpinteria SET nombre='"+c.getNom()+",'"); 
         } catch (SQLException e) {
         }
         
     }
}
