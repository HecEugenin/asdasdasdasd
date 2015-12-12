package Negocio;

import Conexion.Conexion;
import java.util.ArrayList;
import java.util.List;


public class Articulos {
     private int id_articulo;
    private String descripcion;
    private String nombre;
    private int precio;
    private int id_pedido;
     Conexion con;
 public Articulos(){ con = new Conexion();}
    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }
    public void save(){
    con.setEjecutar("insert into articulos(id_articulo,descripcion,nombre,precio,id_pedido) values('" + this.id_articulo + "','" + this.descripcion + "','" + this.nombre + "','"+ this.precio +"','"+ this.id_pedido + "')");
    }
     public void delete() {
        con.setEjecutar("delete from articulos where id_articulo='" + this.id_articulo + "'");
     }
         public void update() {
        con.setEjecutar("update articulos set descripcion='" + this.descripcion + "',nombre='" + this.nombre + "',precio='"+this.precio+"',id_pedido='" + this.id_pedido + " where  id_usuario='" + this.id_articulo + "'");
         }
        
public List list(){
        
    
        List<Articulos> lista=new ArrayList<Articulos>();
        con.setSeleccion("select * from articulos");
        Articulos art;
        try{
            while(con.getRs().next()){
                art=new Articulos();
                art.setId_articulo(con.getRs().getInt("id_articulo"));
                art.setDescripcion(con.getRs().getString("descripcion"));
                art.setNombre(con.getRs().getString("nombre"));
                art.setPrecio(con.getRs().getInt("precio"));
                art.setId_pedido(con.getRs().getInt("id_pedido"));
                
                lista.add(art);
            }
        }catch(Exception ex){
            System.out.println("ERROr"+ex.getMessage());
        }
        return lista;
}
}