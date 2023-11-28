
package com.emergentes.modelo;

import java.math.BigDecimal;

public class Cliente {
    private int codigo_cliente;
    private String nombre_cliente;
    private String nombre_contacto;
    private String apellido_contacto;
    private String telefono;
    private String fax;
    private String linea_direccion1;
    private String linea_direccion2;
    private String ciudad;
    private String region;
    private String pais;
    private String codigo_postal;
    private int codigo_empleado;
    private BigDecimal limite_credito;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    

    public Cliente() {
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getApellido_contacto() {
        return apellido_contacto;
    }

    public void setApellido_contacto(String apellido_contacto) {
        this.apellido_contacto = apellido_contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLinea_direccion1() {
        return linea_direccion1;
    }

    public void setLinea_direccion1(String linea_direccion1) {
        this.linea_direccion1 = linea_direccion1;
    }

    public String getLinea_direccion2() {
        return linea_direccion2;
    }

    public void setLinea_direccion2(String linea_direccion2) {
        this.linea_direccion2 = linea_direccion2;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public BigDecimal getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(BigDecimal limite_credito) {
        this.limite_credito = limite_credito;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo_cliente=" + codigo_cliente + ", nombre_cliente=" + nombre_cliente + ", nombre_contacto=" + nombre_contacto + ", apellido_contacto=" + apellido_contacto + ", telefono=" + telefono + ", fax=" + fax + ", linea_direccion1=" + linea_direccion1 + ", linea_direccion2=" + linea_direccion2 + ", pais=" + pais + ", codigo_postal=" + codigo_postal + ", codigo_empleado=" + codigo_empleado + ", limite_credito=" + limite_credito + '}';
    }
    
    
}
