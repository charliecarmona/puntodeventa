/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import views.*;
/**
 *
 * @author carmona
 */
public class ControllerGeneral implements ActionListener {
    
    ViewSistemGeneral viewsistema;
    JPanel views [];
    
    public ControllerGeneral(ViewSistemGeneral viewsistema,JPanel [] views){
    this.views = views;   
    this.viewsistema = viewsistema;    
    this.viewsistema.jmi_productos.addActionListener(this);
      
    init_View(); 
    }
    
    public void jmi_productosActionPerformed(){
         
        this.viewsistema.setContentPane(views [1]);
        this.viewsistema.revalidate();
        this.viewsistema.repaint();
            
        }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         
        if (e.getSource () == viewsistema.jmi_productos)
            
            jmi_productosActionPerformed();
        
    }
    
    private void init_View() {
        this.viewsistema.setTitle("general");
        this.viewsistema.setLocationRelativeTo(null);
        this.viewsistema.setVisible(true);
    }
    
    
    
    }
    
    

