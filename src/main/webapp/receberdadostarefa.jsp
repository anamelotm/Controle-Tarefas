<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Tarefa"%>
<%@page import="dao.TarefaDAO"%>
<%@page import="java.sql.Timestamp" %>

<%
    int idColaborador = Integer.parseInt(request.getParameter("idcolaborador"));
	String descrTarefa = request.getParameter("descrtarefa");
	String statusTarefa = request.getParameter("statustarefa");
	Timestamp dataHoraFim = Timestamp.valueOf(request.getParameter("datahorafim"));
	String prioridadeTarefa = request.getParameter("prioridadetarefa");
	
	Tarefa tarefa = new Tarefa(idColaborador, descrTarefa, dataHoraFim);
	tarefa.setStatusTarefa(statusTarefa);
	tarefa.setPrioridadeTarefa(prioridadeTarefa);
	
	TarefaDAO tDAO = new TarefaDAO();
	
    
    if (tDAO.incluirTarefa(tarefa)) {
        response.sendRedirect("cadastratarefa.jsp?pmensagem=Tarefa cadastrada com sucesso");
    } else {
        response.sendRedirect("cadastratarefa.jsp?pmensagem=Problemas ao cadastrar tarefa");
    }
%>