<%-- 
    Document   : alterarSenha
    Created on : Nov 21, 2013, 2:25:09 PM
    Author     : Lucas Pinheiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CaronUSP - Alterar Senha</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            
            var RecaptchaOptions = {
                lang : 'br',
            };
            
            var RecaptchaOptions = {
                theme : 'white'
            };
           
        </script>
    </head>
    <body>
        <%@ page import="classes.transacoes.Usuario" %>
        <%@ page import="classes.data.UsuarioDO" %>
        <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
        <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
        <%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
        <%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>

        <%
            if (session.getAttribute("user_name") != null) {
                
                String email = (String) session.getAttribute("user_name");
        %>
        
        <form name="altSenha">
            <table align="center">
                <tr>
                    <td align="center" colspan="2">
                        Bom dia, <%= email%>!!
                        <p>Insira os dados a seguir para alterar sua senha.</p>
                    </td>
                </tr>
                <tr>
                    <td align="right">Senha Atual</td>
                    <td><input type="password" name="senhaAtual" />
                </tr>      
                <tr>
                    <td align="right">Nova Senha</td>
                    <td><input type="password" name="senhaNova" />
                </tr>
                <tr>
                    <td align="right">Confirmação da Nova Senha</td>
                    <td><input type="password" name="confSenhaNova" />
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <%
                        ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lf7fOoSAAAAAF-SgsF1BAeqFjzPWnHxTMRW5xuN", "6Lf7fOoSAAAAAGxU4i10XBvCqbTST7tKGgzBQhmd", false);
                        out.print(c.createRecaptchaHtml(null, null));
                        %>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <input type="submit" name="alterar" value="Alterar Senha" />
                        <input type="hidden" name="campo_controle" />
                    </td>
                </tr>
            </table>
        </form>
        <p align="center"><font id="alerta" color="red">
        <%
                if ( request.getParameter("campo_controle") != null ) {
                    String senhaAtual = request.getParameter("senhaAtual");
                    String senhaNova = request.getParameter("senhaNova");
                    String confSenhaNova = request.getParameter("confSenhaNova");
                    
                    String remoteAddr = request.getRemoteAddr();
                    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
                    reCaptcha.setPrivateKey("6Lf7fOoSAAAAAGxU4i10XBvCqbTST7tKGgzBQhmd");                
                    String challenge = request.getParameter("recaptcha_challenge_field");
                    String uresponse = request.getParameter("recaptcha_response_field");
                    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
                    
                    Usuario user = new Usuario();
                    if ( (senhaAtual.length() > 0) 
                          && (senhaNova.length() > 0) 
                          && (confSenhaNova.length() > 0) ) {
                        if ( confSenhaNova.equals(senhaNova) ) {
                            if (reCaptchaResponse.isValid()) {
                                if ( user.alterarSenha( email, senhaAtual, senhaNova ) ) {
                                //if ( senhaAtual.equals("123") ) {
                                    out.print("<script type='text/javascript'> alert('Senha alterada com sucesso.')");      
                                    out.print("\nwindow.location = 'main.jsp'</script>");
                                } else { %> Senha inválida! <% }
                            } else { %> Erro no preenchimento do reCaptcha. <% } 
                        } else { %> A confirmação da senha não confere com a nova senha fornecida. <% }
                    } else { %> Campo obrigatório não preenchido. <% }
                }
            }
            %>
            </font></p>
        <%
            if (session.getAttribute("user_name") == null) {
        %>
        <table>
            <tr><font color="red">Você precisa estar logado para poder alterar sua senha.</font></tr>
            <tr>
                <td><br><a href="login.jsp"><button type="button">Fazer Login</button></a></td>
                <td><br><a href="main.jsp"><button type="button">Voltar à Página Inicial</button></a></td>
            </tr>
        </table>
        <%
            }
        %>
    </body>
</html>