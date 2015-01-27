<#-- @ftlvariable name="" type="com.example.todo.view.UserEditView" -->
<html>
	<h1> TODO APPLICATION </h1>
	<#if book.isPresent()>
		<h3> Book edition </h3>
	<#else>
		<h3> Book creation </h3>
	</#if>
	
	<p><a href="/book/list">BACK THE THE LIST</a></p>
	
	<form method="POST"  <#if book.isPresent()>  action="/book/edit" <#else> action="/book/create" </#if>>
		Titre : <input type="text" name="titre" <#if book.isPresent()> value="${book.get().getTitre()}" </#if>>
		<input type="submit" value="Submit">
	</form>
		
</html>