<%@ taglib prefix=" c\ uri=\http://java.sun.com/jsp/jstl/core\ %>
<%@ taglib prefix=\form\ uri=\http://www.springframework.org/tags/form\ %>
<%@ page isELIgnored=\false\ %>

<!DOCTYPE html>
<html lang=\en\>
<head>
 <meta charset=\UTF-8\>
 <meta name=\viewport\ content=\width=device-width initial-scale=1\>

 <title>Register | My Application</title>

 <!-- Bootstrap CSS -->
 <link href=\https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\
 rel=\stylesheet\>

 <style>
 body {
 background-color: #f4f7fb;
 min-height: 100vh;
 display: flex;
 flex-direction: column;
 }

 .navbar {
 background: linear-gradient(90deg, #0d6efd, #084298);
 }

 .register-section {
 flex: 1;
 padding: 50px 15px;
 }

 .register-card {
 max-width: 650px;
 margin: auto;
 border: none;
 border-radius: 16px;
 overflow: hidden;
 box-shadow: 0 8px 25px rgba(0, 0, 0, 0.10);
 }

 .register-heading {
 background: linear-gradient(90deg, #0d6efd, #084298);
 color: white;
 padding: 25px;
 text-align: center;
 }

 .register-heading h2 {
 margin-bottom: 8px;
 font-weight: 700;
 }

 .register-body {
 padding: 30px;
 }

 .form-label {
 font-weight: 600;
 }

 .form-control {
 padding: 11px;
 border-radius: 8px;
 }

 .btn-register {
 width: 100%;
 padding: 12px;
 border-radius: 8px;
 font-weight: 600;
 }

 footer {
 background-color: #172337;
 color: white;
 text-align: center;
 padding: 18px 10px;
 margin-top: auto;
 }

 footer p {
 margin: 0;
 }
 </style>
</head>

<body>

<!-- Header -->
<nav class=\navbar navbar-expand-lg navbar-dark\>
 <div class=\container\>
 <a class=\navbar-brand fw-bold\ href=\#\>
 My Application
 </a>

 <button class=\navbar-toggler\ type=\button\
 data-bs-toggle=\collapse\
 data-bs-target=\#navbarMenu\
 aria-controls=\navbarMenu\
 aria-expanded=\false\
 aria-label=\Toggle navigation\>

 <span class=\navbar-toggler-icon\></span>
 </button>

 <div class=\collapse navbar-collapse\ id=\navbarMenu\>
 <ul class=\navbar-nav ms-auto\>
 <li class=\nav-item\>
 <a class=\nav-link\ href=\/\>
 Home
 </a>
 </li>

 <li class=\nav-item\>
 <a class=\nav-link active\
 href=\/register\>
 Register
 </a>
 </li>

 <li class=\nav-item\>
 <a class=\nav-link\
 href=\/login\>
 Login
 </a>
 </li>
 </ul>
 </div>
 </div>
</nav>

<!-- Registration Form -->
<main class=\register-section\>
 <div class=\container\>

 <div class=\card register-card\>

 <div class=\register-heading\>
 <h2>Create an Account</h2>
 <p class=\mb-0\>Register to get started</p>
 </div>

 <div class=\register-body\>

 <c:if test=\\>
 <div class=\alert alert-danger\ role=\alert\>
 
 </div>
 </c:if>

 <c:if test=\\>
 <div class=\alert alert-success\ role=\alert\>
 
 </div>
 </c:if>

 <form:form action=\/register\
 method=\post\ modelAttribute=\registerDTO\>

 <div class=\mb-3\>
 <label for=\name\ class=\form-label\>Full Name</label>
 <form:input type=\text\ class=\form-control\
 id=\name\ path=\name\
 placeholder=\Enter your full name\
 autocomplete=\name\ required=\true\/>
 </div>

 <div class=\mb-3\>
 <label for=\email\ class=\form-label\>Email Address</label>
 <form:input type=\email\ class=\form-control\
 id=\email\ path=\email\
 placeholder=\Enter your email\
 autocomplete=\email\ required=\true\/>
 </div>

 <div class=\mb-3\>
 <label for=\password\ class=\form-label\>Password</label>
 <form:password class=\form-control\
 id=\password\ path=\password\
 placeholder=\Create a password\
 autocomplete=\new-password\ required=\true\/>
 </div>

 <div class=\mb-3\>
 <label for=\mobileNumber\ class=\form-label\>
 Mobile Number
 </label>
 <form:input type=\tel\ class=\form-control\
 id=\mobileNumber\ path=\mobileNumber\
 placeholder=\Enter your mobile number\
 autocomplete=\tel\ required=\true\/>
 </div>

 <div class=\mb-3\>
 <label class=\form-label d-block\>Gender</label>

 <div class=\form-check form-check-inline\>
 <form:radiobutton class=\form-check-input\ path=\gender\
 id=\male\ value=\Male\/>
 <label class=\form-check-label\ for=\male\>
 Male
 </label>
 </div>

 <div class=\form-check form-check-inline\>
 <form:radiobutton class=\form-check-input\ path=\gender\
 id=\female\ value=\Female\/>
 <label class=\form-check-label\ for=\female\>
 Female
 </label>
 </div>
 </div>

 <div class=\mb-4\>
 <label for=\address\ class=\form-label\>Address</label>
 <form:textarea class=\form-control\
 id=\address\ path=\address\
 rows=\3\
 placeholder=\Enter your address\
 autocomplete=\street-address\
 required=\true\/>
 </div>

 <button type=\submit\ class=\btn btn-primary btn-register\>
 Register
 </button>

 <p class=\text-center mt-3 mb-0\>
 Already have an account?
 <a href=\/login\
 class=\text-decoration-none fw-semibold\>
 Login here
 </a>
 </p>

 </form:form>
 </div>
 </div>
 </div>
</main>

<!-- Footer -->
<footer>
 <div class=\container\>
 <p>&copy; 2026 My Application. All rights reserved.</p>
 <small class=\text-white-50\>
 Designed with Bootstrap 5
 </small>
 </div>
</footer>

<!-- Bootstrap JavaScript -->
<script src=\https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\></script>

</body>
</html>
