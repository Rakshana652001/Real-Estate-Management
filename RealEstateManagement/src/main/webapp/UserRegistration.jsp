<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration</title>

</head>
<body>
<form action="UserServlet" id="registrationForm" method="get">
    <h4>User Registration</h4>
    <label for="name">Name: <input type="text" id="name" name="name" placeholder="Rakshana" required/></label>
    
    <div class="dropdown">
        <label class="dropbtn" for="designationDropdown" id="designationDropdown">Select Designation</label>
        <div class="dropdown-content">
            <a href="#" onclick="promptForCode('Admin')">Admin</a>
            <a href="#" onclick="selectOption('Customer')">Customer</a>
            <a href="#" onclick="selectOption('Seller')">Seller</a>
        </div>
    </div>
    <label for="designation">Designation: 
        <input type="text" id="designationInput" name="designation" readonly required/>
    </label>
    <label for="phoneNumber">Phone Number: <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="7339263883" pattern="[789][0-9]{9}" required/></label>
    <label for="emailID">EmailID: <input type="email" id="emailID" name="emailID" placeholder="raksha@gmail.com" required/></label>
    <label for="password">Password: <input type="password" id="password" name="password" placeholder="Rakshana@12" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/></label>
    <label for="address">Address: <textarea id="address" name="address" rows="4" cols="50"></textarea></label>
    <label for="district">District: <input type="text" id="district" name="district" placeholder="Madurai" required/></label>
    <label for="state">State: <input type="text" id="state" name="state" placeholder="Tamil Nadu" required/></label>
    <input type="text" id="generatedUserID" name="generatedUserID" readonly style="display: none;"> <!-- Hidden input field for generated user ID -->
    <label id="userIDLabel" style="display: none;"></label> <!-- Hidden by default -->
    <button type="button" onclick="validateForm()">Register</button>
</form>
<script>
let codeNumber = localStorage.getItem('codeNumber') ? parseInt(localStorage.getItem('codeNumber')) : 1; // Initialize the auto-increment code number from local storage

function promptForCode(option) {
    if (option === 'Admin') {
        let correctCode = "UrbanNest654386"; // Set the correct code here
        let userCode = prompt("Please enter the code for " + option);

        if (userCode === correctCode) {
            document.getElementById('designationDropdown').textContent = option;
            document.getElementById('designationInput').value = option;
        } else {
            alert("Incorrect code. Please try again.");
        }
    } else {
        document.getElementById('designationDropdown').textContent = option;
        document.getElementById('designationInput').value = option;
    }
}

function selectOption(option) {
    document.getElementById('designationDropdown').textContent = option;
    document.getElementById('designationInput').value = option;
}

function generateUserID() {
    let designation = document.getElementById('designationInput').value;
    let companyName = "UNR"; // Company name
    let userID = companyName + '_' + designation + '_' + codeNumber;
    
    // Set the generated user ID value to the input field
    document.getElementById('generatedUserID').value = userID;

    // Show the label with the generated user ID
    document.getElementById('userIDLabel').textContent = "Please Note Generated User ID: " + userID;
    document.getElementById('userIDLabel').style.display = "block"; 

    // Increment the code number for the next user and store it in local storage
    codeNumber++;
    localStorage.setItem('codeNumber', codeNumber);
}

function validateForm() {
    let form = document.getElementById('registrationForm');
    let name = document.getElementById('name');
    let designation = document.getElementById('designationInput');
    let phoneNumber = document.getElementById('phoneNumber');
    let email = document.getElementById('emailID');
    let password = document.getElementById('password');
    let address = document.getElementById('address');
    let district = document.getElementById('district');
    let state = document.getElementById('state');

    // Check if phone number is valid
    if (!phoneNumber.checkValidity()) {
        alert("Please enter a valid phone number.");
        return;
    }

    // Check if email is valid
    if (!email.checkValidity()) {
        alert("Please enter a valid email address.");
        return;
    }

    // Check if password is valid
    if (!password.checkValidity()) {
        alert("Please enter a valid password.\nPassword must contain at least 8 characters including at least one uppercase letter, one lowercase letter, and one number.");
        return;
    }

    // Check if district is not empty
    if (district.value.trim() === "") {
        alert("Please enter the district.");
        return;
    }

    // Check if state is not empty
    if (state.value.trim() === "") {
        alert("Please enter the state.");
        return;
    }

    // If all validations pass, generate user ID
    generateUserID();

    // Submit the form
    form.submit();
}
</script>

</body>
</html>
