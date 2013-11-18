package classes.transacoes;

import utils.*;
import classes.data.*;
/**
 *
 * @author Eduardo Katsuno
 */
public class Rating {
    
    public boolean incluir (RatingDO rating) throws Exception{

     // validacao das regras de negocio
     
     if (rating.getUsuarioCriticado() == 0) {
       return false;
     }
     
     if (rating.getUsuarioCritico() == 0) {
       return false;
     }
     
     if ((rating.getNota() < 0) ||(rating.getNota() > 5)) {
       return false;
     }
     
     if ( rating.getDateRating()==null) {
       return false;
     }     

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         RatingData rdata = new RatingData();
         rdata.incluir(rating, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("Rating: erro ao incluir " + rating.getidRating());
         e.printStackTrace();
     }
     return false;
  } // incluir
    
    public boolean excluir(RatingDO rating)throws Exception{
    
        Transacao tr = new Transacao();
    
     try{
         tr.begin();
         RatingData rdata = new RatingData();
         rdata.excluir(rating, tr);
         tr.commit();
         return true;
     } 
     catch(Exception e){
         tr.rollback();
         System.out.println("Rating: erro ao excluir" + rating.getidRating());
         e.printStackTrace();
         return false;
      }
    }
    
    public boolean alterar (RatingDO rating)throws Exception{
       
        // validacao das regras de negocio
     if (rating.getUsuarioCriticado() == 0) {
       return false;
     }
     
     if (rating.getUsuarioCritico() == 0) {
       return false;
     }
     
     if ((rating.getNota() < 0) ||(rating.getNota() > 5)) {
       return false;
     }
     
     if ( rating.getDateRating()==null) {
       return false;
     }   
        Transacao tr = new Transacao();
        
        try{
           tr.begin();
           RatingData rdata = new RatingData();
           rdata.Alterar(rating , tr);
           tr.commit();
           return true;
       }
       catch(Exception e){
         tr.rollback();
         System.out.println("Rating: erro ao excluir" + rating.getidRating());
         e.printStackTrace();
         return false;
      }
    
    }
    
    public boolean buscarPorCriticado(int criticado)throws Exception{
        
        Transacao tr = new Transacao();
        
        try{
            tr.begin();
            RatingData rdata = new RatingData();
            rdata.buscarPorCriticado(criticado, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
         tr.rollback();
         System.out.println("Rating: Registro não encontrado");
         e.printStackTrace();
         return false;
      }
    }
      public boolean buscarPorCritico(int critico)throws Exception{
        
        Transacao tr = new Transacao();
        
        try{
            tr.begin();
            RatingData rdata = new RatingData();
            rdata.buscarPorCritico(critico, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
         tr.rollback();
         System.out.println("Rating: Registro não encontrado");
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
