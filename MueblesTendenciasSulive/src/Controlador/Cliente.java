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
package Controlador;

import Modelo.MetodoCliente;
import Vista.VentanaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Machaca Luna
 */
public class Cliente {

    private final VentanaCliente vC;
    private final MetodoCliente mC;
    private int idCli;
    private String nom;
    private String apP;
    private String apM;
    private String ci;
    private String fN;
    private int telf;
    private String dir;
    private String email;

    public Cliente(VentanaCliente vC, MetodoCliente mC) {
        this.vC = vC;
        this.mC = mC;
        this.vC.btnSaveSetActionListener(new ActionListenerBtnSave());
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApP() {
        return apP;
    }

    public void setApP(String apP) {
        this.apP = apP;
    }

    public String getApM() {
        return apM;
    }

    public void setApM(String apM) {
        this.apM = apM;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getfN() {
        return fN;
    }

    public void setfN(String fN) {
        this.fN = fN;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    class ActionListenerBtnSave implements ActionListener {

//        @Override
//        public void actionPerformed(ActionEvent ae) {
//            
//            idCli=Integer.parseInt(vC.getTxtName().getText());
//            System.out.println(idCli);
//            
//            nom = vC.getTxtName().getText();
//            System.out.println(nom);
//            System.out.println("Si Llega");
//            System.out.println(vC.getTxtName().getText());
//        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("hola");
        }
    }
}
