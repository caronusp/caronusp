package classes.transacoes;

import classes.utils.*;
import classes.data.*;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
import javax.mail.internet.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.activation.*;
/**
 *
 * @author Vitor Henrique
 */
public class Usuario {
    
    public boolean incluir (UsuarioDO usuario) throws Exception{

     // validacao das regras de negocio
     if ( isEmpty(usuario.getNome())) {
       return false;
     }
     
     if ( isEmpty(usuario.getEmail())) {
       return false;
     }
     
     if ( isEmpty(usuario.getSenha())) {
       return false;
     }
     
     if ( isEmpty(usuario.getCEP())) {
       return false;
     }//cep
     
     if ( isEmpty(usuario.getRua())) {
       return false;
     }//rua
          
     if ( isEmpty(usuario.getTipo())) {
       return false;
     }//tipo
     
     if ( isEmpty(usuario.getSexo())) {
       return false;
     }//sexo
     
     if ( isEmpty(usuario.getProfissao())) {
       return false;
     }//profissão
     
     if ( isEmpty(usuario.getEntidade())) {
       return false;
     }//entidade
     
     if ( usuario.getCPF()==0) {
       return false;
     }//CPF
     
     if ( usuario.getNcasa()==0) {
       return false;
     }//Ncasa
     
     if ( usuario.getTelefone()==0) {
       return false;
     }//telefone
     
     if ( usuario.getDatanascimento()==null) {
       return false;
     }//datanascimento
     

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         UsuarioData udata = new UsuarioData();
         udata.incluir(usuario, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir " + usuario.getNome());
         e.printStackTrace();
     }
     return false;
  } // incluir
    
    public boolean excluir(UsuarioDO usuario)throws Exception{
    
        Transacao tr = new Transacao();
    
     try{
         tr.begin();
         UsuarioData udata = new UsuarioData();
         udata.excluir(usuario, tr);
         tr.commit();
         return true;
     } 
     catch(Exception e){
         tr.rollback();
         System.out.println("erro ao excluir" + usuario.getNome());
         e.printStackTrace();
         return false;
      }
    }
    
    public boolean alterar (UsuarioDO usuario)throws Exception{
       
        // validacao das regras de negocio
     if ( isEmpty(usuario.getNome())) {
       return false;
     }
     
     if ( isEmpty(usuario.getEmail())) {
       return false;
     }
     
     if ( isEmpty(usuario.getSenha())) {
       return false;
     }
     
     if ( isEmpty(usuario.getCEP())) {
       return false;
     }//cep
     
     if ( isEmpty(usuario.getRua())) {
       return false;
     }//rua
          
     if ( isEmpty(usuario.getTipo())) {
       return false;
     }//tipo
     
     if ( isEmpty(usuario.getSexo())) {
       return false;
     }//sexo
     
     if ( isEmpty(usuario.getProfissao())) {
       return false;
     }//profissão
     
     if ( isEmpty(usuario.getEntidade())) {
       return false;
     }//entidade
     
     if ( usuario.getCPF()==0) {
       return false;
     }//CPF
     
     if ( usuario.getNcasa()==0) {
       return false;
     }//Ncasa
     
     if ( usuario.getTelefone()==0) {
       return false;
     }//telefone
     
     if ( usuario.getDatanascimento()==null) {
       return false;
     }//datanascimento
        
        Transacao tr = new Transacao();
        
        try{
           tr.begin();
           UsuarioData udata = new UsuarioData();
           udata.Alterar(usuario , tr);
           tr.commit();
           return true;
       }
       catch(Exception e){
         tr.rollback();
         System.out.println("erro ao alterar" + usuario.getNome());
         e.printStackTrace();
         return false;
      }
    
    }
    
    public UsuarioDO buscarPorNome(String Nome) throws Exception{
        
        Transacao tr = new Transacao();
        
        try{
            tr.begin();
            UsuarioData udata = new UsuarioData();
            UsuarioDO u = udata.buscarPorNome(Nome, tr);
            tr.commit();
            return u;
        }
        catch(Exception e) {
            tr.rollback();
            System.out.println("nao foi possivel concluir sua busca");
            e.printStackTrace();
        }
        return null;
    }
    
