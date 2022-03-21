<%-- 
    Document   : editCity
    Created on : Jan 16, 2022, 9:22:47 AM
    Author     : helali
--%>

<%@page import="net.seniorsteps.senior.dal.DBConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="net.seniorsteps.senior.common.bean.CityBean"%>
<%@page import="net.seniorsteps.bll.SeniorBLGateway"%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    private final SeniorBLGateway seniorBLGateway = new SeniorBLGateway();
%>

<% 
    Integer id = Integer.parseInt(request.getParameter("id"));
    CityBean cityBean = seniorBLGateway.getCity(id);
  
 
                
  
%>



<!DOCTYPE html>
<html>
<head>
        
        <title> Edit City </title>
        <meta  charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
     
        <form action="editCity" method="POST">
            
            <table>
                <tr>
                    <th colspan="2">Edit City</th>
                </tr>
                <tr>
                    <th>Name(AR)</th>
                    <td>
                        <input type ="text" name="name_ar" value="<%= cityBean.getNameAr() %>"/>
                    </td>   
                </tr>
                <tr>
                    <th>Name(EN)</th>
                    <td>
                        <input type ="text" name="name_en" value="<%= cityBean.getNameEn() %>"/>
                    </td>   
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" name="edit_button" value="Edit"/>
                    </th>
                    
                </tr>
            </table>
            
        </form>
       
    </body>
</html>
