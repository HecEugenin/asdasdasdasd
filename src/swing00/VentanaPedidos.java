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
public class VentanaPedidos extends JFrame{
    public VentanaPedidos(){
        this.setTitle("PEDIDOS");
        this.setSize(700,700);
       
        PanelVentanaPedidos m2=new PanelVentanaPedidos();
        this.add(m2);
        
    }
}
