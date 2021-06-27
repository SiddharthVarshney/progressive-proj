<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>

<html>
<head>
<meta charset="UTF-8">
<title>Question Detail</title>
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
					<a href="<sap:url value="/add-ans.jsp">
                						<sap:param name="quesId" value="${requestScope.question.quesId}"/>
         							</sap:url>" class="btn btn-success btn-lg btn-block">Add Answer</a>
				</sap:if>
				<sap:if test="${sessionScope.userId == null}">
					<a href="#" class="btn btn-secondary btn-lg btn-block">Please Login First</a>
				</sap:if>
			</div>
		</div>
		
		<div class="row mt-3 mb-3 border">
			<div class="col-12">
				<h4 class="display-5">  ${requestScope.question.title}</h4>
				<h5 class="display-5">  ${requestScope.question.body}</h5>
				<h6 class="display-7"> Answers : </h6>
				<sap:forEach items="${requestScope.question.answers}" var="answer" >
					<div class="card mt-3 mb-3">
						<div class="card-body">
						  	<div class="card-text">
						  		<p>${answer.ansBody}</p>
						  	</div>
						</div>
					</div>
				</sap:forEach>
			</div>
			
		</div>
		
	</div>
		
</body>
</html>