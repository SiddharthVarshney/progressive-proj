

<%@ include file="./header.jspf" %>

	<div class="container">
	<div class="alert alert-dismissible alert-primary">
	  	<h4 class="alert-heading">${title}</h4>
	  	<a href="./add-question">Ask-question</a>
	  	
	  	<table class="table table-hover mb-0">
		  <thead>
		    <tr>
		      <th scope="col">Question ID</th>
		      <th scope="col">Question</th>
		      <th scope="col">Option 1</th>
		      <th scope="col">Option 2</th>
		      <th scope="col">Option 3</th>
		      <th scope="col">Option 4</th>
		      <th scope = "col">Details
		    </tr>
		  </thead>
		  <tbody>
			  <sap:forEach items="${questions}" var="que" varStatus="status">
				  <tr >
				  	  <td>${que.quesid}</th>
				      <td>${que.question}</td>
				      <td>${que.option1}</td>
				      <td>${que.option2}</td>
				      <td>${que.option3}</td>
				      <td>${que.option4}</td>
				      <td>
					      <a href="<sap:url value="/question-details/?quesid=${que.quesid}">
	         				</sap:url>" class="btn btn-success">Details</a>
	         		  </td>
				  </tr>
			  </sap:forEach>
		    
			</tbody>
		</table>
	</div>
	</div>
	

<%@ include file="./footer.jsp" %>
</body>
</html>