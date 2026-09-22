<!DOCTYPE html>
<html>
<head>
    <title>Telephone Operator Registration</title>
</head>
<body>

<h2>Telephone Operator Registration</h2>

<form action="operator" method="post">

    Operator ID:
    <input type="number" name="operatorId" required>
    <br><br>

    Operator Name:
    <input type="text" name="operatorName" required>
    <br><br>

    Company:
    <input type="text" name="company" required>
    <br><br>

    Mobile:
    <input type="tel" name="mobile" required>
    <br><br>

    <input type="submit" value="Submit">

</form>
${sucssess}
</body>
</html>