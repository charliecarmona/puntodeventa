/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Carlos Carmona Perez
 */
public class ModelProductos {
    
    
    private int id;
    private String producto;
    private String descripcion;
    private double precio_compra;
    private double precio_venta;
    private int productos_existentes;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getProductos_existentes() {
        return productos_existentes;
    }

    public void setProductos_existentes(int productos_existentes) {
        this.productos_existentes = productos_existentes;
    }

    /**
     * @return the precio_compra
     */
    
    
    

    /**
     * @return the precio_compra
     */
    public double getPrecio_compra() {
        return precio_compra;
    }

    /**
     * @param precio_compra the precio_compra to set
     */
    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
    
