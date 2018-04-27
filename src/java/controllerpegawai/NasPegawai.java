/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerpegawai;

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
public class NasPegawai extends HttpServlet {

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
        String id= request.getParameter("noPolis");
        String ktp= request.getParameter("KTP");
        String nama = request.getParameter("nama");
        String tgllahir = request.getParameter("tgllahir");
        String status = request.getParameter("status");
        String pekerjaan = request.getParameter("pekerjaan");
        String penghasilan = request.getParameter("penghasilan");
        String alamat = request.getParameter("alamat");
        String admin = request.getParameter("admin");
        NasabahDao ndao = new NasabahDao();
        RequestDispatcher dispatcher = null;
        Date date1 = null;
        String direct = "", pesan="";
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tgllahir);
        } catch (Exception ex) {
            
        }
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            Nasabah nasabah = new Nasabah(Long.parseLong(id));
            nasabah.setKtp(ktp);
            nasabah.setNmNasabah(nama);
            nasabah.setTglLahir(date1);
            nasabah.setStatus(status);
            nasabah.setPekerjaan(pekerjaan);
            nasabah.setPenghasilan(penghasilan);
            nasabah.setAlamat(alamat);
            nasabah.setIdAdmin(new Admin(admin));
            if (ndao.insert(nasabah)) {
                pesan = "swal('Selamat!', 'Berhasil Menambahkan Data!', 'success');";
                direct = "detnasIdPegawai?noPolis"+id;
                
                
            }
            else{
                pesan = "swal('Oops...', 'Gagal Menambahkan Data !!', 'error');";
                direct = "view/pegawai/insert/nasabah.jsp";
                 
            }
            out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println(pesan);
                out.println("});");
                out.println("</script>");

                dispatcher = request.getRequestDispatcher(direct);
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
