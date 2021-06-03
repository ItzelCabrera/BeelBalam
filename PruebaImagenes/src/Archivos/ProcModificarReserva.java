/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Itzel Cabrera
 */
public class ProcModificarReserva {

    String pNombre;
    String sNombre;
    String pApellido;
    String sApellido;
    String nacionalidad;
    String matricula;
    String usuario;
    String tramo;
    int edad;
    int codReserva;
    String fechaReserva;

    public ProcModificarReserva(String usuario, int codReserva) {
        this.usuario = usuario;
        this.codReserva = codReserva;
    }
    
    public String getpNombre() {
        return pNombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTramo() {
        return tramo;
    }

    public int getEdad() {
        return edad;
    }

    public int getCodReserva() {
        return codReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }
   

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public void setNacionalidad(int nacionalidad) {
        //this.nacionalidad = nacionalidad;
        this.nacionalidad = "MEXICANA";
    }

    public void setMatricula(Date fecha,int hora,int tramo,int direccion) {
        this.matricula = "121220211300TG3N";
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setTramo(int tramo) {
        //this.tramo = tramo;
        this.tramo = "TG3";
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public void setFechaReserva(int hora,Date fecha) {
        this.fechaReserva = "12/12/2021 13:00:00";
    }

    @Override
    public String toString() {
        return "ProcModificarReserva{" + "pNombre=" + pNombre + ", sNombre=" + sNombre + ", pApellido=" + pApellido + ", sApellido=" + sApellido + ", nacionalidad=" + nacionalidad + ", matricula=" + matricula + ", usuario=" + usuario + ", tramo=" + tramo + ", edad=" + edad + ", codReserva=" + codReserva + ", fechaReserva=" + fechaReserva + '}';
    }
    
    public boolean llamarProc(){
        String r = "";
        boolean res;
        System.out.println("Se cumplen los requisitos" + matricula);
        System.out.println("hey you");
        this.toString();
        try {
            //Conecta
            Connection conex = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KT6L84G:1433;databaseName=BEEL_BALAM","sa", "2020640576");
            CallableStatement stm = conex.prepareCall("{call VERIFICACION_MATRICULA(?,?,?,?,?,?,?,?,?,?,?)}");
            stm.setString(1,"Ivan" );
            stm.setString(2, null);
            stm.setString(3, "Gutierrez");
            stm.setString(4, null);
            stm.setInt(5, 20);
            stm.setString(6, "MEXICANA");
            stm.setString(7, "120620211300TS1S");
            stm.setString(8, "12/06/2021 13:00:00");
            stm.setString(9, "itzeeelcava");
            stm.setString(10,"TS1");
            stm.setInt(11, 7);
            ResultSet rs = stm.executeQuery();
            if(rs.next())r = rs.getString(1);
            else r = null;
            stm.execute();
            if(r == "E") res = false;
            else res = true;
            conex.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ERROR en modificarReserva");
            res = false;
        }
        return res;
    }
}