    public UsuarioDO buscarPorEmail(String Email) throws Exception {

        Transacao tr = new Transacao();

        try{
            tr.begin();
            UsuarioData udata = new UsuarioData();
            UsuarioDO u = udata.buscarPorEmail(Email, tr);
            tr.commit();
            return u;
        }
        catch(Exception e){
            tr.rollback();
            System.out.println("nao foi possivel concluir sua busca");
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     *
     * @author Lucas Pinheiro
     */
    
    static final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();
    /* Função para gerar senha de forma pseudo-aleatória. */
    private String randomString( int len ) {
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ ) 
           sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
    
    /* Função para verificar se a senha corresponde ao e-mail fornecido. */
    public boolean verificarLogin( String email, String senha ) throws Exception {
        
        Transacao tr = new Transacao();
        boolean v = false;
        
        try {
            tr.begin();
            UsuarioDO u = buscarPorEmail(email);
            if ( senha.equals(u.getSenha()) ) v = true;
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Não foi possível verificar o Login.");
            e.printStackTrace();
        }
        
        return v;
    }
    
    public boolean recuperarSenha( String email ) throws Exception {
        
        Transacao tr = new Transacao();
        boolean v = false;
        
        try {
            tr.begin();
            UsuarioData udata = new UsuarioData();
            UsuarioDO u = udata.buscarPorEmail(email, tr);
            if (u != null) {
                // Geração de nova senha aleatória.
                String senhaNova = randomString(8);  
                // E-mail de envio.
                String from = "contato.caronusp@gmail.com";
                // Assumindo que o e-mail é enviado do localhost.
                String host = "localhost";
                // Adquirindo propriedades do sistema.
                Properties properties = System.getProperties();
                // Setup do sistemas de e-mail.
                properties.setProperty("mail.smtp.host", host);
                // Adquirindo o objeto de Sessão padrão.
                Session session = Session.getDefaultInstance(properties);
                // Cria um objeto MimeMessage padrão.
                MimeMessage message = new MimeMessage(session);
                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));
                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                // Assunto do e-mail.
                message.setSubject("Recuperação de Senha");
                // Corpo da mensagem do e-mail.
                message.setText("Caro(a) usuário,\n\nFoi requisitado o envio de nova senha para o usuário cadastrado no site CaroNUSP com o seu endereço de e-mail, a qual encontra-se a seguir.\n\nNova senha: " + senhaNova + "\n\nSolicita-se, por questões de segurança, que a nova senha seja alterada o quanto antes. Isso pode ser feito através da opção Alterar Senha disponível em nosso site após o Login.\n\nAtenciosamente,\nEquipe CaroNUSP");
                // Enviar mensagem.
                Transport.send(message);
                // Alteração da senha do usuário.
                u.setSenha(senhaNova);
                udata.alterarSenha(u, tr);
                v = true;
            }
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Não foi possível recuperar a senha.");
            e.printStackTrace();
        }
        return v;
    }
    
    /* Caso de uso: Alterar Senha. */
    public boolean alterarSenha( String email, String senhaAntiga, String senhaNova ) throws Exception {
        
        Transacao tr = new Transacao();
        boolean v = false;
        
        try {
            tr.begin();
            UsuarioData udata = new UsuarioData();
            UsuarioDO u = udata.buscarPorEmail(email, tr);
            if ( senhaAntiga.equals(u.getSenha()) ) {
                u.setSenha(senhaNova);
                udata.alterarSenha(u, tr);
                v =  true;
            }
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Não foi possível recuperar a senha.");
            e.printStackTrace();
        }
        return v;
    }
    
    private boolean isEmpty(String s) {
        if (null == s)
            return true;
        if (s.length() == 0)
            return true;
        return false;
    }
}
