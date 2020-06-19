package com.e.carritocompras;

public class Products {
    String nombre;
    String Precio;

    public Products(String nombre, String precio) {
        this.nombre = nombre;
        Precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }
    @Override
    public String toString(){
        return nombre+ "\n"+Precio;
    }
}
