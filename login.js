function validarLogin() {
    var email=document.forms["Login"]["email"].value;
    var senha=document.forms["Login"]["senha"].value;
    if (email==null || email=="" || senha==null || senha=="") {
        document.getElementById("alerta").innerHTML="Campo obrigatÃ³rio nÃ£o preenchido.";
        //alert("Campo obrigatÃ³rio nÃ£o preenchido.");
        return false;
    }
    var atpos=email.indexOf("@");
    var dotpos=email.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length) {
        document.getElementById("alerta").innerHTML="EndereÃ§o de e-mail nÃ£o Ã© vÃ¡lido.";
        //alert("EndereÃ§o de e-mail nÃ£o Ã© vÃ¡lido.");
        return false;
    }
    
    // boolean v = verificaSenha(email, senha); // MÃ©todo de verificaÃ§Ã£o, a ser criado.
    if (senha=="123") {
        session.setAttribute("user_name", email);
        return true;
    } else {
        document.getElementById("alerta").innerHTML="UsuÃ¡rio e/ou senha invÃ¡lidos!";
        return false;
    } 
}
