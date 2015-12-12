/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing00;

import javax.swing.JFrame;

/**
 *
 * @author tito
 */
public class VentanaUsuarios extends JFrame{
     public VentanaUsuarios(){
        this.setTitle("USUARIOS");
        this.setSize(700,700);
       
         PanelVentanaUsuarios p2=new PanelVentanaUsuarios();
        this.add(p2);
    }
}
