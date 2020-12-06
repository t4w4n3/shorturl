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
			<td>
				<g:link uri="/${bean.fragment}">
					${g.createLink(uri: "/${bean.fragment}", absolute: true)}
				</g:link>
			</td>
			<td>
				<a href="${bean.url}">
					${bean.url}
				</a>
			</td>
		</tr>
	</g:each>
	</tbody>
</table>