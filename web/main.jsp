<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HttpSessionDemo - Pagina Principal</title>
    </head>
    <body>
        <%@ page import="classes.transacoes.Usuario" %>
        <%@ page import="classes.data.UsuarioDO" %>
<%
    // VERIFICACAO MANUAL DO LOGIN
    if ( session.getAttribute("user_name") == null) {
       pageContext.forward("login.jsp");
    }
    Usuario u = new Usuario();
    UsuarioDO udo = u.buscarPorEmail((String)session.getAttribute("user_name"));
    String nome = udo.getNome();
%>
    Bom dia <%= nome %>!!

  <li><a href="./login.jsp">Login</a>
  <li><a href="./recuperarSenha.jsp">Recuperar Senha</a>
  <li><a href="./alterarSenha.jsp">Alterar Senha</a>
  <li><a href="./search.jsp">Pesquisar Contato</a>
    </body>
</html>
