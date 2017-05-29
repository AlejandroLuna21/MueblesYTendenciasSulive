/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ALEJANDRO
 */
public final class Conexion {

    private static Connection conn;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "72749106";
    private final String url = "jdbc:mysql://localhost:3306/muebles_y_tendencias_sulive";

    private Statement stm;

    public Conexion() {
        establecerConexion();
    }

    private void establecerConexion() {
        conn =null;
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error al conectar" + e);
        }
    }
    public Connection getConnection(){
        return conn;
    }
    public void desconectar(){
        try {
                conn.close();
            } catch (SQLException e) {
            }
        
//        conn= null;
//        if (conn== null){
//            System.out.println("Conexion terminada");
//        }
    }

}
