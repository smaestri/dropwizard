<html>
	<h1> TODO APPLICATION </h1>
	<h3> Todo list </h3>

	<ul>
		<#list todos as todo>
			<li>${todo.id} ${todo.libelle} - Book: ${todo.book.titre}
			</li>
		</#list>
	</ul>
</html>