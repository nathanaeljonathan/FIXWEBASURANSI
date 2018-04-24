/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerupdate;

import dao.AsuransiDao;
import entities.Asuransi;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Medina
 */
public class ProsesUpdateAsuran extends HttpServlet {

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
        String id = request.getParameter("txtID");
        String nama = request.getParameter("txtNama");
        String bunga = request.getParameter("bunga");
        String masa = request.getParameter("masa");
        String harga = request.getParameter("harga");
        AsuransiDao adao = new AsuransiDao();
        try (PrintWriter out = response.getWriter()) {
           Asuransi asuransi = new Asuransi(id);
           asuransi.setNmAsuransi(nama);
           asuransi.setBunga(BigInteger.valueOf(Long.parseLong(bunga)));
//           asuransi.setMasaBerlaku(masa);
           asuransi.setHarga(BigInteger.valueOf(Long.parseLong(harga)));
           if (adao.update(asuransi)) {
                
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Selamat!', 'Berhasil Update Data!', 'success');");
                out.println("});");
                out.println("</script>");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("asuranServlet");
                dispatcher.include(request, response);
            }
            else{
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'Gagal Update Data !!', 'error');");
                out.println("});");
                out.println("</script>");

                RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/update/asuran.jsp");
                dispatcher.include(request, response); 
            }
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
