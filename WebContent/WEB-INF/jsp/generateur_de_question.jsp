<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<link rel="icon" href="<c:url value="/img/ua.png"/>">
<title>Générateur de questionnaire - ESTER</title>
<link rel="stylesheet"
	href="<c:url value="/css/old/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/menu.css"/>">

<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/popper.min.js"/>"></script>
<script src="<c:url value="/js/old/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/fb.js"/>"></script>
</head>

<body>
	<!-- entete de page (logo) -->

	<nav class="navbar navbar-expand-lg fixed-top navbar-dark shadowbottom">
		<div class="row">
			<div class="col-md-1" style="text-align: center;">
				<a href="<c:url value="/utilisateur"/>"><img
					src="<c:url value="/img/retour.png"/>" alt="retour" width="65"></a>
			</div>
			<div class="col-md-5" style="text-align: center;">
				<img src="<c:url value="/img/irset.png"/>" alt="Logo-ister"
					width="155">
			</div>
			<div class="col-md-5" style="text-align: center;">
				<img src="<c:url value="/img/ua_h.png"/>"
					alt="Logo-Université-Angers" width="170">
			</div>
		</div>
	</nav>


	<c:if test="${not empty Success}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<strong>Succès</strong>
			<c:out value="${Success}" />
			<c:remove var="Success" scope="session" />
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<c:if test="${not empty Warning}">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<strong>Attention</strong>
			<c:out value="${Warning}" />
			<c:remove var="Warning" scope="session" />
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>


	<!-- questionnaire -->
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-8">
				<div class="clearfix">
					<div class="shadowbottom">
						<h2 style="border-radius: 10px; text-align: center">Questionnaire
						</h2>
						
						<h5> Faites glisser les éléments de votre questionnaire ci-dessous (pour valider, cliquez sur l'onglet Questionnaire) :</h5>
						<form id="target" class="form-horizontal"
							style="word-wrap: break-word; overflow: auto; background: white; min-height: 400px;">

							<div id="build">
								<fieldset>
								
									
								</fieldset>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="shadowbottom">
					<h2 style="border-radius: 10px; text-align: center">Champs
						pour le questionnaire</h2>
				</div>
				<div class="row pt-2">
					<c:import url="/jsp/Alert.jsp" />
				</div>

				<div class="tabbable">
					<ul class="nav nav-tabs" id="navtab">
						<li class="active"><a href="#1" data-toggle="tab"
							style="background: #6bb8c8; color: white;">Questions</a></li>
						<li><a href="#2" data-toggle="tab"
							style="background: #6bb8c8; color: white;">Questionnaire</a></li>
						<li><a id="sourcetab" href="#5" data-toggle="tab"
							style="background: #6bb8c8; color: white;">Html source </a></li>
					</ul>
					<div class="shadowbottom">
						<form class="form-horizontal" id="components"
							style="background: white" method="post">
							<fieldset>
								<div class="tab-content">
									<div class="tab-pane active" id="1">
										<div style='width: 500px' class="form-group component active"
											data-type="text" title="Text Input"
											data-content="
	                      <form class='form'>
	                        <div class='form-group col-md-12'>
	                          <label class='control-label'>Veuillez saisir votre texte</label> <input class='form-control' type='text' id='label' name='label' placeholder='Question'>
	                          <label class='control-label'>Texte par defaut</label> <input type='text' id='placeholder' name='placeholder' placeholder='Texte par défaut' class='form-control'>
	                          <hr/>
	                          <button class='btn btn-info'>Enregistrer</button><button class='btn btn-danger'>Fermer</button>
	                        </div>
	                      </form>"
											data-html="true">
											<!-- Text input-->
											<label class="col-md-4 control-label valtype"
												data-valtype='label'>Question de type texte
												(courte):</label>
											<div class="col-md-4">
												<input type="text" placeholder="Texte par defaut"
													name="input01" class="form-control input-md valtype"
													data-valtype="placeholder">
											</div>
										</div>

										<div class="form-group component" rel="popover"
											data-content="
	                        <div class='form-group col-md-12'>
	                          <label class='control-label'>Texte</label> <input class='form-control' type='text' name='label' id='label'>
	                          <label class='control-label'>Options: </label>
	                          <textarea class='form-control' style='min-height: 130px;min-width:200px;' id='option'></textarea>
	                          <hr/>
	                          <button class='btn btn-info'>Enregistrer</button><button class='btn btn-danger'>Fermer</button>
	                        </div>
	                      "
											data-html="true">
											<!-- Select Multiple -->
											<label class="col-md-4 control-label valtype"
												data-valtype="label">Question choix unique (liste
												déroulante) :</label>
											<div class="col-md-4">
												<select class="form-control input-md valtype"
													multiple="multiple" data-valtype="option">
													<option>Veuillez</option>
													<option>Entrer</option>
													<option>Vos</option>
													<option>Options !</option>
												</select>
											</div>
										</div>
			<div class="form-group component" rel="popover"
											title="Multiple checkboxes"
											data-content="
	                      <form class='form'>
	                        <div class='form-group col-md-12'>
	                          <label class='control-label'>Texte</label> <input class='form-control' type='text' name='label' id='label'>
	                          <label class='control-label'>Options: </label>
	                          <textarea class='form-control' style='min-height: 200px' id='checkboxes'></textarea>
	                          <hr/>
	                          <button class='btn btn-info'>Enregistrer</button><button class='btn btn-danger'>Fermer</button>
	                        </div>
	                      </form>"
											data-html="true">
											
										
											<!-- Multiple Checkboxes -->
											<label class="col-md-4 control-label valtype"
												data-valtype="label">Question à choix multiple</label>
											<div class="col-md-4 valtype" data-valtype="checkboxes">

												<label class="checkbox"> <input type="checkbox"
													value=" Option one "> Option 1
												</label> <label class="checkbox"> <input type="checkbox"
													value=" Option two "> Option 2
												</label>
											</div>
										</div>


										<div class="form-group component" rel="popover"
											title="Multiple Radios"
											data-content="
	                      <form class='form'>
	                        <div class='form-group col-md-12'>
	                          <label class='control-label'>Texte</label> <input class='form-control' type='text' name='label' id='label'>
	                          <label class='control-label'>Attributs</label> <input class='form-control' type='text' name='name' id='name'>
	                          <label class='control-label'>Options: </label>
	                          <textarea class='form-control' style='min-height: 200px' id='radios'></textarea>
	                          <hr/>
	                          <button class='btn btn-info'>Enregistrer</button><button class='btn btn-danger'>Fermer</button>
	                        </div>
	                      </form>"
											data-html="true">
											<!-- Multiple Radios -->
											<label class="col-md-4 control-label valtype"
												data-valtype="label">Question à choix unique: </label>
											<div class="col-md-4 valtype" data-valtype="radios">
												<label class="radio"> <input type="radio"
													value="Option one" name="group" checked="checked">
													premiere option
												</label> <label class="radio"> <input type="radio"
													value="Option two" name="group"> deuxieme option
												</label>
											</div>
										</div>
	
										<div class="form-group component" rel="popover"
											data-content="
	                        <form class='form'>
	                          <div class='form-group col-md-12'>
	                            <label class='control-label'>texte</label> <input class='form-control' type='text' name='label' id='label'>
	                            <label class='control-label'>texte par defaut </label>
	                            <textarea class='form-control' style='min-height: 200px' id='textarea'> </textarea>
	                            <hr/>
	                            <button class='btn btn-info'>Enregistrer</button><button class='btn btn-danger'>Fermer</button>
	                          </div>
	                        </form>"
											data-html="true">

											<!-- Textarea -->
											<label class="col-md-4 control-label valtype"
												data-valtype="label">Question de type texte(long) :</label>
											<div class="col-md-4">
												<div class="textarea" data-valtype="textarea">
													<textarea class="form-control input-md valtype"
														data-valtype="textarea"> </textarea>
												</div>
											</div>
										</div>
										<div class="form-group component" rel="popover"
											title="File Upload"
											data-content="
	                      <form class='form'>
	                        <div class='form-group col-md-12'>
	                          <label class='control-label'>texte</label> <input class='form-control' type='text' name='label' id='label'>
	                          <label id='file'></label>
	                          <hr/>
	                          <button class='btn btn-info'>Enregistrer</button><button class='btn btn-danger'>Fermer</button>
	                        </div>
	                      </form>"
											data-html="true">
											<div class="row">

												<label class="col control-label valtype"
													data-valtype="label"
													style="text-align: center; margin-left: 50px;">Image
													à télécharger </label>
											</div>
											<!-- File Upload -->
											<div class="row">
												<div class="col-md-4 "
													style="margin-left: 50px; margin-top: 7px"
													data-valtype="file">
													<input class="valtype" id="fileInput" name="file1"
														type="file" data-valtype="file">
												</div>
											</div>
										</div>

										<div class="form-group component" rel="popover"
											title="slideBare"
											data-content='<form class="form">
	                        <div class="form-group col-md-12">
	                          <label class="control-label">Label Text</label> <input class="form-control" type="text" name="label" id="label">
	                          <hr/>
	                          <button class="btn btn-info">Enregistrer</button><button class="btn btn-danger">Fermer</button>
	                        </div>
	                      </form>'
											data-html="true">
											<!-- slide  -->
											<label class="col-md-4 control-label valtype"
												data-valtype="label"> Question : </label> <input
												type="range" name="weight" id="range_weight" value="5"
												min="1" max="100"
												oninput="range_weight_disp.value = range_weight.value">
											<output id="range_weight_disp"></output>
										</div>
										<!-- echelle de borg-->
										<div class="form-group component" rel="popover"
											title="Multiple Radios"
											data-content="
	                      <form class='form'>
	                        <div class='form-group col-md-12'>
	                          <label class='control-label'>Texte</label> <input class='form-control' type='text' name='label' id='label'>
	                          <label class='control-label'>Attributs</label> <input class='form-control' type='text' name='name' id='name'>
	                          <label class='control-label'>Options: </label>
	                          <textarea class='form-control' style='min-height: 200px' id='radios'></textarea>
	                          <hr/>
	                          <button class='btn btn-info'>Enregistrer</button><button class='btn btn-danger'>Fermer</button>
	                        </div>
	                      </form>"
											data-html="true">
											<!-- echelle  -->
											<label class="col-md-4 control-label valtype"
												data-valtype="label">Echelle de Borg: </label>
											<div class="col-md-4 valtype" data-valtype="radios">
												<label class="radio"> <input type="radio"
													value="Très très facile" name="Très très facile"
													checked="checked"> Très très facile
												</label> <label class="radio"> <input type="radio"
													value="Très très facile" name="Très facile"> Très
													facile
												</label> <label class="radio"> <input type="radio"
													value="Très très facile" name="Assez facile"> Assez
													facile
												</label> <label class="radio"> <input type="radio"
													value="Un peu dur" name="Un peu dur"> Un peu dur
												</label> <label class="radio"> <input type="radio"
													value="Dur" name="Dur"> Dur
												</label> <label class="radio"> <input type="radio"
													value="Très dur" name="Très dur"> Très dur
												</label> <label class="radio"> <input type="radio"
													value="Très très dur" name="Très très dur"> Très
													très dur
												</label>
											</div>
										</div>
									</div>
									<!-- remplissage de BDD et sauvgarde -->
									<div class="tab-pane" id="2">
										<input type="text" name="Nom" class="form-control"
											style="margin: 6px" placeholder="Nom du questionnaire"
											required> <input type="text" name="Identifiant"
											class="form-control" style="margin: 6px"
											placeholder="Identifiant du questionnaire" required>
										<input type="submit" class="btn btn-primary"
											style="margin: 6px" value="Enregistrer">
									</div>
									<!-- Code Source -->

									<div class="tab-pane" id="5">
										<textarea name="source" id="source" class="col-md-12"
											rows="25" required readonly></textarea>
									</div>
									

								</div>
										
							</fieldset>
								
						</form>
					</div>
				</div>
			</div>
			<!-- fin col-md-4 -->
			<div class="row clearfix">
				<div class="col-md-12"></div>
			</div>
		</div>
		<!-- /container -->

		<div class="row" style="padding-bottom: 20px">
			<div class="col-md-12"></div>

		</div>
		<div class="row" style="text-align: center">
			<div class="col-md-3"></div>
			<div class="col-md-2" style="text-align: center;">
				<a href="<c:url value="/jsp/EnDev.jsp"/>">Mentions Légales</a>
			</div>
			<div class="col-md-2" style="text-align: center;">
				<a href="<c:url value="/jsp/EnDev.jsp"/>">Projet</a>
			</div>
			<div class="col-md-2" style="text-align: center;">
				<a href="<c:url value="/jsp/EnDev.jsp"/>">Contacts</a>
			</div>
		</div>
	</div>
</body>
</html>