
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
	<div>If you don't have an account,</div>
	<div><a class="signUPTrial" href="#">sign up for your 10 day trial.</a></div>
	<br/>
	<br/>
	
	<div class="formContainer">
		<div class="innerFormContainer">
			<form:form action="processLogIn" modelAttribute="account" method="post">
			<div class="form-group">
				<label for="email" > Email Address</label>
				<br>
				<form:input type="text" path="email" id="email" cssClass="form-control" />
				<form:errors path="email" cssClass="error" />
			</div>
				
			<div class="form-group">
				<label for="password">Password <span class="forgotPassword">Forgot Password?</span></label> 
				<br>
				<form:input type="password" path="password" id="password" cssClass="form-control"/>
				<form:errors path="password" cssClass="error" />
				
			</div>
				
				<input type="submit" value="Log In" class="btn btn-success btn-exlg"/>
				
			<br>
			<%-- <div class="form-group">
				<form:checkbox path="stayLogIn" value="true" id="check" cssClass="formCheckBox"/>  <label for="check">Stay Log In</label>
			</div> --%>
				
		
		</form:form>
		</div>
		<h3>${ty}</h3>
	</div>

</div>
</body>
</html>