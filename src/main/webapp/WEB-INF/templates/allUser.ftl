<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All User</title>
</head>
<body>

<#list user as user>
${user.username}
</#list>


<br>
<br>
<a href="/user"><b>USER</b></a><br>
<br>
<br>


<a href="/"><button type="submit" >Home</button></a>

</body>
</html>