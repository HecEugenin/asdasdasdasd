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
public class Ventana_Raza extends JFrame{
    public Ventana_Raza(){
        this.setTitle("VENTANA RAZA");
        this.setSize(600,600);
       
        Panel_Raza r2=new Panel_Raza();
        this.add(r2);
        
    }
}