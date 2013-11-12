package classes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import utils.Transacao;

/**
 *
 * @author Vitor Henrique
 */
public class UsuarioData {
    
  public void incluir(UsuarioDO usuario, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "insert into Usuario (strnome, numCPF ,strEmail, strSenha ,strCEP, strRua, numNumeroCasa, strComplemento, numTelefone, charTipo, charSexo, dateNascimento, strProfissao, strEntidade) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, usuario.getNome());
     ps.setInt(2, usuario.getCPF());
     ps.setString(3, usuario.getEmail());
     ps.setString(4, usuario.getSenha());
     ps.setString(5, usuario.getCEP());
     ps.setString(6, usuario.getRua());
     ps.setInt(7, usuario.getNcasa());
     ps.setString(8, usuario.getComplemento());
     ps.setInt(9, usuario.getTelefone());
     ps.setString(10, usuario.getTipo()); //tipo é um char...
     ps.setString(11, usuario.getSexo());//sexo é um char...
     ps.setDate(12, usuario.getDatanascimento());
     ps.setString(13, usuario.getProfissao());
     ps.setString(14, usuario.getEntidade());
     /*     
     
 */
     
     int result = ps.executeUpdate();
  }

  public void excluir(UsuarioDO usuario, Transacao tr) throws Exception {
     excluir(usuario.getId(), tr);
  } // excluir

  public void excluir (int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "delete from Usuario where idUsuario=?";
     PreparedStatement ps = con.prepareStatement(sql);
     String id = ""+idobj;
     ps.setString(1, id);
     int result = ps.executeUpdate();
  } // excluir 

  public void Alterar(UsuarioDO usuario, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update Usuario set numCPF=? strEmail=? strSenha=? strCEP=? strRua=? numNumeroCasa=? strComplemento=? numTelefone=? charTipo=? charSexo=? dateNascimento=? strProfissao=? strEntidade=? strNome= ? where idUsuario=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, usuario.getCPF());
     ps.setString(2, usuario.getEmail());
     ps.setString(3, usuario.getSenha());
     ps.setString(4, usuario.getCEP());
     ps.setString(5, usuario.getRua());
     ps.setInt(6, usuario.getNcasa());
     ps.setString(7, usuario.getComplemento());
     ps.setInt(8, usuario.getTelefone());
     ps.setString(9, usuario.getTipo()); //tipo é um char...
     ps.setString(10, usuario.getSexo());//sexo é um char...
     ps.setDate(11, usuario.getDatanascimento());
     ps.setString(12, usuario.getProfissao());
     ps.setString(13, usuario.getEntidade());
     ps.setString(14, usuario.getNome());
     ps.setInt(15, usuario.getId());
     int result = ps.executeUpdate();
  } // alterar

  public UsuarioDO buscarPorNome(String nome, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Usuario where  strNome=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, nome);
     ResultSet rs = ps.executeQuery();
     rs.next();
     UsuarioDO usuario = new UsuarioDO();
     usuario.setId (rs.getInt("idUsuario"));
     usuario.setCPF (rs.getInt("intCPF"));
     usuario.setEmail (rs.getString("strEmail"));
     usuario.setSenha (rs.getString("strSenha"));
     usuario.setRua (rs.getString("strRua"));
     usuario.setNcasa (rs.getInt("numNumeroCasa"));
     usuario.setComplemento (rs.getString("strComplemento"));
     usuario.setTelefone (rs.getInt("intTelefone"));
     usuario.setTipo (rs.getString("charTipo"));
     usuario.setSexo (rs.getString("charSexo"));
     usuario.setDatanascimento (rs.getDate("dateNascimento"));
     usuario.setProfissao (rs.getString("strProfissão"));
     usuario.setEntidade (rs.getString("strEntidade"));
     
     return usuario;
  } // buscarPorNome

    public UsuarioDO buscarPorEmail(String Email, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Usuario where  strEmail=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, Email);
     ResultSet rs = ps.executeQuery();
     rs.next();
     UsuarioDO usuario = new UsuarioDO();
     usuario.setId (rs.getInt("idUsuario"));
     usuario.setCPF (rs.getInt("intCPF"));
     usuario.setEmail (rs.getString("strEmail"));
     usuario.setSenha (rs.getString("strSenha"));
     usuario.setRua (rs.getString("strRua"));
     usuario.setNcasa (rs.getInt("numNumeroCasa"));
     usuario.setComplemento (rs.getString("strComplemento"));
     usuario.setTelefone (rs.getInt("intTelefone"));
     usuario.setTipo (rs.getString("charTipo"));
     usuario.setSexo (rs.getString("charSexo"));
     usuario.setDatanascimento (rs.getDate("dateNascimento"));
     usuario.setProfissao (rs.getString("strProfissão"));
     usuario.setEntidade (rs.getString("strEntidade"));
     
     return usuario;
  } // buscarPorNome
  //trabalhar nesse daqui:
  
  
//  public Vector pesquisar
//        (String nome, Transacao tr) throws Exception {
//     Connection con = tr.obterConexao();
//     String sql = "select * from Agenda where nome like ?";
//     PreparedStatement ps = con.prepareStatement(sql);
//     ps.setString(1, nome);
//     ResultSet rs = ps.executeQuery();
//     System.out.println("query executada");
//     Vector contatos = new Vector();
//     while (rs.next()) {
//        ContatoDO c = new ContatoDO();
//        c.setId (rs.getInt("id"));
//        c.setNome (rs.getString("nome"));
//        System.out.println(" got " + c.getNome());
//        c.setTelefone(rs.getString("telefone"));
//        contatos.add(c);
//     }
//     return contatos;
//  } // pesquisarPorNome
}
