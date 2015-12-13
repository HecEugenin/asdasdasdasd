
package swing00;

import Negocio.Pedidos;
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

public class PanelVentanaPedidos extends JPanel {
    JLabel lblId_pedido = new JLabel("ID_PEDIDO");
    JTextField txtId_pedido = new JTextField();

        JLabel lblFecha = new JLabel("FECHA");
    JTextField txtFecha = new JTextField();
   
    JLabel lblCodigo = new JLabel("CODIGO");
    JTextField txtCodigo = new JTextField();
   
    JLabel lblId_usuario = new JLabel("ID_USUARIO");
    JTextField txtId_usuario = new JTextField();
    
    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("Eliminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnLimpiar = new JButton("Limpiar");   
     JButton btnId_pedido = new JButton("ID");
     JButton btnBuscar = new JButton("Buscar");
     
      DefaultTableModel modelo=new DefaultTableModel();{
        modelo.addColumn("ID_PEDIDO");
        modelo.addColumn("FECHA");
        modelo.addColumn("CODIGO");
        modelo.addColumn("ID_USUARIO");
       
    }
        JTable tabla=new JTable(modelo);
    JScrollPane scrollTabla=new JScrollPane(tabla);

    

    public PanelVentanaPedidos() {
          this.setLayout(null);
      lblId_pedido.setBounds(280, 140, 120, 20);
        this.add(lblId_pedido);
        txtId_pedido.setBounds(360, 140, 120, 20);
        this.add(txtId_pedido);
        
        lblFecha .setBounds(20, 50, 120, 20);
        this.add(lblFecha);
        
        txtFecha .setBounds(150, 50, 120, 20);
        this.add(txtFecha );
        
        lblCodigo.setBounds(20, 80, 120, 20);
        this.add(lblCodigo);
        
        txtCodigo.setBounds(150, 80, 120, 20);
        this.add(txtCodigo);
        
        lblId_usuario.setBounds(20, 110, 120, 20);
        this.add(lblId_usuario);
        
        txtId_usuario.setBounds(150, 110, 120, 20);
        this.add(txtId_usuario);
        
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
          OyenteEliminar oEliminar=new OyenteEliminar();
          
        btnEliminar.addActionListener(oEliminar);
        OyenteEditar oEditar=new OyenteEditar();
        
        btnEditar.addActionListener(oEditar);
        scrollTabla.setBounds(20,210, 640,380);
        this.add(scrollTabla);
        
        llenarTabla();

     }

    class OyenteLimpiar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Limpiar();
        }
    }

    class OyenteAgregar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Pedidos  ped = new Pedidos();
            String fech = txtFecha.getText();
            int cod = Integer.parseInt(txtCodigo.getText());
            int id_usuario= Integer.parseInt(txtId_usuario.getText());

            ped.setFecha(fech);
            ped.setCodigo(cod);
            ped.setId_usuario(id_usuario);
            ped.save();
            Limpiar();
            llenarTabla();
        }
    }
        class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Pedidos  ped=new Pedidos();
            int id=Integer.parseInt(txtId_pedido.getText());
            ped.setId_pedido(id);
            ped.delete();
            Limpiar();
            llenarTabla();
        }
    }
        class OyenteEditar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Pedidos ped=new Pedidos();
            String fech=txtFecha.getText();
            int codigo= Integer.parseInt(txtCodigo.getText());
            int id= Integer.parseInt(txtId_usuario.getText());
          
            
            
            ped.setFecha(fech);
            ped.setCodigo(codigo);
            ped.setId_usuario(id);
           
            ped.update();
            Limpiar();
            llenarTabla();
        }
    
    }
    
   

public void llenarTabla(){
        
        modelo.setRowCount(0);
        Pedidos pedidos=new Pedidos();
        List<Pedidos> lista=pedidos.list();
      
       Object[] list=new Object[6];
        for(int i=0;i<lista.size();i++){
           
            list[0]=""+lista.get(i).getId_pedido();
            list[1]=""+lista.get(i).getFecha();
            list[2]=""+lista.get(i).getCodigo();
            list[3]=""+lista.get(i).getId_usuario();
           
           
            modelo.addRow(list);
            
        }
        
    
}

 public void Limpiar() {
        txtFecha.setText("");
        txtCodigo.setText("");
        txtId_usuario.setText("");
        txtId_pedido.setText("");
    }
}
