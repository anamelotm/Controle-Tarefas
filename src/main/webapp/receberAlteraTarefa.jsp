<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Tarefa"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.sql.Timestamp" %>

<%
	int idTarefa = Integer.parseInt(request.getParameter("alterarTarefa"));
	String descrTarefa = request.getParameter("descrtarefa");
	String statusTarefa = request.getParameter("statustarefa");
	Timestamp dataHoraFim = Timestamp.valueOf(request.getParameter("datahorafim"));
	String prioridadeTarefa = request.getParameter("prioridadetarefa");

    TarefaDAO tDAO = new TarefaDAO();
    tDAO.alterarTarefa(idTarefa, descrTarefa, dataHoraFim, statusTarefa, prioridadeTarefa);
    out.write("Tarefa alterada com sucesso");
   
    
%>