
package com.emergentes.modelo;

public class Proveedor {
    private int codigoProveedor;
    private String nombreProveedor;
    private String contacto;
    private String telefono;

    public Proveedor() {
        this.codigoProveedor = 0;
        this.nombreProveedor = "";
        this.contacto = "";
        this.telefono = "";
    }

    
    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codigoProveedor=" + codigoProveedor + ", nombreProveedor=" + nombreProveedor + ", contacto=" + contacto + ", telefono=" + telefono + '}';
    }

   
    
}
