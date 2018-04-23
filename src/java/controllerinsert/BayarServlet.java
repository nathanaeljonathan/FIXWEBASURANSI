/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerinsert;

import dao.PembayaranDao;
import entities.Asuransi;
import entities.Nasabah;
import entities.Pembayaran;
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
public class BayarServlet extends HttpServlet {

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
        String id= request.getParameter("nobayar");
        String tglbayar= request.getParameter("tglbayar");
        String noPolis = request.getParameter("noPolis");
        String jmlbayar = request.getParameter("jmlbayar");
        String idasuransi = request.getParameter("idAsuransi");
        String pesan="Gagal menambah data";
        RequestDispatcher dispatcher = null;
        PembayaranDao pdao = new PembayaranDao();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(tglbayar);
        } catch (Exception ex) {
            
        }
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            Pembayaran bayar = new Pembayaran(id);
            bayar.setTglPembayaran(date1);
            bayar.setNoPolis(new Nasabah(Long.parseLong(noPolis)));
            bayar.setJumlahBayar(jmlbayar);
            bayar.setIdAsuransi(new Asuransi(idasuransi));
            if (pdao.insert(bayar)) {
                pesan="Berhasil menambah data dengan ID :"
                        +bayar.getNoPembayaran();
            }
          
//            out.print(id+", "+tglbayar+", "+noPolis+", "+jmlbayar+", "+idasuransi);
//            System.out.print("id baru: "+id+", "+tglbayar+", "+noPolis+", "+jmlbayar+", "+idasuransi);
         session.setAttribute("pesan", pesan);
         dispatcher = request.getRequestDispatcher("transaksiServlet");
         dispatcher.include(request, response);
//            System.out.println(id);
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
