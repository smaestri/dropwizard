<#-- @ftlvariable name="" type="com.example.todo.view.UserEditView" -->
<html>
	<h1> TODO APPLICATION </h1>
	<#if user.isPresent()>
		<h3> User edition </h3>
	<#else>
		<h3> User creation </h3>
	</#if>
	
	<p><a href="/users/list">BACK THE THE LIST</a></p>
	
	<form method="POST"  <#if user.isPresent()>  action="/users/edit" <#else> action="/users/create" </#if>>
		First name : <input type="text" name="firstName" <#if user.isPresent()> value="${user.get().getFirstName()}" </#if>>
		Last name : <input type="text" name="lastName" <#if user.isPresent()> value ="${user.get().getLastName()}" </#if>>
		<input type="submit" value="Submit">
	</form>
		
</html>