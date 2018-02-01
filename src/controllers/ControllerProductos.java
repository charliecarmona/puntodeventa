/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import lib.Conection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.ViewProductos;
import models.ModelProductos;

/* 
escuchar el componenete

siNumber true false or is Numeric FormatText
if catch en model


*/
public class ControllerProductos implements ActionListener {

    public ViewProductos viewProductos;
    public ModelProductos modelProductos;

    DefaultTableModel mytabla;

    private Statement st;
    private ResultSet rs;

    Conection conection = new Conection();
    Connection cn = conection.conexion();

    public ControllerProductos(ViewProductos viewProductos, ModelProductos modelProductos) {

        this.viewProductos = viewProductos;
        this.modelProductos = modelProductos;

        
        this.viewProductos.jtfId_producto.setVisible(false);

        this.viewProductos.jbtn_agregar.addActionListener(this);
        this.viewProductos.jbtn_actualizar.addActionListener(this);
        this.viewProductos.jbtn_editar.addActionListener(this);
        this.viewProductos.jbtn_buscar.addActionListener(this);
        this.viewProductos.jbtn_guardar.addActionListener(this);
        this.viewProductos.jbtn_actualizar.addActionListener(this);
        this.viewProductos.jbtn_borrar.addActionListener(this);
        this.viewProductos.jbtn_salir.addActionListener(this);
        
        this.viewProductos.jbtn_editar.setVisible(false);
        this.viewProductos.jbtn_actualizar.setVisible(false);
        this.viewProductos.jbtn_guardar.setVisible(false);
        this.viewProductos.jbtn_actualizar.setVisible(false);
        this.viewProductos.jbtn_borrar.setVisible(false);
    }
public void setValues() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

     



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewProductos.jbtn_agregar) {
            this.viewProductos.jbtn_guardar.setVisible(true);
            Limpiar(); 
            Habilitar();
            
              
            }
        
       if (e.getSource()== viewProductos.jbtn_guardar){
           if (viewProductos.jtf_producto.getText().equals("") || viewProductos.jtf_descripcion.getText().equals("") || viewProductos.jtf_precio_compra.getText().equals("") || viewProductos.jtf_precio_venta.getText().equals("") || viewProductos.jtf_productos_existentes.getText().equals("")) {
           JOptionPane.showMessageDialog(null, " Favor de  llenar cada uno de los campos");
            } else {
                guardar();
                Limpiar();
                Deshabilitar();
                JOptionPane.showMessageDialog(viewProductos,"REGISTRO GUARDADO EN BASE DE DATOS");
                this.viewProductos.jbtn_guardar.setVisible(false);
                
           }  
      }
           
        if (e.getSource() == viewProductos.jbtn_actualizar) {
            
            cambiar();
            JOptionPane.showMessageDialog(viewProductos,"REGISTRO MODIFICADO EN BASE DE DATOS");
            vertabla("");
        }
        if (e.getSource() == viewProductos.jbtn_borrar) {
            JOptionPane.showConfirmDialog(null,"Seguro que desea borrar este registro");
            borrar();
            vertabla("");  
            
              
            
           
        }

        if (e.getSource() == viewProductos.jbtn_editar) {
              Habilitar();
              editar();
            this.viewProductos.jbtn_actualizar.setVisible(true);
           
        }
        
        if (e.getSource() == viewProductos.jbtn_actualizar) {
            cambiar();
            Limpiar();
            Deshabilitar();
            vertabla("");
            this.viewProductos.jbtn_actualizar.setVisible(false);
        }
        
        if (e.getSource() == viewProductos.jbtn_buscar) {
            this.viewProductos.jtfId_producto.setVisible(false);
            this.viewProductos.jbtn_editar.setVisible(true);
            this.viewProductos.jbtn_actualizar.setVisible(true);
            this.viewProductos.jbtn_borrar.setVisible(true);
            vertabla("");
            
        }
        
        if (e.getSource() == viewProductos.jbtn_salir) {
            JOptionPane.showConfirmDialog(null,"Seguro que desea salir");
            System.exit(0);
            
        }
        
        }

     
    private void limpiar() {
        this.viewProductos.jtf_producto.setText("");
        this.viewProductos.jtf_descripcion.setText("");
        this.viewProductos.jtf_precio_compra.setText("");
        this.viewProductos.jtf_precio_venta.setText("");
        this.viewProductos.jtf_productos_existentes.setText("");
    }

    public void Habilitar() {
        this.viewProductos.jtf_producto.setEditable(true);
        this.viewProductos.jtf_descripcion.setEditable(true);
        this.viewProductos.jtf_precio_compra.setEditable(true);
        this.viewProductos.jtf_precio_venta.setEditable(true);
        this.viewProductos.jtf_productos_existentes.setEditable(true);

    }

    public void Deshabilitar() {
        this.viewProductos.jtf_producto.setEditable(false);
        this.viewProductos.jtf_descripcion.setEditable(false);
        this.viewProductos.jtf_precio_compra.setEditable(false);
        this.viewProductos.jtf_precio_venta.setEditable(false);
        this.viewProductos.jtf_productos_existentes.setEditable(false);
    }


    void Limpiar() {
        
        this.viewProductos.jtf_producto.setText("");
        this.viewProductos.jtf_descripcion.setText("");
        this.viewProductos.jtf_precio_compra.setText("");
        this.viewProductos.jtf_precio_venta.setText("");
        this.viewProductos.jtf_productos_existentes.setText("");
        
    }
    
    void editar() {
        try {
            int seleccion;
            seleccion = viewProductos.jT_tabla.getSelectedRow();

            if (seleccion >= 0) {

                DefaultTableModel mytabla = (DefaultTableModel) viewProductos.jT_tabla.getModel();

                String id = (String) mytabla.getValueAt(seleccion, 0);
                String producto= (String) mytabla.getValueAt(seleccion, 1);
                String descripcion = (String) mytabla.getValueAt(seleccion, 2);
                String precio_compra = (String) mytabla.getValueAt(seleccion, 3);
                String precio_venta = (String) mytabla.getValueAt(seleccion, 4);
                String existencias = (String) mytabla.getValueAt(seleccion, 5);
                

                viewProductos.jtfId_producto.setText(id);
                viewProductos.jtf_producto.setText(producto);
                viewProductos.jtf_descripcion.setText(descripcion);
                viewProductos.jtf_precio_compra.setText(precio_compra);
                viewProductos.jtf_precio_venta.setText(precio_venta);
                viewProductos.jtf_productos_existentes.setText(existencias);
                
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falla en la operacion");
        }

    }

public void cambiar()  {
try{
        String producto = this.viewProductos.jtf_producto.getText();
        String descripcion = this.viewProductos.jtf_descripcion.getText();
        String precio_compra = this.viewProductos.jtf_precio_compra.getText();
        String precio_venta = this.viewProductos.jtf_precio_venta.getText();
        String existencias = this.viewProductos.jtf_productos_existentes.getText();

       PreparedStatement ps = cn.prepareStatement ("update producto set producto='" + producto + "',descripcion='" + descripcion + "',precio_compra='" + precio_compra + "',precio_venta='" + precio_venta + "' where id_producto='" + this.viewProductos.jtfId_producto.getText() + "';");
       ps.executeUpdate();
    }catch(Exception e){}
}
    
    void borrar() {
        try {
            int fila = viewProductos.jT_tabla.getSelectedRow();
            if (fila >= 0) {

                DefaultTableModel mytabla = (DefaultTableModel) viewProductos.jT_tabla.getModel();

                String id = (String) mytabla.getValueAt(fila, 0);
                int respuesta =JOptionPane.showConfirmDialog(viewProductos,"¿Seguro que quiere borrar este registro?");
                if (respuesta == JOptionPane.YES_OPTION) {
                   
             
                String sql = ("DELETE FROM producto WHERE id_producto ='" + id + "'");
                st = cn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(viewProductos," Registro borrado");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }

    void guardar() {

        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO producto (producto,descripcion,precio_compra,precio_venta,existencias) VALUES (?,?,?,?,?)");
            ps.setString(1, viewProductos.jtf_producto.getText());
            ps.setString(2, viewProductos.jtf_descripcion.getText());
            ps.setString(3, viewProductos.jtf_precio_compra.getText());
            ps.setString(4, viewProductos.jtf_precio_venta.getText());
            ps.setString(5, viewProductos.jtf_productos_existentes.getText());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar ");
            System.out.print(e.getMessage());
        }
    }

  

    public void vertabla(String valor) {
        DefaultTableModel vista = new DefaultTableModel();
        vista.addColumn("Id");
        vista.addColumn("Productos");
        vista.addColumn("Descripcion");
        vista.addColumn("Precio compra");
        vista.addColumn("Precio venta");
        vista.addColumn("exitencias");
        

        viewProductos.jT_tabla.setModel(vista);
        String sql = "";

        if (valor.equals("")) {
            sql = "SELECT  * FROM producto";
        } else {

            sql = "SELECT  * FROM producto WHERE id_producto='" + valor + "'";
        }
        String[] info = new String[6];

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM producto");

            while (rs.next()) {

                info[0] = rs.getString(1);
                info[1] = rs.getString(2);
                info[2] = rs.getString(3);
                info[3] = rs.getString(4);
                info[4] = rs.getString(5);
                info[5] = rs.getString(6);
                

                vista.addRow(info);
            }
            viewProductos.jT_tabla.setModel(vista);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


/*


    BLOCQUEA NUMEROS
    /*public KeyListener numeros = new KeyListener(){
    @Override
    public void KeyTyped(KeyEvent e){
    char valida = e.getKeyChar();
    if (valida< '0') || (valida>'9')
    {
    e.consume();
    }
    }
    BLOQUEA LETRAS
    public KeyListener letra = new KeyListener(){
    @Override
    public void KeyTyped(KeyEvent e){
    char c = e.getKeyChar();
    if (c<'a'||c>'Z')
    {
     if (c<'a'||c>'z')
    {
     e.consume();
    }
    }
    }
    */ 
    
    }

    


