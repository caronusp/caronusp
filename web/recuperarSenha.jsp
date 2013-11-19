<%-- 
    Document   : recuperarSenha
    Created on : Nov 19, 2013, 10:12:13 AM
    Author     : lucasmp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CaronUSP - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
    
            function checkCaptcha() {
                
                <% String remoteAddr = request.getRemoteAddr();
                ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
                reCaptcha.setPrivateKey("6Lf7fOoSAAAAAGxU4i10XBvCqbTST7tKGgzBQhmd");
                
                String challenge = request.getParameter("recaptcha_challenge_field");
                String uresponse = request.getParameter("recaptcha_response_field");
                
                ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
                if (!reCaptchaResponse.isValid()) out.print("Foi!");
                else out.print("Foi!2");
                
                if (reCaptchaResponse.isValid()) {
                    %> document.getElementById("alerta").innerHTML="Correto!";
                    return true; <%
                } else {
                    %> document.getElementById("alerta").innerHTML="Errado!"; 
                    return false; <%
                }
                %>
            }
            
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
            </script>
            <%
            pageContext.forward("index.jsp");
        }
        %>
        Insira seu e-mail e preencha o Captcha para receber uma mensagem de recuperação de senha.
        <form name="formRec" onsubmit="return checkCaptcha()">
            <table>
                <tr>
                <td>E-mail</td>
                <td><input type="text" name="email" />
                </tr>
                <br>
            </table>
            <p id="recaptcha"></p>
            <%
                ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lf7fOoSAAAAAF-SgsF1BAeqFjzPWnHxTMRW5xuN", "6Lf7fOoSAAAAAGxU4i10XBvCqbTST7tKGgzBQhmd", false);
                out.print(c.createRecaptchaHtml(null, null));
            %>
            <input type="submit" name="recuperar" value="Recuperar" />  
        </form>
        <p><font id="alerta" color="red">oi</font></p>
        
    </body>
</html>
