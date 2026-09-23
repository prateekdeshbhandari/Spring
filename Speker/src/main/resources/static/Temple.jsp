<!DOCTYPE html>
<html>
<head>
    <title>Temple Registration</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Temple Registration</h2>

    <form action="temple" method="post">

        <label>Temple ID</label>
        <input type="number" name="templeId" class="form-control mb-3" required>

        <label>Temple Name</label>
        <input type="text" name="templeName" class="form-control mb-3" required>

        <label>City</label>
        <input type="text" name="city" class="form-control mb-3" required>

        <label>State</label>
        <input type="text" name="state" class="form-control mb-3" required>

        <button type="submit" class="btn btn-primary">
            Submit
        </button>

    </form>

</div>

</body>
</html>