package classes.data;

import java.sql.Date;
/**
 *
 * @author Guilherme Chiaramonti
 */




public class InboxDO {
    public int _IdInbox;
    public int _IdRemetente;
    public int _IdDestinatario;
    public Date _date;
    public String _mensagem;
 
    public int getIdInbox() {
     return _IdInbox;
  } 

  public void setIdInbox(int IdInbox) {
    _IdInbox = IdInbox;
  }   
    
    
  public int getIdRemetente() {
     return _IdRemetente;
  } 

  public void setIdRemetente(int idremetente) {
    _IdRemetente = idremetente;
  } 
  
  public int getIdDestinatario() {
     return _IdDestinatario;
  } 

  public void setIdDestinatario(int iddestinatario) {
    _IdDestinatario = iddestinatario;
  } 
    
  public Date getDate() {
     return _date;
  } 

  public void setDate(Date date) {
    _date = date;
  } 
  
  public String getMensagem() {
     return _mensagem;
  } 

  public void setMensagem(String mensagem) {
    _mensagem = mensagem;
  } 
  
}
