<?php
	$sql_loai="select * from loaisp order by idloaisp asc";
	$row_loai=mysqli_query($sql_loai);
?>
<div class="box_list">
            <div class="tieude">
            	<h3>Loại phụ kiện</h3>
            </div>
            	<ul class="list">
                <?php
				while($dong_loai=mysqli_fetch_array($row_loai)){
				?>
                	<li><a href="index.php?quanly=loaisp&id=<?php echo $dong_loai['idloaisp'] ?>"><?php echo $dong_loai['tenloaisp'] ?></a></li>
                  <?php
				}
				  ?>
                </ul>
                </div><!--Ket thuc div box loai phu kien -->
               <?php
	$sql_hieu="select * from hieusp order by idhieusp asc";
	$row_hieu=mysqli_query($sql_hieu);
?>
                <div class="box_list">
            <div class="tieude">
            	<h3>Thương hiệu</h3>
            </div>
            	<ul class="list">
                <?php
				while($dong_hieu=mysqli_fetch_array($row_hieu)){
				?>
                	<li><a href="index.php?quanly=hieusp&id=<?php echo $dong_hieu['idhieusp'] ?>"><?php echo $dong_hieu['tenhieusp'] ?></a></li>
                  <?php
				}
				  ?>
                </ul>
                </div><!--Ket thuc div box thuong hieu -->
                 <div class="box_list">
                 
                   <div class="tieude">
            	<h3>Hàng bán chạy</h3>
            		</div>
                    <?php
					$sql_banchay=mysqli_query("select * from sanpham order by idsanpham desc limit 8");
					
					?>
            	<ul class="hangbanchay">	
                <?php
				while($dong_banchay=mysqli_fetch_array($sql_banchay)){
				?>
                	<li><a href="?quanly=chitietsp&idloaisp=<?php echo $dong_banchay['loaisp'] ?>&id=<?php echo $dong_banchay['idsanpham'] ?>">
                    	<img src="admincp/modules/quanlysanpham/uploads/<?php echo $dong_banchay['hinhanh'] ?>" width="150" height="150" />
                    	<p><?php echo $dong_banchay['tensp'] ?></p>
                        <p style="color:red;"><?php echo number_format($dong_banchay['giadexuat']).' '.'VNĐ' ?></p>
                    </a></li>
                    <?php
				}
					?>
                </ul>
                </div><!--Ket thuc div box hang ban chay -->
                 <div class="box_list">
                 <?php
				 	$sql=mysqli_query("select * from tintuc");
					
				 ?>
                   <div class="tieude">
            	<h3>Tin tức sản phẩm</h3>
            		</div>
            	<ul class="tintucsp">	
                <?php
				while($dong_tin=mysqli_fetch_array($sql)){
				?>
                	<li><a href="#">
                    	<p style="float:left;"><img src="admincp/modules/quanlytintuc/uploads/<?php echo $dong_tin['hinhanh'] ?>" width="40" height="30" /></p>
                        <p style="overflow:hidden;padding-left:5px;"><?php echo $dong_tin['tentintuc'] ?></p>
                    </a></li>
                    <?php
				}
					?>
                </ul>
                </div><!--Ket thuc div box tin tức -->
