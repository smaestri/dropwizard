<#-- @ftlvariable name="" type="com.example.todo.view.UserListView" -->
<html>
	<h1> TODO APPLICATION </h1>
	<h3> Book list </h3>
	
	<p><a href="/book/create">CREATE BOOK</a></p>
	<p><a href="/todo/create">CREATE TASK</a></p>
	
	<ul>
		<#list books as book>
			<li>${book.id} ${book.titre}

			<#if  book.listTask?has_content>
				 Liste taches :
				 <#list book.listTask as task>${task.id} ${task.libelle} </#list><br/>
				 <a href="/book/edit?id=${book.id}">EDIT</a></li> <a href="/book/delete?id=${book.id}">DELETE</a>
			</#if>
		</#list>
	</ul>

</html>