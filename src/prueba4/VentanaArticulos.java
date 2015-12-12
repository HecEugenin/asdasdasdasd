/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;

import javax.swing.JFrame;

/**
 *
 * @author Administrador
 */
public class VentanaArticulos extends JFrame{
    public VentanaArticulos() {
        this.setTitle("ARTICULOS");
        this.setSize(700,700);
        PanelVentanaArticulos p1= new PanelVentanaArticulos();
        this.add(p1);
    }
}
