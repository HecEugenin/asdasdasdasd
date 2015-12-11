/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;

import javax.swing.JFrame;

/**
 *
 * @author yerico
 */
public class Ventana_Usuarios extends JFrame{
     public Ventana_Usuarios(){
        this.setTitle("VENTANA USUARIOS");
        this.setSize(700,600);
       
         Panel_Usuarios p2=new Panel_Usuarios();
        this.add(p2);
    }
}
