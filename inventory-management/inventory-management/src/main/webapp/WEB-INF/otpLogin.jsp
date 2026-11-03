
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>OTP Verification</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css"
          rel="stylesheet">

    <style>
        body {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: linear-gradient(135deg, #667eea, #764ba2);
            font-family: 'Segoe UI', sans-serif;
        }

        .otp-card {
            width: 100%;
            max-width: 430px;
            background: white;
            padding: 40px 35px;
            border-radius: 20px;
            box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        }

        .otp-icon {
            width: 75px;
            height: 75px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 20px;
            border-radius: 50%;
            background: #eef0ff;
            color: #667eea;
            font-size: 32px;
        }

        .otp-input {
            height: 55px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            letter-spacing: 12px;
            border-radius: 10px;
        }

        .otp-input:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102,126,234,.15);
        }

        .verify-btn {
            height: 50px;
            border: none;
            border-radius: 10px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            font-weight: 600;
        }

        .verify-btn:hover {
            color: white;
            opacity: .9;
        }

        .resend-link {
            color: #667eea;
            text-decoration: none;
            font-weight: 600;
        }
    </style>
</head>

<body>

<div class="otp-card">

    <div class="otp-icon">
        <i class="bi bi-shield-lock"></i>
    </div>

    <div class="text-center mb-4">
        <h3 class="fw-bold">Verify OTP</h3>
        <p class="text-secondary">
            Enter the 6-digit OTP sent to your email address.
        </p>
    </div>

    <form action="verifyOtp" method="post">

        <div class="mb-4">
            <label class="form-label fw-semibold">Enter OTP</label>

            <input type="text"
                   name="otp"
                   class="form-control otp-input"
                   placeholder="------"
                   maxlength="6"
                   pattern="[0-9]{6}"
                   inputmode="numeric"
                   autocomplete="one-time-code"
                   required>
        </div>

        <button type="submit" class="btn verify-btn w-100">
            <i class="bi bi-check-circle me-2"></i>
            Verify OTP
        </button>

    </form>

    <div class="text-center mt-4">
        <p class="text-secondary mb-1">Didn't receive the OTP?</p>

        <form action="resendOtp" method="post">
            <input type="hidden"
                   name="email"
                   value="<%= request.getAttribute("email") != null
            ? request.getAttribute("email") : "" %>">

            <button type="submit" class="btn btn-link resend-link">
                Resend OTP
            </button>
        </form>
    </div>

    <div class="text-center mt-3 text-secondary small">
        <i class="bi bi-shield-check me-1"></i>
        Secure Email Verification
    </div>

</div>

</body>
</html>
