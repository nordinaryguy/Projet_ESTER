 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form  id="saisi" method="post">

    
    <label for="typeCompte">Choisissez un type de compte :</label>
        
	<select name="typeCompte" id="typeCompte" size="1">
		<c:if test="${sessionScope.sessionUtilisateur.isAdministrateur()}">	     
			<option value="Administrateur">Administrateur</option>
			<option value="Medecin">Médecin</option>
		 </c:if>
		<option value="Assistant">Assistant</option>
	    <option value="Infirmier">Infirmier</option>
	    <option value="Preventeur">Préventeur</option>
    </select>
	
	     <div class="pt-2">
	  		 <input type="email" id="adress_Email" name="email" class="form-control" placeholder="Adresse Email" required>
   		 </div> 
   		 
   		 <div class="row pt-2">
	  		  <div class="col"><input type="submit" class="btn btn-info" value="Valider" style="float:right;"></div>
	  		  <div class="col"><input type="reset" class="btn btn-danger" value="Annuler"></div>  		  
	  		  
   		 </div> 
   		
	</form> 
