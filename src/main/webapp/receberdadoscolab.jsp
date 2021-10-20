<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Colaborador"%>
<%@page import="dao.ColaboradorDAO"%>

<%
    String vNomecolaborador = request.getParameter("nomecolaborador");

    Colaborador colaborador = new Colaborador(vNomecolaborador);
    ColaboradorDAO col = new ColaboradorDAO();
    
    if (col.incluirColaborador(colaborador)) {
        response.sendRedirect("cadastracolaborador.jsp?pmensagem=Colaborador cadastrado com sucesso");
    } else {
        response.sendRedirect("cadastracolaborador.jsp?pmensagem=Problemas ao cadastrar Colaborador");
    }
%>