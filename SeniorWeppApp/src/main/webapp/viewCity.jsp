<%-- 
    Document   : viewCity
    Created on : Jan 16, 2022, 5:29:12 AM
    Author     : helali
--%>



<%@page import="net.seniorsteps.senior.common.bean.AreaBean"%>
<%@page import="net.seniorsteps.senior.common.bean.CityBean"%>
<%@page import="net.seniorsteps.bll.SeniorBLGateway"%>


<%!
    private final SeniorBLGateway seniorBLGateway = new SeniorBLGateway();
%>

<% 
    Integer id = Integer.parseInt(request.getParameter("id"));
  CityBean cityBean = seniorBLGateway.getCity(id);
  
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>View City</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <Td><%= id %></Td>
                
            </tr>
            <tr>
                <th>Name(AR)</th>
                <Td><%= cityBean.getNameAr() %></Td>               
            </tr>
            <tr>
                <th>Name(EN)</th>
                <Td><%= cityBean.getNameEn() %></Td>                
            </tr>
                      
        </table>
            <h2> City Areas</h2>
              
            <table border="1" >
                <tr>         
                    <th>ID</th>
                    <th>Name(AR)</th>
                    <th>Name(EN)</th>    
                    <th colspan="3">Actions</th> 
                </tr>
                <%for(AreaBean areaBean : cityBean.getAreasList()){ %>
                 <tr>         
                    <td><%=areaBean.getId() %></td>
                    <td><%=areaBean.getNameAr() %></td>
                    <td><%=areaBean.getNameEn() %></td> 
                    
                    
                    <td><a href="viewArea.jsp?id=<%=areaBean.getId()%>">View</a></td> 
                    <td><a href="editArea.jsp?id=<%=areaBean.getId()%>">Edit</a></td> 
                    <td><a href="deleteArea?id=<%=areaBean.getId()%>">Delete</a></td> 
                </tr>
                <%}%>
                
            </table>
                <a href="newArea.jsp?cityId=<%= id %>">Add New Area</a>
    </body>
</html>
