/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author lenovo
 */
public class Product {
    private int id;
    private String name;
    private int stock;
    private float importPrice;
    private String type;

    public Product() {
    }

    public Product(int id, String name, int stock, float importPrice, String type) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.importPrice = importPrice;
        this.type = type;
    }

    public Product( String name, int stock, float importPrice, String type) {
        this.name = name;
        this.stock = stock;
        this.importPrice = importPrice;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", stock=" + stock + ", importPrice=" + importPrice + ", type=" + type + '}';
    }
    
    public Object[] toObject(){
        return new Object[]{
            id,name,stock,importPrice,type
        };
    }
    
}
