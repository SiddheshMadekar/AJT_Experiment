
<!DOCTYPE html>
<html>
<head>
    <title>Send Email</title>
</head>
<body>
    <h2>Send Email Using Java Mail API</h2>

    <form action="SendEmailServlet" method="post">
        Recipient Email:
        <input type="email" name="recipient" required>
        <br><br>

        Subject:
        <input type="text" name="subject" required>
        <br><br>

        Message:
        <textarea name="message" required></textarea>
        <br><br>

        <input type="submit" value="Send Email">
    </form>
</body>
</html>
