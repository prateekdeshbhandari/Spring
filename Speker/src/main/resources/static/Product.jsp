<!DOCTYPE html>
<html>
<head>
    <title>Product Registration</title>

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
                    <h3 class="mb-0">Product Registration</h3>
                </div>

                <div class="card-body">

                    <form action="product" method="post">

                        <!-- Product ID -->
                        <div class="mb-3">
                            <label class="form-label">Product ID</label>
                            <input type="number"
                                   name="productId"
                                   class="form-control"
                                   placeholder="Enter Product ID"
                                   required>
                        </div>

                        <!-- Product Name -->
                        <div class="mb-3">
                            <label class="form-label">Product Name</label>
                            <input type="text"
                                   name="productName"
                                   class="form-control"
                                   placeholder="Enter Product Name"
                                   required>
                        </div>

                        <!-- Price -->
                        <div class="mb-3">
                            <label class="form-label">Price</label>
                            <input type="number"
                                   name="price"
                                   class="form-control"
                                   placeholder="Enter Price"
                                   step="0.01"
                                   required>
                        </div>

                        <!-- Category -->
                        <div class="mb-3">
                            <label class="form-label">Category</label>
                            <input type="text"
                                   name="category"
                                   class="form-control"
                                   placeholder="Enter Category"
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