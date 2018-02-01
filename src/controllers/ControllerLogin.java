/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lib.Conection;
import models.ModelLogin;
import models.ModelProductos;
import views.ViewLogin;
import views.ViewMain;
import views.ViewProductos;
import views.ViewSistemGeneral;

/**
 *
 * @author carmona
 */
public class ControllerLogin implements ActionListener{
    ViewMain viewmain;
    ViewLogin viewLogin;
    ModelLogin modelLogin;
    ViewSistemGeneral general;
    
    private Statement st;
    private ResultSet rs;

    Conection conection = new Conection();
    Connection cn = conection.conexion();
   
    
    public ControllerLogin( ViewLogin viewLogin, ModelLogin modelLogin){
     this.viewmain = viewmain;
     this.general = general;
     this.viewLogin = viewLogin;
     this.modelLogin = modelLogin;
     this.viewLogin.jTextUsuario.addActionListener(this);
     this.viewLogin.jTextContrasena.addActionListener(this);
     this.viewLogin.jButtonEntrar.addActionListener(this);
     this.viewLogin.jComboBoxCargo.addActionListener(this);
     
    }

   
    
    public void acceder(String usuario,String contrasena,String cargo){
       if(this.viewLogin.jTextUsuario.getText().equals("")&&this.viewLogin.jTextUsuario.getText().equals("")){
       
       JOptionPane.showMessageDialog(viewLogin,"Datos no ingresados");
       }else{
        String camp="";
        String sql = "SELECT * FROM usuario where usuario ='"+usuario+"' && contrasena ='"+contrasena+"'&& cargo='"+cargo+"'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            
                camp=rs.getString("cargo");
            }
            if (camp.equals("administrador")){
            JOptionPane.showMessageDialog(viewLogin,"Datos correctos BIENVENIDO");
            ViewSistemGeneral general = new ViewSistemGeneral();            
            general.setVisible(true);
            viewLogin.setVisible(false);
            
            
            }else{
            System.out.println("Datos incorrectos");
            JOptionPane.showMessageDialog(viewLogin,"DATOS INCORRECTOS");
            borrar();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       }
     
        
        
   
    }
    
    public void borrar(){
        this.viewLogin.jTextUsuario.setText("");
        this.viewLogin.jTextContrasena.setText("");
        }
    
    public void jButtonEntrarActionPerformed(){
     
      
            String usuario =viewLogin.jTextUsuario.getText();
            String contrasena = new String(viewLogin.jTextContrasena.getText());
            String cargo =(String) viewLogin.jComboBoxCargo.getSelectedItem();
            acceder(usuario,contrasena,cargo);
            
        }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
       jButtonEntrarActionPerformed();
    }
    
    
    
    
}
