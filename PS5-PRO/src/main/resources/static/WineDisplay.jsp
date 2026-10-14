<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Wine Details</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #fdf2f4, #f3e5f5);
            min-height: 100vh;
        }

        .wine-container {
            margin-top: 50px;
        }

        .wine-heading {
            color: #722f37;
            font-weight: bold;
        }

        .table thead th {
            background-color: #722f37;
            color: white;
            text-align: center;
            vertical-align: middle;
        }

        .table tbody td {
            text-align: center;
            vertical-align: middle;
        }

        .card {
            border: none;
            border-radius: 15px;
            overflow: hidden;
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

<div class="container-fluid wine-container px-4">
    <div class="card shadow-lg">
        <div class="card-body p-4">

            <h2 class="text-center wine-heading mb-4">
                Wine Details
            </h2>

            <div class="table-responsive">
                <table class="table table-bordered table-striped table-hover align-middle">

                    <thead>
                    <tr>
                        <th>Company Name</th>
                        <th>Manufacturer Name</th>
                        <th>Manufacture Date</th>
                        <th>Age</th>
                        <th>Action</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${wineDTOList}" var="wineDTO">
                        <tr>
                            <td>${wineDTO.companyName}</td>
                            <td>${wineDTO.manfName}</td>
                            <td>${wineDTO.manfDate}</td>
                            <td>${wineDTO.age}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/wine/edit?id=${wineDTO.id}"
                                   class="btn btn-sm btn-primary me-2">
                                    Edit
                                </a>
                                <a href="${pageContext.request.contextPath}/wine/delete?id=${wineDTO.id}"
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('Are you sure you want to delete this record?')">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty wineDTOList}">
                        <tr>
                            <td colspan="5" class="text-center text-muted py-4">
                                No wine records found.
                            </td>
                        </tr>
                    </c:if>
                    </tbody>

                </table>
            </div>

            <div class="text-center mt-4">
                <a href="${pageContext.request.contextPath}/Wine.jsp"
                   class="btn btn-wine px-4">
                    Back to Wine Form
                </a>
            </div>

        </div>
    </div>
</div>

</body>
</html>
