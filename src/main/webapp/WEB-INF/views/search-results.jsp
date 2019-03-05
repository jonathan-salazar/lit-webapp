<%-- 
    Document   : search-results.jsp
    Created on : Feb 12, 2019, 11:45:51 AM
    Author     : Johnny
--%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.salazar.lit.model.LitItem" %>


<html lang="en">  
    <head>
    <title>Master Canada Lit Inventory</title>

    </head>

    <body>
        <jsp:include page="./fragments/header.jsp"/>
        <br><br>    
        Search Results

        <% ArrayList<LitItem> litItemList = (ArrayList<LitItem>)request.getAttribute("litItemList");
        %>
        
        <br>
        <%  if(litItemList.size() == 0){  %>  
            <div id="no-lit-items">Sorry no items in inventory yet.</div>
        <% } else { %>
                <div id="lit-items">
                    <div id="header">List of Search Results</div>
                            <div id="lit-items-header">
                                <div class="column">Investor Com Id</div>
                                <div class="column">Title</div>
                                <div class="column">Description</div>
                                <div class="column">Date Created</div>
                        </div>
                </div>

        <%        for(LitItem litItem : litItemList) {
        %>        
                        <div id="litItem">
                                <div class="column"><%= litItem.getInvestorComId()%></div>
                                <div class="column"><%= litItem.getTitle()%></div>
                                <div class="column"><%= litItem.getDescription()%></div>
                                <div class="column"><%= litItem.getCreateDate()%></div>
                                <li><a href="/lit-item-details">View All Item Details</a></li>
                        </div>
        <% }    
                } %>
        
    </body>
</html>