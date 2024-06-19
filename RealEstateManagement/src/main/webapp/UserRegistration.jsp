<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration</title>
<style>
    body{
    font-family: Arial, sans-serif;
    background-color: grey;
    background-size: cover;
 	background-position: center;
  	position: relative;
    color: #333;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    }
    #registrationForm {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 400px;
        box-sizing: border-box;
    }
    label {
        display: block;
        margin-bottom: 10px;
    }
    input[type="text"],
    input[type="tel"],
    input[type="email"],
    input[type="password"],
    textarea {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .dropdown {
        position: relative;
        display: inline-block;
        margin-bottom: 15px;
        width: 100%;
    }
    .dropbtn {
        background-color: #f9f9f9;
        color: black;
        padding: 8px;
        font-size: 16px;
        border: none;
        cursor: pointer;
        width: 100%;
        text-align: left;
        box-sizing: border-box;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: white;
        min-width: 100%;
        box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        z-index: 1;
        box-sizing: border-box;
    }
    .dropdown-content button {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        width: 100%;
        border: none;
        background-color: white;
        text-align: left;
        box-sizing: border-box;
    }
    .dropdown-content button:hover {
        background-color: #ddd;
    }
    .dropdown:hover .dropdown-content {
        display: block;
    }
    .button-group {
        display: flex;
        justify-content: space-between;
    }
    button {
        background-color: black;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 48%;
        margin-top: 10px;
    } 
    button:hover {
        background-color: #333;
    }
</style>
</head>
<body>
<form action="UserServlet" id="registrationForm" method="get">
    <h4>User Registration</h4>
    <label for="name">Name: <input type="text" id="name" name="name" placeholder="Rakshana" required/></label>
    <div class="dropdown">
        <label class="dropbtn" for="designationDropdown" id="designationDropdown">Select Designation</label>
        <div class="dropdown-content">
            <button type="button" onclick="promptForCode('Admin')">Admin</button>
            <button type="button" onclick="selectOption('Customer')">Customer</button>
            <button type="button" onclick="selectOption('Seller')">Seller</button>
        </div>
    </div>
    <label for="designation">Designation: 
        <input type="text" id="designationInput" name="designation" readonly required/>
    </label>
    <label for="phoneNumber">Phone Number: <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="7339263883" pattern="[789][0-9]{9}" required/></label>
    <label for="emailID">EmailID: <input type="email" id="emailID" name="emailID" pattern="[a-z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}$" placeholder="raksha@gmail.com" required/></label>
    <label for="password">Password: <input type="password" id="password" name="password" placeholder="Rakshana@12" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/></label>
    <label for="address">Address: <textarea id="address" name="address" rows="4" cols="50"></textarea></label>
    <label for="district">District: <input type="text" id="district" name="district" placeholder="Madurai" required/></label>
    <label for="state">State: <input type="text" id="state" name="state" placeholder="Tamil Nadu" required/></label>
    <input type="text" id="generatedUserID" name="generatedUserID" readonly style="display: none;"> 
    <label id="userIDLabel" style="display: none;"></label>
    
    <div class="button-group">
        <button type="button" onclick="validateForm()">Register</button>
    </div>
</form>
<script>
let codeNumber = localStorage.getItem('codeNumber') ? parseInt(localStorage.getItem('codeNumber')) : 1; 

function promptForCode(option) {
    if (option === 'Admin') {
        let correctCode = "UrbanNest654386";
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
    let companyName = "UNR";
    let userID = companyName + '_' + designation + '_' + codeNumber;
   
    document.getElementById('generatedUserID').value = userID;
    
    
    document.getElementById('userIDLabel').textContent = "Please Note Generated User ID: " + userID;
    document.getElementById('userIDLabel').style.display = "block"; 
  
    codeNumber++;
    localStorage.setItem('codeNumber', codeNumber);
}

function validateForm() 
{
    let form = document.getElementById('registrationForm');
    let phoneNumber = document.getElementById('phoneNumber');
    let email = document.getElementById('emailID');
    let password = document.getElementById('password');

    if (!phoneNumber.checkValidity()) 
    {
        alert("Please enter a valid phone number.");
        return;
    }

    if (!email.checkValidity()) 
    {
        alert("Please enter a valid email address.");
        return;
    }

    if (!password.checkValidity())
    {
        alert("Please enter a valid password.\nPassword must contain at least 8 characters including at least one uppercase letter, one lowercase letter, and one number.");
        return;
    }
    
    
    generateUserID();
    
    setTimeout(function(){ form.submit(); }, 5000);
}
</script>
<a href="WelcomePage.jsp"><button type="submit" >Back to home</button></a>
</body>
</html>
    