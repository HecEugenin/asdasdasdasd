/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;


import Negocio.Usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel_Usuarios extends JPanel {

    JLabel lblNombre = new JLabel("Nombre:");
    JTextField txtNombre = new JTextField();
    JLabel lblApellido = new JLabel("Apellido");
    JTextField txtApellido = new JTextField();
    JLabel lblCiudad = new JLabel("Ciudad");
    JTextField txtCiudad = new JTextField();
    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("ELiminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnLimpiar = new JButton("Limpiar");

    public Panel_Usuarios() {
        this.setLayout(null);
        lblNombre.setBounds(20, 20, 120, 20);
        this.add(lblNombre);
        txtNombre.setBounds(150, 20, 120, 20);
        this.add(txtNombre);
        lblApellido.setBounds(20, 50, 120, 20);
        this.add(lblApellido);
        txtApellido.setBounds(150, 50, 120, 20);
        this.add(txtApellido);
        lblCiudad.setBounds(20, 80, 120, 20);
        this.add(lblCiudad);
        txtCiudad.setBounds(150, 80, 120, 20);
        this.add(txtCiudad);
        btnAgregar.setBounds(20, 110, 120, 20);
        this.add(btnAgregar);
        btnLimpiar.setBounds(150, 110, 120, 20);
        this.add(btnLimpiar);
        btnEliminar.setBounds(280, 110, 120, 20);
        this.add(btnEliminar);
        btnEditar.setBounds(410, 110, 120, 20);
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
            Usuarios usu = new Usuarios();
            String nom = txtNombre.getText();
            String ape = txtApellido.getText();
            int Mascota_id = Integer.parseInt(txtCiudad.getText());

            usu.setNombre(nom);
            usu.setApepat(ape);
            usu.setId_mascota(Mascota_id);
            usu.save();
            Limpiar();
        }
    }
    
    public void Limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCiudad.setText("");
    }

}
