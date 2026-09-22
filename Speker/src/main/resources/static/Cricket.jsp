<!DOCTYPE html>
<html>
<head>
    <title>Team Registration</title>
</head>
<body>

<h2>Team Registration</h2>

<form action="team" method="post">

    Team ID:
    <input type="number" name="teamId" required>
    <br><br>

    Team Name:
    <input type="text" name="teamName" required>
    <br><br>

    Captain:
    <input type="text" name="captain" required>
    <br><br>

    Coach:
    <input type="text" name="coach" required>
    <br><br>

    <input type="submit" value="Submit">

</form>
${sucssess}
</body>
</html>