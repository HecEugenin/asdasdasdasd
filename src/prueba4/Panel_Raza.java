/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;

import Negocio.Razas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel_Raza extends JPanel {

    JLabel lblNombre = new JLabel("Nombre:");
    JTextField txtNombre = new JTextField();
    
    JLabel lblId_Raza = new JLabel("Id_Raza");
    JTextField txtId_Raza = new JTextField();
    

    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("ELiminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnLimpiar = new JButton("Limpiar");

    public Panel_Raza() {
        this.setLayout(null);
        
        lblNombre.setBounds(20, 20, 120, 20);
        this.add(lblNombre);
        txtNombre.setBounds(150, 20, 120, 20);
        this.add(txtNombre);
        
         lblId_Raza.setBounds(20, 50, 120, 20);
        this.add(lblId_Raza);
        txtId_Raza.setBounds(150, 50, 120, 20);
        this.add(txtId_Raza);
        
        btnAgregar.setBounds(20, 80, 120, 20);
        this.add(btnAgregar);
        btnLimpiar.setBounds(150, 80, 120, 20);
        this.add(btnLimpiar);
        btnEliminar.setBounds(280, 80, 120, 20);
        this.add(btnEliminar);
        btnEditar.setBounds(410, 80, 120, 20);
        this.add(btnEditar);
        OyenteLimpiar oLimpiar = new OyenteLimpiar();
        btnLimpiar.addActionListener(oLimpiar);
        OyenteAgregar oAgregar = new OyenteAgregar();
        btnAgregar.addActionListener(oAgregar);

    }

    class OyenteLimpiar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Limpiar();
        }
    }

    class OyenteAgregar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Razas raza = new Razas();
            String nom = txtNombre.getText();
            int Id_Raza= Integer.parseInt(txtId_Raza.getText());
            
            raza.setNombre(nom);
            raza.setId_raza(Id_Raza);
            raza.save();
            Limpiar();
        }
    }
    
    public void Limpiar() {
        txtNombre.setText("");
        txtId_Raza.setText("");
        
        
    }

}
