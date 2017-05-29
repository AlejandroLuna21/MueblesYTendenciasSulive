/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodoPersonal;
import Vista.PersonalEliminar;
import Vista.PersonalModificar;
import javax.swing.DefaultListModel;

/**
 *
 * @author Alejandro Machaca Luna
 */
public class Personal {

    private int idPersonal;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String FechaNacimiento;
    private String celulaIdentidad;
    private String direccion;
    private int telefono;
    private String email;
    private float sueldo;
    private String fechaInicioActividades;
    private String fechaFinActividades;
    private int idTipoPersonal;
    private String nameCom;

    //Implementacion del mvc
    private PersonalModificar pm;
    private MetodoPersonal mpm;
    private PersonalEliminar pe;

    public Personal() {
        inicializar();
    }

    public void setIdPer(int idPer) {
        this.idPersonal = idPer;
    }

    public int getIdPer() {
        return this.idPersonal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setAp(String ap) {
        this.apellidoPaterno = ap;
    }

    public String getAp() {
        return this.apellidoPaterno;
    }

    public void setAm(String am) {
        this.apellidoMaterno = am;
    }

    public String getAm() {
        return this.apellidoMaterno;
    }

    public void setFN(String fN) {
        this.FechaNacimiento = fN;
    }

    public String getFN() {
        return this.FechaNacimiento;
    }

    public void setCi(String ci) {
        this.celulaIdentidad = ci;
    }

    public String getCi() {
        return this.celulaIdentidad;
    }

    public void setDir(String dir) {
        this.direccion = dir;
    }

    public String getDir() {
        return this.direccion;
    }

    public void setTel(int tel) {
        this.telefono = tel;
    }

    public int getTel() {
        return this.telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setSuel(float suel) {
        this.sueldo = suel;
    }

    public float getSuel() {
        return this.sueldo;
    }

    public void setFI(String fI) {
        this.fechaInicioActividades = fI;
    }

    public String getFI() {
        return this.fechaInicioActividades;
    }

    public void setFF(String fF) {
        this.fechaFinActividades = fF;
    }

    public String getFF() {
        return this.fechaFinActividades;
    }

    public void setIdTipPer(int idTipPer) {
        this.idTipoPersonal = idTipPer;
    }

    public int getIdTipPer() {
        return this.idTipoPersonal;
    }

    public void setNameCom(String NameCom) {
        this.nameCom = NameCom;
    }

    public String getNameCom() {
        return this.nameCom;
    }

    private void inicializar() {
        pm = new PersonalModificar();
        mpm = new MetodoPersonal();
    }

    public void mostrarDatosAList() {
        mpm.mostrarDatos(pm.lLista);
    }

    public void mostrarArrayList() {
        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement(mpm.mostrarelim());
        pm.lLista.setModel(modelo);
    }

//    public void mostrarDatos() {
//       pe.tabla.setModel(mpm.ObtenerDatos());        
//    }

}
