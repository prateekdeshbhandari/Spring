<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>Register</h2>

<form action="${pageContext.request.contextPath}/register"
      method="post">

    <label>Name:</label>
    <input type="text" name="name" />
    <br><br>

    <label>Email:</label>
    <input type="email" name="email" />
    <br><br>

    <label>Password:</label>
    <input type="password" name="password" />
    <br><br>

    <label>Mobile Number:</label>
    <input type="text" name="mobileNumber" />
    <br><br>

    <label>Gender:</label>
    <input type="radio" name="gender" value="Male" /> Male
    <input type="radio" name="gender" value="Female" /> Female
    <br><br>

    <label>Address:</label>
    <textarea name="address"></textarea>
    <br><br>

    <button type="submit">Register</button>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <c:if test="${not empty successMessage}">
        <p style="color: green;">${successMessage}</p>
    </c:if>

</form>

</body>
</html>