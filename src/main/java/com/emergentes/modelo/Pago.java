
package com.emergentes.modelo;
import java.math.BigDecimal;
import java.sql.Date;

public class Pago {
    private int codigo_cliente;
    private String forma_pago;
    private int id_transaccion;
    private Date fecha_pago;
    private BigDecimal total;
    private String cliente;

    public Pago() {
        this.codigo_cliente = 0;
        this.forma_pago = "";
        this.id_transaccion = 0;
        this.fecha_pago = null;
        this.total = BigDecimal.ZERO;
        this.cliente = "";
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_Pago) {
        this.fecha_pago = fecha_Pago;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pago{" + "codigo_cliente=" + codigo_cliente + ", forma_pago=" + forma_pago + ", id_transaccion=" + id_transaccion + ", fecha_Pago=" + fecha_pago + ", total=" + total + ", cliente=" + cliente + '}';
    }

    
    
}
