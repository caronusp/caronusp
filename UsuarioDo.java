package classes.data;

import java.sql.Date;

/**
 *
 * @author Vitor Henrique
 */
public class UsuarioDO {
  private int _idUsuario;
  private String _strNome; 
  private int _numCPF;
  private String _strEmail;// VARCHAR(45) NULL,
  private String _strSenha;// VARCHAR(20) NULL,
  private String _strCEP;// VARCHAR(20) NULL,
  private String _strRua;// VARCHAR(45) NULL,
  private int _numNumeroCasa;// INTEGER UNSIGNED NULL,
  private String _strComplemento;// VARCHAR(20) NULL,
  private int _numTelefone;// INTEGER UNSIGNED NULL,
  private String _strTipo;// CHAR NULL,
  private String _strSexo;// CHAR NULL,
  private Date _dateNascimento;// DATE NULL,
  private String _strProfissao;// VARCHAR(45) NULL,
  private String _strEntidade;// VARCHAR(45) NULL,
  
   public String getNome() {
     return _strNome;
  } // getEmail

  public void setNome(String Nome) {
    _strNome = Nome;
  } // setEmail
  
    public int getId() {
     return _idUsuario;
  } // getId

  public void setId(int id) {
    _idUsuario = id;
  } // setId
  
      public int getCPF() {
     return _numCPF;
  } // getCPF

  public void setCPF(int CPF) {
    _numCPF = CPF;
  } // setCPF
  
        public String getEmail() {
     return _strEmail;
  } // getEmail

  public void setEmail(String Email) {
    _strEmail = Email;
  } // setEmail
  
        public String getSenha() {
     return _strSenha;
  } // getSenha

  public void setSenha(String Email) {
    _strSenha = Email;
  } // setSenhaCPF
  
        public String getCEP() {
     return _strCEP;
  } // getCEP

  public void setCEP(String CEP) {
    _strCEP = CEP;
  } // setCEP
  
        public String getRua() {
     return _strRua;
  } // getRua

  public void setRua(String Rua) {
    _strRua = Rua;
  } // setRua
  
        public int getNcasa() {
     return _numNumeroCasa;
  } // getNcasa

  public void setNcasa(int Ncasa) {
    _numNumeroCasa = Ncasa;
  } // setNcasa
  
        public String getComplemento() {
     return _strComplemento;
  } // getComplemento

  public void setComplemento(String Complemento) {
    _strComplemento = Complemento;
  } // setComplemento
  
        public int getTelefone() {
     return _numTelefone;
  } // getTelefone

  public void setTelefone(int Telefone) {
    _numTelefone = Telefone;
  } // setTelefone
  
        public String getTipo() {
     return _strTipo;
  } // getTipo

  public void setTipo(String Tipo) {
    _strTipo = Tipo;
  } // setId
  
         public String getSexo() {
     return _strSexo;
  } // getSexo

  public void setSexo(String Sexo) {
    _strSexo = Sexo;
  } // setSexo
  
         public Date getDatanascimento() {
     return _dateNascimento;
  } // getDatanascimento

  public void setDatanascimento(Date Datanascimento) {
    _dateNascimento = Datanascimento;
  } // setDatanascimento
  
         public String getProfissao() {
     return _strProfissao;
  } // getProfissao

  public void setProfissao(String Profissao) {
    _strProfissao = Profissao;
  } // setProfissao
  
         public String getEntidade() {
     return _strEntidade;
  } // getEntidade

  public void setEntidade(String Entidade) {
    _strEntidade = Entidade;
  } // setEntidade
}
