<#-- @ftlvariable name="" type="TodoView" -->
<html>
    <body>
    List Taches
        <#list todos as x>
          ${x.id} - ${x.libelle}
        </#list>
    </body>
</html>