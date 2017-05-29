/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.PersonalGuardar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ALEJANDRO
 */
public class MetodoTipoPersonal {

    private Conexion cn;
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
    PersonalGuardar pg;

    public MetodoTipoPersonal() {

    }

//    public void getTipoPersonal() {
//
//        try {
//            cn = new Conexion();
//            conn = cn.getConnection();
//            String sql = "SELECT * FROM  tipo_personal";
//            PreparedStatement sqls = conn.prepareStatement(sql);
//            rs = sqls.executeQuery();
////            TipoPersonal tp = new TipoPersonal();
//            while (rs.next()){
//                TipoPersonal tp = new TipoPersonal();
//                tp.setIdTipPer(rs.getInt("id_tipo_personal"));
//                tp.setTipPer(rs.getString("tipo_personal"));
//                
//                pg.getCbxCargo().addItem(tp);
//            }
//
//        } catch (SQLException e) {
//        }
//    }
}
