<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/main.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/allUsersScreen.css"/>">
    <style type="text/css">
        body {  background-image: url("<c:url value="/resources/pictures/bg2.jpg" />");
                background-position: right;
                background-repeat: repeat-y;
                background-color: #033334;}
    </style>
</head>
<body onload="getUsers()">
<h2><a href="/DevelopersTimeTracker/users/admin" ><button name="back">Back</button></a>
    All users</h2>
        <div class="block3" id="allUsers"></div>
</body>
</html>
