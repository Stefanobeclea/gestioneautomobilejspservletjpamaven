<!doctype html>
<%@page import="it.prova.gestioneautomobilejspservletjpamaven.model.Automobile"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Visualizza Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>
					     <% Automobile automobileInPagina = (Automobile)request.getAttribute("visualizza_automobile_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Marca</dt>
							  <dd class="col-sm-9"><%=automobileInPagina.getMarca() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Modello:</dt>
							  <dd class="col-sm-9"><%=automobileInPagina.getModello() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9"><%=automobileInPagina.getPrezzo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Immatricolazione:</dt>
							  <dd class="col-sm-9"><%=automobileInPagina.getDataImmatricolazione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(automobileInPagina.getDataImmatricolazione()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='col-12'>
				    		<form action="ExecuteDeleteServlet" method="post">
				    			<input type="hidden" name="idDaEliminare" value="<%= automobileInPagina.getId()%>">			
								<input type="submit" class="btn btn-outline-danger" value="Conferma">
						        <a href="ListAutomobiliServlet" class='btn btn-outline-secondary' style='width:80px'>
						            <i class='fa fa-chevron-left'></i> Back
						        </a>
							</form>
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>