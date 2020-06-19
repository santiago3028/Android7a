package com.example.carritodecompras;

public class Products {
    String name;
    String Price;

    public Products(String name, String price) {
        this.name = name;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
    @Override
    public String toString(){
        return name + "\n"+Price;
    }

}
