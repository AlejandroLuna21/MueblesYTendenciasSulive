/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Pedido;
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
public class MetodoPedido {
     private final Conexion cn = new Conexion();
    Connection conn = cn.getConnection();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    
    public MetodoPedido(){
    }
    
    public void dataSave(Pedido p){
        try {
            pst = conn.prepareStatement("INSERT INTO pedido(cantidad,fecha_pedido,fecha_entrega,descripcion_pedido,estado,id_personal,id_cliente,id_mueble,id_tipo_material) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, p.getCatidad());
            pst.setString(2, p.getFechaP());
            pst.setString(3, p.getFechaE());
            pst.setString(4, p.getDescri());
            pst.setInt(5, p.isEstado());
            pst.setInt(6, p.getIdPer());
            pst.setInt(7, p.getIdCli());
            pst.setInt(8, p.getIdMueble());
            pst.setInt(9, p.getIdTipoMat());
            pst.executeUpdate();
            cn.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }
    }
}
