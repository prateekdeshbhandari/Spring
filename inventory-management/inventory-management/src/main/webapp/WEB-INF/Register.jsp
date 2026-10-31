
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Inventory Management - Register</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background: #f1f5f9;
            font-family: Arial, sans-serif;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .navbar {
            background: #102a43;
        }

        .navbar-brand {
            font-size: 23px;
            font-weight: bold;
        }

        .register-section {
            flex: 1;
            padding: 45px 15px;
        }

        .register-card {
            max-width: 650px;
            margin: auto;
            background: #fff;
            border-radius: 16px;
            overflow: hidden;
            box-shadow: 0 8px 30px rgba(15, 40, 70, 0.10);
        }

        .register-header {
            background: #1769e0;
            color: white;
            padding: 28px 25px;
            text-align: center;
        }

        .register-header h2 {
            font-weight: bold;
            margin-bottom: 8px;
        }

        .register-body {
            padding: 30px;
        }

        .form-label {
            font-weight: 600;
            color: #334155;
        }

        .form-control {
            padding: 11px 12px;
            border-radius: 7px;
        }

        .form-control:focus {
            border-color: #1769e0;
            box-shadow: 0 0 0 0.2rem rgba(23, 105, 224, 0.12);
        }

        .btn-register {
            background: #1769e0;
            color: white;
            border: none;
            padding: 12px;
            font-weight: bold;
            border-radius: 7px;
        }

        .btn-register:hover {
            background: #1053b8;
            color: white;
        }

        .btn-register:disabled {
            opacity: 0.65;
            cursor: not-allowed;
        }

        .error-text {
            color: #dc3545;
            font-size: 13px;
            margin-top: 5px;
        }

        footer {
            background: #102a43;
            color: #dbe7f3;
            text-align: center;
            padding: 18px;
            margin-top: auto;
        }

        footer p {
            margin: 4px;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">

        <a class="navbar-brand"
           href="${pageContext.request.contextPath}/">
            📦 InventoryPro
        </a>

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarMenu"
                aria-controls="navbarMenu"
                aria-expanded="false"
                aria-label="Toggle navigation">

            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarMenu">

            <ul class="navbar-nav ms-auto align-items-lg-center">

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/">
                        Home
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/#about">
                        About
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/register">
                        Register
                    </a>
                </li>

                <li class="nav-item">
                    <a class="btn btn-outline-light ms-lg-3 mt-2 mt-lg-0"
                       href="${pageContext.request.contextPath}/register/login">
                        Login
                    </a>
                </li>

            </ul>
        </div>
    </div>
</nav>


<!-- REGISTRATION SECTION -->

<main class="register-section">

    <div class="register-card">

        <div class="register-header">

            <h2>Create Your Account</h2>

            <p class="mb-0">
                Register to access the Inventory Management System
            </p>

        </div>

        <div class="register-body">

            <!-- SUCCESS MESSAGE -->

            <c:if test="${not empty successMessage}">

                <div class="alert alert-success alert-dismissible fade show"
                     role="alert">

                    <c:out value="${successMessage}"/>

                    <button type="button"
                            class="btn-close"
                            data-bs-dismiss="alert"
                            aria-label="Close">
                    </button>

                </div>

            </c:if>


            <!-- BACKEND ERROR -->

            <c:if test="${not empty errorMessage}">

                <div class="alert alert-danger" role="alert">
                    <c:out value="${errorMessage}"/>
                </div>

            </c:if>


            <!-- VALIDATION ERRORS -->

            <c:if test="${not empty validationErrors}">

                <div class="alert alert-danger" role="alert">

                    <strong>Please correct the following errors:</strong>

                    <ul class="mb-0 mt-2">

                        <c:forEach items="${validationErrors}" var="error">

                            <li>
                                <c:out value="${error.defaultMessage}"/>
                            </li>

                        </c:forEach>

                    </ul>

                </div>

            </c:if>


            <!-- REGISTRATION FORM -->

            <form id="registerForm"
                  action="${pageContext.request.contextPath}/register"
                  method="post"
                  onsubmit="return validateForm(event)">

                <!-- NAME -->

                <div class="mb-3">

                    <label for="name" class="form-label">
                        Full Name
                    </label>

                    <input type="text"
                           class="form-control"
                           id="name"
                           name="name"
                           value="<c:out value='${registerDTO.name}'/>"
                           placeholder="Enter your full name">

                    <div id="nameError" class="error-text"></div>

                </div>


                <!-- EMAIL -->

                <div class="mb-3">

                    <label for="email" class="form-label">
                        Email Address
                    </label>

                    <input type="email"
                           class="form-control"
                           id="email"
                           name="email"
                           value="<c:out value='${registerDTO.email}'/>"
                           placeholder="example@email.com">

                    <div id="EmailError" class="error-text"></div>

                </div>


                <!-- PASSWORD -->

                <div class="mb-3">

                    <label for="password" class="form-label">
                        Password
                    </label>

                    <input type="password"
                           class="form-control"
                           id="password"
                           name="password"
                           placeholder="Minimum 8 characters">

                    <div id="passwordError" class="error-text"></div>

                </div>


                <!-- PHONE NUMBER -->

                <div class="mb-3">

                    <label for="phoneNumber" class="form-label">
                        Phone Number
                    </label>

                    <input type="tel"
                           class="form-control"
                           id="phoneNumber"
                           name="mobileNumber"
                           value="<c:out value='${registerDTO.mobileNumber}'/>"
                           placeholder="Enter 10-digit phone number"
                           maxlength="10">

                    <div id="PhoneError" class="error-text"></div>

                </div>


                <!-- GENDER -->

                <div class="mb-3">

                    <label class="form-label d-block">
                        Gender
                    </label>

                    <div class="form-check form-check-inline">

                        <input type="radio"
                               class="form-check-input"
                               id="male"
                               name="gender"
                               value="Male">

                        <label class="form-check-label" for="male">
                            Male
                        </label>

                    </div>

                    <div class="form-check form-check-inline">

                        <input type="radio"
                               class="form-check-input"
                               id="female"
                               name="gender"
                               value="Female">

                        <label class="form-check-label" for="female">
                            Female
                        </label>

                    </div>

                    <div id="genderError" class="error-text"></div>

                </div>


                <!-- ADDRESS -->

                <div class="mb-4">

                    <label for="address" class="form-label">
                        Address
                    </label>

                    <textarea class="form-control"
                              id="address"
                              name="address"
                              rows="3"
                              placeholder="Enter your full address"><c:out value="${registerDTO.address}"/></textarea>

                    <div id="addressError" class="error-text"></div>

                </div>


                <!-- SUBMIT -->

                <button type="submit"
                        id="registerButton"
                        class="btn btn-register w-100">

                    Create Account

                </button>


                <p class="text-center mt-3 mb-0">

                    Already have an account?

                    <a href="${pageContext.request.contextPath}/register/login"
                       class="text-primary text-decoration-none fw-semibold">

                        Login here

                    </a>

                </p>

            </form>

        </div>

    </div>

</main>


<!-- FOOTER -->

<footer>

    <p>
        <strong>InventoryPro</strong> |
        Inventory Management System
    </p>

    <p>
        &copy; 2026 Inventory Management System. All rights reserved.
    </p>

</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>


<script>

    // ======================================
    // EMAIL DUPLICATE VALIDATION
    // ======================================

    async function checkEmailExit() {

        const emailId = document.getElementById("email").value.trim();
        const errorDiv = document.getElementById("EmailError");

        errorDiv.innerText = "";

        if (emailId === "") {
            errorDiv.innerText = "Email cannot be empty";
            errorDiv.style.color = "red";
            return false;
        }

        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(emailId)) {
            errorDiv.innerText = "Enter a valid email address";
            errorDiv.style.color = "red";
            return false;
        }

        try {

            const response = await fetch(
                "${pageContext.request.contextPath}/api/inventory/checkEmailExit/"
                + encodeURIComponent(emailId)
            );

            if (!response.ok) {
                throw new Error("Email checking failed: " + response.status);
            }

            const result = (await response.text()).trim().toLowerCase();

            if (result === "true") {

                errorDiv.innerText = "Email is available";
                errorDiv.style.color = "green";

                return true;

            } else if (result === "false") {

                errorDiv.innerText = "Email already registered";
                errorDiv.style.color = "red";

                return false;

            } else {

                throw new Error("Invalid server response: " + result);
            }

        } catch (error) {

            console.error("Email check error:", error);

            errorDiv.innerText = "Unable to verify email. Please try again.";
            errorDiv.style.color = "red";

            return false;
        }
    }


    // ======================================
    // PHONE NUMBER DUPLICATE VALIDATION
    // ======================================

    async function checkPhoneNumber() {

        const phoneNumber =
            document.getElementById("phoneNumber").value.trim();

        const errorDiv = document.getElementById("PhoneError");

        errorDiv.innerText = "";

        if (phoneNumber === "") {

            errorDiv.innerText = "Phone number cannot be empty";
            errorDiv.style.color = "red";

            return false;
        }

        if (!/^[6-9][0-9]{9}$/.test(phoneNumber)) {

            errorDiv.innerText = "Enter a valid 10-digit phone number";
            errorDiv.style.color = "red";

            return false;
        }

        try {

            const response = await fetch(
                "${pageContext.request.contextPath}/api/inventory/checkPhoneNumber/"
                + encodeURIComponent(phoneNumber)
            );

            if (!response.ok) {
                throw new Error("Phone checking failed: " + response.status);
            }

            const result = (await response.text()).trim().toLowerCase();

            if (result === "true") {

                errorDiv.innerText = "Phone number is available";
                errorDiv.style.color = "green";

                return true;

            } else if (result === "false") {

                errorDiv.innerText = "Phone number already registered";
                errorDiv.style.color = "red";

                return false;

            } else {

                throw new Error("Invalid server response: " + result);
            }

        } catch (error) {

            console.error("Phone check error:", error);

            errorDiv.innerText =
                "Unable to verify phone number. Please try again.";

            errorDiv.style.color = "red";

            return false;
        }
    }


    // ======================================
    // FORM VALIDATION
    // ======================================

    let registrationSubmitting = false;

    async function validateForm(event) {

        event.preventDefault();

        if (registrationSubmitting) {
            return false;
        }

        let isValid = true;

        const name = document.getElementById("name").value.trim();
        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value;

        const phoneNumber =
            document.getElementById("phoneNumber").value.trim();

        const address =
            document.getElementById("address").value.trim();

        const gender =
            document.querySelector('input[name="gender"]:checked');


        // CLEAR PREVIOUS ERRORS

        document.getElementById("nameError").innerText = "";
        document.getElementById("EmailError").innerText = "";
        document.getElementById("passwordError").innerText = "";
        document.getElementById("PhoneError").innerText = "";
        document.getElementById("genderError").innerText = "";
        document.getElementById("addressError").innerText = "";


        // NAME VALIDATION

        if (name === "") {

            document.getElementById("nameError").innerText =
                "Name cannot be empty";

            isValid = false;

        } else if (name.length < 3 || name.length > 50) {

            document.getElementById("nameError").innerText =
                "Name must contain 3 to 50 characters";

            isValid = false;
        }


        // EMAIL VALIDATION

        if (email === "") {

            document.getElementById("EmailError").innerText =
                "Email cannot be empty";

            isValid = false;

        } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {

            document.getElementById("EmailError").innerText =
                "Enter a valid email address";

            isValid = false;
        }


        // PASSWORD VALIDATION

        if (password === "") {

            document.getElementById("passwordError").innerText =
                "Password cannot be empty";

            isValid = false;

        } else if (password.length < 8) {

            document.getElementById("passwordError").innerText =
                "Password must contain at least 8 characters";

            isValid = false;
        }


        // PHONE VALIDATION

        if (phoneNumber === "") {

            document.getElementById("PhoneError").innerText =
                "Phone number cannot be empty";

            isValid = false;

        } else if (!/^[6-9][0-9]{9}$/.test(phoneNumber)) {

            document.getElementById("PhoneError").innerText =
                "Enter a valid 10-digit phone number";

            isValid = false;
        }


        // GENDER VALIDATION

        if (gender === null) {

            document.getElementById("genderError").innerText =
                "Please select your gender";

            isValid = false;
        }


        // ADDRESS VALIDATION

        if (address.length < 5) {

            document.getElementById("addressError").innerText =
                "Address must contain at least 5 characters";

            isValid = false;
        }


        if (!isValid) {
            return false;
        }


        // CHECK EMAIL AND PHONE AVAILABILITY

        const [emailAvailable, phoneAvailable] = await Promise.all([
            checkEmailExit(),
            checkPhoneNumber()
        ]);


        if (!emailAvailable || !phoneAvailable) {
            return false;
        }


        // SUBMIT FORM

        const registerButton =
            document.getElementById("registerButton");

        registrationSubmitting = true;

        registerButton.disabled = true;
        registerButton.innerText = "Registering...";

        document.getElementById("registerForm").submit();

        return false;
    }

</script>

</body>
</html>
