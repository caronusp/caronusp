package classes.data;

import java.sql.*;
import java.util.*;

public class UsuarioData {

  public void incluir(UsuarioDO contato) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "insert into Agenda (nome, telefone) values (?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, contato.getNome());
     ps.setString(2, contato.getTelefone());
     int result = ps.executeUpdate();
  }

  public void excluir(ContatoDO contato, Transacao tr) throws Exception {
     excluir(contato.getId(), tr);
  } // excluir

  public void excluir (int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "delete from Agenda where id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     String id = ""+idobj;
     ps.setString(1, id);
     int result = ps.executeUpdate();
  } // excluir 

  public void atualizar(ContatoDO contato, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update Agenda set nome=?, telefone=? where id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, contato.getNome());
     ps.setString(2, contato.getTelefone());
	 ps.setInt(3, contato.getId());
     int result = ps.executeUpdate();
  } // atualizar

  public ContatoDO buscar(int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Agenda where  id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, idobj);
     ResultSet rs = ps.executeQuery();
     rs.next();
     ContatoDO contato = new ContatoDO();
     contato.setId (rs.getInt("id"));
     contato.setNome (rs.getString("nome"));
     contato.setTelefone(rs.getString("telefone"));
     return contato;
  } // buscar

  public Vector pesquisarPorNome(String nome, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Agenda where nome like ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, nome);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector contatos = new Vector();
     while (rs.next()) {
        ContatoDO c = new ContatoDO();
        c.setId (rs.getInt("id"));
        c.setNome (rs.getString("nome"));
        System.out.println(" got " + c.getNome());
        c.setTelefone(rs.getString("telefone"));
        contatos.add(c);
     }
     return contatos;
  } // pesquisarPorNome

} // ContatoData
