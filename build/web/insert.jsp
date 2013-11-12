<html>
<header>
  <title>Inserir Contato</title>
</header>

<body bgcolor="white">
<%@ page import="classes.transacoes.Contato" %>
<%@ page import="classes.data.ContatoDO" %>

<! ------------------------------------------------------------>
<!--   se for o request inicial, mostrar somente o formulario -->

<%     if ( null == request.getParameterValues("incluir") ) {
%>
       <form action="./insert.jsp" method="post">
          <table>
            <tr>
               <td>Nome</td>
               <td><input type="text" name="nome" />
            </tr>
            <tr>
               <td>Telefone</td>
               <td><input type="text" name="telefone" />
            </tr>
          </table>
          <input type="submit" name="incluir" value="incluir" />
        </form>

<%      } else { 
%>
<! ------------------------------------------------------------------->
<!--   se nao for o request inicial, acionar a transacao de negocio -->


<%     String nome = request.getParameter("nome");
       String telefone = request.getParameter("telefone");
       classes.transacoes.Contato tn = new classes.transacoes.Contato();
       classes.data.ContatoDO contato = new classes.data.ContatoDO();
       contato.setNome(nome);
       contato.setTelefone(telefone); 
       if ( tn.incluir(contato)) {
         // avisar usuario que transacao foi feita com sucesso
%>
          Transação realizada com sucesso!
          <form action="./index.html" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
<%     } else {
%>
          Erro ao incluir usuário            
          <form action="./insert.jsp" method="post">
             <input type="submit" name="retry" value="Repetir" />
          </form>
<%     }
       }
%>

</body>
</html>
