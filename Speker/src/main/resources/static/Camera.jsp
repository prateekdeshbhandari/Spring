<!DOCTYPE html>
<html>
<head>
    <title>Camera Registration</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<div class="container mt-5">

    <div class="card shadow mx-auto" style="max-width: 500px;">

        <div class="card-header text-center">
            <h2>Camera Registration</h2>
        </div>

        <div class="card-body">

            <form action="camera" method="post">

                <div class="mb-3">
                    <label class="form-label">Camera ID</label>
                    <input type="number" name="cameraId"
                           class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Camera Name</label>
                    <input type="text" name="cameraName"
                           class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Brand</label>
                    <input type="text" name="brand"
                           class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Price</label>
                    <input type="number" name="price"
                           step="0.01"
                           class="form-control" required>
                </div>

                <div class="text-center">
                    <input type="submit"
                           value="Submit"
                           class="btn btn-primary px-4">
                </div>

            </form>

        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>
${sucssess}

</body>
</html>