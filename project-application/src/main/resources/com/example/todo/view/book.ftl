<#-- @ftlvariable name="" type="TodoView" -->
<html>
    <body>
    Liste Carnets
        <#list books as x>
          ${x.id} - ${x.titre}
        </#list>
    </body>
</html>