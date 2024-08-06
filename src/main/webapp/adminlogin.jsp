<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Form</title>

<style type="text/css">
/* Reset default styles */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
	background: linear-gradient(120deg, #f6d365 0%, #fda085 100%);
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

/* Form container styles */
form {
	background: #fff;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
	width: 100%;
	max-width: 400px;
	text-align: center;
}

/* Image styles */
.profile-image-pic {
	width: 120px;
	height: 120px;
	object-fit: cover;
	border-radius: 50%;
}

/* Input styles */
.form-control {
	width: calc(100% - 20px);
	padding: 15px;
	margin: 10px 0;
	border: 1px solid #ddd;
	border-radius: 25px;
	box-sizing: border-box;
	font-size: 16px;
	background: #f9f9f9;
	transition: all 0.3s ease;
}

.form-control:focus {
	border-color: #fda085;
	background: #fff;
	outline: none;
	box-shadow: 0 0 8px rgba(253, 160, 133, 0.5);
}

/* Button styles */
.btn-color {
	background: #ff7e5f;
	color: white;
	border: none;
	border-radius: 14px;
	padding: 12px 20px;
	font-size: 18px;
	cursor: pointer;
	transition: background 0.3s ease, transform 0.2s ease;
}

.btn-color:hover {
	background: #ff6a3d;
	transform: translateY(-2px);
}

/* Responsive adjustments */
@media ( max-width : 600px) {
	.form-control {
		width: calc(100% - 10px);
	}
	.btn-color {
		width: 100%;
		padding: 12px;
		font-size: 16px;
	}
}
</style>
</head>

<body>
	<form class="card-body cardbody-color p-lg-5" method="post"
		action="AdminLoginServlet1">
		<%@include file="message.jsp"%>

		<div class="text-center">
			<img
				src="img/adminimage.jpg"
				class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
				alt="profile">
		</div>

		<div class="mb-3">
			<input type="text" name="username" class="form-control" id="Username"
				aria-describedby="emailHelp" placeholder="User Name">
		</div>
		<div class="mb-3">
			<input type="password" name="password" class="form-control"
				id="password" placeholder="Password">
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-color px-5 mb-5 w-100">Login</button>
		</div>
	</form>
</body>

</html>
