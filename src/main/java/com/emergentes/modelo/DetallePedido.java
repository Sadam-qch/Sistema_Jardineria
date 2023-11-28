
package com.emergentes.modelo;

import java.math.BigDecimal;

public class DetallePedido {
    private int codigoPedido;
    private int cantidad;
    private BigDecimal precioUnidad;
    private int numeroLinea;
    private Producto codigoProducto;
    private Pedido codigoPedidos;
    private Proveedor codigoProveedor;

    public DetallePedido(){
        this.codigoPedido = 0;
        this.cantidad = 0;
        this.precioUnidad = BigDecimal.ZERO;
        this.numeroLinea = 0;
        this.codigoPedidos = new Pedido();
        this.codigoProveedor = new Proveedor();
        this.codigoProducto = new Producto();
    }

    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Pedido getCodigoPedidos() {
        return codigoPedidos;
    }

    public void setCodigoPedidos(Pedido codigoPedidos) {
        this.codigoPedidos = codigoPedidos;
    }

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "codigoPedido=" + codigoPedido + ", cantidad=" + cantidad + ", precioUnidad=" + precioUnidad + ", numeroLinea=" + numeroLinea + ", codigoProducto=" + codigoProducto + ", codigoPedidos=" + codigoPedidos + ", codigoProveedor=" + codigoProveedor + '}';
    }

    
      
}
