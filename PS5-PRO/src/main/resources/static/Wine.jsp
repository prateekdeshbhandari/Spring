```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Add Wine</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #fdf2f4, #f3e5f5);
            min-height: 100vh;
        }

        .wine-card {
            max-width: 650px;
            margin: 50px auto;
            border: none;
            border-radius: 15px;
        }

        h2 {
            color: #722f37;
            font-weight: bold;
        }

        .btn-wine {
            background-color: #722f37;
            color: white;
        }

        .btn-wine:hover {
            background-color: #57232a;
            color: white;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="card shadow-lg wine-card">
        <div class="card-body p-4">


                <h2 class="text-center mb-4">
                    <c:choose>
                        <c:when test="${not empty wineDTO.id}">
                            Update Wine
                        </c:when>
                        <c:otherwise>
                            Wine Form
                        </c:otherwise>
                    </c:choose>
                </h2>

            <h2 class="text-center mb-4">Add Wine</h2>


            <c:if test="${not empty message}">
                <div class="alert alert-success">${message}</div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>

            <a href="${pageContext.request.contextPath}/wine/showAll"
               class="btn btn-outline-secondary mb-3">
                Show All
            </a>

            <c:choose>
                <c:when test="${not empty wineDTO.id}">
                    <form action="${pageContext.request.contextPath}/wine/edit"
                          method="post">
                </c:when>
                <c:otherwise>
                    <form action="${pageContext.request.contextPath}/wine"
                          method="post">
                </c:otherwise>
            </c:choose>

                <div class="mb-3">
                    <label class="form-label">Company Name</label>
                    <input type="text"
                           name="companyName"
                           class="form-control"
                           placeholder="Enter company name"
                           value="${wineDTO.companyName}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Manufacturer Name</label>
                    <input type="text"
                           name="manfName"
                           class="form-control"
                           placeholder="Enter manufacturer name"
                           value="${wineDTO.manfName}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Manufacturing Date</label>
                    <input type="date"
                           name="manfDate"
                           class="form-control"
                           value="${wineDTO.manfDate}"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Age</label>
                    <input type="number"
                           step="0.1"
                           name="age"
                           class="form-control"
                           placeholder="Enter age"
                           value="${wineDTO.age}"
                           required>
                </div>
            <div class="text-center">
                <button type="submit" class="btn btn-wine px-4">
                    <c:choose>
                        <c:when test="${not empty wineDTO.id}">
                            Update Wine
                        </c:when>
                        <c:otherwise>
                            Save Wine
                        </c:otherwise>
                    </c:choose>
                </button>
            </div>

            </form>

            <div class="text-danger mt-3">
                <c:forEach items="${validationErrors}" var="objectError">
                    <p>${objectError.defaultMessage}</p>
                </c:forEach>
            </div>

        </div>
    </div>
</div>

</body>
</html>
