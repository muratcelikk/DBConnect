<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Hello world!
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="" method="post">
    <input type="submit" value="Kaydet" />
</form>


<form action="delete" method="post">
    <input type="submit" value="Sil" />
</form>

<hr/>
<c:if test="${not empty data }">
    <c:forEach items="${data }" var="item">
        <div>${item.uid} - ${item.uname }</div>
    </c:forEach>
</c:if>


</body>
</html>
