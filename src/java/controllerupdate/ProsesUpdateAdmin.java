/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerupdate;

import dao.AdminDao;
import entities.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Medina
 */
public class ProsesUpdateAdmin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String id= request.getParameter("idAdmin");
        String nama = request.getParameter("nmAdmin");
        String alamat = request.getParameter("alamat");
        String noTelp = request.getParameter("noTelp");
        String email = request.getParameter("email");
        String pesan="Gagal mengubah data";
        RequestDispatcher dispatcher = null;
        AdminDao amdao = new AdminDao();
        try (PrintWriter out = response.getWriter()) {
            Admin admin = new Admin(id);
            admin.setNamaAdmin(nama);
            admin.setAlamat(alamat);
            admin.setEmail(email);
            admin.setNoTelp(noTelp);
            if(amdao.update(admin)){
                pesan = "Berhasil Update Data dengan ID : "
                        +admin.getIdAdmin();
            }
            out.println(pesan);
            dispatcher = request.getRequestDispatcher("admServlet");
            dispatcher.include(request, response);
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
