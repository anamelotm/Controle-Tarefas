<%@page import="java.util.List"%>
<%@page import="entity.Colaborador"%>
<%@page import="dao.ColaboradorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTROLE DE TAREFAS - CAPGEMINI</title>
        <link rel="stylesheet" href="Styles/padraotelagrid.css">
        <!-- bootstrap -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet"/>        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <!-- Fontawesome' -->
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>
    <body>
        <%
            ColaboradorDAO col = new ColaboradorDAO();
            List<Colaborador> listaColaboradores = col.consultarColaboradores();
        %>
        <table id="consulta">
            <!-- cabecalho da tabela -->
            <thead>
           		<th> ID Colaborador </th>
                <th> Colaborador </th>
                <th> Alterar </th>
                <th> Excluir </th>
            </thead>
            <!-- corpo da tabela -->
            <tbody>
                <% for (Colaborador c: listaColaboradores) { %>
                <tr>
                	<td><% out.write(String.valueOf(c.getIdColaborador())); %> </td>
                    <td><% out.write(c.getNomeColaborador()); %></td>
                    <td> <a href="alterarColaborador.jsp?alterarColab=<%=c.getIdColaborador()%>" target="janela_prog"><i class="far fa-edit"     ;style="color:blue"></i></a></td>
                    <td> <a href="excluirColab.jsp?excluirColab=<%=c.getIdColaborador()%>"> <i class="far fa-trash-alt";style="color:red"></i></a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
