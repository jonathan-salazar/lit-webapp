/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salazar.lit.model;

import java.sql.Date;

/**
 *
 * @author Johnny
 */
public class LitItem {
    int itemId;
    String investorComId;
    String investorComIdOld;
    String oldCodeInUse; //could be boolean
    String title;
    String langVersion;
    String deliveryType;
    String series;
    String active;      //could be boolean
    String rebranded;   //could be boolean
    String contentType;
    String frequency;
    String searchKeyword;
    String description;
    Date createDate;
    Date updatedDate;
    String [] metaData;
    String [] fundData;
//    MetaData metaData;
//    LitFund litFund;
//
//    public MetaData getMetaData() {
//        return metaData;
//    }
//
//    public void setMetaData(MetaData metaData) {
//        this.metaData = metaData;
//    }

    public String[] getMetaData() {
        return metaData;
    }

    public String[] getFundData() {
		return fundData;
	}

	public void setFundData(String[] fundData) {
		this.fundData = fundData;
	}

	public void setMetaData(String[] metaData) {
        this.metaData = metaData;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getInvestorComId() {
        return investorComId;
    }

    public void setInvestorComId(String investorComIdNew) {
        this.investorComId = investorComIdNew;
    }

    public String getInvestorComIdOld() {
        return investorComIdOld;
    }

    public void setInvestorComIdOld(String investorComIdOld) {
        this.investorComIdOld = investorComIdOld;
    }

    public String getOldCodeInUse() {
        return oldCodeInUse;
    }

    public void setOldCodeInUse(String oldCodeInUse) {
        this.oldCodeInUse = oldCodeInUse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLangVersion() {
        return langVersion;
    }

    public void setLangVersion(String langVersion) {
        this.langVersion = langVersion;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRebranded() {
        return rebranded;
    }

    public void setRebranded(String rebranded) {
        this.rebranded = rebranded;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
