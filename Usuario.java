package classes.transacoes;

import utils.*;
import classes.data.*;
import java.util.*;
/**
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
    
    public boolean buscarPorNome(String Nome)throws Exception{
        
        Transacao tr = new Transacao();
        
        try{
            tr.begin();
            UsuarioData udata = new UsuarioData();
            udata.buscarPorNome(Nome, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
         tr.rollback();
         System.out.println("nao foi possivel concluir sua busca");
         e.printStackTrace();
         return false;
      }
    }
      public boolean buscarPorEmail(String Email)throws Exception{
        
        Transacao tr = new Transacao();
        
        try{
            tr.begin();
            UsuarioData udata = new UsuarioData();
            udata.buscarPorEmail(Email, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
         tr.rollback();
         System.out.println("nao foi possivel concluir sua busca");
         e.printStackTrace();
         return false;
      }
    
    }
      private boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
  }
}
