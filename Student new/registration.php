<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Student Registration Form</title> 
</head> 
<body> 
    <?php 
    // Function to sanitize input data 
    function sanitize_input($data) { 
        $data = trim($data); 
        $data = stripslashes($data); 
        $data = htmlspecialchars($data); 
        return $data; 
    } 
  
    // Define variables and set to empty values 
    $name = $email = $phone = ""; 
    $nameErr = $emailErr = $phoneErr = ""; 
  
    if ($_SERVER["REQUEST_METHOD"] == "POST") { 
        // Validate name 
        if (empty($_POST["name"])) { 
            $nameErr = "Name is required"; 
        } else { 
            $name = sanitize_input($_POST["name"]); 
            // Check if name only contains letters and whitespace 
            if (!preg_match("/^[a-zA-Z ]*$/", $name)) { 
                $nameErr = "Only letters and white space allowed"; 
            } 
        } 
  
        // Validate email 
        if (empty($_POST["email"])) { 
            $emailErr = "Email is required"; 
        } else { 
            $email = sanitize_input($_POST["email"]); 
            // Check if email is well-formed 
            if (!filter_var($email, FILTER_VALIDATE_EMAIL)) { 
                $emailErr = "Invalid email format"; 
            } 
        } 
  
        // Validate phone number 
        if (empty($_POST["phone"])) { 
            $phoneErr = "Phone number is required"; 
        } else { 
            $phone = sanitize_input($_POST["phone"]); 
            // Check if phone number is valid 
            if (!preg_match("/^\d{10}$/", $phone)) { 
                $phoneErr = "Invalid phone number"; 
            } 
        } 
    } 
    ?> 
  
    <h2>Student Registration Form</h2> 
    <form method="post" action="<?php echo 
htmlspecialchars($_SERVER["PHP_SELF"]);?>"> 
        Name: <input type="text" name="name" value="<?php echo $name;?>"> 
        <span class="error">* <?php echo $nameErr;?></span> 
        <br><br> 
  
        Email: <input type="text" name="email" value="<?php echo $email;?>"> 
        <span class="error">* <?php echo $emailErr;?></span> 
        <br><br> 
  
        Phone: <input type="text" name="phone" value="<?php echo $phone;?>"> 
        <span class="error">* <?php echo $phoneErr;?></span> 
        <br><br> 
  
        <input type="submit" name="submit" value="Submit"> 
    </form> 
  
    <?php 
    if ($_SERVER["REQUEST_METHOD"] == "POST" && empty($nameErr) && 
empty($emailErr) && empty($phoneErr)) { 
        echo "<h2>Thank you for registering!</h2>"; 
        echo "<p>Your details:</p>"; 
        echo "Name: " . $name . "<br>"; 
        echo "Email: " . $email . "<br>"; 
        echo "Phone: " . $phone . "<br>"; 
    } 
    ?> 
</body> 
</html>