/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodoCarpinteria;
import Vista.VentanaCarpinteria;

/**
 *
 * @author ALEJANDRO
 */
public class Carpinteria {

    private VentanaCarpinteria vC;
    private MetodoCarpinteria mC;
    private int id_Carp;
    private String nom;
    private int telf;
    private int nit;
    private String dir;

    public Carpinteria() {
    }

    public int getId_Carp() {
        return id_Carp;
    }

    public void setId_Carp(int id_Carp) {
        this.id_Carp = id_Carp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
    public void obtenerDatos(){
        vC = new VentanaCarpinteria();
//        nom=vC.getTxtName().getText();
        this.setNom(nom);nom=vC.txtName.getText();
        System.out.println(this.getNom()+"No se que pasa");
    }
}
