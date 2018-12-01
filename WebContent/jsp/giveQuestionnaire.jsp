 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form  id="saisi" method="post">

    
    <label for="idQuestionnaires">Choisissez un questionnaire à soumettre :</label>
        
	<select class="form-control" name="IdentifiantQuestionnaire" id="listeQuestionnaires">
	    <c:forEach items="${ListeQuestionnaires}" var="identifiant" varStatus="status">
		    <option> <c:out value="${identifiant}"></c:out> </option>
		</c:forEach>
		<c:remove var="ListeQuestionnaires" scope="session" />	
    </select>
    
	<select class="form-control" name="IdentifiantSalarie" id="listeSalaries">
	    <c:forEach items="${ListeSalaries}" var="identifiant" varStatus="status">
		    <option> <c:out value="${identifiant}"></c:out> </option>
		</c:forEach>
		<c:remove var="ListeSalaries" scope="session" />	
    </select>
   		 
   		 <div class="row pt-2">
	  		  <div class="col"><input type="submit" class="btn btn-info" value="Valider" style="float:right;"></div>
	  		  <div class="col"><input type="reset" class="btn btn-danger" value="Annuler"></div>  		  
	  		  
   		 </div> 
   		
	</form> 
