<!DOCTYPE html>
<html>
<head>
    <title>Product Registration</title>
</head>
<body>

<h2>Product Registration</h2>

<form action="product" method="post">

    Product ID:
    <input type="number" name="productId" required>
    <br><br>

    Product Name:
    <input type="text" name="productName" required>
    <br><br>

    Price:
    <input type="number" name="price" step="0.01" required>
    <br><br>

    Category:
    <input type="text" name="category" required>
    <br><br>

    <input type="submit" value="Submit">

</form>
${sucssess}
</body>
</html>