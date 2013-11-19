<%-- 
    Document   : login
    Created on : Nov 19, 2013, 9:46:32 AM
    Author     : Lucas Pinheiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CaronUSP - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@ page import="classes.transacoes.Usuario" %>
        <%@ page import="classes.data.UsuarioDO" %>
        
        <%
        if ( session.getAttribute("user_name") != null) {
            %>
            <script type="text/javascript">
            alert("Você já está logado!");
            </script>
            <%
            pageContext.forward("index.jsp");
        }
        %>
        Bem-vindo ao CaronUSP. 
        <br>Insira seu e-mail e sua senha para ter acesso ao site.
        <form name="Login" action="login.jsp" 
              onsubmit="return validarLogin()">
            <table>
                <tr>
                <td>E-mail</td>
                <td><input type="text" name="email" />
                </tr>      
                <tr>
                <td>Senha</td>
                <td><input type="password" name="senha" />
                </tr>
            </table>
            <input type="submit" name="entrar" value="Entrar" />  
        </form>
        <p><font id="alerta" color="red"></font></p>
        <script src="login.js"></script>
    </body>
</html>

