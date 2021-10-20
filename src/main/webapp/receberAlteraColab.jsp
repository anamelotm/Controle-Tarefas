<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Colaborador"%>
<%@page import="dao.ColaboradorDAO"%>

<%
    String vNomecolaborador = request.getParameter("nomecolaborador");

    Colaborador colaborador = new Colaborador(vNomecolaborador);
    ColaboradorDAO col = new ColaboradorDAO();
    col.alterarColaborador(Integer.parseInt(request.getParameter("alterarColab")), vNomecolaborador);
    
    out.write("Colaborador alterado com sucesso");
%>