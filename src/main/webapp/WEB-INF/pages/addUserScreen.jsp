<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Add User</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/main.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/addUserScreen.css"/>">
    <style type="text/css">
        body {  background-image: url("<c:url value="/resources/pictures/bg2.jpg" />");  }
    </style>
</head>
<body>
    <h2><a href="/DevelopersTimeTracker/users/admin" ><button name="back">Back</button></a>
        Adding new user. Please enter data to all fields</h2>
    <form id="addUserForm">
        <div class="block3">
            <div class="block1">Login
                <div class="block2"><input type="text" name="userLogin" id="userLogin"></div>
            </div>
            <div class="block1">Password
                <div class="block2"><input type="password"  name="userPassword" id="userPassword"></div>
            </div>
            <div class="block1">Confirm password
                <div class="block2"><input type="password"  name="userConfirmPassword" id="userConfirmPassword"></div>
            </div>
            <div class="block1">Name
                <div class="block2"><input type="text" name="userName" id="userName"></div>
            </div>
            <div class="block1">User last name
                <div class="block2"><input type="text" name="userLastName" id="userLastName"></div>
            </div>
            <div class="block1">User position
                <div class="block2"><input type="text" name="userPosition" id="userPosition"></div>
            </div>
            <div class="block1" id="userRole">User role
                <div class="block2" ><input type="radio" name="userRole" value="ROLE_DEVELOPER"> Developer</div>
                <div class="block2" ><input type="radio" name="userRole" value="ROLE_TEAM_LEAD"> Team lead</div>
                <div class="block2" ><input type="radio" name="userRole" value="ROLE_ADMIN"> Admin</div>
            </div>
            <div class="block1"><input type="submit" onclick="check()" name ="addUser" value="add new user"/></div>
        </div>

    </form>
</body>
</html>
