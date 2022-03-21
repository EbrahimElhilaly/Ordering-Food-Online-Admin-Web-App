/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.presentation.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import net.seniorsteps.bll.SeniorBLGateway;
import net.seniorsteps.senior.common.bean.CityBean;

/**
 *
 * @author helali
 */
public class ListAllCitiesServlet extends HttpServlet {

 private final SeniorBLGateway seniorBLGateway = new SeniorBLGateway();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(MediaType.TEXT_HTML);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter out = response.getWriter()) {

            List<CityBean> findCities = seniorBLGateway.findCities();
            String message ="";
             
            String status = request.getParameter("s");
            if(status != null){
                
            if ("true".equals(status)) {
                message="Added Successfully";
            }else{
                message="Error in Adding";
            }
            }
            
            
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListAllCitiesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>"+message+"</p>");
            out.println("<table border = 1>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>ID</th>");
            out.println("</tr>");

            for (CityBean iCityBean : findCities) {
                out.println("<tr>");

                out.println("<td>" + iCityBean.getNameAr()+ "</td>");
                out.println("<td>" + iCityBean.getId() + "</td>");
                out.println("<td>DELETE</td>");

                out.println("</tr>");
            }

            out.println("</table>");
            
            out.println("<a href ='newCity.html'>Add New City</a>");

            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception ex) {
            throw ex;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
     
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
