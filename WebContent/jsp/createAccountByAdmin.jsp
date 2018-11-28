 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="rpw pt-2">
    <h4>Créer un nouveau compte</h4>
    <label for="typeCompte">Choisissez un type de compte :</label>		     
	<select name="typeCompte" id="typeCompte" size="1">
		<option value="Assistant">Administrateur</option>
		<option value="Assistant">Médecin</option>
		<option value="Assistant">Assistant</option>
	    <option value="Infirmier">Infirmier</option>
	    <option value="Preventeur">Préventeur</option>
    </select>
	
	<form  id="saisi" method="post">
	     <div class="pt-2">
	  		 <input type="email" id="adress_Email" name="email" class="form-control" placeholder="Adresse Email" required>
   		 </div> 
   		 
   		 <div class="row pt-2">
	  		  <div class="col"><input type="submit" class="btn btn-info" value="Valider" style="float:right;"></div>
	  		  <div class="col"><input type="reset" class="btn btn-danger" value="Annuler"></div>  		  
	  		  
   		 </div> 
   		
	</form>  						     
						
</div>