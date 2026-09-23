<!DOCTYPE html>
<html>
<head>
    <title>Contact Registration</title>

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
                    <h3 class="mb-0">Contact Registration</h3>
                </div>

                <div class="card-body">

                    <form action="contact" method="post">

                        <!-- Contact ID -->
                        <div class="mb-3">
                            <label class="form-label">Contact ID</label>
                            <input type="number"
                                   name="contactId"
                                   class="form-control"
                                   placeholder="Enter Contact ID"
                                   required>
                        </div>

                        <!-- Name -->
                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text"
                                   name="name"
                                   class="form-control"
                                   placeholder="Enter Name"
                                   required>
                        </div>

                        <!-- Email -->
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email"
                                   name="email"
                                   class="form-control"
                                   placeholder="Enter Email"
                                   required>
                        </div>

                        <!-- Mobile -->
                        <div class="mb-3">
                            <label class="form-label">Mobile</label>
                            <input type="tel"
                                   name="mobile"
                                   class="form-control"
                                   placeholder="Enter Mobile Number"
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