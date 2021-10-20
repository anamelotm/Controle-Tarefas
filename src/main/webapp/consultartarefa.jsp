<%@page import="java.util.List"%>
<%@page import="entity.Tarefa"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
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
            TarefaDAO tDAO = new TarefaDAO(); 
            List<Tarefa> listaTarefas = tDAO.consultarTarefas();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        %>
        <table id="consulta">
            <!-- cabecalho da tabela -->
            <thead>
                <th> ID colaborador </th>
                <th> Descrição da Tarefa</th>
                <th> Data Início </th>
                <th> Data Fim </th>
                <th> Status </th>
                <th> Prioridade </th>
                <th> Alterar </th>
                <th> Excluir </th>
            </thead>
            <!-- corpo da tabela -->
            <tbody>
                <% for (Tarefa t: listaTarefas) { %>
                <tr>
                	<td><% out.write(String.valueOf(t.getIdColaborador())); %> </td>
                    <td><% out.write(t.getDescrTarefa()); %></td>
                    <td><% out.write(sdf.format(t.getDataHoraInicio())); %></td>
                    <td><% out.write(sdf.format(t.getDataHoraFim())); %></td>
                    <td><% out.write(t.getStatusTarefa()); %></td>
                    <td><% out.write(t.getPrioridadeTarefa()); %></td>
                    <td> <a href="alterarTarefa.jsp?alterarTarefa=<%=t.getIdTarefa()%>" target="janela_prog"><i class="far fa-edit"     ;style="color:blue"></i></a></td>
                    <td> <a href="excluirTarefa.jsp?excluirTarefa=<%=t.getIdTarefa()%>"> <i class="far fa-trash-alt";style="color:red"></i></a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
