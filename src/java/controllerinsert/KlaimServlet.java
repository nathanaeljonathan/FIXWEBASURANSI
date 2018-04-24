/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerinsert;

import dao.KlaimDao;
import entities.Asuransi;
import entities.Klaim;
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
public class KlaimServlet extends HttpServlet {

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
        String id = request.getParameter("idklaim");
        String noPolis = request.getParameter("noPolis");
        String idAsuransi = request.getParameter("idAsuransi");
        String tglklaim = request.getParameter("tglklaim");
        KlaimDao kmdao = new KlaimDao();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tglklaim);
        } catch (Exception ex) {
            
        }
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            Klaim klaim = new Klaim(id);
            klaim.setNoPolis(new Nasabah(Long.parseLong(noPolis)));
            klaim.setIdAsuransi(new Asuransi(idAsuransi));
            klaim.setTglKlaim(date1);
            if (kmdao.insert(klaim)) {
                
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Selamat!', 'Berhasil Menambahkan Data!', 'success');");
                out.println("});");
                out.println("</script>");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("klaimServlet");
                dispatcher.include(request, response);
            }
            else{
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'Gagal Menambahkan Data !!', 'error');");
                out.println("});");
                out.println("</script>");

                RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/insert/klaim.jsp");
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
