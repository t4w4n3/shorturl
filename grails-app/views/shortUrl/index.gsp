<%@ page import="shorturl2.ShortUrl" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<g:set var="entityName" value="${message(code: 'shortUrl.label', default: 'ShortUrl')}"/>
	<title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-shortUrl" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
															   default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		<li><g:link class="create" action="create"><g:message code="default.new.label"
															  args="[entityName]"/></g:link></li>
	</ul>
</div>

<div id="list-shortUrl" class="content scaffold-list" role="main">
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	<f:table collection="${shortUrlList}" template="shortUrl"/><br>

	<div class="pagination">
		<g:paginate total="${shortUrlCount ?: 0}"/>
	</div>
</div>
</body>
</html>