<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="<c:url value="/img/ua.png"/>">
    
	<title>Questionnaire</title>

	<link rel="stylesheet" href="<c:url value="/css/default.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	
</head>
<body>

  	<c:import url="/jsp/Menu.jsp"/>
	
	<!-- Liste des questionnaires -->
	
    <div class="card text-center m-3" id="questionnaire">
		<form method="post">
	    	<c:if test="${empty Questionnaire}">  	
					<div class="card-header">
				    	<h3 class="card-title">Liste Questionnaires</h3>
				    </div>
				    <div class="card-body">
					    <select class="form-control" name="Identifiant" id="listeQuestionnaires">
					    <c:forEach items="${ListeQuestionnaires}" var="identifiant" varStatus="status">
						    <option> <c:out value="${identifiant}"></c:out> </option>
						</c:forEach>
						<c:remove var="ListeQuestionnaires" scope="session" />
					    </select>
				        <button class="btn btn-primary m-3" type="submit">AFFICHER</button>
				    </div>
	    	</c:if>
	    	
	    	<c:if test="${not empty Questionnaire}">
				<div class="card-header">
	    			<h3 class="card-title"><c:out value="${Nom}"></c:out></h3>
	    			<h5 class="card-subtitle mb-2 text-muted">Soumis par <cite><c:out value="${IdentifiantEster}"></c:out></cite>, le <c:out value="${Date}"></c:out></h5>
	    		</div>
			    <div class="card-body">
		    		<c:out value="${Questionnaire}" escapeXml="" ></c:out>
		    		<c:remove var="Questionnaire" scope="session" />
				    <button class="btn btn-primary m-3" type="submit">VALIDER</button>
				    <button class="btn btn-danger m-3" type="reset">ANNULER</button>
				    
			    </div>
	    	</c:if>
		</form>	
    </div>

  	<c:import url="/jsp/Footer.jsp"/>
  	
</body>
</html>