package org.alexis.spring.domain;

public class Product {
    private Integer id;
    private String nombreProducto;
    private Double price;
    private Integer stock;


    public Product(Integer id, String nombreProducto, Double price, Integer stock) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
