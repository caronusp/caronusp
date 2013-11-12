package classes.data;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import utils.Transacao;

/**
 *
 * @author Lucas Pinheiro
 */

public class Login {
    static final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    String randomString( int len ) {
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ ) 
           sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
    
    /* Função para verificar se a senha corresponde ao e-mail fornecido. */
    public boolean verificarLogin( String email, String senha ) {
        Transacao tr = new Transacao();
        UsuarioData data = new UsuarioData();
        UsuarioDO user;
        try {
            user = data.buscarPorEmail(email, tr);
        } catch (Exception ex) {
            return false;
        }
        if ( senha.equals(user.getSenha()) ) return true;
        return false;
    }
    
    public boolean recuperarSenha( String email ) {
        Transacao tr = new Transacao();
        UsuarioData data = new UsuarioData();
        UsuarioDO user;
        try {
            user = data.buscarPorEmail(email, tr);
        } catch (Exception ex) {
            return false;
        }
        // Geração de nova senha aleatória.
        String senhaNova = randomString(8);  
        // E-mail de envio.
        String from = "contato.caronusp@gmail.com";
        // Assuming you are sending email from localhost
        String host = "localhost";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // Assunto do e-mail.
            message.setSubject("Recuperação de Senha");
            // Corpo da mensagem do e-mail.
            message.setText("Caro(a) usuário,\n\n"
                    + "Foi requisitado o envio de nova senha para o usuário cadastrado "
                    + "no site CaroNUSP com o seu endereço de e-mail, a qual encontra-se a seguir.\n\n"
                    + "Nova senha: " + senhaNova + "\n\n"
                    + "Solicita-se, por questões de segurança, que a nova senha seja alterada o quanto antes. "
                    + "Isso pode ser feito através da opção Alterar Senha disponível em nosso site após o Login.\n\n"
                    + "Atenciosamente,\n"
                    + "Equipe CaroNUSP");
            // Enviar mensagem.
            Transport.send(message);
            // Alteração da senha do usuário.
            user.setSenha(senhaNova);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean alterarSenha( String email, String senhaAntiga, String senhaNova ) {
        Transacao tr = new Transacao();
        UsuarioData data = new UsuarioData();
        UsuarioDO user;
        try {
            user = data.buscarPorEmail(email, tr);
        } catch (Exception ex) {
            return false;
        }
        if ( senhaAntiga.equals(user.getSenha()) ) {
            user.setSenha(senhaNova);
            return true;
        }
        return false;
    }
    
}
