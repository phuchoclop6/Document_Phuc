<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style-login.css" />
<title>Đăng nhập vào trang admincp</title>
</head>
<?php
	session_start();
	include('modules/config.php');
	if(isset($_POST['login'])){
		$username = $_POST['username'];
		$password = $_POST['password'];
		$sql="select * from admin where username='$username' and password='$password' limit 1 ";
		$row=mysqlii_query($sql);
		$count=mysqlii_num_rows($row);
		if($count>0){
			$_SESSION['dangnhap']=$username;
			header('location:index.php');
		}else{
			
			echo '<script>alert("Tài khoản hoặc mật khẩu không đúng.Làm ơn đăng nhập lại.");</script>';
			header('location:login.php');
		}
	}
?>
<body>
<div id="login">
	<form action="login.php" method="post" enctype="multipart/form-data">
    <h2>Đăng nhập</h2>
    <input type="text" name="username" id="username" placeholder="Enter username..." required="required" />
     <input type="password" name="password" id="password" placeholder="Enter password..." required="required" />
      <input type="submit" name="login" id="button" value="Sign in"/>
    </form>

</div>
	

</div>
</body>
</html>
