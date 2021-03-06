/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.salazar.lit.model.LitItem;



/**
 *
 * @author Johnny
 */
public class LitItemDAOSqlImpl implements LitItemDAO {

	Logger logger = LogManager.getLogger(LitItemDAOSqlImpl.class);


	public void insert(LitItem litItem) {




	}


	public int getMetaDataId(String metadata) {
		int metaId = 0;






		return metaId;
	}

	private void insertMetadata(int itemId, String[] metadata) {
    	Map<Integer, LitItem> itemMap = new HashMap<>();

    	String sqlQuery ="";

    	for (int i=0; i < metadata.length; i++) {
           String metaSql = "SELECT meta_id FROM metadata WHERE metaname = " + metadata[i];
	        try {
	            Connection con = ConnectionManager.getConnection();
	            Statement stmt = con.createStatement();
	            stmt.execute(metaSql);

	        } catch (SQLException e) {
	            logger.debug("Exception Caught!: " + e.getLocalizedMessage());
	            logger.debug("StackTrace is: " + e.getStackTrace());
	        }
    	}

	}

	private void insertFundData(int itemId, String[] fundData) {

	}


    private void insertLitItem(LitItem litItem) {
        String sqlQuery = "INSERT INTO lititem (investor_com_id, investor_com_id_old, old_code_in_use, title, "
                    + "language_version, delivery_type, series_specific, active, rebranded, content_type, frequency, search_keyword, description)"
                    + " VALUES('" + litItem.getInvestorComId() + "', '" + litItem.getInvestorComIdOld() + "', '"
                    + litItem.getOldCodeInUse() + "', '" + litItem.getTitle() + "', '" + litItem.getLangVersion()
                    + "', '" + litItem.getDeliveryType() + "', '" + litItem.getSeries() + "', '" + litItem.getActive()
                    + "', '" + litItem.getRebranded() + "', 'Brochure', '" + litItem.getFrequency()
                    + "', '" + litItem.getSearchKeyword() + "', '" + litItem.getDescription() + "')";

        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(sqlQuery);


        } catch (SQLException e) {
            logger.debug("Exception Caught!: " + e.getLocalizedMessage());
            logger.debug("StackTrace is: " + e.getStackTrace());
        }

    }

    @Override
    public void delete(int itemId) {
        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("DELETE from lititem where item_id = " + itemId );

        } catch (SQLException e) {
            logger.debug("Exception Caught!: " + e.getLocalizedMessage());
            logger.debug("StackTrace is: " + e.getStackTrace());
        }
    }

    @Override
    public void update(LitItem litItem, int itemId) {
        String sqlQuery = "UPDATE lititem SET investor_com_id = '" + litItem.getInvestorComId() + "', investor_com_id_old = '"
            + litItem.getInvestorComIdOld() + "', old_code_in_use = '" + litItem.getOldCodeInUse() + "', title = '" + litItem.getTitle()
            + "', language_version = '" + litItem.getLangVersion() + "', delivery_type = '" + litItem.getDeliveryType()
            + "', series_specific = '" + litItem.getSeries() + "', active = '" + litItem.getActive() + "', rebranded = '" + litItem.getRebranded()
            + "', content_type = '" + litItem.getContentType() + "', frequency = '" + litItem.getFrequency() + "', search_keyword = '" + litItem.getSearchKeyword()
            + "', description = '" + litItem.getDescription() + "' WHERE item_id = " + itemId;

        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(sqlQuery);

        } catch(SQLException e ){
            logger.debug("Exception Caught!: " + e.getLocalizedMessage());
            logger.debug("StackTrace is: " + e.getStackTrace());
        }
    }

    @Override
    public LitItem getLitItemById(int itemId) {
        LitItem newLitItem = new LitItem();

        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select investor_com_id, investor_com_id_old, old_code_in_use, title, language_version, "
                    + "delivery_type, series_specific, active, rebranded, content_ype, frequency, description, create_date FROM lititem WHERE item_id = " + itemId);

            while (results.next()) {
                newLitItem.setItemId(itemId);
                newLitItem.setInvestorComId(results.getString("investor_com_id"));
                newLitItem.setInvestorComIdOld(results.getString("investor_com_id_old"));
                newLitItem.setOldCodeInUse(results.getString("old_code_in_use"));
                newLitItem.setTitle(results.getString("title"));
                newLitItem.setLangVersion(results.getString("language_version"));
                newLitItem.setDeliveryType(results.getString("delivery_type"));
                newLitItem.setSeries(results.getString("series_specific"));
                newLitItem.setActive(results.getString("active"));
                newLitItem.setRebranded(results.getString("rebranded"));
                newLitItem.setContentType(results.getString("content_type"));
                newLitItem.setFrequency(results.getString("frequency"));
                newLitItem.setDescription(results.getString("description"));
                newLitItem.setCreateDate(results.getDate("create_date"));
            }
        } catch (SQLException e) {
            logger.debug("Exception Caught!: " + e.getLocalizedMessage());
            logger.debug("StackTrace is: " + e.getStackTrace());
        }
        return newLitItem;
    }

    @Override
    public ArrayList<LitItem> getAllLitItems() {
        ArrayList<LitItem> list = new ArrayList<>();

        try{
            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select investor_com_id, investor_com_id_old, old_code_in_use, title, language_version, "
                    + "delivery_type, series_specific, active, rebranded, content_ype, frequency FROM lititem");

            while (results.next()) {
                LitItem newLitItem = new LitItem();
                newLitItem.setItemId(results.getInt("item_id"));
                newLitItem.setInvestorComId(results.getString("investor_com_id"));
                newLitItem.setInvestorComIdOld(results.getString("investor_com_id_old"));
                newLitItem.setOldCodeInUse(results.getString("old_code_in_use"));
                newLitItem.setTitle(results.getString("title"));
                newLitItem.setLangVersion(results.getString("language_version"));
                newLitItem.setDeliveryType(results.getString("delivery_type"));
                newLitItem.setSeries(results.getString("series_specific"));
                newLitItem.setActive(results.getString("active"));
                newLitItem.setRebranded(results.getString("rebranded"));
                newLitItem.setContentType(results.getString("content_type"));
                newLitItem.setFrequency(results.getString("frequency"));
                newLitItem.setDescription(results.getString("description"));
                newLitItem.setCreateDate(results.getDate("create_date"));

            }
        } catch (SQLException e) {
            logger.debug("Exception Caught!: " + e.getLocalizedMessage());
            logger.debug("StackTrace is: " + e.getStackTrace());
        }
        return list;
    }


    @Override
    /**
     *
     */
    public ArrayList<LitItem>  searchByKeyword(String keyword){
    	Map<Integer, LitItem> itemMap = new HashMap<>();

    	logger.info("Searching for: " + keyword);
        itemMap = searchLitItem(keyword);

        // Now let check the meta data
    	logger.info("Searching meta data: " + keyword);
        searchItemMetaData(itemMap, keyword);

        // Check the fund table
    	logger.info("Searching fund: " + keyword);
        searchItemFund(itemMap, keyword);

        ArrayList<LitItem> list = new ArrayList<LitItem>(itemMap.values());
        return list;

    }

    /**
     *
     * @param keyword
     * @return
     */
    private Map<Integer, LitItem> searchLitItem(String keyword){
    	Map<Integer, LitItem> itemMap = new HashMap<>();
        String sqlQuery = "SELECT investor_com_id, title, description, create_date FROM lititem WHERE 1 = 1";

        if(keyword != null){
            sqlQuery += " AND title LIKE '%" + keyword + "%' "
                    + "OR investor_com_id LIKE '%" + keyword + "%' "
                    + "OR title LIKE '%" + keyword + "%' "
                    + "OR search_keyword LIKE '%" + keyword + "%' "
                    + "OR description LIKE '%" + keyword + "%'";
        }

        try{

            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery(sqlQuery);

            while(results.next()){
                LitItem newLitItem = new LitItem();
                int itemId = results.getInt("item_id");
                newLitItem.setInvestorComId(results.getString("investor_com_id"));
                newLitItem.setTitle(results.getString("title"));
                newLitItem.setDescription(results.getString("description"));
                newLitItem.setCreateDate(results.getDate("create_date"));
                logger.debug("Found item id: " + itemId + " title" + newLitItem.getTitle());
                itemMap.put(itemId, newLitItem);
            }


        } catch (SQLException e){
            logger.debug("Exception Caught!: " + e.getLocalizedMessage());
            logger.debug("StackTrace is: " + e.getStackTrace());

        }
        return itemMap;
    }

    /**
     *
     * @param itemMap
     * @param keyword
     * @return
     */
    private Map<Integer, LitItem>  searchItemMetaData(Map<Integer, LitItem> itemMap, String keyword){

        String sqlQuery = " SELECT l.item_id, investor_com_id, title, description, create_date	FROM lititem l, lit_meta lm, metadata m WHERE m.meta_name like '%" + keyword + "%';" ;

        try{

            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery(sqlQuery);

            while(results.next()){
                LitItem newLitItem = new LitItem();
                int itemId = results.getInt("item_id");
                newLitItem.setInvestorComId(results.getString("investor_com_id"));
                newLitItem.setTitle(results.getString("title"));
                newLitItem.setDescription(results.getString("description"));
                newLitItem.setCreateDate(results.getDate("create_date"));

                // Check to see if the book exists, if so ignore it
                // if not added to the map.
                if(!itemMap.containsKey(itemId)) {
                	logger.debug("Found item: " + itemId + " title: " + newLitItem.getTitle());
                	itemMap.put(itemId, newLitItem);
                }
            }


        } catch (SQLException e){
            logger.error("Exception Caught!: " + e.getLocalizedMessage());
            logger.error("StackTrace is: " + e.getStackTrace());

        }

        return itemMap;

    }

    /**
     *
     * @param itemMap
     * @param keyword
     * @return
     */
    private Map<Integer, LitItem>  searchItemFund(Map<Integer, LitItem> itemMap, String keyword){
        String sqlQuery = " SELECT l.item_id, investor_com_id, title, description, create_date	FROM lititem l, lit_fund lf, fund f WHERE f.fund_name like '%" + keyword + "%';" ;

        try{

            Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery(sqlQuery);

            while(results.next()){
                LitItem newLitItem = new LitItem();
                int itemId = results.getInt("item_id");
                newLitItem.setInvestorComId(results.getString("investor_com_id"));
                newLitItem.setTitle(results.getString("title"));
                newLitItem.setDescription(results.getString("description"));
                newLitItem.setCreateDate(results.getDate("create_date"));

                // Check to see if the book exists, if so ignore it
                // if not added to the map.
                if(!itemMap.containsKey(itemId)) {
                	 itemMap.put(itemId, newLitItem);
                }

            }

        } catch (SQLException e){
            logger.error("Exception Caught!: " + e.getLocalizedMessage());
            logger.error("StackTrace is: " + e.getStackTrace());

        }

        return itemMap;

    }

}
