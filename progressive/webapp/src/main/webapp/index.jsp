<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>

<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
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
					<a href="./ask-question.jsp" class="btn btn-success btn-lg btn-block">Ask a Question</a>
				</sap:if>
				<sap:if test="${sessionScope.userId == null}">
					<a href="#" class="btn btn-secondary btn-lg btn-block">Login to ask a Question</a>
				</sap:if>
			</div>
		</div>
		
		<div class="row mt-3 mb-3 border">
			<div class="col-12">
				<sap:forEach items="${requestScope.questions}" var="question" >
					<div class="card mt-3 mb-3">
						<div class="card-body">
						  	<h5 class="card-title">${question.title}</h5>
						  
						  	<div class="card-text">
						  		<p>${question.body}</p>
						  		<div class="mb-3">
						  		<sap:forEach items="${question.tags}" var="tags">
						  			<span class="d-inline p-2 bg-dark text-white">${tags}</span>
						  		</sap:forEach>
						  		</div>
						  	</div>
						  	<a href="<sap:url value="/questionDetails">
                						<sap:param name="quesId" value="${question.quesId}"/>
         							</sap:url>" 
         						class="btn btn-primary mt-2"> Details
         					</a>
						</div>
					</div>
				</sap:forEach>
			</div>
		</div>
		
	</div>
		
</body>
</html>
