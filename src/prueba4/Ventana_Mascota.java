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
public class Ventana_Mascota extends JFrame{
    public Ventana_Mascota(){
        this.setTitle("VENTANA MASCOTAS");
        this.setSize(500,200);
       
        Panel_Mascota m2=new Panel_Mascota();
        this.add(m2);
        
    }
}
