/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Negocio.Articulos;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emanuel
 */
public class Panel_Articulos extends JPanel {
    
    JLabel lblDescripcion = new JLabel("Descripcion:");
    JTextField txtDescripcion = new JTextField();
    JLabel lblNombre = new JLabel("Nombre:");
    JTextField txtNombre = new JTextField();
    JLabel lblPrecio = new JLabel("Precio:");
    JTextField txtPrecio = new JTextField();
    JLabel lblId_pedido = new JLabel("Id_pedido");
    JTextField txtId_pedido = new JTextField();
    JButton btnAgregar = new JButton("Agregar");
    JButton btnBuscar = new JButton("Buscar");
    JButton btnEliminar = new JButton("ELiminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnLimpiar = new JButton("Limpiar");
     JTextField txtId_articulo = new JTextField();
    JLabel lblId_articulo = new JLabel("Id_articulo");
    DefaultTableModel modelo=new DefaultTableModel();{
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("ID_PEDIDO");
       
    }
    public Panel_Articulos() {
     this.setLayout(null);
        lblDescripcion.setBounds(20, 20, 120, 20);
        this.add(lblDescripcion);
        txtDescripcion.setBounds(150, 20, 120, 20);
        this.add(txtDescripcion);
        lblNombre.setBounds(20, 50, 120, 20);
        this.add(lblNombre);
        txtNombre.setBounds(150, 50, 120, 20);
        this.add(txtNombre);
        lblPrecio.setBounds(20, 80, 120, 20);
        this.add(lblPrecio);
        txtPrecio.setBounds(150, 80, 120, 20);
        this.add(txtPrecio);
        lblId_pedido.setBounds(20, 110, 120, 20);
        this.add(lblId_pedido);
        txtId_pedido.setBounds(150, 110, 120, 20);
        this.add(txtId_pedido);
             
                        
        
        btnAgregar.setBounds(20, 170, 120, 20);                
        this.add(btnAgregar);
        btnLimpiar.setBounds(150, 170, 120, 20);
        this.add(btnLimpiar);
        btnEliminar.setBounds(280, 170, 120, 20);
        this.add(btnEliminar);
        btnEditar.setBounds(410, 170, 120, 20);
        this.add(btnEditar);
        btnBuscar.setBounds(540,170,120,20);
        this.add(btnBuscar);
         Panel_Articulos.OyenteLimpiar oLimpiar = new Panel_Articulos.OyenteLimpiar();
        btnLimpiar.addActionListener(oLimpiar);
        Panel_Articulos.OyenteAgregar oAgregar = new Panel_Articulos.OyenteAgregar();
        btnAgregar.addActionListener(oAgregar);
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
            Articulos art = new Articulos();
            String desc=txtDescripcion.getText();
            String nom = txtNombre.getText();
            int pre = Integer.parseInt(txtPrecio.getText());
            int id = Integer.parseInt(txtId_pedido.getText());

            art.setDescripcion(desc);
            art.setNombre(nom);
            art.setPrecio(pre);
            art.setId_pedido(id);
            
            art.save();
            Limpiar();
        }
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Articulos  art=new Articulos();
            int id=Integer.parseInt(txtId_articulo.getText());
            art.setId_pedido(id);
            art.delete();
            Limpiar();
            
        }
    }
    class OyenteEditar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Articulos art=new Articulos();
            String desc=txtDescripcion.getText();
            String nom = txtNombre.getText();
            int pre = Integer.parseInt(txtPrecio.getText());
            int id = Integer.parseInt(txtId_pedido.getText());

            art.setDescripcion(desc);
            art.setNombre(nom);
            art.setPrecio(pre);
            art.setId_pedido(id);
            
            art.save();
            Limpiar();
        }
    
    }
       public void llenarTabla(){
        
       modelo.setRowCount(0);
        Articulos articulo=new Articulos();
        List<Articulos> lista=articulo.list();
      
       Object[] list=new Object[6];
        for(int i=0;i<lista.size();i++){
           
            list[0]=""+lista.get(i).getId_articulo();
            list[1]=""+lista.get(i).getDescripcion();
            list[2]=""+lista.get(i).getNombre();
            list[3]=""+lista.get(i).getPrecio();
            list[4]=""+lista.get(i).getId_pedido();
         
            modelo.addRow(list);
            
       
    }
       }
    
    public void Limpiar() {
        txtDescripcion.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtId_pedido.setText("");

    }
}
      