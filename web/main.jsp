<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HttpSessionDemo - Pagina Principal</title>
    </head>
    <body>
<%
    // VERIFICACAO MANUAL DO LOGIN
    if ( session.getAttribute("user_name") == null) {
       pageContext.forward("login.jsp");
    }
    
    String nome = (String)session.getAttribute("user_name");
%>
    Bom dia <%= nome %>!!

  <li><a href="./login.jsp">Login</a>
  <li><a href="./recuperarSenha.jsp">Recuperar Senha</a>
  <li><a href="./alterarSenha.jsp">Alterar Senha</a>
  <li><a href="./search.jsp">Pesquisar Contato</a>
    </body>
</html>
