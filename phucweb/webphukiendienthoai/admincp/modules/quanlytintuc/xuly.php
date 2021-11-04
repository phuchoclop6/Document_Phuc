<?php
	include('../config.php');
	$tentintuc=$_POST['tentintuc'];
	$matin=$_POST['matin'];
	$hinhanh=$_FILES['hinhanh']['name'];
	$hinhanh_tmp=$_FILES['hinhanh']['tmp_name'];
	move_uploaded_file($hinhanh_tmp,'uploads/'.$hinhanh);
	
	$noidung=$_POST['noidung'];
	
	$tinhtrang=$_POST['tinhtrang'];
	
	if(isset($_POST['them'])){
		//them
		 $sql_them=("insert into tintuc (tentintuc,matin,hinhanh,noidung,tinhtrang) value('$tentintuc','$matin','$hinhanh','$noidung','$tinhtrang')");
		mysql_query($sql_them);
		header('location:../../index.php?quanly=tintuc&ac=lietke');
	}elseif(isset($_POST['sua'])){
		//sua
		if($hinhanh!=''){
	  $sql_sua = "update tintuc set tentintuc='$tentintuc',matin='$matin',hinhanh='$hinhanh',noidung='$noidung',tinhtrang='$tinhtrang' where idtintuc='$_GET[id]'";
		}else{
			  $sql_sua = "update tintuc set tentintuc='$tentintuc',matin='$matin',noidung='$noidung',tinhtrang='$tinhtrang' where idtintuc='$_GET[id]'";
		}
		mysql_query($sql_sua);
		header('location:../../index.php?quanly=tintuc&ac=lietke');
	}else{
		$sql_xoa = "delete from tintuc where idtintuc = $_GET[id]";
		mysql_query($sql_xoa);
		header('location:../../index.php?quanly=tintuc&ac=lietke');
	}
?>
