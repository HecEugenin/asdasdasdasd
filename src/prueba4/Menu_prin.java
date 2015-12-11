
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
    JMenuItem mnuUsuarios=new JMenuItem("Usuarios");
    JMenuItem mnuMascotas=new JMenuItem("Mascotas");
    JMenuItem mnuRazas=new JMenuItem("Razas");
    Ventana_Usuarios vU=new Ventana_Usuarios();
    Ventana_Mascota vMS=new Ventana_Mascota();
    Ventana_Raza vRZ= new Ventana_Raza();
    
    public Menu_prin(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cuartel de Operaciones xD");
        this.setSize(600, 600);
        this.setVisible(true);
      
        barra.add(mnuArchivo);
        barra.add(mnuModulos);
        mnuModulos.add(mnuUsuarios);
        mnuModulos.add(mnuMascotas);
        mnuModulos.add(mnuRazas);
        mnuArchivo.add(mnuSalir);
        this.add(barra,BorderLayout.NORTH);
        OyenteModulo1 o1=new OyenteModulo1();
        mnuUsuarios.addActionListener(o1);
        OyenteModulo2 o2=new OyenteModulo2();
        mnuMascotas.addActionListener(o2);
        OyenteModulo3 o3=new OyenteModulo3();
        mnuRazas.addActionListener(o3);
        
        OyenteCerrar oCerrar=new OyenteCerrar();
        mnuSalir.addActionListener(oCerrar);
    }
    class OyenteModulo1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
         vU.setVisible(true);
        }
    }
    class OyenteModulo2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
         vMS.setVisible(true);
        }
    }
    class OyenteModulo3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
         vRZ.setVisible(true);
        }
    }
    
    class OyenteCerrar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
}
