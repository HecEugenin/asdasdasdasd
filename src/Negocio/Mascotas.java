/*
 mascotas1
 */
package Negocio;

import Conexion.Conexion;
import java.util.ArrayList;
import java.util.List;


public class Mascotas {

    private int id_mascota;
    private String nombre;
    
    private int peso;
    private int id_raza;
    Conexion con; 
    
    public Mascotas(){ con = new Conexion();}

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int id_raza) {
        this.id_raza = id_raza;
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }

   public void save() {
        con.setEjecutar("insert into Mascotas(id_mascota,nombre,peso,id_raza) values('" + this.id_mascota + "','" + this.nombre + "','" +this.peso+"','"+this.id_raza+"')");
    }

    public void delete() {
        con.setEjecutar("delete from Mascotas where id_mascota='" + this.id_mascota + "'");
    }

    public void update() {
        con.setEjecutar("update Mascotas set nombre='" + this.nombre + "',peso='"+this.peso+"',id_raza='" + this.id_raza+"' where  id_mascota='" + this.id_mascota + "'");
    }
    

public List list(){
        List<Mascotas> lista=new ArrayList<Mascotas>();
        con.setSeleccion("select * from Mascotas");
        Mascotas mascota;
        try{
            while(con.getRs().next()){
                mascota=new Mascotas();
                mascota.setId_mascota(con.getRs().getInt("id_mascota"));
                mascota.setNombre(con.getRs().getString("nombre"));
                mascota.setPeso(con.getRs().getInt("Peso"));
                mascota.setId_raza(con.getRs().getInt("id_raza"));
                lista.add(mascota);
            }
        }catch(Exception ex){
            System.out.println("ERROr"+ex.getMessage());
        }
        return lista;
    }
}