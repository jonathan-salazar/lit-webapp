<%-- 
    Document   : search.jsp
    Created on : Feb 12, 2019, 11:45:31 AM
    Author     : Johnny
--%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html lang="en">  
    <head>
    <title>Master Canada Lit Inventory</title>

    </head>

    <body>
        <jsp:include page="./fragments/header.jsp"/>
        <br>        

        <form:form method="POST" action="/search-results" modelAttribute="newLitItem">
            <h2>Search Form</h2>
                <table>
                    <tr>
                        <td><form:label path="searchKeyword">Search by keyword</form:label></td>
                        <td><form:input path="searchKeyword"/></td> 
                    </tr>
                    
                    <td><input type="submit" value="Search"/></td>
                    
                </table>
        </form:form>
    </body>
</html>
