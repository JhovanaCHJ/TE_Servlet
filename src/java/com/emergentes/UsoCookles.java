/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Omen
 */
@WebServlet(name = "UsoCookles", urlPatterns = {"/UsoCookles"})
public class UsoCookles extends HttpServlet {


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
        response.setContentType("text/htm;charset=UTF-8");
        PrintWriter out =response.getWriter();
        try{
        out.println("<!DOCTYPE html>");    
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Uso de Cookies</title>");
        out.println("</head>");
        out.println("<body>");
       //mostrar todas las cookies
       Cookie[] cookies =request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                String name =c.getName();
                String value = c.getValue();
            }
            //adicionar cookies
            String name=request.getParameter("name");
       if(name != null && name.length()> 0 ){
       String value = request.getParameter("calor");
       Cookie c =new Cookie(name,value);
       }else{
           out.println("Ponga los parametros en la URL");
       }
       out.println("</form>");
        out.println("</body>");
        out.println("</html>");
          } finally{
            out.close();
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


}
