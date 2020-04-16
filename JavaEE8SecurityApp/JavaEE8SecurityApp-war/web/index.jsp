<%-- 
    Document   : index
    Created on : 3 Mar, 2020, 11:35:49 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form method="post" action="j_security_check">
            UserName:
            <input type="text" name="j_username"><br>
            Password:
            <input type="password" name="j_password"><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
