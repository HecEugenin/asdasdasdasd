/*
MASCOTAS
 */
package prueba4;

import Negocio.Mascotas;
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
     JButton btnBuscar = new JButton("Buscar");
    
    
    DefaultTableModel modelo=new DefaultTableModel();{
       
        modelo.addColumn("NOMBRE");
        modelo.addColumn("ID_RAZA");
        
        modelo.addColumn("PESO");
        modelo.addColumn("ID_Mascota");
    }
    
    JTable tabla=new JTable(modelo);
    JScrollPane scrollTabla=new JScrollPane(tabla);

    

    public Panel_Mascota() {
        this.setLayout(null);
        
        lblNombre.setBounds(20, 20, 120, 20);
        this.add(lblNombre);
        txtNombre.setBounds(150, 20, 120, 20);
        this.add(txtNombre);
        lblId_Raza.setBounds(20, 50, 120, 20);
        this.add(lblId_Raza);
        txtId_Raza.setBounds(150, 50, 120, 20);
        this.add(txtId_Raza);
        lblPeso.setBounds(20, 80, 120, 20);
        this.add(lblPeso);
        txtPeso.setBounds(150, 80, 120, 20);
        this.add(txtPeso);
        lblId_Mascota.setBounds(20, 110, 120, 20);
        this.add(lblId_Mascota);
        txtId_Mascota.setBounds(150, 110, 120, 20);
        this.add(txtId_Mascota);
        
         btnAgregar.setBounds(20, 140, 120, 20);
        this.add(btnAgregar);
        btnLimpiar.setBounds(150, 140, 120, 20);
        this.add(btnLimpiar);
        btnEliminar.setBounds(280, 140, 120, 20);
        this.add(btnEliminar);
        btnEditar.setBounds(410, 140, 120, 20);
        this.add(btnEditar);
         btnBuscar.setBounds(540,140,120,20);
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
            llenarTabla();
        }
    }
    
    public void Limpiar() {
        txtNombre.setText("");
        txtId_Raza.setText("");
        txtPeso.setText("");
        txtId_Mascota.setText("");
        
    }

    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Mascotas mas=new Mascotas();
            int id=Integer.parseInt(txtId_Mascota.getText());
            mas.setId_mascota(id);
            mas.delete();
            Limpiar();
            llenarTabla();
        }
    }
    
    
    
    class OyenteEditar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Mascotas mas=new Mascotas();
            
            String nom=txtNombre.getText();
            int Id_Usu= Integer.parseInt(txtId_Raza.getText());
            int rut= Integer.parseInt(txtPeso.getText());
            int Mascota_id = Integer.parseInt(txtId_Mascota.getText());
            
            mas.setNombre(nom);
            mas.setId_raza(Id_Usu);
            mas.setPeso(rut);
            
            mas.setId_mascota(Mascota_id);
            mas.update();
            Limpiar();
            llenarTabla();
        }
    
    }
    
    public void llenarTabla(){
        
        modelo.setRowCount(0);
        Mascotas mas=new Mascotas();
        List<Mascotas> lista=mas.list();
      
       Object[] list=new Object[6];
        for(int i=0;i<lista.size();i++){
           
            list[0]=""+lista.get(i).getId_mascota();
            list[1]=""+lista.get(i).getNombre();
            list[2]=""+lista.get(i).getPeso();
            list[3]=""+lista.get(i).getId_raza();
         
            modelo.addRow(list);
            
        }
        
    }
    
    
    
    
}
