<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <div>
        <span>Content. Русский</span>
        <p>Size: ${requestScope.flights.size()}</p>
        <p>Id: ${requestScope.flights[1].id}</p>
        <p>Map Id: ${requestScope.flightsMap[1]}</p>
        <p>JSESSIONID: ${cookie["JSESSIONID"].value}, unique identifier</p>
        <p>Header: ${header["Cookie"]}</p>
        <p>Param id: ${param.id}</p>
        <p>Param test: ${param.test}</p>
        <p>Empty list: ${not empty requestScope.flights}</p>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
