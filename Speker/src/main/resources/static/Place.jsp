<!DOCTYPE html>
<html>
<head>
    <title>Place Registration</title>
</head>
<body>

<h2>Place Registration</h2>

<form action="place" method="post">

    Place ID:
    <input type="number" name="placeId" required>
    <br><br>

    Place Name:
    <input type="text" name="placeName" required>
    <br><br>

    City:
    <input type="text" name="city" required>
    <br><br>

    State:
    <input type="text" name="state" required>
    <br><br>

    <input type="submit" value="Submit">

</form>
${sucssess}
</body>
</html>