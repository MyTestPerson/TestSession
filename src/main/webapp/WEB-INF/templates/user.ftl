<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
User
<br>
<br>
<br>

<form name="user" action="/user" method="post">

    <input type="text" name="username" placeholder="User Name"/><br>

    <input type="password" name="password" placeholder="User Password"/><br>

    <button type="submit" id="submit">Add User</button>

</form>

<br>
<br>
<form method="post" action="/logout">
    <button type="submit">Exit</button>
</form>

<br>
<br>

<a href="/allUser"><button type="submit" >All User</button></a>

<br>
<br>

<a href="/"><button type="submit" >Home</button></a>

</body>
</html>