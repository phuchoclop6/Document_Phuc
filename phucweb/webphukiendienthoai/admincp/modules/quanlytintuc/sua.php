<?php
	$sql = "select * from tintuc where idtintuc='$_GET[id]' ";
	$row=mysql_query($sql);
	$dong=mysql_fetch_array($row);
 ?>
<div class="button_themsp">
<a href="index.php?quanly=tintuc&ac=lietke">Liệt kê tin tức</a> 
</div>
<form action="modules/quanlytintuc/xuly.php?id=<?php echo $dong['idtintuc'] ?>" method="post" enctype="multipart/form-data">
<h3>&nbsp;</h3>
<table width="600" border="1">
  <tr>
    <td colspan="2"  style="text-align:center;font-size:25px;">Sửa tin tức</td>
  </tr>
  <tr>
    <td width="97">Tên tin tuc</td>
    <td width="87"><input type="text" name="tentintuc" value="<?php echo $dong['tentintuc'] ?>"></td>
  </tr>
  <tr>
    <td>Mã SP</td>
    <td><input type="text" name="matin" value="<?php echo $dong['matin'] ?>"></td>
  </tr>
  <tr>
    <td>Hình ảnh</td>
    <td><input type="file" name="hinhanh" /><img src="modules/quanlytintuc/uploads/<?php echo $dong['hinhanh'] ?>" width="80" height="80"></td>
  </tr>
  <tr>
    <td>Nội dung</td>
    <td><textarea name="noidung" cols="40" rows="10"><?php echo $dong['noidung'] ?></textarea></td>
  </tr>
 
 
  <tr>
    <td>Tình trạng</td>
    <td><select name="tinhtrang">
   
    <option value="1">Kích hoạt</option>
     <option value="2">Không kích hoạt</option>
    </select></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">
      <input type="submit" name="sua" value="Sửa sản phẩm">
    </div></td>
  </tr>
</table>
</form>


