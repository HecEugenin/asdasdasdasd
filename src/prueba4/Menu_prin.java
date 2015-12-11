
package prueba4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu_prin extends JFrame {
    
    JMenuBar barra=new JMenuBar();
    JMenu mnuArchivo=new JMenu("Archivo");
    JMenu mnuModulos=new JMenu("Modulos");
    JMenuItem mnuSalir=new JMenuItem("Salir");
    JMenuItem mnuCiudad=new JMenuItem("Ciudades");
    Ventana2 v2=new Ventana2();
    
    public Menu_prin(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CRUD JAVA SWING");
        this.setSize(600, 600);
        this.setVisible(true);
      
        barra.add(mnuArchivo);
        barra.add(mnuModulos);
        mnuModulos.add(mnuCiudad);
        mnuArchivo.add(mnuSalir);
        this.add(barra,BorderLayout.NORTH);
        OyenteModulo1 o1=new OyenteModulo1();
        mnuCiudad.addActionListener(o1);
        OyenteCerrar oCerrar=new OyenteCerrar();
        mnuSalir.addActionListener(oCerrar);
    }
    class OyenteModulo1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
           v2.setVisible(true);
        }
    }
    class OyenteCerrar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
}
