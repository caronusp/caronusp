package classes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.Transacao;

/**
 *
 * @author Guilherme Chiaramonti
 */
public class InboxData {
    
    public void Incluir(InboxDO inbox, Transacao tr)throws Exception{
     Connection con = tr.obterConexao();
     String sql = "insert to Inbox (intRemetente, intDestinatario, strMensagem, dateDate) values(?,?,?,?) ";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, inbox.getIdRemetente());
     ps.setInt(2, inbox.getIdDestinatario());
     ps.setString(3, inbox.getMensagem());
     ps.setDate(4, inbox.getDate());
     
     int result = ps.executeUpdate();
    }
    
    public void Excluir(InboxDO inbox, Transacao tr)throws Exception{
     Connection con = tr.obterConexao();
     String sql = "delete from Inbox where id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, inbox.getIdInbox());
     
     int result = ps.executeUpdate();
    }
    
     
}
