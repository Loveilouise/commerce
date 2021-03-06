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
<style type="text/css">
body, html {
	width: 100%;
	height: 100%;
	background: #fff;
}

.goodscontent p {
	font-size: 24px;
	line-height: 40px;
}

.store {
	border: 1px solid #ccc;
	border-radius: 10px;
	margin: 20px 0 20px 0;
	padding-left: 3%;
}

.store h3 {
	line-height: 40px;
}

.store p {
	line-height: 40px;
	color: #666;
	border-top: 1px solid #ccc;
}
</style>
</head>
<body>

	<div id="main-content" class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="goodscontent">
				<p>My stores</p>
				<div class="store">
					<h3 class="blue">eBay</h3>
					
					<#list ebaylist as e>
					<p><a href="/bvo-showstoregoods/${e.store_id}">${e.store_name}</a></p>
					</#list>
					
					

				</div>
				<div class="store">
					<h3 class="blue">Amazon</h3>
					
					<#list amazonlist as a>
					<p><a href="/bvo-showstoregoods/${a.store_id}">${a.store_name}</a></p>
					</#list>
					
				</div>

				<div style="text-align: right">
					<button class="btn btn-primary addshop">Add a new store</button>
				</div>

			</div>
		</div>
	</div>
</body>
<script src="js/jquery-1.9.1.js"></script>
<script>
      $('.addshop').click(function(){
    	 	
        window.location.href = "/bvo-shops";
      })

    </script>
</html>
