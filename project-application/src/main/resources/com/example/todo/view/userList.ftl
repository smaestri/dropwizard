<#-- @ftlvariable name="" type="com.example.todo.view.UserListView" -->
<html>
	<h1> TODO APPLICATION </h1>
	<h3> User list </h3>
	
	<p><a href="/users/create">CREATE</a></p>
	
	<ul>
		<#list users as user>
			<li>${user.id} ${user.firstName} ${user.lastName} 
				<a href="/users/edit?id=${user.id}">EDIT</a> <a href="/users/delete?id=${user.id}">DELETE</a>
			</li>
		</#list>
	</ul>
</html>