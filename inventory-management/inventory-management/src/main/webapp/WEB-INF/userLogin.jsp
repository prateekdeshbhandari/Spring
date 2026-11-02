
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>User Login - Email OTP</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css"
          rel="stylesheet">

    <style>
        body {
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #667eea, #764ba2);
            font-family: 'Segoe UI', sans-serif;
        }

        .login-card {
            width: 100%;
            max-width: 430px;
            padding: 40px 35px;
            border-radius: 20px;
            background: #ffffff;
            box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        }

        .login-icon {
            width: 75px;
            height: 75px;
            background: #eef0ff;
            color: #667eea;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 32px;
            margin: 0 auto 20px;
        }

        .login-title {
            font-weight: 700;
            color: #292d3e;
        }

        .form-control {
            height: 50px;
            border-radius: 10px;
            padding-left: 15px;
        }

        .form-control:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102,126,234,0.15);
        }

        .otp-btn {
            height: 50px;
            border-radius: 10px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            font-weight: 600;
            border: none;
            transition: 0.3s;
        }

        .otp-btn:hover {
            color: white;
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(102,126,234,0.3);
        }

        .login-footer {
            color: #888;
            font-size: 13px;
        }
    </style>
</head>

<body>

<div class="login-card">

    <div class="login-icon">
        <i class="bi bi-envelope-at"></i>
    </div>
    <h1>userLogin</h1>


    <div class="text-center mb-4">
        <h3 class="login-title">Welcome Back!</h3>
        <p class="text-secondary">
            Login using your registered email address
        </p>
    </div>

    <form action="userLogin" method="post">

        <div class="mb-4">
            <label class="form-label fw-semibold">Email Address</label>

            <input type="email"
                   name="email"
                   class="form-control"
                   placeholder="Enter your email address"
                   required>
        </div>

        <button type="submit" class="btn otp-btn w-100">

            <i class="bi bi-send me-2"></i>
            Get OTP
        </button>
        <a href="${pageContext.request.contextPath}/index.jsp">home</a>


    </form>

    <div class="text-center mt-4 login-footer">
        <i class="bi bi-shield-lock me-1"></i>
        Your account is protected with email verification.
    </div>


</div>

</body>
</html>
