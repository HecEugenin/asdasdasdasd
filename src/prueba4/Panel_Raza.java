/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;

import Negocio.Razas;
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

public class Panel_Raza extends JPanel {

    JLabel lblNombre = new JLabel("Nombre:");
    JTextField txtNombre = new JTextField();
    
    JLabel lblId_Raza = new JLabel("Id_Raza");
    JTextField txtId_Raza = new JTextField();
    

    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("ELiminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnLimpiar = new JButton("Limpiar");
    JButton btnBuscar = new JButton("Buscar");
    
    
    DefaultTableModel modelo=new DefaultTableModel();{
        modelo.addColumn("ID_Raza");
        modelo.addColumn("NOMBRE");
        
    }
    
    JTable tabla=new JTable(modelo);
    JScrollPane scrollTabla=new JScrollPane(tabla);
    
    
    

    public Panel_Raza() {
        this.setLayout(null);
        
        lblNombre.setBounds(20, 50, 120, 20);
        this.add(lblNombre);
        txtNombre.setBounds(150, 50, 120, 20);
        this.add(txtNombre);
        
         lblId_Raza.setBounds(20, 80, 120, 20);
        this.add(lblId_Raza);
        txtId_Raza.setBounds(150, 80, 120, 20);
        this.add(txtId_Raza);
        
        
        btnAgregar.setBounds(20, 110, 120, 20);
        this.add(btnAgregar);
        btnLimpiar.setBounds(150, 110, 120, 20);
        this.add(btnLimpiar);
        btnEliminar.setBounds(280, 110, 120, 20);
        this.add(btnEliminar);
        btnEditar.setBounds(410, 110, 120, 20);
        this.add(btnEditar);
        btnBuscar.setBounds(540,110,120,20);
        this.add(btnBuscar);
        OyenteLimpiar oLimpiar = new OyenteLimpiar();
        btnLimpiar.addActionListener(oLimpiar);
        OyenteAgregar oAgregar = new OyenteAgregar();
        btnAgregar.addActionListener(oAgregar);
        
        
        scrollTabla.setBounds(75,160, 500,380);
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
            Razas raza = new Razas();
            String nom = txtNombre.getText();
            int Id_Raza= Integer.parseInt(txtId_Raza.getText());
            
            raza.setNombre(nom);
            raza.setId_raza(Id_Raza);
            raza.save();
            Limpiar();
            llenarTabla();
        }
    }
    
    public void Limpiar() {
        txtNombre.setText("");
        txtId_Raza.setText("");
    }
    
    
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Razas raza=new Razas();
            int id=Integer.parseInt(txtId_Raza.getText());
            raza.setId_raza(id);
            raza.delete();
            Limpiar();
            llenarTabla();
        }
    }
    
    class OyenteEditar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Razas raza=new Razas();
            String nom=txtNombre.getText();
            int Id_Usu= Integer.parseInt(txtId_Raza.getText());
            
            raza.setId_raza(Id_Usu);
            raza.setNombre(nom);
            
            raza.update();
            Limpiar();
            llenarTabla();
        }
    
    }
    
    public void llenarTabla(){
        
        modelo.setRowCount(0);
        Razas raza=new Razas();
        List<Razas> lista=raza.list();
      
       Object[] list=new Object[6];
        for(int i=0;i<lista.size();i++){
           
            list[0]=""+lista.get(i).getId_raza();
            list[1]=""+lista.get(i).getNombre();
            
            modelo.addRow(list);
            
        }
        
    }
    
    
    

}
