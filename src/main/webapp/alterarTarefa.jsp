<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTROLE DE TAREFAS - CAPGEMINI</title>
        <link   rel ="stylesheet" href="Styles/padraotelacadastro.css">
        <script src ="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src ="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    
    <body> 
        <div class="container">
            <form id="matchtech" action="receberAlteraTarefa.jsp" method="POST">
                <h3>Alterar Tarefa</h3>
                <p></p>
                
                <label class="mensagem" id="msg">
                    <%
                        if(request.getParameter("pmensagem") != null)
                            out.write(request.getParameter("pmensagem"));  
                    int idTarefa = Integer.parseInt(request.getParameter("alterarTarefa"));
                    %>
                </label>
                
                  <fieldset> 
               
                    <div class="descrtarefa">
                    <label>Descricao Tarefa</label>
                        <input id="descrtarefa" name="descrtarefa" type="text" maxlength="30" required size=30>
                    </div>
					
					<div class="statustarefa">
						<label>Status tarefa</label>
						<select name="statustarefa">
							<option value="Iniciada" selected>Iniciada</option>
							<option value="Cancelada">Cancelada</option>
							<option value="Executada">Executada</option>
						</select>
					</div>
					
					<div class="datahorafim">
						<label>Data hora fim</label>
						<input id="datahorafim" name="datahorafim" type="text" maxlength="50" required size=50 placeholder="yyyy-mm-dd hh:mm:ss">
						
					</div>
					
					<div class="prioridadetarefa">
						<label>Prioridade Tarefa</label>
						<select name="prioridadetarefa">
							<option value="Baixa" selected>Baixa</option>
							<option value="Media">Media</option>
							<option value="Alta">Alta</option>
							<option value="Urgente">Urgente</option>
						</select>
					</div>
					<input type="text" value="<%=idTarefa%>" name="alterarTarefa" hidden>
                
                <div>
                    <div class="form-group col-md-2 h-8">
                        <input type="submit" value="Cadastrar" class="btn btn-success "/>
                    </div>
                    <div class="form-group col-md-2 h-8">                                 
                        <input type="reset"  value="Cancelar" class="btn btn-danger"/>                        
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>