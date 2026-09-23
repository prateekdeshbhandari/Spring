<!DOCTYPE html>
<html>
<head>
    <title>Place Registration</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3 class="mb-0">Place Registration</h3>
                </div>

                <div class="card-body">

                    <form action="place" method="post">

                        <!-- Place ID -->
                        <div class="mb-3">
                            <label class="form-label">Place ID</label>
                            <input type="number"
                                   name="placeId"
                                   class="form-control"
                                   placeholder="Enter Place ID"
                                   required>
                        </div>

                        <!-- Place Name -->
                        <div class="mb-3">
                            <label class="form-label">Place Name</label>
                            <input type="text"
                                   name="placeName"
                                   class="form-control"
                                   placeholder="Enter Place Name"
                                   required>
                        </div>

                        <!-- City -->
                        <div class="mb-3">
                            <label class="form-label">City</label>
                            <input type="text"
                                   name="city"
                                   class="form-control"
                                   placeholder="Enter City"
                                   required>
                        </div>

                        <!-- State -->
                        <div class="mb-3">
                            <label class="form-label">State</label>
                            <input type="text"
                                   name="state"
                                   class="form-control"
                                   placeholder="Enter State"
                                   required>
                        </div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <input type="submit"
                                   value="Submit"
                                   class="btn btn-primary">
                        </div>

                    </form>

                    <!-- Success Message -->
                    <div class="text-success text-center mt-3">
                        ${sucssess}
                    </div>

                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>