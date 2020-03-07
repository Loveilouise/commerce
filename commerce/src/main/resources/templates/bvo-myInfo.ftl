<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/ace.min.css">
<link rel="stylesheet" href="css/ace-skins.min.css">
<link rel="stylesheet" href="css/ace-responsive.min.css">

</head>
<style>
body, html {
	width: 100%;
	height: 100%;
	background: #fff;
}

.inputName {
	width: 50%;
	margin: 0 auto;
	font-size: 20px;
}
</style>
<body>

	<div id="main-content" class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="page-header position-relative">
				<h1 style="color: #2679b5;">
					借卖方<small><i class="icon-double-angle-right"></i> 我的信息</small>
				</h1>
			</div>


			<div class="inputName">
				<div style="margin-bottom: 40px">
					Username:<#if
						Session["seller"]?exists> ${Session["seller"].sname} </#if>
					
					</div>
				<div>
					<label class="green">Name:</label> <input type="text" name="sname" value="${Session["seller"].sname}">
				</div>
				<div>
					<label class="green">Email:</label> <input type="text"	name="semail" value="${Session["seller"].semail}">
				</div>
				<div>
					<label class="green">Phone:</label> <input type="text" name="sphone" value="${Session["seller"].sphone}">
				</div>
				<button class="btn  btn-success save">save</button>
				<button class="btn  btn-pink" onclick="myshop()">My Stores</button>


			</div>

		</div>
	</div>



</body>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>
<script type="text/javascript">
	function myshop() {
		window.location.href = "/bvo-goodsstoreAdd";
	} 
	$(function(){
		$('.save').click(function(){
			var sname=$(" input[ name='sname' ] ").val();
			var semail=$(" input[ name='semail' ] ").val();
			var sphone=$(" input[ name='sphone' ] ").val();
			//alert(sname+semail+sphone+"hdhdhdhh");
			$.ajax({
            type:'post',
            contentType:'application/json;charset=utf-8',
            url:'/save',
            data:'{"sname":"'+sname+'","semail":"'+semail+'","sphone":"'+sphone+'"}',
            success:function (data) {
                bootbox.alert("修改个人信息成功");
            }
        	}) 
		}) 
	})
</script>
</body>
</html>
