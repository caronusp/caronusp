<%-- 
    Document   : login
    Created on : 29/11/2013, 18:07:58
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Página de Login do site CaronUSP">
    <meta name="author" content="Lucas Pinheiro">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>CaronUSP - Login</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="login.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <%@ page import="classes.transacoes.Usuario" %>
    <%@ page import="classes.data.UsuarioDO" %>

    <%
        if (session.getAttribute("user_name") == null) {
    %>
        <div class="container">

          <form class="form-signin">
            <h2 class="form-signin-heading">Insira seus dados para acessar sua conta.</h2>
            <input name="email" type="text" class="form-control" placeholder="Email address" required autofocus>
            <input name="senha" type="password" class="form-control" placeholder="Password" required>
            <!-- <label class="checkbox">
              <input type="checkbox" value="remember-me"> Lembrar-me.
            </label> -->
            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            <input type="hidden" name="campo_controle">
          </form>

        </div> <!-- /container -->
        
        <h4 class="form-signin-heading" align="center"><font id="alerta" color="red">
        <%
            if (request.getParameter("campo_controle") != null) {
                // processa login
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");

                int atpos = email.indexOf("@");
                int dotpos = email.lastIndexOf(".");
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length()) {
                    %> Endereço de e-mail não é válido. <%
                } else {
                    Usuario user = new Usuario();

                    if (user.verificarLogin(email, senha)) {
                        session.setAttribute("user_name", email);
                        pageContext.forward("main.jsp");
                    } else {
                            %>Usuário e/ou senha inválidos! <%

                    }
                }
            }
        }
    %>
    </font></h4>
    <%
        if (session.getAttribute("user_name") != null) {
    %>
    <table width="80" align="center">
        <tr><td>
        <form name="logout" width="30%">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Logout</button>
            <input type="hidden" name="campo_controle2" />
        </form>
        </td></tr>
    </table>
    <%
            if (request.getParameter("campo_controle2") != null) {

                out.println("Você será agora deslogado do site.");
                session.setAttribute("user_name", null);
                pageContext.forward("login.jsp");

                }
            }
        %>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://code.jquery.com/jquery.js"></script>
    	<!-- Include all compiled plugins (below), or include individual files as needed -->
    	<script src="js/bootstrap.min.js"></script>
</html>
