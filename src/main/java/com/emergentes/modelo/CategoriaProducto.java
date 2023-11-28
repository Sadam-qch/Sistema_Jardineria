
package com.emergentes.modelo;

public class CategoriaProducto {
    private int codigoCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;
    
    public CategoriaProducto(){
        this.codigoCategoria = 0;
        this.nombreCategoria = "";
        this.descripcionCategoria = "";
    }
    
    public CategoriaProducto(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
    
    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" + "codigoCategoria=" + codigoCategoria + ", nombreCategoria=" + nombreCategoria + ", descripcionCategoria=" + descripcionCategoria + '}';
    }

}
