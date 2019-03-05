/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.dao;

import com.salazar.lit.model.LitFund;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Johnny
 */
public class LitFundDAOSqlImpl implements LitFundDAO{

    @Override
    public void insert(LitFund litFund) {
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO fund (fund_name, fund_short_name) VALUES('" + litFund.getFundName() 
                    + "', '" + litFund.getFundShortName() + "'");
        } catch(SQLException e){
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());  
        }
    }

    @Override
    public void delete(LitFund litFund) {
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM fund WHERE fund_id = " + litFund.getFundId());
        } catch(SQLException e){
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
    }

    @Override
    public void update(LitFund litFund, int fundId) {
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE fund SET fund_name = '" + litFund.getFundName() 
                    + "', fund_short_name = '" + litFund.getFundShortName() + "' WHERE fund_id = " + fundId);
        } catch(SQLException e){
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }    
    }

    @Override
    public LitFund getLitFundById(int fundId) {
        LitFund newLitFund = new LitFund();
        
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT fund_name, fund_short_name FROM fund WHERE fund_id = " + fundId);
            
            while(results.next()){
                newLitFund.setFundId(fundId);
                newLitFund.setFundName(results.getString("fund_name"));
                newLitFund.setFundShortName(results.getString("fund_short_name"));
            }
            
        } catch(SQLException e){
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
        return newLitFund;
    }

    @Override
    public ArrayList<LitFund> getAllLitFunds() {
        ArrayList<LitFund> list = new ArrayList();
        
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT fund_id, fund_name, fund_short_name FROM fund");
            
            while(results.next()){
                LitFund newLitFund = new LitFund();
                newLitFund.setFundId(results.getInt("fund_id"));
                newLitFund.setFundName(results.getString("fund_name"));
                newLitFund.setFundShortName(results.getString("fund_short_name"));
                list.add(newLitFund);
            }
            
        } catch(SQLException e){
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
        return list;
    }
    
    //@Override
    //public ArrayList<LitFund>
    
}
