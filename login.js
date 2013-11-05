function validateForm() {
    var email=document.forms["Login"]["email"].value;
    var senha=document.forms["Login"]["senha"].value;
    if (email==null || email=="" || senha==null || senha=="") {
        alert("Campo obrigatório não preenchido.");
        return false;
    }
    var atpos=email.indexOf("@");
    var dotpos=email.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length) {
        alert("Endereço de e-mail não é válido.");
        return false;
    }
    
    // boolean v = verifica(email, senha); // Método de verificação, a ser criado.
    boolean v = "123".equals(senha);
    if (v) {
        session.setAttribute("user_name", user);
        pageContext.forward("main.html");
    } else document.getElementById("alerta").innerHTML="Usuário e/ou senha inválidos!";
}
