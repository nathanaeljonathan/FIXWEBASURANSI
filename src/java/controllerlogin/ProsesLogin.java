/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerlogin;

import dao.AdminDao;
import entities.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Medina
 */
public class ProsesLogin extends HttpServlet {

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
        String username = request.getParameter("idAdmin");
        String password = request.getParameter("namaAdmin");
        String err="";
        int q=0;
        Admin ad = (Admin) new AdminDao().getById(username);
          if (ad == null) {
            err = "Tidak ada data dengan ID tersebut";
            }
          else if(username.equals("") || password==null){
                err="Username harus diisi";
            }
            else if(password.equals("") || username==null){
                err="Password harus diisi";
            }
            else if(ad.getIdAdmin().equals(username) && ad.getNamaAdmin().equals(password))
            {
                HttpSession session = request.getSession();
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                Admin admin = new Admin();
                admin.setIdAdmin(username);
                admin.setNamaAdmin(password);
                session.setAttribute("admin", admin);
                rd.forward(request, response);
        }
              request.setAttribute("err", err);
            RequestDispatcher rd = request.getRequestDispatcher("log-in.jsp");
            rd.forward(request, response);
            
            if(q==0){
            request.setAttribute("err", err);
            rd = request.getRequestDispatcher("log-in.jsp");
            rd.forward(request, response);
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
