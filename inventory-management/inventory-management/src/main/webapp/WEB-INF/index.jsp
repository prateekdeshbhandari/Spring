<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory Management System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap"
          rel="stylesheet">

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: 'Poppins', Arial, sans-serif;
            background: #f4f7fb;
            color: #1e293b;
        }

        /* Navbar */
        .navbar {
            background: linear-gradient(110deg, #0f172a, #173b63);
            padding: 18px 0;
            box-shadow: 0 4px 18px rgba(15, 23, 42, 0.12);
        }

        .navbar-brand {
            color: white !important;
            font-size: 25px;
            font-weight: 800;
            letter-spacing: -0.7px;
        }

        .nav-link {
            color: #e2e8f0 !important;
            margin: 0 10px;
            font-size: 14px;
            font-weight: 500;
            transition: 0.3s;
        }

        .nav-link:hover {
            color: #60a5fa !important;
        }

        .navbar .btn-primary {
            background: #3b82f6;
            border: none;
            border-radius: 8px;
            padding: 10px 23px;
            font-weight: 600;
            transition: 0.3s;
        }

        .navbar .btn-primary:hover {
            background: #2563eb;
            transform: translateY(-2px);
        }

        /* Hero section */
        .hero {
            position: relative;
            overflow: hidden;
            background:
                radial-gradient(circle at 85% 30%,
                rgba(96, 165, 250, 0.20), transparent 28%),
                linear-gradient(135deg, #ffffff 0%, #edf5ff 100%);
        }

        .hero-content {
            padding-top: 105px;
            padding-bottom: 110px;
            max-width: 780px;
        }

        .hero .badge {
            background: #dbeafe !important;
            color: #1d4ed8 !important;
            padding: 10px 17px !important;
            border-radius: 50px;
            font-size: 11px;
            font-weight: 700;
            letter-spacing: 1.4px;
        }

        .hero h1 {
            font-size: clamp(38px, 5.5vw, 65px);
            font-weight: 800;
            color: #102a43;
            line-height: 1.2;
            letter-spacing: -2px;
            margin-top: 15px;
        }

        .hero h1 br {
            display: block;
        }

        .hero p {
            font-size: 16px;
            line-height: 1.9;
            color: #64748b;
            max-width: 590px;
            margin-top: 24px;
            margin-bottom: 28px;
        }

        /* Buttons */
        .btn-primary-custom {
            background: linear-gradient(135deg, #2563eb, #1d4ed8);
            color: white;
            padding: 14px 27px;
            border-radius: 9px;
            text-decoration: none;
            display: inline-block;
            margin: 8px 10px 0 0;
            font-size: 14px;
            font-weight: 600;
            box-shadow: 0 8px 20px rgba(37, 99, 235, 0.20);
            transition: all 0.3s ease;
        }

        .btn-primary-custom:hover {
            background: #1e40af;
            color: white;
            transform: translateY(-3px);
            box-shadow: 0 12px 25px rgba(37, 99, 235, 0.25);
        }

        .btn-outline-custom {
            border: 1px solid #cbd5e1;
            background: white;
            color: #1e40af;
            padding: 13px 27px;
            border-radius: 9px;
            text-decoration: none;
            display: inline-block;
            margin-top: 8px;
            font-size: 14px;
            font-weight: 600;
            transition: all 0.3s ease;
        }

        .btn-outline-custom:hover {
            background: #eff6ff;
            border-color: #3b82f6;
            color: #1d4ed8;
            transform: translateY(-3px);
        }

        /* Features */
        .features {
            padding: 65px 0;
        }

        .feature-card {
            background: white;
            border-radius: 16px;
            padding: 30px 24px;
            height: 100%;
            box-shadow: 0 8px 30px rgba(15, 40, 70, 0.05);
            border: 1px solid #e5edf5;
            transition: all 0.3s ease;
        }

        .feature-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 15px 35px rgba(15, 40, 70, 0.10);
        }

        .feature-icon {
            font-size: 38px;
            margin-bottom: 18px;
        }

        .feature-card h5 {
            color: #102a43;
            font-weight: 700;
            margin-bottom: 12px;
        }

        .feature-card p {
            color: #64748b;
            line-height: 1.8;
            margin-bottom: 0;
            font-size: 14px;
        }

        /* Footer */
        footer {
            background: linear-gradient(110deg, #0f172a, #173b63);
            color: #cbd5e1;
            text-align: center;
            padding: 30px 12px;
        }

        footer strong {
            color: #ffffff;
            font-size: 16px;
        }

        footer p {
            margin: 6px 0;
            font-size: 13px;
        }

        /* Responsive UI */
        @media (max-width: 767px) {
            .navbar {
                padding: 14px 0;
            }

            .navbar-brand {
                font-size: 21px;
            }

            .hero-content {
                padding-top: 70px;
                padding-bottom: 75px;
            }

            .hero h1 {
                letter-spacing: -1px;
            }

            .hero p {
                font-size: 14px;
            }

            .btn-primary-custom,
            .btn-outline-custom {
                padding: 12px 18px;
            }
        }
    </style>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">

        <a class="navbar-brand"
           href="${pageContext.request.contextPath}/">
            📦 InventoryPro
        </a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarMenu">
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
                    <a class="btn btn-primary"
                       href="${pageContext.request.contextPath}/register/login">
                        Login
                    </a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<!-- Header / Hero Section -->
<header class="hero" id="about">
    <div class="container">
        <div class="hero-content">

            <span class="badge text-bg-primary mb-3 p-2">
                SMART STOCK MANAGEMENT
            </span>

            <h1>
                Inventory Management<br>
                Made Simple
            </h1>

            <p>
                Manage your products, monitor stock levels and organize
                your inventory efficiently — all in one place.
                A smarter way to keep your business running smoothly.
            </p>

            <a href="Register.jsp" class="btn-primary-custom">
                Get Started →
            </a>

            <a href="Login.jsp" class="btn-outline-custom">
                Login to Account
            </a>

        </div>
    </div>
</header>

<!-- Footer -->
<footer>
    <p><strong>InventoryPro — Inventory Management System</strong></p>
    <p>Manage your inventory. Simplify your business.</p>
    <p>&copy; 2026 Inventory Management System. All rights reserved.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>