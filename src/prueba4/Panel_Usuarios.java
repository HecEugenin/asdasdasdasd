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
    JLabel lblPeso = new JLabel("PESO");
    JTextField txtPeso  = new JTextField();
    JLabel lblApellidoPAT = new JLabel("Apellido Paterno");
    JTextField txtApellidoPAT = new JTextField();
    JLabel lblApellidoMAT = new JLabel("Apellido Materno");
    JTextField txtApellidoMAT = new JTextField();
    JLabel lblSexo = new JLabel("SEXO");
    JTextField txtSexo = new JTextField();
    
    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("ELiminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnLimpiar = new JButton("Limpiar");
    JButton btnBuscar = new JButton("Buscar");
    
    
    DefaultTableModel modelo=new DefaultTableModel();{
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PESO");
         modelo.addColumn("SEXO");
        modelo.addColumn("APEPAT");
        modelo.addColumn("APEMAT");
       
    }
    
    JTable tabla=new JTable(modelo);
    JScrollPane scrollTabla=new JScrollPane(tabla);

    
    
    
    public Panel_Usuarios() {
        this.setLayout(null);
        
        lblNombre.setBounds(20, 20, 120, 20);
        this.add(lblNombre);
        txtNombre.setBounds(150, 20, 120, 20);
        this.add(txtNombre);
        
        lblPeso.setBounds(20, 50, 120, 20);
        this.add(lblPeso);
        txtPeso.setBounds(150, 50, 120, 20);
        this.add(txtPeso);
        
        lblApellidoPAT.setBounds(20, 80, 120, 20);
        this.add(lblApellidoPAT);
        txtApellidoPAT.setBounds(150, 80, 120, 20);
        this.add(txtApellidoPAT);
        
        lblApellidoMAT.setBounds(20, 110, 120, 20);
        this.add(lblApellidoMAT);
        txtApellidoMAT.setBounds(150, 110, 120, 20);
        this.add(txtApellidoMAT);
        
        lblSexo.setBounds(20, 140, 120, 20);
        this.add(lblSexo);
        txtSexo.setBounds(150, 140, 120, 20);
        this.add(txtSexo);
        
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
        btnBuscar.setBounds(540,180,120,20);
        this.add(btnBuscar);
        
        OyenteLimpiar oLimpiar = new OyenteLimpiar();
        btnLimpiar.addActionListener(oLimpiar);
        OyenteAgregar oAgregar = new OyenteAgregar();
        btnAgregar.addActionListener(oAgregar);
        
        
        scrollTabla.setBounds(20,210, 640,380);
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
            int peso= Integer.parseInt(txtPeso.getText());
            String apeP = txtApellidoPAT.getText();
            String apeM = txtApellidoMAT.getText();
            String sex = txtSexo.getText();
            
            
            usu.setNombre(nom);
            usu.setId_usuario(Id_Usu);
            usu.setPeso(peso);
            usu.setApepat(apeP);
            usu.setApemat(apeM);
            usu.setSexo(sex);
            usu.save();
            Limpiar();
            llenarTabla();
        }
    }
    
    public void Limpiar() {
        txtNombre.setText("");
        txtId_Usuarios.setText("");
        txtPeso.setText("");
        txtApellidoPAT.setText("");
        txtApellidoMAT.setText("");
        txtSexo.setText("");
        
    }

    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Usuarios usu=new Usuarios();
            int id=Integer.parseInt(txtId_Usuarios.getText());
            usu.setId_usuario(id);
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
            int Peso= Integer.parseInt(txtPeso.getText());
            String apeP = txtApellidoPAT.getText();
            String apeM = txtApellidoMAT.getText();
            String Sexo = txtSexo.getText();
            
            
            
            usu.setId_usuario(Id_Usu);
            usu.setNombre(nom);
            usu.setPeso(Peso);
            usu.setApepat(apeP);
            usu.setApepat(apeM);
            usu.setSexo(Sexo);
           
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
           
            list[0]=""+lista.get(i).getId_usuario();
            list[1]=""+lista.get(i).getNombre();
            list[2]=""+lista.get(i).getPeso();
            list[3]=""+lista.get(i).getApepat();
            list[4]=""+lista.get(i).getApemat();
            list[5]=""+lista.get(i).getSexo();
           
            modelo.addRow(list);
            
        }
        
    }
}