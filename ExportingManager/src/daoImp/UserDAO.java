/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import context.MSSQLConnection;
import daoInter.IUser;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class UserDAO implements IUser{

    @Override
    public boolean checkLogin(User user) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        
        String sql="select * from tbl_user where username=? and password=?";
        
        try{
            con=MSSQLConnection.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            
            if(rs.next()){                
                user.setId(rs.getInt("id"));
                user.setPosition(rs.getString("position"));
                user.setFullName(rs.getString("fullname"));
                return true;
                
            }
       
        }catch (SQLException e){
            System.out.println(e);
        } finally{
            MSSQLConnection.closeResultSet(rs);
            MSSQLConnection.closePrparedStatement(ps);
            MSSQLConnection.closeConnection(con);
        }
        return false;
    }
    public static void main(String[] args) {
        User userTest=new User("hieu123","123");
        IUser iUser=new UserDAO();
        System.out.println(iUser.checkLogin(userTest));
    }
}
