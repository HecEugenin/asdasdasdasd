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
public class Ventana_Articulos extends JFrame{
    public Ventana_Articulos(){
        this.setTitle("VENTANA ARTICULOS");
        this.setSize(700,600);
       
        Panel_Articulos ar=new Panel_Articulos();
        this.add(ar);
        
    }
}
