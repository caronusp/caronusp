<%-- 
    Document   : recuperarSenha
    Created on : Nov 19, 2013, 10:12:13 AM
    Author     : lucasmp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CaronUSP - Recuperar Senha</title>
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
        if ( session.getAttribute("user_name") != null) {
            %>
            <script type="text/javascript">
                alert("Você já está logado. Utilize a função de alterar senha ou efetue logout.");
                window.location = "main.jsp";
            </script>
            <%
        }
        %>
        
        
        <p align="center">Insira seu e-mail e preencha o Captcha para receber 
                          uma mensagem de recuperação de senha. </p>
        <form name="formRec">
            <table align="center">
                <tr>
                    <td align="right">E-mail</td>
                    <td><input type="text" name="email" />
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
                        <input type="submit" name="recuperar" value="Recuperar" />
                        <input type="hidden" name="campo_controle" />
                    </td>
                </tr>
                <br>
            </table>         
        </form>
        <%
            if ( request.getParameter("campo_controle") != null ) {
                // Processa o pedido de recuperação de e-mail.
                String email = request.getParameter("email");
                String remoteAddr = request.getRemoteAddr();
                ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
                reCaptcha.setPrivateKey("6Lf7fOoSAAAAAGxU4i10XBvCqbTST7tKGgzBQhmd");
                
                String challenge = request.getParameter("recaptcha_challenge_field");
                String uresponse = request.getParameter("recaptcha_response_field");
                
                ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
                
                if (email.length() != 0) {
                    if (reCaptchaResponse.isValid()) {
                        Usuario user = new Usuario();
                        //if(user.recuperarSenha(email)) {
                        if(email.equals("123")) {
                            out.print("<script type='text/javascript'> alert('Uma mensagem contendo a nova senha gerada pelo sistema foi enviada para seu endereço de e-mail.')");      
                            out.print("\nwindow.location = 'main.jsp'</script>");
                        }
                        else out.print("<font id='alerta' color='red'>Endereço de e-mail inválido.</font>");
                    } else out.print("<font id='alerta' color='red'>Erro no preenchimento do reCaptcha.</font>");
                } else out.print("<font id='alerta' color='red'>Insira um endereço de e-mail.</font>");
                
            }
        %>   
    </body>
</html>