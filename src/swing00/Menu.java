
package swing00;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame {
    
    JMenuBar barra=new JMenuBar();
    JMenu mnuArchivo=new JMenu("Archivo");
    JMenu mnuModulos=new JMenu("Modulos");
    
    JMenuItem mnuSalir=new JMenuItem("Salir");
    JMenuItem mnuUsuarios=new JMenuItem("Usuarios");
    JMenuItem mnuPedidos=new JMenuItem("Pedidos");
    JMenuItem mnuArticulos=new JMenuItem("Articulos");
    
    
    VentanaUsuarios VentanaUsuarios=new VentanaUsuarios();
    VentanaPedidos VentanaPedidos=new VentanaPedidos();
    VentanaArticulos VentanaArticulos= new VentanaArticulos();
    
    public Menu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("MENU PRINCIPAL");
        this.setVisible(true);
      
        barra.add(mnuArchivo);
        barra.add(mnuModulos);
        mnuModulos.add(mnuUsuarios);
        mnuModulos.add(mnuPedidos);
        mnuModulos.add(mnuArticulos);
        mnuArchivo.add(mnuSalir);
        this.add(barra,BorderLayout.NORTH);
        OyenteModulo1 o1=new OyenteModulo1();
        mnuUsuarios.addActionListener(o1);
        OyenteModulo2 o2=new OyenteModulo2();
        mnuPedidos.addActionListener(o2);
        OyenteModulo3 o3=new OyenteModulo3();
        mnuArticulos.addActionListener(o3);
        
        OyenteCerrar oCerrar=new OyenteCerrar();
        mnuSalir.addActionListener(oCerrar);
    }
    class OyenteModulo1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
         VentanaUsuarios.setVisible(true);
        }
    }
    class OyenteModulo2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
         VentanaPedidos.setVisible(true);
        }
    }
    class OyenteModulo3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
         VentanaArticulos.setVisible(true);
        }
    }
    
    class OyenteCerrar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
}
