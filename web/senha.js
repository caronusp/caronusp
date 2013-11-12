function checarSenha(str) {
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
    return re.test(str);
}

function alterarSenha() {
    var atual = document.forms["formSenha"]["atual"].value;
    var nova = document.forms["formSenha"]["nova"].value;
    var novaConf = document.forms["formSenha"]["novaConf"].value;
    var email = session.getAttribute("user_name");
    
    if (atual != "123") {
        document.getElementById("alerta").innerHTML="Senha atual inválida!";
        return false;
    }
    if (novaConf != nova) {
        document.getElementById("alerta").innerHTML="Erro na confirmação da nova senha.";
        return false;
    }
    if (checarSenha(nova) == false) {
        document.getElementById("alerta").innerHTML="Nova senha inválida. Ela precisa ter no mínimo 6 caracteres, incluindo no mínimo um número, uma letra maiúscula e uma letra minúscula.";
        return false;
    } else {
        // user = getUser(email);
        // user.setSenha(nova);
        return true;
    }
}
