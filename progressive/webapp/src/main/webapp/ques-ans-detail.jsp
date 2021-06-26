<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>

<html>
<head>
<meta charset="UTF-8">
<title>QADetail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css">
</head>
<body>

	<header>
		<%@ include file="./WEB-INF/views/header.jsp"%>
	</header>
	
	<div class="container">
		<div class="row mt-3">
			<div class="col-12">
				<sap:if test="${sessionScope.userId != null}">
					<a href="./ask-question.jsp" class="btn btn-success btn-lg btn-block">Add Answer</a>
				</sap:if>
				<sap:if test="${sessionScope.userId == null}">
					<a href="#" class="btn btn-secondary btn-lg btn-block">Please Login First</a>
				</sap:if>
			</div>
		</div>
		
	</div>
		
</body>
</html>
