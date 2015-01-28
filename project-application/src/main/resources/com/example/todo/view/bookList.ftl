<#-- @ftlvariable name="" type="com.example.todo.view.UserListView" -->
<html>
	<h1> TODO APPLICATION </h1>
	<h3> Book list </h3>
	
	<p><a href="/book/create">CREATE</a></p>
	
	<ul>
		<#list books as book>
			<li>${book.id} ${book.titre}
			 Liste taches :
             <#list book.listTask as task>${task.id} ${task.libelle} </#list><br/>
			 <a href="/book/edit?id=${book.id}">EDIT</a></li>
		</#list>
	</ul>
</html>