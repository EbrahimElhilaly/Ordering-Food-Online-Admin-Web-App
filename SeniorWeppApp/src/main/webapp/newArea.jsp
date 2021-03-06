<%-- 
    Document   : newArea
    Created on : Jan 17, 2022, 6:23:32 AM
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
 
 Integer cityId = Integer.parseInt(request.getParameter("cityId"));
 
   List<CityBean> foundCities = seniorBLGateway.findCities();
 



%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <<body>
     
        <form action="addArea" method="POST">
            
            <table>
                <tr>
                    <th colspan="2">Add New City</th>
                </tr>
                <tr>
                    <th>Name(AR)</th>
                    <td>
                        <input type ="text" name="name_ar"/>
                    </td>   
                </tr>
                <tr>
                    <th>Name(EN)</th>
                    <td>
                        <input type ="text" name="name_en"/>
                    </td>   
                </tr>
                <tr>
                    <th>City</th>
                    <td>
                        <select>
                            <option disabled="disabled"> --select--</option>
                            <% for (CityBean iCityBean : foundCities){%>
                            <option 
                                <% if(iCityBean.getId().equals(cityId)) {%>
                                selected="selected"
                                <%}%>
                                value="<%= iCityBean.getId()%>"
                                ><%= iCityBean.getName()%></option>
                                
                            <%}%>
                            
                        </select>
                        <input type ="hidden" name="city_id" value="<%= cityId %>"/>
                    </td>   
                </tr>
               
                <tr>
                    <th colspan="1">
                        <input type="submit" name="add_button" value="Save & Exit"/>
                    </th>
                    <th colspan="2">
                        <input type="submit" name="add_button" value="Save & Add Another"/>
                    </th>
                    
                </tr>

            </table>
            
        </form>
       
    </body>
</html>
