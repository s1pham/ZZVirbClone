<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Virb > Log In</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resources/css/virb.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	
</head>
<body class="logBody">

<div class="containerLog"> 
	<a href="${pageContext.request.contextPath}/" ><img class="logInLogo" alt="logo" src="${pageContext.request.contextPath}/Resources/pics/logo.png" /></a>
	<br/>
	<br>
	<h4>Start Your Free 10 Day Trial</h4>
	<div>Try out the Full version of Virb free for 10 days. No credit card</div>
	<div>required. <a>Log in</a> if you already have an account.</div>
	<br/>
	<br/>
	
	<div class="trialFormContainer">
		<div class="innerTrialFormContainer">
			<div><h4>Personal Info</h4></div>
			<form:form action="processFreeTrialForm" method="post" modelAttribute="combineAccountWebsite">
			<div class="form-group">
				<label for="firstName" >First Name</label>
				<br>
				<form:input type="text" path="firstName" id="firstName" cssClass="form-control" />
				<form:errors path="firstName" cssClass="error" />
			</div>
				
			<div class="form-group">
				<label for="lastName">LastName</label> 
				<br>
					<form:input type="text" path="lastName" id="lastName" cssClass="form-control"/>
					<form:errors path="lastName" cssClass="error" />
			</div>
				
			<div class="form-group">
				<label for="email">Email</label> 
				<br>
					<form:input type="email" path="email" id="email" cssClass="form-control"/>
					<form:errors path="email" cssClass="error" />
			</div>
			
			<div class="form-group">
				<label for="password">Password <span>(must be 8 characters long)</span></label> 
				<br>
					<form:input type="password" path="password" id="passowrd" cssClass="form-control"/>
					<form:errors path="password" cssClass="error" />
			</div>
			
			<br/>
			<br/>
			
			<div><h4>Website Info</h4></div>
				
			<br>
			
			<div class="form-group">
				<label for="title">Site Title</label> 
				<br>
					<form:input type="text" path="title" id="title" cssClass="form-control"/>
					<form:errors path="title" cssClass="error" />
			</div>
			
			<div class="form-group">
				<label for="link">Site Link</label> 
				<br>
					<form:input type="text" path="link" id="link" cssClass="form-control"/>
					<form:errors path="link" cssClass="error" />
			</div>
			
			<div class="form-group">
				<label for="category">Site Category (optional)</label>
				<br/>
				<form:select path="category" cssClass="form-control">
					<form:options items="${combineAccountWebsite.categoryList}" />
				</form:select>
				<form:errors path="category" cssClass="error" />
			
			</div>
			
			<br/>
			<input type="submit" value="Log In" class="btn btn-success btn-exlg"/>
				
			<br/><br/>
			<div class="term">By clicking this button you agree to Birb's <a>terms and conditions</a></div>
		
		</form:form>
		<h3>${ty}</h3>
		</div>
		
	</div>
	<br/>
	<div class="copyright">@2018 Birb, A (mt) Media Temple Product.</div>
	<br/><br/><br/>
</div>
</body>
