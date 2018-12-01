<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid" id="container_formpatient"  style="height:75rem;padding-top:4.5rem;">
			<div class="row">
					<form class="form-patient" method="post">
			            <div class="form-title-row">
			                <h3>Veuillez saisir vos informations avant de débuter les questionnaires : </h3>
			            </div>
			
			            <div class="form-row">
			                <label>  
			                		<span>Sexe : </span> 		
			                </label> 
			                <div class="form-radio-buttons">
			                	<input type="radio" name="sexe" value="homme"> Homme<br>
								 <input type="radio" name="sexe" value="femme"> Femme<br>                
			                </div>  
			            </div>
			
			            <div class="form-row">
			                <label>
			                    <span>Âge</span>
			                    <script>
									  // On récupère l'année courante
 									   var date = new Date();
 									  document.write("<select name='years'>");
									  // On ajoute l'année courante et les 100 années à venir
									  // dans l'élément <select> pour l'année
									  for(var i = 15; i <= 79; i+=5) {
										  document.write("<option value=\""+i +"-"+(i+4)+"\">" + i +"-"+(i+4)+ "</option>");
									  }
 									  document.write("</select>");
								</script>
			                </label>
			            </div>
			
			            <div class="form-row">
			                <label>
			                    <span>PCS</span>
			                    <select name="pcs" id="pcs">
			                    </select>
			                </label>
			            </div>
			            
			            <div class="form-row">
			                <label>
			                    <span>NAF</span>
			                    <select name="naf" id="naf">
			                    </select>
			                </label>
			            </div>
			            
			            <div class="form-row">
			                <label>
			                    <span>Region</span>
			                    <select name="region" id="region" onchange="populateDep('region','departement')">
			                    </select>
			                </label>
			            </div>
			            
			            
						<div class="form-row">
			                <label>
			                    <span>Département</span>
			                    <select name="departement" id="departement" onchange="populateReg('departement','region')">
			                    </select>
			                </label>
			            </div>
			            
			            <div class="form-row">
			                <button type="submit" class="btn-primary">Soumettre</button>
			            </div>
			        </form>
			</div>
	</div>
	
<script>
	populateSelect("<c:url value="/src/pcs.json"/>","pcs");
	populateSelect("<c:url value="/src/naf.json"/>","naf");
	populateSelect("<c:url value="/src/regions.json"/>","region");
	populateSelect("<c:url value="/src/departments.json"/>","departement");
</script>