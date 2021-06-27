<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ask Question</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css">
</head>
<body>

	<header>
		<%@ include file="./WEB-INF/views/header.jsp"%>
	</header>
	<div class="container">
		<div class="row mt-3">
			<div class="col-12">
				<h2>Ask a question</h2>
			</div>
		</div>
		
		<div class="row mt-3 mb-3 border">
			<div class="col-12">
				<form method="post" action="askQuestion" class="mt-4 mb-4">
					<div class="container">
						<div class="form-group">
							<label for="title">Question Title</label> 
							<input type="text" class="form-control" id="title" name="title" placeholder="Enter title for the question"> 
						</div>
						
						<div class="form-group">
							<label for="quesBody">Question Body</label> 
							<textarea class="form-control" name="quesBody" id="quesBody" rows="3" placeholder="Enter the body of the question"></textarea>
						</div>
						
						<div class="form-group">
							<label for="quesTags">Question Tags</label> 
							<input type="text" class="form-control" id="quesTags" name="quesTags" placeholder="Enter comma separated tags"> 
						</div>
						
						 <button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>