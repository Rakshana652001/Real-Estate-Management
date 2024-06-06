<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Property Registration</title>
</head>
<body>
<form action="PropertyServlet" method="post" onsubmit="return validateForm()">
    <h4>Property Registration</h4>
    <label>Seller ID: <input type="text" name="sellerId" placeholder="Enter the ID given by the company" required/></label><br><br>
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
    <label>Property Price: <input type="number" id="propertyPrice" name="propertyPrice" required/></label><br><br>
    <label>Property Address: <textarea id="propertyAddress" name="propertyAddress" placeholder="Enter detail address includes your Property type, Door no, Street name, Landmark" rows="4" cols="100" required></textarea></label><br><br>
    <label>Property District: <input type="text" id="propertyDistrict" name="propertyDistrict" placeholder="Madurai" required/></label><br><br>
    <label>Property State: <input type="text" id="propertyState" name="propertyState" placeholder="Tamil Nadu" required/></label><br><br>
    <button type="submit">Register the Property</button>
</form>
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
