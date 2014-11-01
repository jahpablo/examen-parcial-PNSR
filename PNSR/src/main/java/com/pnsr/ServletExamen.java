package com.pnsr;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ServletExamen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        SessionFactory sf = HibernateUtil.getSessionFactory(); 
         Session s = sf.openSession(); 
        Transaction t = s.beginTransaction();              
             String nombre = request.getParameter("Ana"); 
             String calificacion = request.getParameter("7"); 
             Evaluacion e = new Evaluacion();             
             e.setNombre(nombre); 
             e.setCalificacion(calificacion);               
             s.update(t); 
             t.commit(); 
             s.close(); 
    }
}
