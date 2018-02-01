package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import views.ViewMain;
import views.ViewProductos;
import views.ViewLogin;


public class ControllerMain implements ActionListener{
    
    ViewMain viewMain;
    JPanel views [];
    public ControllerMain (ViewMain viewMain, JPanel [] views ) {
        
        
        this.viewMain = viewMain;
        this.views = views;
        
        this.viewMain.jmi_registrar.setVisible(true);
        
        this.viewMain.jmi_registrar.addActionListener(this);
        
        init_View();
    }
    
    @Override 
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource () == viewMain.jmi_registrar)
            
            jmi_registrarActionPerformed();
        
    }
    
   
    private void jmi_registrarActionPerformed() {
        
        this.viewMain.setContentPane(views [0]);
        this.viewMain.revalidate();
        this.viewMain.repaint();
    }
    
    private void init_View() {
        this.viewMain.setTitle("Tienda");
        this.viewMain.setLocationRelativeTo(null);
        this.viewMain.setVisible(true);
    }
    
}
    
