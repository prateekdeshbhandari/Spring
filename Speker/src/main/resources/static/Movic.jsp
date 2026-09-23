<!DOCTYPE html>
<html>
<head>
    <title>Movie Registration</title>

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
                    <h3 class="mb-0">Movie Registration</h3>
                </div>

                <div class="card-body">

                    <form action="movie" method="post">

                        <!-- Movie ID -->
                        <div class="mb-3">
                            <label class="form-label">Movie ID</label>
                            <input type="number"
                                   name="movieId"
                                   class="form-control"
                                   placeholder="Enter Movie ID"
                                   required>
                        </div>

                        <!-- Movie Name -->
                        <div class="mb-3">
                            <label class="form-label">Movie Name</label>
                            <input type="text"
                                   name="movieName"
                                   class="form-control"
                                   placeholder="Enter Movie Name"
                                   required>
                        </div>

                        <!-- Hero -->
                        <div class="mb-3">
                            <label class="form-label">Hero</label>
                            <input type="text"
                                   name="hero"
                                   class="form-control"
                                   placeholder="Enter Hero Name"
                                   required>
                        </div>

                        <!-- Director -->
                        <div class="mb-3">
                            <label class="form-label">Director</label>
                            <input type="text"
                                   name="director"
                                   class="form-control"
                                   placeholder="Enter Director Name"
                                   required>
                        </div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <input type="submit"
                                   value="Submit"
                                   class="btn btn-primary">
                        </div>

                    </form>

                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>