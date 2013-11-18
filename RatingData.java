package classes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * @author Vitor Henrique
 */
public class RatingData {
    
  public void incluir(RatingDO rating, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "insert into Rating (numUsuarioCriticado, numUsuarioCritico, numNota, dateRating, strComentario) values (?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, rating.getUsuarioCriticado());
     ps.setInt(2, rating.getUsuarioCritico());
     ps.setInt(3, rating.getNota());
     ps.setDate(4, rating.getDateRating());
     ps.setString(5, rating.getComentario());
     
     int result = ps.executeUpdate();
  }

  public void excluir(RatingDO rating, Transacao tr) throws Exception {
     excluir(rating.getidRating(), tr);
  } // excluir

  public void excluir (int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "delete from Rating where idRating=?";
     PreparedStatement ps = con.prepareStatement(sql);
     String id = ""+idobj;
     ps.setString(1, id);
     int result = ps.executeUpdate();
  } // excluir 

  public void Alterar(RatingDO rating, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update Rating set numUsuarioCriticado=? numUsuarioCritico=? numNota=? dateRating=? strComentario=? where idRating=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, rating.getUsuarioCriticado());
     ps.setInt(2, rating.getUsuarioCritico());
     ps.setInt(3, rating.getNota());
     ps.setDate(4, rating.getDateRating());
     ps.setString(5, rating.getComentario());
     int result = ps.executeUpdate();
  } // alterar

  public RatingDO buscarPorCriticado(int criticado, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Rating where numUsuarioCriticado =?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, criticado);
     ResultSet rs = ps.executeQuery();
     rs.next();
     RatingDO rating = new RatingDO();
         
     
     rating.setidRating (rs.getInt("idRating"));
     rating.setUsuarioCriticado(rs.getInt("numUsuarioCriticado"));
     rating.setUsuarioCritico(rs.getInt("numUsuarioCritico"));
     rating.setNota(rs.getInt("numNota"));
     rating.setDateRating (rs.getDate("dateRating"));
     rating.setComentario(rs.getString("strComentario"));

     return rating;
  } // buscar

  public RatingDO buscarPorCritico(int criticado, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Rating where numUsuarioCritico =?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, criticado);
     ResultSet rs = ps.executeQuery();
     rs.next();
     RatingDO rating = new RatingDO();
         
     
     rating.setidRating (rs.getInt("idRating"));
     rating.setUsuarioCriticado(rs.getInt("numUsuarioCriticado"));
     rating.setUsuarioCritico(rs.getInt("numUsuarioCritico"));
     rating.setNota(rs.getInt("numNota"));
     rating.setDateRating (rs.getDate("dateRating"));
     rating.setComentario(rs.getString("strComentario"));

     return rating;
  } // buscar

}
