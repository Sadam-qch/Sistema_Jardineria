
package com.emergentes.modelo;

public class Oficina {
    private int codigo_oficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigo_postal;
    private String telefono;
    private String linea_direccion1;
    private String linea_direccion2;

    public Oficina() {
        this.codigo_oficina = 0;
        this.ciudad = "";
        this.pais = "";
        this.region = "";
        this.codigo_postal = "";
        this.telefono = "";
        this.linea_direccion1 = "";
        this.linea_direccion2 = "";
    }

    public int getCodigo_oficina() {
        return codigo_oficina;
    }

    public void setCodigo_oficina(int codigo_oficina) {
        this.codigo_oficina = codigo_oficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Oficina{" + "codigo_oficina=" + codigo_oficina + ", ciudad=" + ciudad + ", pais=" + pais + ", region=" + region + ", codigo_postal=" + codigo_postal + ", telefono=" + telefono + ", linea_direccion1=" + linea_direccion1 + ", linea_direccion2=" + linea_direccion2 + '}';
    }
    
    
}
