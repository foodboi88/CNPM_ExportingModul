/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import context.MSSQLConnection;
import daoInter.IAgency;
import entity.Agency;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class AgencyDAO implements IAgency{
    
    @Override
    public ArrayList<Agency> searchAgency(String key){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        ArrayList<Agency> result = new ArrayList<Agency>();
        String sql = "SELECT * FROM tbl_agency WHERE name LIKE ?";
        try{
            con=MSSQLConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            rs = ps.executeQuery();

            while(rs.next()){
                    Agency ca = new Agency();
                    ca.setId(rs.getInt("id"));
                    ca.setName(rs.getString("name"));
                    ca.setAddress(rs.getString("address"));
                    ca.setTel(rs.getString("tel"));
                    result.add(ca);
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

    /**
     * get a agency whose id is @key
     * @param key
     * @return
     */
    @Override
    public Agency getAgencyById(int key){

            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs = null;
            Agency agency = null;
            String sql = "SELECT * FROM tbl_agency WHERE id=?";
            try{
                    con=MSSQLConnection.getConnection();
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, key);
                    rs = ps.executeQuery();

                    if(rs.next()){
                            agency = new Agency();
                            agency.setId(rs.getInt("id"));
                            agency.setName(rs.getString("name"));
                            agency.setAddress(rs.getString("address"));
                            agency.setTel(rs.getString("tel"));

                    }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                MSSQLConnection.closeResultSet(rs);
                MSSQLConnection.closePrparedStatement(ps);
                MSSQLConnection.closeConnection(con);

            }	
            return agency;
    }

    /**
     * get all agency from tblAgency
     * @return
     */
    @Override
    public ArrayList<Agency> getAllAgency(){

            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs = null;
            ArrayList<Agency> result = new ArrayList<Agency>();
            String sql = "SELECT * FROM tbl_agency";
            try{
                    con=MSSQLConnection.getConnection();
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();

                    while(rs.next()){
                            Agency agency = new Agency();
                            agency.setId(rs.getInt("id"));
                            agency.setName(rs.getString("name"));
                            agency.setAddress(rs.getString("address"));
                            agency.setTel(rs.getString("tel"));
                            result.add(agency);
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

    /**
     * add a new @agency into the DB
     * @param agency
     */
    @Override
    public void addAgency(Agency agency){

            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs = null;
            String sql = "INSERT INTO tbl_agency(name, address, tel) VALUES(?,?,?)";
            try{
                    con=MSSQLConnection.getConnection();
                    ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, agency.getName());

                    ps.setString(2, agency.getAddress());
                    ps.setString(3, agency.getTel());


                    ps.executeUpdate();

                    //get id of the new inserted agency
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                            agency.setId(generatedKeys.getInt(1));
                    }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                MSSQLConnection.closePrparedStatement(ps);
                MSSQLConnection.closeConnection(con);

            }
    }

    /**
     * update the @agency
     * @param agency
     */
    @Override
    public void editAgency(Agency agency){

            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs = null;
            String sql = "UPDATE tbl_agency SET name=?,address=?, tel=? WHERE id=?";
            try{
                    con=MSSQLConnection.getConnection();
                    ps = con.prepareStatement(sql);
                    ps.setString(1, agency.getName());
                    ps.setString(2, agency.getAddress());
                    ps.setString(3, agency.getTel());

                    ps.setInt(4, agency.getId());

                    ps.executeUpdate();
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                MSSQLConnection.closePrparedStatement(ps);
                MSSQLConnection.closeConnection(con);

            }
    }

    /**
     * delete the agency whose id is @id
     * @param id
     */
    @Override
    public void deleteAgency(int id){

            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs = null;
            String sql = "DELETE FROM tbl_agency WHERE id=?";
            try{
                    con=MSSQLConnection.getConnection();
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, id);

                    ps.executeUpdate();
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                MSSQLConnection.closePrparedStatement(ps);
                MSSQLConnection.closeConnection(con);

            }
    }
    

    public static void main(String[] args) {
        Agency agency = new Agency();
        IAgency iAgency=new AgencyDAO();
        System.out.println(iAgency.getAgencyById(1).toString());
    }
    
    
}
