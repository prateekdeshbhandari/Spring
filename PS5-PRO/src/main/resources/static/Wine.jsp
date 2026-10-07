<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Wine</title>
</head>

<body>

<h2>Wine Form</h2>



<form action="wine" method="post">

    <label>Company Name</label>
    <input type="text"
           name="companyName"
           value="${wineDTO.companyName}">
    <br><br>

    <label>Manf Name</label>
    <input type="text"
           name="manfName"
           value="${wineDTO.manfName}">
    <br><br>

    <label>Manf Date</label>
    <input type="date"
           name="manfDate"
           value="${wineDTO.manfDate}">
    <br><br>

    <label>Age</label>
    <input type="number"
           step="0.1"
           name="age"
           value="${wineDTO.age}">
    <br><br>

    <input type="submit" value="Save">

</form>

<div style="color:red">

    <c:forEach items="${validationErrors}" var="objectError">
        <p>${objectError.defaultMessage}</p>
    </c:forEach>
    <c:if test="${not empty message}">
        <p style="color:green">${message}</p>
    </c:if>

</div>

</body>
</html>