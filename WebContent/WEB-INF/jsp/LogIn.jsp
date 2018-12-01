<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr-FR">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="<c:url value="/img/ua.png"/>">

    <title>Connexion</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/Accueil.css"/>">
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    

    <script>
      function showDiv(name) {
        document.getElementById('divSalarie').style.display = "none";
        document.getElementById('divEntreprise').style.display = "none";
        document.getElementById('divUtilisateur').style.display = "none";
        document.getElementById(name).style.display = "block";
      }
      
    <%String clock = request.getParameter( "clock" ); if( clock == null ) clock = "4";%>
  	var timeout = <%=clock%>;
  	
   	function timer_utilisateur()
  	{
  		if( --timeout > 0 ){
  			window.setTimeout( "timer_utilisateur()", 1000 );
  		}
  		else
  		{
  			document.location.href="<%= request.getContextPath()%>/utilisateur";
  			
  		}
  	}
  	
  	function timer_entreprise()
  	{
  		if( --timeout > 0 ){
  			window.setTimeout( "timer_entreprise()", 1000 );
  		}
  		else
  		{
  			document.location.href="<%= request.getContextPath()%>/entreprise";
  			
  		}
  	}
  	
  	function timer_salarie()
  	{
  		if( --timeout > 0 ){
  			window.setTimeout( "timer_salarie()", 1000 );
  		}
  		else
  		{

  			document.location.href="<%= request.getContextPath()%>/salarie";
  			
  		}
  	}
      
    </script>
    
</head>
<body>
	
	
  	<c:import url="/jsp/Menu.jsp"/>
  
    <div class="container-fluid text-center mb-4" id="container">
    
	    <div class="row justify-content-center pb-2">
	        <div class="col-md-2" style="text-align:center;"><img src="<c:url value="/img/irset.png"/>" alt="Logo-ister" width="205" height="90"></div>
	        <div class="col-md-2" style="text-align:center;"><img src="<c:url value="/img/ua_h.png"/>" alt="Logo-Université-Angers" width="190" height="62"></div>
	        
	    </div>

	    <c:if test="${not empty Success}">
	    	<c:if test="${sessionScope.sessionUtilisateur.isUtilisateur()}">
	    		<script>timer_utilisateur();</script>
	    	</c:if> 
	    	<c:if test="${sessionScope.sessionUtilisateur.isEntreprise()}">
	    		<script>timer_entreprise();</script>
	    	</c:if>
	    	<c:if test="${sessionScope.sessionUtilisateur.isSalarie()}">
	    		<script>timer_salarie();</script>
	    	</c:if>  	
	      <div class="alert alert-success alert-dismissible" role="alert">
          <strong>Succès</strong> <c:out value = "${Success}"/> <c:remove var="Success" scope="session" />
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	    </c:if>
	
	    <c:if test="${not empty Warning}">
	      <div class="alert alert-warning alert-dismissible" role="alert">
          <strong>Attention</strong> <c:out value = "${Warning}"/> <c:remove var="Warning" scope="session" />
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	    </c:if>

        <h1 class="font-weight-normal">Connexion</h1>
    
        <div class="btn-group" role="group">
          <button id="btnSalarie" class="btn btn-primary" type="button" onclick="showDiv('divSalarie');">Salarié</button>
          <button id="btnEntreprise" class="btn btn-primary" type="button" onclick="showDiv('divEntreprise')">Entreprise</button>
          <button id="btnUtilisateur" class="btn btn-primary" type="button" onclick="showDiv('divUtilisateur')">Utilisateur</button>
        </div>
    
        <form id="divSalarie" style="display:none;" class="form-signin" method="post">
          <div class="form-label-group">
            <input type="text" id="inputIdentifiant" name="Identifiant" class="form-control" placeholder="Identifiant" required>
            <label for="inputIdentifiant">Identifiant</label>
          </div>
          <input type="hidden" name="Type" value="Salarie" />
          <div class="btn-group" role="group">
         	<button class="btn btn-primary" type="submit">SE CONNECTER</button>
          </div>
        </form>

        <form id="divEntreprise" style="display:none;" class="form-signin" method="post"> 
          <div class="form-label-group">
            <input type="text" id="inputEmailEntreprise" name="Identifiant" class="form-control" placeholder="Identifiant" required>
            <label for="inputEmailEntreprise">Adresse email ou identifiant</label>
          </div>
          <div class="form-label-group">
            <input type="password" id="inputPasswordEntreprise" name="Password" class="form-control" placeholder="Password" required>
            <label for="inputPasswordEntreprise">Mot de passe</label>
          </div>
            <div class="row mb-4">
            	<a href="<c:url value="/ForgotPassword"/>">Mot de passe oublié ?</a>
            </div>
          <input type="hidden" name="Type" value="Entreprise" />
          <div class="btn-group" role="group">
              <button class="btn btn-primary" type="submit">SE CONNECTER</button>
          </div>
        </form>

        <form id="divUtilisateur" style="display:none;" class="form-signin" method="post">
            <div class="form-label-group">
              <input type="text" id="inputEmailUtilisateur" name="Identifiant" class="form-control" placeholder="Identifiant" required>
              <label for="inputEmailUtilisateur">Adresse email ou identifiant</label>
            </div>
            <div class="form-label-group">
              <input type="password" id="inputPasswordUtilisateur" name="Password" class="form-control" placeholder="Password" required>
              <label for="inputPasswordUtilisateur">Mot de passe</label>
            </div>
            <div class="row mb-4">
            	<a href="<c:url value="/ForgotPassword"/>">Mot de passe oublié ?</a>
            </div>
            <input type="hidden" name="Type" value="Utilisateur" />
            <div class="btn-group" role="group">
              <button class="btn btn-primary" type="submit">SE CONNECTER</button>
            </div>
        </form>         
      </div>

  	<c:import url="/jsp/Footer.jsp"/>

</body>
</html>
