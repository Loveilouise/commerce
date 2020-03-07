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
<link rel="stylesheet" href="webuploader/webuploader.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<style type="text/css">
body, html {
	width: 100%;
	height: 100%;
	background: #fff;
}

.Register {
	width: 50%;
	margin: auto;
}
</style>
</head>
<body>

	<div id="main-content" class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="page-header position-relative">
				<h1 style="color: #2679b5;">
					借卖方<small><i class="icon-double-angle-right"></i> 钱包账号注册</small>
				</h1>
			</div>
			
				<div class="Register">
					<div>
						<label class="green">Account Name:</label><input type="text"
							name="sa_name" />
					</div>
					<div>
						<label class="green">Email:</label><input type="text"
							name="sa_email" />
					</div>
					
					<div>
						<label class="green">Password:</label><input type="password"
							name="sa_pwd" />
					</div>
					<button class="btn  btn-success save" onclick="gotoWalletLogin()">sign up</button>
                <button class="btn  btn-success login" onclick="gotoWallet()">login in</button>
				</div>
			
		</div>
	</div>

	<script type="text/javascript">
	
	
	function gotoWalletLogin(){
    	var sa_name=$(" input[ name='sa_name' ] ").val();
		var sa_email=$(" input[ name='sa_email' ] ").val();
		var sa_pwd=$(" input[ name='sa_pwd' ] ").val();
        window.location.href = "/depositwallersignup?sa_name="+sa_name+"&sa_email="+sa_email+"&sa_pwd="+sa_pwd;
    }
    
    function gotoWallet(){
    	var sa_name=$(" input[ name='sa_name' ] ").val();
		var sa_email=$(" input[ name='sa_email' ] ").val();
		var sa_pwd=$(" input[ name='sa_pwd' ] ").val();
		  window.location.href = "/loginSellerAccount?sa_name="+sa_name+"&sa_email="+sa_email+"&sa_pwd="+sa_pwd;
    }
	</script>
</body>
</html>
