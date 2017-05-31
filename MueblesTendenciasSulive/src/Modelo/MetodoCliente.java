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
package Modelo;

import Controlador.Cliente;
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
public class MetodoCliente {

    private final Conexion cn = new Conexion();
    Connection conn = cn.getConnection();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    public MetodoCliente() {

    }

    public void dataSave(Cliente c) {
        try {
            pst = conn.prepareStatement("INSERT INTO cliente(nombre_cliente,"
                    + "apellido_paterno,apellido_materno,ci,direccion) VALUES(?,?,?,?,?)");
            pst.setString(1, c.getNom());
            pst.setString(2, c.getApP());
            pst.setString(3, c.getApM());
            pst.setString(4, c.getCi());
            pst.setString(5, c.getDir());
            pst.executeUpdate();

            cn.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos" + e);
        }
    }

    public void dataSearch(Cliente c) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM cliente WHERE id_cliente='" + c.getIdCli() + "'");
            while (rs.next()) {
                c.setIdCli(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setApP(rs.getString(3));
                c.setApM(rs.getString(4));
                c.setCi(rs.getString(5));
                c.setfN(rs.getString(6));
                c.setTelf(rs.getInt(7));
                c.setDir(rs.getString(8));
                c.setEmail(rs.getString(9));

            }
            System.out.println("Obtencion de datos exitosa!!!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos!!" + e);
        }
    }

    public void dataUpdate(Cliente c) {
        try {
            pst = conn.prepareStatement("UPDATE cliente SET nombre_cliente='" + c.getNom() + "',apellido_paterno='" + c.getApP() + "',apellido_materno='" + c.getApM() + "',ci='" + c.getCi() + "',fecha_nacimiento='" + c.getfN() + "',telefono='" + c.getTelf() + "',direccion='" + c.getDir() + "',email='" + c.getEmail() + "'WHERE id_cliente='" + c.getIdCli() + "'");

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    public void dataDelete(Cliente c) {
        try {
            pst = conn.prepareStatement("DELETE FROM cliente WHERE id_cliente='" + c.getIdCli() + "'");
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

}
