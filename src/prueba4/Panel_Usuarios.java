/*
 USUARIOS
 */
package prueba4;


import Negocio.Usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    
    
    DefaultTableModel modelo=new DefaultTableModel();{
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("RUT");
        modelo.addColumn("APELLIDO PATERNO");
        modelo.addColumn("APELLIDO MATERNO");
        modelo.addColumn("ID_Mascota");
    }
    
    JTable tabla=new JTable(modelo);
    JScrollPane scrollTabla=new JScrollPane(tabla);

    
    
    
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
        
        
        scrollTabla.setBounds(20,210, 500,380);
        this.add(scrollTabla);
        
        OyenteEliminar oEliminar=new OyenteEliminar();
        btnEliminar.addActionListener(oEliminar);
        OyenteEditar oEditar=new OyenteEditar();
        btnEditar.addActionListener(oEditar);
        
        llenarTabla();
        
        
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

    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Usuarios usu=new Usuarios();
            int id=Integer.parseInt(txtId_Usuarios.getText());
            usu.setId_Usuario(id);
            usu.delete();
            Limpiar();
            llenarTabla();
        }
    }
    
    class OyenteEditar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Usuarios usu=new Usuarios();
            String nom=txtNombre.getText();
            int Id_Usu= Integer.parseInt(txtId_Usuarios.getText());
            int rut= Integer.parseInt(txtRut.getText());
            String apeP = txtApellidoPAT.getText();
            String apeM = txtApellidoMAT.getText();
            int Mascota_id = Integer.parseInt(txtId_Mascota.getText());
            
            
            usu.setId_Usuario(Id_Usu);
            usu.setNombre(nom);
            usu.setRut(rut);
            usu.setApemat(apeP);
            usu.setApepat(apeP);
            usu.setId_mascota(Mascota_id);
            usu.update();
            Limpiar();
            llenarTabla();
        }
    
    }
    
    public void llenarTabla(){
        
        modelo.setRowCount(0);
        Usuarios usuario=new Usuarios();
        List<Usuarios> lista=usuario.list();
      
       Object[] list=new Object[6];
        for(int i=0;i<lista.size();i++){
           
            list[0]=""+lista.get(i).getId_Usuario();
            list[1]=""+lista.get(i).getNombre();
            list[2]=""+lista.get(i).getRut();
            list[3]=""+lista.get(i).getApepat();
            list[4]=""+lista.get(i).getApemat();
            list[5]=""+lista.get(i).getId_mascota();
           
            modelo.addRow(list);
            
        }
        
    }
}
