<%-- 
    Document   : UpdateCity
    Created on : Mar 3, 2020, 7:54:59 PM
    Author     : helali
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.web.app.senior.beans.AreaBean"%>
<%@page import="net.web.app.senior.beans.CityBean"%>
<%@page import="net.web.app.senior.bll.SeniorBLGateWay"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%!
        SeniorBLGateWay gateWay = new SeniorBLGateWay();
        List<CityBean> cityList = new ArrayList<>();
        CityBean city = new CityBean();
        AreaBean area = new AreaBean();
        Integer id;
        String idString;
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update City</title>
    </head>
    <body>
        <%
            cityList = gateWay.findCityList();
            idString = request.getParameter("id");
            if (null != idString) {
                id = Integer.parseInt(idString);
                area = gateWay.findAreaById(id);
                city = area.getCityBean();

            }
        %>
        <form action="UpdateArea?id=<%=id%>" method="POST">
            <table width="30%">
                <tr>
                    <td>
                        <label>Area Name In Arabic</label>
                    </td>
                    <td>
                        <input type="text"  placeholder="<%=area.getNameAr()%>" name="nameAr" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Area Name In English</label>
                    </td>
                    <td>
                        <input type="text"  placeholder="<%=area.getNameEn()%>" name="nameEn" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>City</label>
                    </td>
                    <td>
                        <select   name="city_id">
                            <%
                                for (CityBean iCity : cityList) {
                            %>
                            <option value="<%=iCity.getId()%>" 
                                    <%if (city.getId().equals(iCity.getId())) {%> selected = "selected"<%}%> >
                                <%= iCity.getNameEn()%></option>
                                <%}%>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update" />
                        <a href="ViewCity.jsp?id=<%= city.getId()%>">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

