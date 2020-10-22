<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
Active
<#list user as user>
    <b>${user.username}</b>
</#list>

<br>
<br>

<a href="/"><button type="submit" >Home</button></a>

<br>
<br>

<form method="post" action="/logout">
    <button type="submit">Exit</button>
</form>


</body>
</html>