<%-- 
    Document   : index.jsp
    Created on : Feb 12, 2019, 11:48:29 AM
    Author     : Johnny
--%>

<%@ page session="false"%>
<%@ tag lib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

HI

<!DOCTYPE html>
<html lang="en">  
    
<head>
<title>Spring MVC Form Handling Example</title>

</head>
    
<body>
    <jsp:include page="./fragments/header.jsp"/>
    <br>    
        
    <form:form method="POST" action="/new-lit-item-success" modelAttribute="newLitItem">
        <h2>Lit Item Form</h2>
            <table>
                <tr>
                    <td><form:label path="title">Title:</form:label></td>
                    <td><form:input path="title"/></td> 
                </tr>
                <tr>
                    <td><form:label path="description">Description:</form:label></td>
                    <td><form:input path="description"/></td> 
                </tr>
                <tr>
                    <td><form:label path="searchKeyword">Set Item Search Keyword:</form:label></td>
                    <td><form:input path="searchKeyword"/></td> 
                </tr>
                <tr>
                    <td><form:label path="investorComId">Investor Com Id (Current Code):</form:label></td>
                    <td><form:input path="investorComId"/></td>               
                </tr>
                <tr>
                    <td><form:label path="investorComIdOld">Investor Com Id (Old Code):</form:label></td>
                    <td><form:input path="investorComIdOld"/></td>               
                </tr>
                <tr>
                    <td><form:label path="oldCodeInUse">Old Code in use?</form:label></td>
                    <td><form:select path = "oldCodeInUse">
                        <form:option value = "NONE" label = "--Select--"/>
                        <form:options items = "${yesList}" />
                        </form:select>
                    </td> 
                </tr>
                <tr>
                    <td><form:label path="langVersion">Language Version:</form:label></td>
                    <td><form:select path = "langVersion">
                        <form:option value = "NONE" label = "--Select--"/>
                        <form:options items = "${langList}" />
                        </form:select>     	
                    </td>
                </tr>
                <tr>
                    <td><form:label path="deliveryType">Delivery Type:</form:label></td>
                    <td><form:select path = "deliveryType">
                        <form:option value = "NONE" label = "--Select--"/>
                        <form:options items = "${deliveryList}" />
                        </form:select>     	
                    </td>
                </tr>
                <tr>
                    <td><form:label path="active">Active</form:label></td>
                    <td><form:select path = "active">
                        <form:option value = "NONE" label = "--Select--"/>
                        <form:options items = "${yesList}" />
                        </form:select>     	
                    </td>
                </tr>
                <tr>
                    <td><form:label path="frequency">Frequency:</form:label></td>
                    <td><form:select path = "frequency">
                        <form:option value = "NONE" label = "--Select--"/>
                        <form:options items = "${frequencyList}" />
                        </form:select>
                    </td> 
                </tr>
                <tr>
                    <td><form:label path="rebranded">Rebranded:</form:label></td>
                    <td><form:select path="rebranded"/>
                        <form:option value = "NONE" label = "--Select--"/>
                        <form:options items = "${yesList}" />
                        </form:select> 
                    </td> 
                </tr>
                <tr>
                    <td><form:label path="series">Series:</form:label></td>
                    <td><form:input path="series"/></td> 
                </tr>
                
    MetaData metaData;
                    
<td><input type="submit" value="Submit"/></td>


            </table>
        </form:form>
    </body>
</html>    