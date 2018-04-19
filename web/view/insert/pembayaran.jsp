<%-- 
    Document   : pembayaran
    Created on : Apr 18, 2018, 2:47:52 PM
    Author     : Medina
--%>

<%@page import="entities.Asuransi"%>
<%@page import="dao.AsuransiDao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Asuransi Kita</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">-->


        <!--For Plugins external css-->
        <link rel="stylesheet" href="assets/css/plugins.css" />
        <link rel="stylesheet" href="assets/css/roboto-webfont.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <div class='preloader'><div class='loaded'>&nbsp;</div></div>
        <!-- Sections -->
        <section id="social" class="social">
            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="social-wrapper">
                        <div class="col-md-6">
                            <div class="social-icon">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="social-contact">
                                <a href="#"><i class="fa fa-phone"></i>+011217779</a>
                                <a href="#"><i class="fa fa-envelope"></i>contact@asuransikita.com</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- /container -->       
        </section>

        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><img src="assets/images/logo2.png" alt="Logo" /></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="index.html">Home</a></li>
                        <li><a href="admServlet">ADMIN</a></li>
                        <li><a href="nasabahServlet">NASABAH</a></li>
                        <li><a href="asuransiServlet">ASURANSI</a></li>
                        <li><a href="transaksiServlet">PEMBAYARAN</a></li>
                        <li><a href="#contact">REPORT</a></li>
                        <li><a href="#contact">CONTACT</a></li>
                        <!--<li class="login"><a href="#">Sign In</a></li>-->
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <section id="admin" class="contact sections">
            <div class="container">
                <div class="row">
                    <div class="main_contact whitebackground">
                        <div class="head_title text-center">
                            <h2>PEMBAYARAN</h2>
                        </div>
                        <div class="contact_content">
                            <div class="col-md-6">
                                <div class="single_left_contact">
                                    <form id="formid" action="bayarInsertServlet" method="POST">
                                        <% String asr = (String) session.getAttribute("autoID");%>

                                        <div class="form-group">
                                            <input type="text" class="form-control" name="nobayar" placeholder="No Pembayaran" value="<%= asr%>">
                                        </div>

                                        <div class="form-group">
                                            <input type="date" class="form-control" name="tglbayar" placeholder="Tanggal Bayar" value="">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" name="noPolis" placeholder="No Polis" required="" value="">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" name="jmlbayar" placeholder="Jumlah Bayar" required="" value="">
                                        </div>

                                        <div>
                                            <select name="idasuransi">
                                                <% List<Object> datas2 = new AsuransiDao().getAll();
                                                    for (Object data : datas2) {
                                                        Asuransi asrr = (Asuransi) data;%>
                                                <option value="<%= asrr.getIdAsuransi()%>"><%= asrr.getNmAsuransi()%></option>
                                                <%
                                                        }%>
                                            </select>
                                        </div>
                                            

                                        <div class="center-content">
                                            <input type="submit" value="Add" class="btn btn-default">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section><!-- End of Contact Section -->
        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/modernizr.js"></script>
        <script src="assets/js/main.js"></script>

    </body>
</html>
