/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class Bill {
    private int id;
    private String date;
    private String paymentMethod;
    private float amount;
    private ArrayList<ExportedProduct> exProductList;
    private User user;
    private Agency agency;

    public Bill() {
    }

    public Bill(int id, String date, String paymentMethod, float amount, ArrayList<ExportedProduct> exProductList, User user, Agency agency) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.exProductList = exProductList;
        this.user = user;
        this.agency = agency;
    }

    

    public Bill(String date, String paymentMethod, float amount, ArrayList<ExportedProduct> exProductList, User user, Agency agency) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.exProductList = exProductList;
        this.user = user;
        this.agency = agency;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public ArrayList<ExportedProduct> getExProductList() {
        return exProductList;
    }

    public void setExProductList(ArrayList<ExportedProduct> exProductList) {
        this.exProductList = exProductList;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", date=" + date + ", paymentMethod=" + paymentMethod + ", amount=" + amount + ", exProductList=" + exProductList + ", user=" + user + ", agency=" + agency + '}';
    }

    
    
    
    
    public Object[] toObject(){
        return new Object[]{
            id,date,paymentMethod,amount,exProductList,user,agency
        };
    }
}
