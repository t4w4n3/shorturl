<!doctype html>
<html lang="en" class="no-js">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<title>
	<g:layoutTitle default="Grails"/>
	</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

	<asset:stylesheet src="application.css"/>

	<g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
	<div class="container-fluid">
		<a class="navbar-brand" href="/#"><asset:image src="axe.svg" alt="Tawane's url shortener Logo"/></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
			<ul class="nav navbar-nav ml-auto">
				<g:pageProperty name="page.nav"/>
			</ul>
		</div>
	</div>
</nav>

<g:layoutBody/>

<div class="footer row" role="contentinfo">
	<div class="col">
		<p>Url shortener by tawane</p>
	</div>

	<div class="col">
		<p>Powered by Grails <g:meta name="info.app.grailsVersion"/></p>
		<p>This is just a demo. Database is flushed at each reboot</p>
	</div>

	<div class="col">
		<p>Served by Heroku with Gradle buildpack</p>
	</div>
</div>

<div id="spinner" class="spinner" style="display:none;">
	<g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
