package com.emergentes.modelo;

import java.math.BigDecimal;

public class Producto {
    private int codigoProducto;
    private String nombre;
    private String dimensiones;
    private String proveedor;
    private String descripcion;
    private int cantidadStock;
    private BigDecimal precioVenta;
    private BigDecimal precioDecimal;
    private CategoriaProducto codigoCategoria; 
        
    public Producto() {
        this.codigoProducto = 0;
        this.nombre = "";
        this.dimensiones = "";
        this.proveedor = "";
        this.descripcion = "";
        this.cantidadStock = 0;
        this.precioVenta = BigDecimal.ZERO;
        this.precioDecimal = BigDecimal.ZERO; 
        this.codigoCategoria = new CategoriaProducto();
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getPrecioDecimal() {
        return precioDecimal;
    }

    public void setPrecioDecimal(BigDecimal precioDecimal) {
        this.precioDecimal = precioDecimal;
    }

    public CategoriaProducto getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(CategoriaProducto codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", dimensiones=" + dimensiones + ", proveedor=" + proveedor + ", descripcion=" + descripcion + ", cantidadStock=" + cantidadStock + ", precioVenta=" + precioVenta + ", precioDecimal=" + precioDecimal + ", codigoCategoria=" + codigoCategoria + '}';
    }

   
}
