<#-- @ftlvariable name="" type="TodoView" -->
<html>
    <body>
    Test sma
        <#list todos as x>
          ${x.id} - ${x.libelle}
        </#list>
    </body>
</html>