<?php
	$sql_lietkesp="select * from tintuc
	
	 order by tintuc.idtintuc desc ";
	$row_lietkesp=mysql_query($sql_lietkesp);

?>
<div class="button_themsp">
<a href="index.php?quanly=tintuc&ac=them">Thêm Mới</a> 
</div>

<table width="100%" border="1">
  <tr>
    <td>ID</td>
    <td>Tên sản phẩm</td>
    <td>Mã sp</td>
    <td>Hình ảnh</td>
   
    <td>Tình trạng</td>
    <td colspan="2">Quản lý</td>
  </tr>
  <?php
  $i=1;
  while($dong=mysql_fetch_array($row_lietkesp)){

  ?>
  <tr>
    <td><?php  echo $i;?></td>
    <td><?php echo $dong['tentintuc'] ?></td>
    <td><?php echo $dong['matin'] ?></td>
    <td><img src="modules/quanlytintuc/uploads/<?php echo $dong['hinhanh'] ?>" width="80" height="80" /></td>
    
    <td><?php $sql_tinhtrang = "select tinhtrang from tintuc";
	$row_tinhtrang = mysql_query($sql_tinhtrang);
	$dong_tinhtrang=mysql_fetch_array($row_tinhtrang);
	if($dong_tinhtrang['tinhtrang'] == 1 ){
		echo 'Kích hoạt';
	}elseif($dong_tinhtrang['tinhtrang'] ==2){
		echo 'Không kích hoạt';
	}
    ?></td>
    <td><a  href="index.php?quanly=tintuc&ac=sua&id=<?php echo $dong['idtintuc'] ?>"><center><img src="../imgs/edit.png" width="30" height="30" /></center></a></td>
    <td><a class="delete_link" href="modules/quanlytintuc/xuly.php?id=<?php echo $dong['idtintuc']?>"><center><img src="../imgs/delete.png" width="30" height="30" /></center></a></td>
  </tr>
  <?php
  $i++;
  }
  ?>
</table>
