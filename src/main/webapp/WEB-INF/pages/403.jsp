<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/403.css"/>">
<style type="text/css">
    body {  background-image: url("<c:url value="/resources/pictures/bg2.jpg" />");
            background-position: right;
            background-color:  #034748;}
</style>

<h2>HTTP Status 403 - Access is denied</h2>
<c:choose>
    <c:when test="${empty userLogin}">
        <h2>You do not have permission to access this page!</h2>
    </c:when>
    <c:otherwise>
        <h2>Username : ${userLogin} <br/>
            You do not have permission to access this page!</h2>
    </c:otherwise>
</c:choose>

</body>
</html>
