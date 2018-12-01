 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form  id="saisi" method="post">

    
    <label for="typeCompte">Choisissez un type de questionnaire :</label>
        
	<select name="typeCompte" id="typeCompte" size="1">
	<!-- à remplir avec les questionnaires -->
			<option value=""></option>
			
    </select>
	
	     <div class="pt-2">
	  		 <input type="text" id="id_salarie" name="salarie" class="form-control" placeholder="Identifiant du Salarié" required>
   		 </div> 
   		 
   		 <div class="row pt-2">
	  		  <div class="col"><input type="submit" class="btn btn-info" value="Valider" style="float:right;"></div>
	  		  <div class="col"><input type="reset" class="btn btn-danger" value="Annuler"></div>  		  
	  		  
   		 </div> 
   		
	</form> 
