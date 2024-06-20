<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Property Registration</title>
<style type="text/css">
body {
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

.container {
    max-width: 500px;
    width: 100%;
    padding: 20px;
    background: #fff;
    border: 12px solid white;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    box-sizing: border-box;
}

h4 {
    text-align: center;
    margin-bottom: 20px;
    color: black;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 10px;
    color: black;
}

input[type="text"], input[type="number"], textarea, select, input[type="file"], input[type="date"] {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
    background-color: #f4f4f4;
    box-sizing: border-box;
}

button {
    padding: 10px 20px;
    margin-top: 20px;
    border: none;
    border-radius: 4px;
    background-color: #000100;
    color: white;
    font-size: 16px;
    cursor: pointer;
}

button:hover {
    background-color: #333;
}
</style>
</head>
<body>
<%
    LocalDate registeredDate = LocalDate.now();
    String getSellerId = (String)session.getAttribute("id");
%>
<div class="container">
<form action="PropertyServlet" method="post" onsubmit="return validateForm()" enctype="multipart/form-data">
    <h4>Property Registration</h4>
    <label>Seller ID: <input type="text" name="sellerId" placeholder="Enter the ID given by the company" value="<%= getSellerId != null ? getSellerId : "" %>" readonly></label><br><br>
    <label>Property Name: 
        <select id="propertyNameSelect" name="propertyNameSelect" onchange="autoFillPropertyDetails()" required>
            <option value="">Select Property</option>
            <option value="101" data-name="Land">Land</option>
            <option value="102" data-name="Residential">Residential(House)</option>
            <option value="103" data-name="Commercial">Commercial(Showroom/Floor in complex/Shop)</option>
            <option value="104" data-name="Industrial">Industrial(Warehouse/Loft)</option>
        </select>
    </label><br><br>
    <label>Property ID: <input type="text" id="propertyId" name="propertyId" readonly/></label><br><br>
    <label>Property Name: <input type="text" id="propertyName" name="propertyName" readonly/></label><br><br>
    <label>Registration Date: <input type="date" id="registeredDate" name="registeredDate" value="<%= registeredDate %>" readonly></label><br><br>
    <label>Property Price: <input type="number" id="propertyPrice" name="propertyPrice" required/></label><br><br>
    <label>Add Images: <input type="file" id="propertyImages" name="propertyImage" required/></label><br><br>
    <label>Property Documents Photo Copy: <input type="file" id="propertyDocument" name="propertyDocument" required/></label><br><br>
    <label>Property Address: <textarea id="propertyAddress" name="propertyAddress" placeholder="Enter detail address includes your Property type, Door no, Street name, Landmark" rows="4" cols="30" required></textarea></label><br><br>
    <label>Property District: <input type="text" id="propertyDistrict" name="propertyDistrict" placeholder="Madurai" required/></label><br><br>
    <label>Property State: <input type="text" id="propertyState" name="propertyState" placeholder="Tamil Nadu" required/></label><br><br>
    <button type="submit">Register the Property</button>
</form>
<form action="SellerWelcomePage.jsp"><button>Back to Your Page</button></form>
</div>
<script>
function autoFillPropertyDetails() {
    var propertySelect = document.getElementById('propertyNameSelect');
    var selectedOption = propertySelect.options[propertySelect.selectedIndex];
    var propertyId = selectedOption.value;
    var propertyName = selectedOption.getAttribute('data-name');

    document.getElementById('propertyId').value = propertyId;
    document.getElementById('propertyName').value = propertyName;
}

function validateForm() {
    var propertyNameSelect = document.getElementById('propertyNameSelect').value;
    var propertyPrice = document.getElementById('propertyPrice').value;
    var propertyAddress = document.getElementById('propertyAddress').value;
    var propertyDistrict = document.getElementById('propertyDistrict').value;
    var propertyState = document.getElementById('propertyState').value;

    if (propertyNameSelect === "" || propertyPrice === "" || propertyAddress === "" || propertyDistrict === "" || propertyState === "") {
        alert("Please fill in all required fields.");
        return false;
    }

    return true;
}
</script>
</body>
</html>
