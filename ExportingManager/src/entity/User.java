/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author admin
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String position;
    private String fullName;

    public User() {
    }

    public User(int id, String userName, String password, String position, String fullName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.position = position;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", position=" + position + ", fullName=" + fullName + '}';
    }
    
    
    
    
}
