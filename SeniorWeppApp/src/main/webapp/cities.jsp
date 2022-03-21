<%-- 
    Document   : cities
    Created on : Jan 14, 2022, 11:50:29 AM
    Author     : helali
--%>

<%@page import="java.util.List"%>
<%@page import="net.seniorsteps.senior.common.bean.CityBean"%>
<%@page import="net.seniorsteps.bll.SeniorBLGateway"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%!
    private final SeniorBLGateway seniorBLGateway = new SeniorBLGateway();
%>

<%
    List<CityBean> findCities = seniorBLGateway.findCities();
    String message = "";

    String status = request.getParameter("s");
    if (status != null) {

        if ("true".equals(status)) {
            message = "Added Successfully";
        } else {
            message = "Error in Adding";
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <p><%= message%></p>

        <table border = 1>

            <tr>

                <th>ID</th>
                <th>Name(AR)</th>
                <th>Name(EN)</th>
                <th colspan="3">Actions</th>

            </tr>  

            <% for (CityBean iCityBean : findCities) {%>
            <tr>
                <td><%= iCityBean.getId()%></td>
                <td><%= iCityBean.getNameAr()%></td>
                <td><%= iCityBean.getNameEn()%></td>


                <td><a href="viewCity.jsp?id=<%=iCityBean.getId()%>">View</a></td>
                <td><a href="editCity.jsp?id=<%=iCityBean.getId()%> ">Edit</a></td>
                <td><a href="deleteCity" 
                       onclick="if (confirm('Are you Sure?')) {
                                   return true
                               } else {
                                   return false
                               }">Delete</a></td>

            </tr>

            <% }%>

        </table>

        <a href ='newCity.html'>Add New City</a>


    </body>
</html>


</body>
</html>
