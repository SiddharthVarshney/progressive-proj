<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		 <a class="navbar-brand ml-3" href="/home">Progressive Project</a>
		 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" 
		 			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		 	<span class="navbar-toggler-icon"></span>
		 </button>
	
		 <div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			<sap:if test="${sessionScope.userId == null}">
				  <li class="nav-item active">
				    <a class="nav-link" href="#">Login <span class="sr-only">(current)</span></a>
				  </li>
				  <li class="nav-item">
				  	<a class="nav-link" href="#">Register</a>
				  </li>
			  </sap:if>
			</ul>
		 </div>
	</nav>
	
</body>
</html>