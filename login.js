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
}