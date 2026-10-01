<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Telephone Operator Registration</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3 class="mb-0">Telephone Operator Registration</h3>
                </div>

                <div class="card-body">

                    <form action="operator" method="post">

                        <!-- Operator ID -->
                        <div class="mb-3">
                            <label class="form-label">Operator ID</label>
                            <input type="number"
                                   name="operatorId"
                                   class="form-control"
                                   value="${dto.operatorId}"
                                   placeholder="Enter Operator ID"
                                   required>
                        </div>

                        <!-- Operator Name -->
                        <div class="mb-3">
                            <label class="form-label">Operator Name</label>
                            <input type="text"
                                   name="operatorName"
                                   class="form-control"
                                   value="${dto.operatorName}"
                                   placeholder="Enter Operator Name"
                                   required>
                        </div>

                        <!-- Company -->
                        <div class="mb-3">
                            <label class="form-label">Company</label>
                            <input type="text"
                                   name="company"
                                   class="form-control"
                                   value="${dto.company}"
                                   placeholder="Enter Company Name"
                                   required>
                        </div>

                        <!-- Mobile -->
                        <div class="mb-3">
                            <label class="form-label">Mobile</label>
                            <input type="tel"
                                   name="mobile"
                                   class="form-control"
                                   value="${dto.mobile}"
                                   placeholder="Enter Mobile Number"
                                   required>
                        </div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <input type="submit"
                                   value="Submit"
                                   class="btn btn-primary">
                        </div>

                    </form>

                    <!-- Success Message -->
                    <div class="text-success text-center mt-3">
                        ${sucssess}
                        ${errors}
                        <c:forEach items="${errors}" var="error">
                            <div class="alert alert-danger">${error.defaultMessage}</div>
                        </c:forEach>
                    </div>

                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>