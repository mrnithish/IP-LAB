<?php

function validateForm()
{
    $errors = [];

    if (empty($_POST['textnames'])) {
        $errors[] = "Enter Your First Name!";
    }

    if (empty($_POST['lastnames'])) {
        $errors[] = "Enter Your Last Name!";
    }

    if (empty($_POST['fathername'])) {
        $errors[] = "Enter Your Father Name!";
    }

    if (empty($_POST['paddress'])) {
        $errors[] = "Enter Your Postal Address!";
    }

    if (empty($_POST['personaladdress'])) {
        $errors[] = "Enter Your Personal Address!";
    }

    if (!isset($_POST['sex']) || (($_POST['sex'] != 'Male') && ($_POST['sex'] != 'Female'))) {
        $errors[] = "Choose Your Gender: Male or Female";
    }

    if ($_POST['City'] == "-1") {
        $errors[] = "Enter Your City!";
    }

    if ($_POST['Course'] == "-1") {
        $errors[] = "Enter Your Course!";
    }

    if ($_POST['District'] == "-1") {
        $errors[] = "Select Your District!";
    }

    if ($_POST['State'] == "-1") {
        $errors[] = "Select Your State!";
    }

    $pincode = $_POST['pincode'];
    if (empty($pincode) || !is_numeric($pincode) || strlen($pincode) != 6) {
        $errors[] = "Enter your pincode in format ######.";
    }

    $email = $_POST['emailid'];
    if (empty($email) || !filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $errors[] = "Enter your correct email ID";
    }

    if (empty($_POST['dob'])) {
        $errors[] = "Enter your DOB!";
    }

    $mobileno = $_POST['mobileno'];
    if (empty($mobileno) || !is_numeric($mobileno) || strlen($mobileno) != 10) {
        $errors[] = "Enter your Mobile No. in the format 123.";
    }

    return $errors;
}

// Example usage:
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $validationErrors = validateForm();

    if (empty($validationErrors)) {
        // Form is valid, do further processing or redirect
        echo "Form submitted successfully!";
    } else {
        // Form has errors, display them
        echo "Form submission failed. Please fix the following errors:<br>";
        foreach ($validationErrors as $error) {
            echo "- $error<br>";
        }
    }
}

?>
