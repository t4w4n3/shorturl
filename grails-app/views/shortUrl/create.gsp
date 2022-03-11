<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<g:set var="entityName" value="${message(code: 'shortUrl.label', default: 'ShortUrl')}"/>
	<title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div id="content" role="main">
	<div class="container">
		<section class="row">
			<a href="#create-shortUrl" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

			<div class="nav" role="navigation">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
				</ul>
			</div>
		</section>
		<section class="row">
			<div id="create-shortUrl" class="col-12 content scaffold-create" role="main">
				<h1><g:message code="default.create.label" args="[entityName]"/></h1>
				<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
				</g:if>
				<g:hasErrors bean="${this.shortUrl}">
					<ul class="errors" role="alert">
						<g:eachError bean="${this.shortUrl}" var="error">
							<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
						</g:eachError>
					</ul>
				</g:hasErrors>
				<g:form resource="${this.shortUrl}" method="POST">
					<fieldset class="form">
						<f:all bean="shortUrl"/>
					</fieldset>
					<fieldset class="buttons">
						<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}"/>
					</fieldset>
				</g:form>
			</div>
		</section>
	</div>
</div>
<g:if test="${created}">
	<div id="show-shortUrl" class="content scaffold-show" role="main">
		<h1>Shortened url :</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:set var="link" value="${createLink(uri: "/${created.segment}", absolute: true)}"/>
		<a href="${link}">${link}</a>
	</div>
</g:if>
</body>
</html>
