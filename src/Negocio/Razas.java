/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.Conexion;
import java.util.ArrayList;
import java.util.List;



public class Razas {
    
    private int id_raza;
    private String nombre;
    Conexion con; 
    
     public Razas(){ con = new Conexion();}

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int id_raza) {
        this.id_raza = id_raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }
    public void save() {
        con.setEjecutar("insert into Razas(id_raza,nombre) values('" + this.id_raza + "','" + this.nombre + "')");
    }
    public void delete() {
        con.setEjecutar("delete from Razas where id_raza='" + this.id_raza + "'");
    }
    public void update() {
        con.setEjecutar("update Razas set id_raza='" + this.id_raza + "',nombre='" + this.nombre + "' where  id_raza='" + this.id_raza + "'");
    }

public List list(){
        List<Razas> lista=new ArrayList<Razas>();
        con.setSeleccion("select * from Razas");
        Razas raza;
        try{
            while(con.getRs().next()){
                raza=new Razas();
                raza.setId_raza(con.getRs().getInt("id_raza"));
                raza.setNombre(con.getRs().getString("nombre"));
                lista.add(raza);
            }
        }catch(Exception ex){
            System.out.println("ERROr"+ex.getMessage());
        }
        return lista;
    }
}