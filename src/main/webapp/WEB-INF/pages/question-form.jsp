<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<%@ include file="./header.jspf" %>
	<div class="container">
		<div class="row">
			<div class="col-6">
			
				<sf:form modelAttribute="question" action="save-question" method="post">
					<div class="form-group row mb-2">
				      <label for="question" class="col-sm-2 col-form-label">Question</label>
				      <div class="col-sm-10">
				        <sf:input path="question" cssClass="form-control"/>
				      </div>
				    </div>
				    
				    
					<div class="form-group row mb-2">
				      <label for="opt1" class="col-sm-2 col-form-label">Option 1</label>
				      <div class="col-sm-10">
				        <sf:input path="opt1" cssClass="form-control"/>
				      </div>
				    </div>
				    
				    
					<div class="form-group row mb-2">
				      <label for="opt2" class="col-sm-2 col-form-label">Option 2</label>
				      <div class="col-sm-10">
				        <sf:input path="opt2" cssClass="form-control"/>
				      </div>
				    </div>
				    
				    
					<div class="form-group row mb-2">
				      <label for="opt3" class="col-sm-2 col-form-label">Option 3</label>
				      <div class="col-sm-10">
				        <sf:input path="opt3" cssClass="form-control"/>
				      </div>
				    </div>
				    
				    
					<div class="form-group row mb-3">
				      <label for="opt4" class="col-sm-2 col-form-label">Option 4</label>
				      <div class="col-sm-10">
				        <sf:input path="opt4" cssClass="form-control"/>
				      </div>
				    </div>
				    
				    <div class="form-group row mb-3">
				    	<div class="col-sm-2"></div>
				      <div class="col-sm-10">
				        <button type="submit">Submit</button>
				      </div>
				    </div>
				</sf:form>
			
			</div>
		</div>
	</div>
</body>
</html>