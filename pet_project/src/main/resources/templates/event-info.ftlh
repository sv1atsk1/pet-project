<!DOCTYPE html>
<html>
<head>
    <title>All Events</title>
</head>
<body>
<h1>Hello,All Events</h1><hr>
<h4>Подробная информация об ивенте</h4>
<#list images as img>
    <img src="/images/${img.id}" height="200px"/><br><br>
</#list>
<b>Описание ивента: </b>${event.description}<br>
<b>Название ивента: </b>${event.name}<br>
<b>Тип ивента: </b>${event.type}<br>
<b>Дата начала ивента: </b>${event.startDate}<br>
<b>Количество посетитилей ивента: </b>${event.numberOfVisitors}<br>
<hr>
<h3>Создать новый инвент</h3>
<form action="/event/delete/${event.id}" method="post">
    <input type="submit" value="Удалить ивент"/>

</form>
</body>
</html>