
<div class="button_themsp">
<a href="index.php?quanly=tintuc&ac=lietke">Liệt kê tin tức</a></div>
<form action="modules/quanlytintuc/xuly.php" method="post" enctype="multipart/form-data">
<h3>&nbsp;</h3>
<table width="600" border="1">
  <tr>
    <td colspan="2"  style="text-align:center;font-size:25px;">Thêm tin tức</td>
  </tr>
  <tr>
    <td width="97">Tên tin tức</td>
    <td width="87"><input type="text" name="tentintuc"></td>
  </tr>
  <tr>
    <td>Mã tin</td>
    <td><input type="text" name="matin"></td>
  </tr>
  <tr>
    <td>Hình ảnh</td>
    <td><input type="file" name="hinhanh" /></td>
  </tr>
  <tr>
    <td>Nội dung</td>
    <td><textarea name="noidung" cols="40" rows="10"></textarea></td>
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
      <input type="submit" name="them" value="Thêm tin">
    </div></td>
  </tr>
</table>
</form>


