/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import context.MSSQLConnection;
import daoInter.IBillDAO;
import entity.Bill;
import entity.ExportedProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author lenovo
 */
public class BillDAO implements IBillDAO{

    @Override
    public boolean addBill(Bill b) {
        Connection con=MSSQLConnection.getConnection();
        boolean result = false;
        String addBookingSql = "INSERT INTO tbl_bill(exportDate,paymentMethod,tblUserID,tblAgencyID,amount) VALUES(?,?,?,?,?) ";
        String addBookedRoomSql = "INSERT INTO tbl_exportedproduct(exportPrice,discount,quantity,tblProductID,tblBillID) VAlUES(?,?,?,?,?)";
        String decreaseProduct="UPDATE tbl_product SET stock = ? WHERE ID = ?";
        try {
            // Thêm bill vào csdl
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(addBookingSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, b.getDate());
            ps.setString(2, b.getPaymentMethod());
            ps.setInt(3, b.getUser().getId());
            ps.setInt(4, b.getAgency().getId());
            ps.setFloat(5, b.getAmount());
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                b.setId(generatedKeys.getInt(1)); //set Id tự tạo do csdl cho bill
                System.out.println(generatedKeys.getInt(1));
                for (ExportedProduct br : b.getExProductList()) {
                    //Them cac exportedProduct vao csdl
                    ps = con.prepareStatement(addBookedRoomSql, Statement.RETURN_GENERATED_KEYS);
                    ps.setFloat(1, br.getExportedPrice());
                    ps.setFloat(2, br.getDiscount());
                    ps.setInt(3, br.getQuantity());
                    ps.setFloat(4, br.getProduct().getId());
                    ps.setInt(5, b.getId());

                    
                    if (ps.executeUpdate()==0) {

                        try {
                            con.rollback();
                            con.setAutoCommit(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        return result;
                    }else{
                    
                        //Neu them thanh cong exportedProduct ta se bat dau tru so luong cua Pro cho exPro  
                        ps = con.prepareStatement(decreaseProduct, Statement.RETURN_GENERATED_KEYS);
                        ps.setInt(1, br.getProduct().getStock()-br.getQuantity());
                        ps.setInt(2, br.getProduct().getId());
                        
                        ps.executeUpdate();
                    }

                    
                }
                con.commit();
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }
    
}
