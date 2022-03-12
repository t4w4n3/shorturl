<table>
	<thead>
	<tr>
		<th>Short urls</th>
		<th>Shortened urls</th>
	</tr>
	</thead>
	<tbody>
	<g:each in="${collection}" var="bean" status="i">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<g:each in="${domainProperties}" var="p" status="j">
				<g:if test="${j == 0}">
					<td>
						<g:link uri="/${bean.segment}">
							${g.createLink(uri: "/${bean.segment}", absolute: true)}
						</g:link>
					</td>
					<td>
						<a href="${bean.url}">
							${bean.url}
						</a>
					</td>
				</g:if>
				<g:else>
					<td><f:display bean="${bean}" property="${p.property}" displayStyle="${displayStyle ?: 'table'}" theme="${theme}"/></td>
				</g:else>
			</g:each>
		</tr>
	</g:each>
	</tbody>
</table>