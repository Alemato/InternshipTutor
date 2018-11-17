<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Send Mail</title>
</head>
<body>
<h1>INVIA MANUAL MENTE UNA EMAIL DI PROVA</h1>
<form action="/SendMail" method="get">
    To:<input type="text" name="to"/><br/>
    Subject:<input type="text" name="subject"><br/>
    Text:<textarea rows="10" cols="70" name="msg"></textarea><br/>
    <input type="submit" value="send"/>
</form>
</body>
</html>