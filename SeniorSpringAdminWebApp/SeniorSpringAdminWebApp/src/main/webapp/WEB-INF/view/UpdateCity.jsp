
<%@page import="net.seniorsteps.senior.common.bean.CityBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update City</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
        %>
        <form action="updateCity?id=<%=id%>" method="POST">
            <table width="30%">
                <tr>
                    <td>
                        <label>City Name In Arabic</label>
                    </td>
                    <td>
                        <input type="text"   name="nameAr" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>City Name In English</label>
                    </td>
                    <td>
                        <input type="text"   name="nameEn" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update" />
                        <a href="findCityList">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

