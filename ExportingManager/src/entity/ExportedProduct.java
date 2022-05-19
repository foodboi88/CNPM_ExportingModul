/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lenovo
 */
public class ExportedProduct {
    private int id;
    private float exportedPrice;
    private float discount;
    private int quantity;
    private Product product;

    public ExportedProduct() {
    }

    public ExportedProduct(int id, float exportedPrice, float discount, int quantity, Product product) {
        this.id = id;
        this.exportedPrice = exportedPrice;
        this.discount = discount;
        this.quantity = quantity;
        this.product = product;
    }

    
    public ExportedProduct(float exportedPrice, float discount, int quantity, Product product) {
        this.exportedPrice = exportedPrice;
        this.discount = discount;
        this.quantity = quantity;
        this.product = product;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getExportedPrice() {
        return exportedPrice;
    }

    public void setExportedPrice(float exportedPrice) {
        this.exportedPrice = exportedPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ExportedProduct{" + "id=" + id + ", exportedPrice=" + exportedPrice + ", discount=" + discount + ", quantity=" + quantity + ", product=" + product + '}';
    }

    
    
    public Object[] toObject(){
        return new Object[]{
            product.getName(),exportedPrice,discount,quantity 
        };
    }
}
