/*
MASCOTAS
 */
package prueba4;

import Negocio.Mascotas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel_Mascota extends JPanel {

    JLabel lblNombre = new JLabel("Nombre:");
    JTextField txtNombre = new JTextField();
    
    JLabel lblId_Mascota = new JLabel("Id_mascota");
    JTextField txtId_Mascota = new JTextField();
    
    JLabel lblId_Raza = new JLabel("Id_Raza");
    JTextField txtId_Raza = new JTextField();
    
    JLabel lblPeso = new JLabel("Peso");
    JTextField txtPeso = new JTextField();

    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("ELiminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnLimpiar = new JButton("Limpiar");

    public Panel_Mascota() {
        this.setLayout(null);
        
        lblNombre.setBounds(20, 20, 120, 20);
        this.add(lblNombre);
        txtNombre.setBounds(150, 20, 120, 20);
        this.add(txtNombre);
        
        
        lblId_Raza.setBounds(20, 80, 120, 20);
        this.add(lblId_Raza);
        txtId_Raza.setBounds(150, 80, 120, 20);
        this.add(txtId_Raza);
        
        lblPeso.setBounds(20, 110, 120, 20);
        this.add(lblPeso);
        txtPeso.setBounds(150, 110, 120, 20);
        this.add(txtPeso);
        
        lblId_Mascota.setBounds(280, 110, 120, 20);
        this.add(lblId_Mascota);
        txtId_Mascota.setBounds(360, 110, 120, 20);
        this.add(txtId_Mascota);
    
        btnAgregar.setBounds(20, 140, 120, 20);
        this.add(btnAgregar);
        btnLimpiar.setBounds(150, 140, 120, 20);
        this.add(btnLimpiar);
        btnEliminar.setBounds(280, 140, 120, 20);
        this.add(btnEliminar);
        btnEditar.setBounds(410, 140, 120, 20);
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
            Mascotas mas = new Mascotas();
            String nom = txtNombre.getText();
            int Id_Raza= Integer.parseInt(txtId_Raza.getText());
            int peso= Integer.parseInt(txtPeso.getText());
            int Mascota_id = Integer.parseInt(txtId_Mascota.getText());

            mas.setNombre(nom);
            mas.setId_raza(Id_Raza);
            mas.setPeso(peso);
            mas.setId_mascota(Mascota_id);
            mas.save();
            Limpiar();
        }
    }
    
    public void Limpiar() {
        txtNombre.setText("");
        txtId_Raza.setText("");
        txtPeso.setText("");
        txtId_Mascota.setText("");
        
    }

}
