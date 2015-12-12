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
public class Ventana_Pedidos extends JFrame{
    public Ventana_Pedidos(){
        this.setTitle("VENTANA PeDiDoS");
        this.setSize(700,600);
       
        Panel_Pedidos m2=new Panel_Pedidos();
        this.add(m2);
        
    }
}
