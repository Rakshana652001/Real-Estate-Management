<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Seller Welcome Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: grey;
        background-position: center;
        margin: 0;
        padding: 0;
        height: 100%;
        overflow: hidden;
    }
    .navbar {
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #333;
        padding: 10px;
    }
    .navbar a {
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
        font-size: 17px;
        margin: 0 10px;
    }
    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }
    .dropdown {
        position: relative;
        display: inline-block;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }
    .dropdown-content a {
        color: white;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }
    .dropdown:hover .dropdown-content {
        display: block;
        background: #333;
    }
    .dropdown:hover .dropbtn {
        background-color: #ddd;
        color: black;
    }
    .content {
        display: flex;
        justify-content: center;
        align-items: center;
        height: calc(100vh - 50px);
    }
    h1 {
        font-family: "Times New Roman", Times, serif;
        color: white;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 2rem;
    }
    ul {
    	display: flex;
        justify-content: center;
        align-items: center;
        margin-right: 5%;
        margin-left: 3%;
        margin-bottom: 0.5%;
        background: none;
        
		}

	li {
   		margin: 0;
		margin-right: 10px;
   		display: inline-block;
   		
 		}
 	button {
	background: white;
	border: none;
	border-radius: 4px;
	color: black;
	cursor: pointer;
	box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;	
	}
</style>
</head>
<body>
<section id="home" class="container mt-5">
    <h1 class="text-center">Urban Nest Realty</h1>
    <ul>
    	<li><a class="nav-link active" href="http://localhost:8080/RealEstateManagement/WelcomePage.jsp#home"><button>Home</button></a></li>
    	<li><a class="nav-link active" href="http://localhost:8080/RealEstateManagement/WelcomePage.jsp#realties"><button>Realties</button></a></li>
    	<li><a class="nav-link active" href="http://localhost:8080/RealEstateManagement/WelcomePage.jsp#about"><button>About Us</button></a></li>
    	<li><a class="nav-link active" href="http://localhost:8080/RealEstateManagement/WelcomePage.jsp#contact"><button>Contact</button></a></li>
    </ul>
</section>
    <div class="navbar">
        <a href="SellerProfileServlet">Profile</a>
        <a href="PropertyRegistration.jsp">Property Registration</a>
        <a href="PropertyTableServlet">Registered Properties</a>
        <a href="PaidServlet">Completed Deals</a>
        <a href="WelcomePage.jsp">Logout</a>
    </div>
    <div class="content">
        <h1>Welcome to the Seller Dashboard</h1>
    </div>
</body>
<body>
</html>