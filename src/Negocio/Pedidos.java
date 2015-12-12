/*
 mascotas1
 */
package Negocio;

import Conexion.Conexion;
import java.util.ArrayList;
import java.util.List;


public class Pedidos {

    private int id_pedido;
    private String fecha;
    
    private int codigo;
    private int id_usuario;
    Conexion con; 

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }
    
    public Pedidos(){ con = new Conexion();}

  

   public void save() {
        con.setEjecutar("insert into Pedidos(fecha,codigo,id_usuario) values('" + this.fecha + "','" +this.codigo+"','"+this.id_usuario+"')");
    }

    public void delete() {
        con.setEjecutar("delete from Pedidos where id_pedido='" + this.id_pedido + "'");
    }

    public void update() {
        con.setEjecutar("update Pedidos set fecha='" + this.fecha + "',codigo='"+this.codigo+"',id_usuario='" + this.id_usuario+"' where  id_pedido='" + this.id_pedido + "'");
    }
    

public List list(){
        List<Pedidos> lista=new ArrayList<Pedidos>();
        con.setSeleccion("select * from Pedidos");
        Pedidos ped;
        try{
            while(con.getRs().next()){
                ped=new Pedidos();
                ped.setId_pedido(con.getRs().getInt("id_pedido"));
                ped.setFecha(con.getRs().getString("Fecha"));
                ped.setCodigo(con.getRs().getInt("Codigo"));
                ped.setId_usuario(con.getRs().getInt("id_usuario"));
                lista.add(ped);
            }
        }catch(Exception ex){
            System.out.println("ERROr"+ex.getMessage());
        }
        return lista;
    }
}