<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Virb</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Resources/css/virb.css">
	<link rel="styelsheet" type="text/css" href="${pageContext.request.contextPath}/Resources/css/bootstrap-social.css">
	<script src="https://use.fontawesome.com/f649b23c13.js"></script>
	
</head>
<body>

<nav class="navbar navbar-default" id="navbar">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img id="iconBrand" alt="" src="${pageContext.request.contextPath}/Resources/pics/logo.png"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1 id="titleLink">
      <ul class="nav navbar-nav navigation">
        <li class=""><a class="alink navFeature" href="${pageContext.request.contextPath}/home/features">FEATURES</a></li>
        <li><a class="alink" href="${pageContext.request.contextPath}/home/themes">THEMES</a></li>
        <li><a class="alink" href="${pageContext.request.contextPath}/home/showcase">SHOWCASE</a></li>
        <li><a class="alink" href="${pageContext.request.contextPath}/home/pricing">PRICING</a></li>
        <li><a class="alink" href="${pageContext.request.contextPath}/home/about-us" id="aboutUs" class="active">ABOUT US</a></li>
       	<li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
      	<li><button type="button" onclick=window.location.href="${pageContext.request.contextPath}/home/startTrialForm" class="btn btn-success navbar-btn btn-md startTrialButton alink">Start Your Trial</button></li>
        <li><a class="alink"  href="${pageContext.request.contextPath}/home/logIn">LOG IN</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
  
  

   	<div class="features navFeature">
   		<div class="triangle"></div>
   		<ul>
   			<li><span>vibe for:</span></li>
  			<li><a>EVERYONE</a></li>
  			<li><a>PHOTOGRAPHERS</a></li>
  			<li><a>MUSIANS</a></li>
  			<li><a>FOOD & DRINK</a></li>
  			<li><a>DESIGNERS</a></li>
  			<li><a>LIST</a></li>
   		</ul>
  		
  
  	</div>
 

 