<html>
	<h1> TODO APPLICATION </h1>
	<#if todo.isPresent()>
		<h3> Task edition </h3>
	<#else>
		<h3> Task creation </h3>
	</#if>
	
	<p><a href="todo/list">BACK THE THE LIST</a></p>
	
	<form method="POST"  <#if todo.isPresent()>  action="/todo/edit" <#else> action="/todo/create" </#if>>
		<#if todo.isPresent()><input type="hidden" name="id" value="${todo.get().getId()}"/></#if>
		Libellé : <input type="text" name="libelle" <#if todo.isPresent()> value="${todo.get().getLibelle()}" </#if>>
		Id Carnet : <input type="text" name="idBook" <#if todo.isPresent()> value="${todo.get().getBook().getId()}" </#if>>
		<input type="submit" value="Submit">
	</form>
		
</html>