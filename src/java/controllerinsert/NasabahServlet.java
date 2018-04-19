/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerinsert;

import dao.NasabahDao;
import entities.Admin;
import entities.Nasabah;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class NasabahServlet extends HttpServlet {

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
        String ktp= request.getParameter("KTP");
        String id= request.getParameter("noPolis");
        String nama = request.getParameter("nama");
        String tgllahir = request.getParameter("tgllahir");
        String status = request.getParameter("status");
        String pekerjaan = request.getParameter("pekerjaan");
        String penghasilan = request.getParameter("penghasilan");
        String alamat = request.getParameter("alamat");
        String admin = request.getParameter("admin");
        String pesan="Gagal menambah data";
        RequestDispatcher dispatcher = null;
        NasabahDao ndao = new NasabahDao();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(tgllahir);
        } catch (Exception ex) {
            
        }
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            Nasabah nasabah = new Nasabah(id);
            nasabah.setKtp(ktp);
            nasabah.setNmNasabah(nama);
            nasabah.setTglLahir(date1);
            nasabah.setStatus(status);
            nasabah.setPekerjaan(pekerjaan);
            nasabah.setPenghasilan(penghasilan);
            nasabah.setAlamat(alamat);
            nasabah.setIdAdmin(new Admin(admin));
            if (ndao.insert(nasabah)) {
                pesan="Berhasil menambah data dengan ID :"
                        +nasabah.getNoPolis();
            }
          
         session.setAttribute("pesan", pesan);
//         session.setAttribute("autoID", ndao.getAutoID());
         dispatcher = request.getRequestDispatcher("nasabahServlet");
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
