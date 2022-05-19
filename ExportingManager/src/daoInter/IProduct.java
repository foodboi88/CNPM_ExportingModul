/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInter;

import entity.Agency;
import entity.Product;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public interface IProduct {
    ArrayList<Product> searchProduct(String key);
    ArrayList<Product> getAllProduct();
}
