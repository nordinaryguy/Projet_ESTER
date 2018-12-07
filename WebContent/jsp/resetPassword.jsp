<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="<c:url value="/js/checkPass.js"/>"></script>
<form class="form-reset" method="post">
		 <div class="form-title-row">
	           <h3>Veuillez entrer un nouveau mot de passe  </h3>
         </div>
		<c:import url="/jsp/Alert.jsp"/>
         <div class="form-row">
				<span>Email : </span> 		
	            <div class="col-xs-12 center-block text-center"> 
	               		<input type='email' name='email' id='email' value="${id}"  disabled="disabled" >
	            </div>
         </div>
					            
       <div class="form-row">
				<label for=#password>
						Nouveau mot de passe : 
				</label>		
                <input type='password' name='password' id='pass_1' onkeyup="return passwordChanged('pass_1');"  onBlur="checkPass('pass_1','pass_1')" required>
            	 <span id="strength" class="col col-xs-2"></span>
       </div> 
       <div class="row" >
    		
	   	</div>
	    <div class="form-row">
		  		<label>
						Confirmer le mot de passe : 	
				</label>	
	            <input type="password" name="passwordConfirm" id="pass_2" onkeyup="checkPass('pass_1','pass_2')" required>
	     </div>
	    <div id="divcomp">
			   	<div class="row" >
						          		
		      	</div>
		 </div>
	      <div class="row showPass">
		       	 <label>
					<input type="checkbox" id="showPass" onchange="document.getElementById('pass_2').type = this.checked ? 'text' : 'password';document.getElementById('pass_1').type = this.checked ? 'text' : 'password'">Mot de passe visible
		     	 </label>
		   </div>
	       <div class="row">
			  		<button id="submit" class="btn  btn-primary" type="submit" disabled>VALIDER</button>
	       </div>
</form>