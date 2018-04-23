<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="asset/images/favicon.png">

  <title>Asuransi Kita</title>

  <!-- Bootstrap CSS -->
  <link href="asset/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="asset/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="asset/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="asset/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="asset/css/style.css" rel="stylesheet">
  <link href="asset/css/style-responsive.css" rel="stylesheet" />

</head>
<body class="login-img3-body">
  <div class="container">
    <form class="login-form" method="post" action="prosessLogin">
      <div class="login-wrap">
        <p class="login-img"><i class="icon_lock_alt"></i></p>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_profile"></i></span>
          <input type="text" class="form-control" name="idAdmin" placeholder="Username" autofocus>
        </div>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_key_alt"></i></span>
          <input type="password" class="form-control" name="namaAdmin" placeholder="Password">
        </div>
        <center>
        <button class="btn btn-primary btn-lg btn-block" value="Login" type="submit">Login</button>
        <a href="registrasi.jsp" class="btn btn-info btn-lg btn-block" type="submit" >Signup</a>
        </center>
      </div>
    </form>
        <%
        String err = (String) request.getAttribute("err");
        if(err!=null)
        {
            %>
        <script type ="text/javascript"/>
        alert('<%=err%>');
        </script>
        }
        <%
            }
        %>
  </div>
</body>
</html>