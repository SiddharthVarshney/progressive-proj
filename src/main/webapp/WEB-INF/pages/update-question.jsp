<%@ include file="./header.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<div class ="container mx-5">

 

    <div class="row">
        <div class="col">
            <sf:form modelAttribute="question" action = "question" method="POST">
                
                <div class="form-group row">
                    <label class="col-md-4" for="question">Enter Question</label>
                    <div class="col-md-8">
                        <sf:input path="question" cssClass="form-control" value = "${question.question}"/>
                    </div>
                </div>
                
                <div class="form-group row" style="display:none">
                    <label class="col-md-4" for="question">Enter Question</label>
                    <div class="col-md-8">
                        <sf:input path="question" cssClass="form-control" value = "${question.quesid}"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-4" for="option1">Enter Option1</label>
                    <div class="col-md-8">
                        <sf:input path="option1" cssClass="form-control" value = "${question.option1}"/>
                    </div>
                </div>
                
    
                <div class="form-group row">
                    <label class="col-md-4" for="option2">Enter Option2</label>
                    <div class="col-md-8">        
                <sf:input path="option2" cssClass="form-control" value = "${question.option2}"/>
                    </div>
                </div>
                
    
                <div class="form-group row">
                    <label class="col-md-4" for="option3">Enter Option3</label>
                    <div class="col-md-8">
                        <sf:input path="option3" cssClass="form-control" value = "${question.option3}"/>
                    </div>
                </div>
                
    
                <div class="form-group row">
                    <label class="col-md-4" for="option4">Enter Option4</label>
                    <div class="col-md-8">
                        <sf:input path="option4" cssClass="form-control" value = "${question.option4}"/>
                    </div>
                </div>
                
    
                <div class="form-group row">
                    <label class="col-md-4"></label>
                    <div class="col-md-8">
                         <button class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </sf:form>
        </div>
    
    </div>
</div>

 


<%@ include file="./footer.jsp" %>