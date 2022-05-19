/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Agency implements Serializable{
    private int id;
    private String name;
    private String address;
    private String tel;

    public Agency() {
    }

    public Agency(int id, String name, String address, String tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public Agency(String name, String address, String tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "ClientAgency{" + "id=" + id + ", name=" + name + ", address=" + address + ", tel=" + tel + '}';
    }
    
    public Object[] toObject(){
        return new Object[]{
            id,name,address,tel
        };
    }
}
