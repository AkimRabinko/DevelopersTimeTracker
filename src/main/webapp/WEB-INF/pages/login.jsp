<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page session="true"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Developers Time Tracker</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/main.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
    <style type="text/css">
        body {  background-image: url("<c:url value="/resources/pictures/bg2.jpg" />");
                background-position: right;
                background-color:  #034748;}
    </style>
</head>
<body>

<h2> Welcome to Developers time tracker , please sign in</h2>
<form name="loginForm" action="<c:url value="/users"/>" method="POST">
    <div class="block3">
        <div class="block1">Login
            <div class="block2"><input type="text" name="USER_LOGIN" id="USER_LOGIN"></div>
        </div>
        <div class="block1">Password
            <div class="block2"><input type="password" name="USER_PASSWORD" id="USER_PASSWORD"></div>
        </div>
        <div class="block1"><input type="submit"  name ="Sign in" value="Sign in"/></div>
    </div>
</form>

<h2><c:if test="${param.error == 'true'}">
    <div  style="color:red;margin-left: 400px">
        Login Failed!!!<br />
        Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if></h2>

</body>
</html>