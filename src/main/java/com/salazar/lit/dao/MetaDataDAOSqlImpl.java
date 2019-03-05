/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.dao;

import com.salazar.lit.model.MetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Johnny
 */
public class MetaDataDAOSqlImpl implements MetaDataDAO {

    @Override
    public void insert(MetaData mData) {
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            //Finish Query
           /** stmt.execute("INSERT INTO metadata (on_web, mers, results, pm_years_of_exp, annual_stats, "
                    + "capital_advantage, morningstar_stewardship, firm_specific)"
                    + " VALUES ('" + mData.getOnWeb() + "', '" + mData.getMers() + "', '"
                    + mData.getResults() + "', '" + mData.getPmYrsOfExp() + "', '" + mData.getAnnualStats() 
                    + "', '" + mData.getCapAdv() + "', '" + mData.getMstarStewardship() + "', '" + mData.getFirmSpecific() + "')");
            **/
        } catch (SQLException e) {
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
    }
    
    //Check Delete statement
    @Override
    public void delete(MetaData mData) {
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            /** stmt.execute("DELETE FROM metadata WHERE m_id = " + mData.getMetaId());
            **/
        } catch (SQLException e) {
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
    }

    @Override
    public void update(MetaData mData, int metaId) {
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            //Finish Query
           /** stmt.execute("UPDATE metadata SET on_web = '" + mData.getOnWeb() + "', mers = '" + mData.getMers() 
                    + "', results = '" + mData.getResults() + "', pm_years_of_exp = '" + mData.getPmYrsOfExp()
                    + "', annual_stats = '" + mData.getAnnualStats() + "', capital_advantage = '" + mData.getCapAdv()
                    + "', morningstar_stewardship = '" + mData.getMstarStewardship() + "', firm_specific = '" + mData.getFirmSpecific()
                    + "' WHERE m_id = " + metaId);
           **/ 
        } catch (SQLException e) {
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
    }

    @Override
    public MetaData getMetaDataById(int metaId) {
        MetaData newMetaData = new MetaData();
        
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select m_id, on_web, mers, results, pm_years_of_exp, "
                    + "annual_stats, capital_advantage, morningstar_stewardship, firm_specific FROM metadata WHERE m_id = " + metaId);
            
            while (results.next()) {
              /**  newMetaData.setMetaId(metaId);
                newMetaData.setOnWeb(results.getString("on_web"));
                newMetaData.setMers(results.getString("mers"));
                newMetaData.setResults(results.getString("results"));
                newMetaData.setPmYrsOfExp(results.getString("pm_years_of_exp"));
                newMetaData.setAnnualStats(results.getString("annual_stats"));
                newMetaData.setCapAdv(results.getString("capital_advantage"));
                newMetaData.setMstarStewardship(results.getString("morningstar_stewardship"));
                newMetaData.setFirmSpecific(results.getString("firm_specific"));
               **/                 
            }   
        } catch (SQLException e) {
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
        
        return newMetaData;
    }

    @Override
    public ArrayList<MetaData> getAllMetaData() {
        ArrayList<MetaData> list = new ArrayList();
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select m_id, on_web, mers, results, pm_years_of_exp, "
                    + "annual_stats, capital_advantage, morningstar_stewardship, firm_specific FROM metadata");
            
            while (results.next()) {
                MetaData newMetaData = new MetaData();
               /** newMetaData.setMetaId(results.getInt("m_id"));
                newMetaData.setOnWeb(results.getString("on_web"));
                newMetaData.setMers(results.getString("mers"));
                newMetaData.setResults(results.getString("results"));
                newMetaData.setPmYrsOfExp(results.getString("pm_years_of_exp"));
                newMetaData.setAnnualStats(results.getString("annual_stats"));
                newMetaData.setCapAdv(results.getString("capital_advantage"));
                newMetaData.setMstarStewardship(results.getString("morningstar_stewardship"));
                newMetaData.setFirmSpecific(results.getString("firm_specific"));
                list.add(newMetaData);
                **/
            }   
        } catch (SQLException e) {
            System.out.println("Exception Caught!: " + e.getLocalizedMessage());
            System.out.println("StackTrace is: " + e.getStackTrace());
        }
        return list;
    }
    
}
