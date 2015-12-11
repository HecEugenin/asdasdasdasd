
package Negocio;

import Conexion.Conexion;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {

    private int id_usuario;
    private String nombre;
    private int rut;
    private String apepat;
    private String apemat;
    private int id_mascota;
    Conexion con;

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public Usuarios() {
        con = new Conexion();
    }
    
    
    public int getId_Usuario() {
        return id_usuario;
        
    }

    public void setId_Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }

    public void save() {
        con.setEjecutar("insert into usuarios(id_usuario,rut,nombre,apepat,apemat,id_mascota) values('" + this.id_usuario + "','" + this.rut + "','"+this.nombre+"','" + this.apepat + "','" + this.apemat + "','" + this.id_mascota + "')");
    }

    public void delete() {
        con.setEjecutar("delete from usuarios where id_usuario='" + this.id_usuario + "'");
    }

    public void update() {
        con.setEjecutar("update usuarios set rut='" + this.rut + "', nombre='" + this.nombre + "',apepat='" + this.apepat + "',apemat='"+this.apemat+"' where  id_usuario='" + this.id_usuario + "'");
    }

   
    
    
    
public List list(){
        List<Usuarios> lista=new ArrayList<Usuarios>();
        con.setSeleccion("select * from Usuarios");
        Usuarios user;
        try{
            while(con.getRs().next()){
                user=new Usuarios();
                user.setId_Usuario(con.getRs().getInt("id_usuario"));
                user.setNombre(con.getRs().getString("nombre"));
                user.setApepat(con.getRs().getString("apepat"));
                user.setApemat(con.getRs().getString("apemat"));
                user.setRut(con.getRs().getInt("rut"));
                user.setId_mascota(con.getRs().getInt("Id_Mascota"));
                lista.add(user);
            }
        }catch(Exception ex){
            System.out.println("ERROr"+ex.getMessage());
        }
        return lista;
    }
}


/* public void Buscar(){
        con.setEjecutar("select * from Usuarios where nombre like '%'" + this.nombre + "'%' ");
    }
*/