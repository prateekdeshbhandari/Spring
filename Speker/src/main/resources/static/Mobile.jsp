
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Mobile Registration</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body style="background-image: url('${pageContext.request.contextPath}/images/mobile.jpeg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;">


<div class="container mt-5">

    <div class="card shadow mx-auto" style="max-width: 500px;">

        <div class="card-header text-center">
            <h2>Mobile Registration</h2>
        </div>

        <div class="card-body">

            <form action="mobile" method="post">

                <div class="mb-3">
                    <label class="form-label">Mobile ID</label>
                    <input type="number" name="mobileId"
                           value="${dto.mobileId}"
                           class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Mobile Name</label>
                    <input type="text" name="mobileName"
                           value="${dto.mobileName}"
                           class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="mobileBrand">Mobile Brand:</label>

                    <select id="mobileBrand" name="mobileBrand" class="form-select" required>
                        <option value="">-- Select Mobile Brand --</option>

                        <c:forEach items="${mobileBrand}" var="brand">
                            <option value="${brand}"
                                    ${brand == dto.mobileBrand ? 'selected' : ''}>${brand}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">Price</label>
                    <input type="number" name="price"
                           step="0.01"
                           value="${dto.price}"
                           class="form-control" required>
                </div>

                <div class="text-center">
                    <input type="submit"
                           value="Submit"
                           class="btn btn-primary px-4">
                </div>

            </form>

        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>
${sucssess}
${errors}
${error}
<c:forEach items="${errors}" var="error">
    <div class="alert alert-danger">${error.defaultMessage}</div>
</c:forEach>


</body>
</html>