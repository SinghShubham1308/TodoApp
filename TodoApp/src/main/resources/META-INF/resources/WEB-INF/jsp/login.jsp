<!DOCTYPE html>
<html>

<head>
<title>HTML Login Form</title>
<link rel="stylesheet" href="WEB-INF/css/styles.css">
</head>

<body>
	<div class="main">
	<pre>${error}</pre>
		<h1>GeeksforGeeks ${name }</h1>
		<h3>Enter your login credentials</h3>
		<form action="" method="post">
			<label for="username"> Username: </label> <input type="texst" id="username"
				name="username" placeholder="Enter your Username" required> <label
				for="password"> Password: </label> <input type="password"
				id="password" name="password" placeholder="Enter your Password"
				required>

			<div class="wrap">
				<button type="submit" onclick="solve()">Submit</button>
			</div>
		</form>
		<p>
			Not registered? <a href="#" style="text-decoration: none;">
				Create an account </a>
		</p>
	</div>
</body>

</html>