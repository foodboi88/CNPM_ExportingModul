/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImp;

import context.MSSQLConnection;
import daoInter.IProduct;
import entity.Agency;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ProductDAO implements IProduct{

    @Override
    public ArrayList<Product> searchProduct(String key) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        ArrayList<Product> result = new ArrayList<Product>();
        String sql = "SELECT * FROM tbl_product WHERE name LIKE ?";
        try{
            con=MSSQLConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setStock(rs.getInt("stock"));
                product.setImportPrice(rs.getFloat("importPrice"));
                product.setType(rs.getString("type"));
                result.add(product);
            }
        }catch (SQLException e){
            System.out.println(e);
        }finally{
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePrparedStatement(ps);
            MSSQLConnection.closeConnection(con);

        }	
        return result;
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        ArrayList<Product> result = new ArrayList<Product>();
        String sql = "SELECT * FROM tbl_product";
//        int id, String name, int stock, float importPrice, String type
        try{
            con=MSSQLConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setStock(rs.getInt("stock"));
                    product.setImportPrice(rs.getFloat("importPrice"));
                    product.setType(rs.getString("type"));
                    result.add(product);
            }
        }catch (SQLException e){
            System.out.println(e);
        }finally{
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePrparedStatement(ps);
            MSSQLConnection.closeConnection(con);

        }	
        return result;
    }
    
}
