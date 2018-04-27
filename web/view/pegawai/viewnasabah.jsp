<%@page import="entities.Klaim"%>
<%@page import="dao.KlaimDao"%>
<%@page import="dao.Detail_nasDao"%>
<%@page import="entities.DetailNasabah"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="entities.Admin"%>
<%@page import="dao.AdminDao"%>
<%@page import="entities.Nasabah"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="asset/images/favicon.png">
        <title>Asuransi Kita</title>
        <!-- Bootstrap Core CSS -->
        <link href="asset/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="asset/css/helper.css" rel="stylesheet">
        <link href="asset/css/style.css" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:** -->
        <!--[if lt IE 9]>
        <script src="https:**oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https:**oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>

    <body class="fix-header fix-sidebar">
        <%
            Object datas = session.getAttribute("nasabah");
            Nasabah nasabah = (Nasabah) datas;
        %>
        <!-- Preloader - style you can find in spinners.css -->
        <div class="preloader">
            <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
        </div>
        <!-- Main wrapper  -->
        <div id="main-wrapper">
            <!-- header header  -->
            <div class="header">
                <nav class="navbar top-navbar navbar-expand-md navbar-light">
                    <!-- Logo -->
                    <div class="navbar-header">
                        <a class="navbar-brand" href="indexadmin.jsp">
                            <!-- Logo icon -->
                            <b><img src="images/logo.png" alt="Asuransi" class="dark-logo" /></b>
                            <!--End Logo icon -->
                            <!-- Logo text -->
                            <span><img src="images/logo2.png" alt="Kita" class="dark-logo" /></span>
                        </a>
                    </div>
                    <!-- End Logo -->
                    <div class="navbar-collapse">
                        <!-- toggle and nav items -->
                        <ul class="navbar-nav mr-auto mt-md-0">
                            <!-- This is  -->
                            <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted  " href="javascript:void(0)"><i class="mdi mdi-menu"></i></a> </li>
                            <li class="nav-item m-l-10"> <a class="nav-link sidebartoggler hidden-sm-down text-muted  " href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                        </ul>
                        <!-- User profile and search -->
                        <ul class="navbar-nav my-lg-0">

                            <!-- Comment -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fa fa-bell"></i>
                                    <div class="notify"> <span class="heartbit"></span> <span class="point"></span> </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right mailbox animated zoomIn">
                                    <ul>
                                        <li>
                                            <div class="drop-title">Notifications</div>
                                        </li>
                                        <li>
                                            <div class="message-center">
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="btn btn-danger btn-circle m-r-10"><i class="fa fa-link"></i></div>
                                                    <div class="mail-contnet">
                                                        <h5>This is title</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span>
                                                    </div>
                                                </a>
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="btn btn-success btn-circle m-r-10"><i class="ti-calendar"></i></div>
                                                    <div class="mail-contnet">
                                                        <h5>This is another title</h5> <span class="mail-desc">Just a reminder that you have event</span> <span class="time">9:10 AM</span>
                                                    </div>
                                                </a>
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="btn btn-info btn-circle m-r-10"><i class="ti-settings"></i></div>
                                                    <div class="mail-contnet">
                                                        <h5>This is title</h5> <span class="mail-desc">You can customize this template as you want</span> <span class="time">9:08 AM</span>
                                                    </div>
                                                </a>
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="btn btn-primary btn-circle m-r-10"><i class="ti-user"></i></div>
                                                    <div class="mail-contnet">
                                                        <h5>This is another title</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </li>
                                        <li>
                                            <a class="nav-link text-center" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <!-- End Comment -->
                            <!-- Messages -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted  " href="#" id="2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fa fa-envelope"></i>
                                    <div class="notify"> <span class="heartbit"></span> <span class="point"></span> </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right mailbox animated zoomIn" aria-labelledby="2">
                                    <ul>
                                        <li>
                                            <div class="drop-title">You have 4 new messages</div>
                                        </li>
                                        <li>
                                            <div class="message-center">
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="user-img"> <img src="asset/images/users/5.jpg" alt="user" class="img-circle"> <span class="profile-status online pull-right"></span> </div>
                                                    <div class="mail-contnet">
                                                        <h5>Michael Qin</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:30 AM</span>
                                                    </div>
                                                </a>
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="user-img"> <img src="asset/images/users/2.jpg" alt="user" class="img-circle"> <span class="profile-status busy pull-right"></span> </div>
                                                    <div class="mail-contnet">
                                                        <h5>John Doe</h5> <span class="mail-desc">I've sung a song! See you at</span> <span class="time">9:10 AM</span>
                                                    </div>
                                                </a>
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="user-img"> <img src="asset/images/users/3.jpg" alt="user" class="img-circle"> <span class="profile-status away pull-right"></span> </div>
                                                    <div class="mail-contnet">
                                                        <h5>Mr. John</h5> <span class="mail-desc">I am a singer!</span> <span class="time">9:08 AM</span>
                                                    </div>
                                                </a>
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="user-img"> <img src="asset/images/users/4.jpg" alt="user" class="img-circle"> <span class="profile-status offline pull-right"></span> </div>
                                                    <div class="mail-contnet">
                                                        <h5>Michael Qin</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </li>
                                        <li>
                                            <a class="nav-link text-center" href="javascript:void(0);"> <strong>See all e-Mails</strong> <i class="fa fa-angle-right"></i> </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <!-- End Messages -->
                            <!-- Profile -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="asset/images/users/5.jpg" alt="user" class="profile-pic" /></a>
                                <div class="dropdown-menu dropdown-menu-right animated zoomIn">
                                    <ul class="dropdown-user">
                                        <li><a href="#"><i class="ti-user"></i> Profile</a></li>
                                        <li><a href="#"><i class="ti-wallet"></i> Balance</a></li>
                                        <li><a href="#"><i class="ti-email"></i> Inbox</a></li>
                                        <li><a href="#"><i class="ti-settings"></i> Setting</a></li>
                                        <li><a href="prosesLogout"><i class="fa fa-power-off"></i> Logout</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- End header header -->
            <!-- Left Sidebar  -->
            <div class="left-sidebar">
                <!-- Sidebar scroll-->
                <div class="scroll-sidebar">
                    <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li class="nav-devider"></li>
                        <li> <a href="indexpegawai.jsp" aria-expanded="false"><i class="fa fa-dashboard" ></i><span class="hide-menu">Dashboard</span></a></li>

                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-file-archive-o"></i><span class="hide-menu">Master</span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="nasabahPegawai">Nasabah</a></li>
                                <li><a href="detailNasPegawai">Detail Nasabah</a></li>
                            </ul>
                        </li>
                        
                        <li> <a href="transaksiPegawai" aria-expanded="false"><i class="fa fa-money"></i><span class="hide-menu">Transaksi</span></a></li>
                        <li> <a href="klaimPegawai" aria-expanded="false"><i class="fa fa-deaf"></i><span class="hide-menu">Klaim</span></a></li>
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
            </div>
            <!-- End Left Sidebar  -->
            <!-- Page wrapper  -->
            <div class="page-wrapper">
                <!-- Bread crumb -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-primary">Master</h3> </div>
                    <div class="col-md-7 align-self-center">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Master</a></li>
                            <li class="breadcrumb-item active">Nasabah</li>
                            <li class="breadcrumb-item active">Detail</li>
                        </ol>
                    </div>
                </div>
                <!-- End Bread crumb -->
                <!-- Container fluid  -->
                <div class="container-fluid">
                    <!-- Start Page Content -->
                    <div class="row">
                        <div class="col-lg-9">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">DATA NASABAH POLIS <%= nasabah.getNoPolis()%></h4>
                                    <form class="form p-t-20" action="" method="">
                                        <% DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                            String cc = dateFormat.format(nasabah.getTglLahir());%>

                                        <div class="form-group">
                                            <label for="exampleInputKtp">KTP</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"></div>
                                                <input type="text" class="form-control" id="exampleInputKtp" name="ktp" value="<%= nasabah.getKtp()%>" disabled="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="exampleInputNama">Nama Nasabah</label>
                                            <div class="input-group">
                                                <div class="input-group-addon"></div>
                                                <input type="text" class="form-control" id="exampleInputNama" name="nama" required="" value="<%= nasabah.getNmNasabah()%>" disabled="">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="exampleInputTgl">Tanggal Lahir</label>
                                            <div class="input-group">
                                                <input type="date" class="form-control" placeholder="dd/mm/yyyy" name="tgllahir" value="<%= cc%>" disabled="">
                                            </div>
                                        </div>
                                </div>

                                <div class="form-group">
                                    <label for="status">Status</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"></div>
                                        <input type="text" class="form-control" id="status" name="status" value="<%= nasabah.getStatus()%>" disabled="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pekerjaan">Pekerjaan</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"></div>
                                        <input type="text" class="form-control" id="pekerjaan" name="pekerjaan" value="<%= nasabah.getPekerjaan()%>" disabled="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="penghasilan">Penghasilan</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"></div>
                                        <input type="text" class="form-control" id="penghasilan" name="penghasilan" value="Rp<%= nasabah.getPenghasilan()%>" disabled="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="alamat">Alamat</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"></div>
                                        <input type="text" class="form-control" id="alamat" name="alamat" value="<%= nasabah.getAlamat()%>" disabled="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="admin">Admin</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"></div>
                                        <input type="text" class="form-control" id="admin" name="admin" value="<%= nasabah.getIdAdmin().getNamaAdmin()%>" disabled="">
                                    </div>
                                </div>
                                </form>
                                <!-- Start Page Content -->
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <center><h4 class="card-title">ASURANSI YANG DIMILIKI</h4></center>
                                                <div class="table-responsive m-t-40">
                                                    <table id="myTable" class="table table-bordered table-striped">
                                                        <thead>
                                                            <tr> 
                                                                <th>ASURANSI</th>
                                                                <th>SALDO</th>
                                                                <th>STATUS</th>
                                                                <th>TANGGAL KLAIM</th>
                                                                <th>HISTORY TRANSAKSI</th>
                                                            </tr>
                                                        </thead>
                                                        <%
                                                            List<Object> datas3 = new Detail_nasDao().search("noPolis", nasabah.getNoPolis().toString());
                                                            if (!datas3.isEmpty()) {

                                                                for (Object data : datas3) {
                                                                    
                                                                    DetailNasabah a = (DetailNasabah) data;


                                                        %>
                                                        <tr>

                                                            <td><%= a.getIdAsuransi().getNmAsuransi()%></td>
                                                            <td><%= a.getSaldo()%></td>
                                                            <td>BELUM KLAIM</td>
                                                            <td>-</td>
                                                             <td>
                                                                <a href="viewNasHistoryServlet?id=<%= a.getIdAsuransi() %>"><i class="fa fa-eye"></i></a>
                                                            </td>


                                                        </tr>
                                                        <%
                                                                }
                                                            }
                                                            List<Object> klaim = new KlaimDao().search("noPolis", nasabah.getNoPolis().toString());
                                                            if (!klaim.isEmpty()) {

                                                                for (Object data2 : klaim) {
                                                                    
                                                                    Klaim a = (Klaim) data2;
                                                        %>
                                                        <tr>

                                                            <td><%= a.getIdAsuransi().getNmAsuransi()%></td>
                                                            <td>-</td>
                                                            <td>SUDAH KLAIM</td>
                                                            <td><%= a.getTglKlaim()%></td>
                                                             <td>
                                                                <a href="viewNasHistoryServlet?id=<%= a.getIdKlaim()%>"><i class="fa fa-eye"></i></a>
                                                            </td>


                                                        </tr><%
                                                                }
                                                            }
                                                        %>
                                                    </table>
                                                    <br>
                                                    <!--                                    <a href="detNasAutoID" class="btn btn-success m-b-10 m-l-5">Add</a>-->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- End PAge Content -->
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End PAge Content -->
            </div>
            <!-- End Container fluid  -->
        </div>
        <!-- End Page wrapper  -->
    </div>
    <!-- End Wrapper -->
    <!-- All Jquery -->
    <script src="asset/js/lib/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="asset/js/lib/bootstrap/js/popper.min.js"></script>
    <script src="asset/js/lib/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="asset/js/jquery.slimscroll.js"></script>
    <!--Menu sidebar -->
    <script src="asset/js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="asset/js/lib/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <!--Custom JavaScript -->
    <script src="asset/js/custom.min.js"></script>

</body>

</html>