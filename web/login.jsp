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
        if ( session.getAttribute("user_name") == null) {
        %>
        Bem-vindo ao CaronUSP. 
        <br>Insira seu e-mail e sua senha para ter acesso ao site.
        <form name="Login">
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
            <input type="hidden" name="campo_controle" />
        </form>
        <p><font id="alerta" color="red">
            <%
                if ( request.getParameter("campo_controle") != null ) {
                    // processa login
                    String email = request.getParameter("email");
                    String senha = request.getParameter("senha");
                    
                    int atpos = email.indexOf("@");
                    int dotpos = email.lastIndexOf(".");
                    if (atpos<1 || dotpos<atpos+2 || dotpos+2 >= email.length()) {
                        %> Endereço de e-mail não é válido. <%
                    } else {
                        //Usuario user = new Usuario();
                        //UsuarioDO userDO = user.buscarPorEmail(email);

                        //if (userDO == null) {
                        if(!email.equals("oi@oi.com")) {
                            %> Usuário e/ou senha inválidos! <%
                        //} else if ( senha.equals(userDO.getSenha())) {
                        } else if (senha.equals("123")) {
                            session.setAttribute("user_name", email);
                            pageContext.forward("main.jsp");
                        } else {
                            %>Usuário e/ou senha inválidos! <%
                        }                        
                    }
                }                   
            %>
        </font></p>
        <% } 
        if ( session.getAttribute("user_name") != null) { 
            %>
            <form name="logout">
                <input type="submit" name="sair" value="Logout"/>
                <input type="hidden" name="campo_controle2" />
            </form>
            <%
                if ( request.getParameter("campo_controle2") != null ) {
                    
                    out.println("Você será agora deslogado do site.");
                    session.setAttribute("user_name", null);
                    //session.removeAttribute("user_name");
                    //session.invalidate();
                    pageContext.forward("login.jsp");
                    
                }
        } %>
    </body>
</html>