<!DOCTYPE html>
<html>
<head>
    <title>Team Registration</title>

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
                    <h3 class="mb-0">Team Registration</h3>
                </div>

                <div class="card-body">

                    <form action="team" method="post">

                        <!-- Team ID -->
                        <div class="mb-3">
                            <label class="form-label">Team ID</label>
                            <input type="number"
                                   name="teamId"
                                   class="form-control"
                                   placeholder="Enter Team ID"
                                   required>
                        </div>

                        <!-- Team Name -->
                        <div class="mb-3">
                            <label class="form-label">Team Name</label>
                            <input type="text"
                                   name="teamName"
                                   class="form-control"
                                   placeholder="Enter Team Name"
                                   required>
                        </div>

                        <!-- Captain -->
                        <div class="mb-3">
                            <label class="form-label">Captain</label>
                            <input type="text"
                                   name="captain"
                                   class="form-control"
                                   placeholder="Enter Captain Name"
                                   required>
                        </div>

                        <!-- Coach -->
                        <div class="mb-3">
                            <label class="form-label">Coach</label>
                            <input type="text"
                                   name="coach"
                                   class="form-control"
                                   placeholder="Enter Coach Name"
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