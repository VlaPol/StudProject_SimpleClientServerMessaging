<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<img width="150" height="150" src="${pageContext.request.contextPath}/images/users/1675177185878.jpg" alt="User image">
<%--<audio src=""></audio>--%>
<%--<video src=""></video>--%>

<%--  enctype="multipart/form-data" added for pass immage to server      --%>
    <form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
        <label for="userName"> Name:
            <input type="text" name="name" id="userName">
        </label>
        <br><br>
        <label for="bDay"> Birthday:
            <input type="date" name="birthday" id="bDay">
        </label>
        <br><br>
        <label for="imageId"> Image:
            <input type="file" name="image" id="imageId">
        </label>
        <br>
        <label for="mail"> email:
            <input type="text" name="email" id="mail">
        </label>
        <br><br>
        <label for="pass"> password:
            <input type="password" name="password" id="pass">
        </label>
        <br><br>
        <label for="role"> Role:
            <select name="role" id="role">
                <c:forEach var="role" items="${requestScope.roles}">
                    <option value="${role}"> ${role} </option>
                </c:forEach>
            </select>
        </label>
        <br><br>
        <label>Gender:<br>
            <c:forEach var="gender" items="${requestScope.genders}">
                <input type="radio" name="gender" value="${gender}"> ${gender}
                <br>
            </c:forEach>
            <br><br>
        </label>
        <button type="submit"> Send </button>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                    <br>
                </c:forEach>
            </div>
        </c:if>
    </form>

</body>
</html>
