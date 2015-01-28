<html>
	<h1> TODO APPLICATION </h1>
	<h3> Todo list </h3>

	<p><a href="/todo/create">CREATE</a></p>

	<ul>
		<#list todos as todo>
			<li>${todo.id} ${todo.libelle} - Book: ${todo.book.titre}
			<a href="/todo/edit?id=${todo.id}">EDIT</a> <a href="/todo/delete?id=${todo.id}">DELETE</a>
			</li>
		</#list>
	</ul>
</html>