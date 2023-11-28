
package com.emergentes.modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class Venta {
    private int codigo_venta;
    private Date fecha_venta;
    private int codigo_cliente;
    private int codigo_empleado;
    private int codigo_producto;
    private int cantidad;
    private BigDecimal precio_unitario;
    private BigDecimal total_venta;

    public Venta() {
        this.codigo_venta = 0;
        this.fecha_venta = null;
        this.codigo_cliente = 0;
        this.codigo_empleado = 0;
        this.codigo_producto = 0;
        this.cantidad = 0;
        this.precio_unitario = BigDecimal.ZERO;
        this.total_venta = BigDecimal.ZERO;
    }
    
    
    public int getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(int codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public BigDecimal getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(BigDecimal total_venta) {
        this.total_venta = total_venta;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo_venta=" + codigo_venta + ", fecha_venta=" + fecha_venta + ", codigo_cliente=" + codigo_cliente + ", codigo_empleado=" + codigo_empleado + ", codigo_producto=" + codigo_producto + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", total_venta=" + total_venta + '}';
    }
    
    
}
