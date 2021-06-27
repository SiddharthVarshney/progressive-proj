<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Answer</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css">
</head>
<body>

	<header>
		<%@ include file="./WEB-INF/views/header.jsp"%>
	</header>
	<div class="container">
		<div class="row mt-3">
			<div class="col-12">
				<h2>Add answer</h2>
			</div>
		</div>
		
		<div class="row mt-3 mb-3 border">
			<div class="col-12">
				<form method="post" action="addAnswer" class="mt-4 mb-4">
					<div class="container">
						<div class="form-group">
							<label for="ansBody">Answer Body</label> 
							<textarea class="form-control" name="ansBody" id="ansBody" rows="3" placeholder="Enter answer"></textarea>
						</div>
						<input type="hidden" name="quesId" id="quesId" value="${param.quesId}" />
                   
						<button type="submit" class="btn btn-primary">
         					Submit
         				</button>
						 
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>