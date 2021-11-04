<?php
	@session_start();
	include('admincp/modules/config.php');

		$name=$_SESSION['dangnhap'];	
		$insert_cart="insert into cart (fullname) value ('".$name."')";
		$ketqua=mysqli_query($insert_cart);
		if($ketqua){
			for($i=0;$i<count($_SESSION['product']);$i++){
			$max=mysqli_query("select max(id) from cart");
			$row=mysqli_fetch_array($max);
			
			$cart_id=$row[0];
			$product_id=$_SESSION['product'][$i]['id'];
			$quantity=$_SESSION['product'][$i]['soluong'];
			
			$price=$_SESSION['product'][$i]['gia'];
			
			 $insert_cart_detail="insert into cart_detail (cart_id,product_id,quantity,price) values('".$cart_id."','".$product_id."','".$quantity."','".$price."');";
			 $cart_detail=mysqli_query($insert_cart_detail);

		}
		
	}	
		unset($_SESSION['product']);
		
		header('location:index.php?quanly=camon');
	
?>
