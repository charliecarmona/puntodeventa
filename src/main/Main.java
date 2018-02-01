package main;

import models.*;
import views.*;
import controllers.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    
    
    
    public static void main ( String [] car) {
        
         JPanel views[] = new JPanel[1];
       
        ViewMain viewMain = new ViewMain();
        ControllerMain controllermain = new ControllerMain(viewMain,views);
        
       
        ModelLogin modelLogin = new ModelLogin();
        ViewLogin viewLogin = new ViewLogin();
        
 
        ControllerLogin controllerLogin = new ControllerLogin(viewLogin, modelLogin);
        
        
         ModelProductos modelProductos = new ModelProductos();
         ViewProductos viewProductos = new ViewProductos();
         ControllerProductos controllerproductos = new ControllerProductos(viewProductos,modelProductos);
        
         
        
          
          views [0] = viewLogin;
        
      
       
       
        
        
        
        
        
    }  
}