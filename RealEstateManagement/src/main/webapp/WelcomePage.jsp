<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Urban Nest Realty</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
body
{
    font-family: 'Roboto', sans-serif;
    font-size: large;
    margin: 0;
    padding: 0;
    background-color: #f8f9fa;
    
}
h1{
font-family: "Times New Roman", Times, serif;
color: black;
}
.navbar 
{
    background-color: #343a40;
    padding: 10px 20px;
    border-bottom: 1px solid #e7e7e7;
    position: sticky;
    top: 0;
  	left: 0;
  	z-index: 100;
}

.navbar-nav 
{
    display: flex;
    align-items: center;
}

.nav-item 
{
    list-style: none;
    margin-right: 15px;
}

.nav-link 
{
    color: #ffffff;
    padding: 8px 15px;
    border-radius: 5px;
}

.nav-link:hover, .nav-link.active 
{
    background-color: #495057;
    color: #ffffff;
}

.dropdown-menu 
{
    background-color: #343a40;
    border: none;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.dropdown-item 
{
    color: #ffffff;
    padding: 10px 20px;
    text-decoration: none;
}

.dropdown-item:hover 
{
    background-color: #495057;
    color: #ffffff;
}

.form-control 
{
    border-radius: 5px;
    border: 1px solid #ced4da;
    padding: 8px 15px;
}

.form-control:focus 
{
    border-color: #80bdff;
    outline: 0;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.25);
}

#navbarSupportedContent 
{
    display: flex;
    justify-content: space-between;
    align-items: center;
}

#search 
{
    margin-left: auto;
}

.card img
{
    height: 200px;
    object-fit: cover;
}
.btn-outline-dark{
  background-color:rgba(238, 43, 43, 0)!important;
  border-width: 2px !important;
  border-color: rgb(75, 3, 3) !important;
  color: black !important;
}

section{
  width: 100%;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#footer
{
  color: white;
  bottom: 0;
  left: 0;
  z-index: 100;
  padding: .4rem .4rem;
  background-color: #343a40; 
}

#home{
  background: url(Images/Flat.webp);
  background-size: cover;
  background-position: center;
  position: relative;
  justify-content: center;
  align-items: center;
  }

</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
 <div class="container">
  
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link active" href="#home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#realties">Realties</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#about">About Us</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#contact">Contact</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Account
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="UserRegistration.jsp">Register</a>
            <a class="dropdown-item" href="AdminLogin.jsp">Login</a>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>
<section id="home" class="container mt-5">
    <h1 class="text-center">Urban Nest Realty</h1>
</section>
<section id="realties" class="container mt-5">
    <div class="row">
        <div class="col-lg-3 col-md-4 col-12 mb-4">
            <div class="card">
                <img src="Images/House.jpg" class="card-img-top" alt="House">
                <div class="card-body text-center">
                  <h5 class="card-title">Residential</h5>
                  <a href="ResidentialServlet" class="btn btn-outline-dark">See More</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-12 mb-4">
            <div class="card">
                <img src="Images/Land.jpg" class="card-img-top" alt="Land">
                <div class="card-body text-center">
                  <h5 class="card-title">Land</h5>
                  <a href="LandServlet" class="btn btn-outline-dark">See More</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-12 mb-4">
            <div class="card">
                <img src="Images/Flat.webp" class="card-img-top" alt="Industrial">
                <div class="card-body text-center">
                  <h5 class="card-title">Industrial</h5>
                  <a href="IndustrialServlet" class="btn btn-outline-dark">See More</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-12 mb-4">
            <div class="card">
                <img src="Images/Shop.webp" class="card-img-top" alt="Commercial">
                <div class="card-body text-center">
                  <h5 class="card-title">Commercial</h5>
                  <a href="CommercialServlet" class="btn btn-outline-dark">See More</a>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="about">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-4 col-lg-4 col-6">
              <img alt="Aboutus" src="Images/quality.jpg" class="card-img-top">
            </div>
            <div class="col-lg-6 col-lg-6 col-12">
              <h1>About Urban Nest Realty</h1>
              	<p>Welcome to Urban Nest Realty, your trusted partner in real estate transactions. Our mission is to provide exceptional service and help you find your dream property. Whether you are buying, selling, or investing, we are here to guide you every step of the way.</p>
	        	<p>With years of experience in the real estate industry, our team of professionals is committed to delivering outstanding results. We pride ourselves on transparency, integrity, and customer satisfaction.</p>
    	    	<p>Explore our website to discover a wide range of properties, from residential homes to commercial spaces. Feel free to contact us for any inquiries or assistance. We look forward to serving you!</p>
            </div>
          </div>
        </div>
</section>
      
<footer id="footer">
      <p class="text-center"> Conditions of Use and Sale Privacy Notice Interest-Based Ads</p>
        <p class="text-center"> 2024 Company, Inc</p>
  </footer>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>