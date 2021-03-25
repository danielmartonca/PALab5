<!DOCTYPE html>
<html lang="en-US">
<head>
    <title>Catalogue items</title></head>
<body>
<main>
    <h2>Printing the values for catalogue ${catalogName}</h2>

    <div class="catalogueProprieties">
        <h3>The catalogue is situated at path:</h3><em>${catalogPath}</em>
        <h3>It contains the fallowing items:</h3>
        <ul>
            <#list itemsList as item>
                <li class="item">
                    <p>Item id: ${item.id}</p>
                    <p>Item name: ${item.name}</p>
                    <p>Item path: ${item.path}</p>
                    <p>Item itemSize: ${item.itemSize}</p>
                </li>
            </#list>
        </ul>
    </div>

</main>

</body>
</html>