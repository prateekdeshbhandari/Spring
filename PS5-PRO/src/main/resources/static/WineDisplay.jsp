<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Wine Display</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg border-0">
        <div class="card-header bg-primary text-white text-center py-3">
            <h3 class="mb-0">Wine Manufacturer Details</h3>
        </div>

        <div class="card-body p-4">


                    <div class="table-responsive">
                        <table class="table table-bordered table-hover align-middle">
                            <thead class="table-dark">
                            <tr>
                                <th>Company Name</th>
                                <th>Manufacturer Name</th>
                                <th>Manufacturing Date</th>
                                <th>Age</th>

                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="wine" items="${wineDTOList}">
                            <tr>
                                <td> ${wine.companyName}</td>
                                <td>${wine.manfName}</td>
                                <td> ${wine.manfDate}</td>
                                <td>${wine.age}</td>
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


            <div class="text-center mt-3">
                <a href="${pageContext.request.contextPath}/wine" class="btn btn-secondary">Back to Form</a>
            </div>

        </div>
    </div>
</div>

</body>
</html>