<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:land">
<head>
<meta charset="ISO-8859-1">
<title>Urban Nest Realty</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f8f9fa;
}

.navbar {
    background-color: #343a40; 
    padding: 10px 20px;
    border-bottom: 1px solid #e7e7e7;
}

.navbar-nav {
    display: flex;
    align-items: center;
}

.nav-item {
    list-style: none;
    margin-right: 15px;
}

.nav-link {
    color: #ffffff; 
    text-decoration: none;
    padding: 8px 15px;
    border-radius: 5px;
}

.nav-link:hover, .nav-link.active {
    background-color: #495057; 
    color: #ffffff;
}

.dropdown-menu {
    background-color: #343a40; 
    border: none;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.dropdown-item {
    color: #ffffff;
    padding: 10px 20px;
    text-decoration: none;
}

.dropdown-item:hover {
    background-color: #495057;
    color: #ffffff;
}

.form-control {
    border-radius: 5px;
    border: 1px solid #ced4da;
    padding: 8px 15px;
}

.form-control:focus {
    border-color: #80bdff;
    outline: 0;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.25);
}

#navbarSupportedContent {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

#search {
    margin-left: auto;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark" id="navbar">
  <div class="container m-2" id="navbarSupportedContent">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <li class="nav-item">
        <a class="nav-link active" href="#home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active"  href="#realties">Realties</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#about">About Us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active"  href="#contact">Contact</a>
      </li>
      <li class="nav-item dropdown">
        
        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Account
        </a> 
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="UserRegistration.jsp">Register</a>
          <a class="dropdown-item" href="AdminLogin.jsp">Admin Login</a>
          <a class="dropdown-item" href="SellerLogin.jsp">Seller Login</a>
          <a class="dropdown-item" href="CustomerLogin.jsp">Customer Login</a>
        </div>
      </li>
    </ul>
    <form class="d-flex" role="search" id="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
    </form>
  </div>
</nav>
<section id="home">
        <h3>Urban Nest Realty</h3>
</section>
<section id="realties">
	<div class="row" style="width: 50rem">
                <div class="col-lg-4 col-md-4 col-12">
                    <div class="card">
                        <img src="Images/House.jpg" class="card-img-top" alt="House">
                        <div class="card-body text-center">
                          <h5 class="card-title">Residential</h5>
                          <a href="ResidentialServlet" class="btn btn-outline-dark">See More</a>
                        </div>
                      </div>
                </div>
                <div class="col-lg-4 col-md-4 col-12">
                    <div class="card">
                        <img src="Images/Land.jpg" class="card-img-top" alt="House">
                        <div class="card-body text-center">
                          <h5 class="card-title">Land</h5>
                          <a href="LandServlet" class="btn btn-outline-dark">See More</a>
                        </div>
                      </div>
                </div>
                <div class="col-lg-4 col-md-4 col-12">
                    <div class="card">
                        <img src="Images/Flat.webp" class="card-img-top" alt="House">
                        <div class="card-body text-center">
                          <h5 class="card-title">Industrial</h5>
                          <a href="IndustrialServlet" class="btn btn-outline-dark">See More</a>
                        </div>
                      </div>
                </div>
                <div class="col-lg-4 col-md-4 col-12">
                    <div class="card">
                        <img src="Images/Shop.webp" class="card-img-top" alt="House">
                        <div class="card-body text-center">
                          <h5 class="card-title">Commercial</h5>
                          <a href="CommercialServlet" class="btn btn-outline-dark">See More</a>
                        </div>
                      </div>
                </div>
     </div>
</section>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
