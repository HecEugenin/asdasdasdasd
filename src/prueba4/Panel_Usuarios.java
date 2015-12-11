/*
 USUARIOS
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
    
    JLabel lblId_Usuarios = new JLabel("id_usuarios");
    JTextField txtId_Usuarios = new JTextField();
    
    JLabel lblRut = new JLabel("RUT");
    JTextField txtRut = new JTextField();
    
    JLabel lblApellidoPAT = new JLabel("Apellido Paterno");
    JTextField txtApellidoPAT = new JTextField();
    
    JLabel lblApellidoMAT = new JLabel("Apellido Materno");
    JTextField txtApellidoMAT = new JTextField();
    
    JLabel lblId_Mascota = new JLabel("id_mascota");
    JTextField txtId_Mascota = new JTextField();
    
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
        
        lblRut.setBounds(20, 50, 120, 20);
        this.add(lblRut);
        txtRut.setBounds(150, 50, 120, 20);
        this.add(txtRut);
        
        lblApellidoPAT.setBounds(20, 80, 120, 20);
        this.add(lblApellidoPAT);
        txtApellidoPAT.setBounds(150, 80, 120, 20);
        this.add(txtApellidoPAT);
        
        lblApellidoMAT.setBounds(20, 110, 120, 20);
        this.add(lblApellidoMAT);
        txtApellidoMAT.setBounds(150, 110, 120, 20);
        this.add(txtApellidoMAT);
        
        lblId_Mascota.setBounds(20, 140, 120, 20);
        this.add(lblId_Mascota);
        txtId_Mascota.setBounds(150, 140, 120, 20);
        this.add(txtId_Mascota);
        
       lblId_Usuarios.setBounds(280, 140, 120, 20);
        this.add(lblId_Usuarios);
        txtId_Usuarios.setBounds(360, 140, 120, 20);
        this.add(txtId_Usuarios);
        
        btnAgregar.setBounds(20, 180, 120, 20);
        this.add(btnAgregar);
        btnLimpiar.setBounds(150, 180, 120, 20);
        this.add(btnLimpiar);
        btnEliminar.setBounds(280, 180, 120, 20);
        this.add(btnEliminar);
        btnEditar.setBounds(410, 180, 120, 20);
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
            int Id_Usu= Integer.parseInt(txtId_Usuarios.getText());
            int rut= Integer.parseInt(txtRut.getText());
            String apeP = txtApellidoPAT.getText();
            String apeM = txtApellidoMAT.getText();
            int Mascota_id = Integer.parseInt(txtId_Mascota.getText());
            
            
            

            usu.setNombre(nom);
            usu.setId_Usuario(Id_Usu);
            usu.setRut(rut);
            usu.setApepat(apeP);
            usu.setApemat(apeM);
            usu.setId_mascota(Mascota_id);
            usu.save();
            Limpiar();
        }
    }
    
    public void Limpiar() {
        txtNombre.setText("");
        txtId_Usuarios.setText("");
        txtRut.setText("");
        txtApellidoPAT.setText("");
        txtApellidoMAT.setText("");
        txtId_Mascota.setText("");
        
    }

}
