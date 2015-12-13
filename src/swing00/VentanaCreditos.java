package swing00;
import javax.swing.JFrame;

public class VentanaCreditos extends JFrame{
     public VentanaCreditos(){
        this.setTitle("Creditos");
        this.setSize(700,700);
       
         PanelVentanaCreditos Pc=new PanelVentanaCreditos();
        this.add(Pc);
    }
}