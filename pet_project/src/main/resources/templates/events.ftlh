<!DOCTYPE html>
<html>

<head>
    <title>All Events</title>
</head>
<body>
<h1>Hello,All Events | <a href="/login">Войти</a></h1><hr>
<h4>Ивенты в Беларуси</h4>
<form action="/" method = "get">
    Поиск по названию ивента: <input type="text" name="description"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list events as event>
    <div>
        <p><b>${event.description}</b></p>
        <p><b>${event.name}</b></p>
        <p><b>${event.type}</b></p>
        <p><b>${event.startDate}</b></p>
        <p>${event.numberOfVisitors}| <a href = "/event/${event.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Ивентов нет</h3>
</#list>
<hr>
<h3>Создать новый инвент</h3>
<form action="/event/create" method="post" enctype="multipart/form-data">
    Описание ивента: <input type="text" name="description"><br><br>
    Название ивента: <input type="text" name="name"><br><br>
    Тип ивента <input type="text" name="type"><br><br>
    Дата начала ивента: <input type="text" name="startDate"><br><br>
    Количество посетителей ивента: <input type="number" name="numberOfVisitors"><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить ивент"/>

</form>
</body>
</html>