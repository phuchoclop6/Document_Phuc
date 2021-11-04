<?php
	@session_start();
	
	if(isset($_SESSION['product'])){
		if(isset($_SESSION['dangnhap'])){
			echo '<div class="tieude">Giỏ hàng của bạn | <span>Xin chào bạn:<strong><em> '.$_SESSION['dangnhap'].'</em></strong><a href="update_cart.php?thoat=1" style="text-decoration:underline;color:#fff; margin-left:10px;">Đăng Xuất</a></span></div>';
		}else{
			echo '<div class="tieude">Giỏ hàng của bạn</div>';
		}
			
			echo '<div class="box_giohang">';
			echo '  <table width="100%" border="1" style="border-collapse:collapse; margin:5px; text-align:center;">';
			
			echo'  <tr>';
			echo '<td>MÃ SP</td>';
			echo'<td>Tên SP</td>';
			echo'<td>Hình ảnh</td>';
			echo'<td>Giá sp</td>';
			echo'<td>SL</td>';
			echo'<td>Tổng tiền</td>';
			echo'<td>Quản lý</td>';
			echo'</tr>';
	$thanhtien=0;
	foreach($_SESSION['product'] as $cart_item){
			$id=$cart_item['id'];
			$sql="select * from sanpham where idsanpham='$id'";
			$row=mysql_query($sql);
			$dong=mysql_fetch_array($row);
		 	echo'<tr>';
			echo'<td>'.$dong['masp'].'</td>';
			echo'<td>'.$dong['tensp'].'</td>';
			echo'<td><img src="admincp/modules/quanlysanpham/uploads/'.$dong['hinhanh'].'" width="100" height="100" /></td>';
			echo'<td>'.number_format($dong['giadexuat']).'</td>';
			
			echo'<td><a href="update_cart.php?cong='.$cart_item['id'].'" style="margin-right:2px;"><img src="imgs/plus.png" width="20" height="20"></a>'.$cart_item['soluong'].'<a href="update_cart.php?tru='.$cart_item['id'].'" style="margin-left:2px;"><img src="imgs/subtract.png" width="20" height="20"></a></td>';
			$tongtien=0;
			$tongtien=$cart_item['soluong']*$cart_item['gia'];
			$thanhtien=($thanhtien + $tongtien);
			echo'<td>'.number_format($tongtien).'</td>';
			echo'<td><a href="update_cart.php?xoa='.$cart_item['id'].'"><img src="imgs/deletered.png" width="30" height="30"></a></td>';
			echo'</tr>';
			echo '<tr>';
			echo'</tr>';
			
  	}
			echo '<tr>
				
				<td colspan="6"><a href="update_cart.php?xoatoanbo=1"  style="text-decoration:none;" >Xóa toàn bộ</a>	
				
				</td>
				
				
				<td>Thành tiền : '.number_format($thanhtien).'VNĐ'.'</td>
				
			
			</tr>';
			
	}else{
		
		echo 'Giỏ hàng của bạn trống';
	}
	

 	echo'</table>';
	
	
  ?>
  
 

            <ul	class="control">
              <p><a href="">Tiếp tục mua hàng</a></p>
                <p><a href="?quanly=dangkymoi">Đăng ký mới</a></p>
                <p><a href="?quanly=dangnhap">Bạn đã có tài khoản</a></p>
                <?php
				if(isset($_SESSION['dangnhap'])&&isset($_SESSION['product'])){
				?>
                 <p style="float:right; background:#FF0;text-decoration:none;"><a href="thanhtoan.php" style="color:#000;margin:5px;">Thanh toán</a></p>
				<?php
				}
				?>
        	</ul>
    
        </div>
