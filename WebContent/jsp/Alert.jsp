<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${not empty Success}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<strong>Succès</strong> <c:out value = "${Success}"/> <c:remove var="Success" scope="session" />
		    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    	<span aria-hidden="true">&times;</span>
			 </button>
        </div>
</c:if>
	
<c:if test="${not empty Warning}">
      <div class="alert alert-warning alert-dismissible" role="alert">
         <strong>Erreur </strong> <c:out value = "${Warning}"/>
         <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		      <span aria-hidden="true">&times;</span>
	    </button>
      </div>
</c:if>

<c:if test="${not empty Error}">
      <div class="alert alert-danger alert-dismissible" role="alert">
         <strong>Erreur </strong> <c:out value = "${Error}"/>
         <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		      <span aria-hidden="true">&times;</span>
	    </button>
      </div>
</c:if>