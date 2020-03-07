<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/ace.min.css">
<link rel="stylesheet" href="css/ace-skins.min.css">
<link rel="stylesheet" href="css/ace-responsive.min.css">
<style>
body, html {
	width: 100%;
	height: 100%;
	background: #fff;
}

.info div {
	float: right;
}

a {
	color: #fff;
}

a:hover {
	color: #fff;
}
</style>
<body>

	<div id="main-content" class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="page-header position-relative">
				<h1 style="color: #2679b5;">
					品牌商 <small><i class="icon-double-angle-right"></i> 账户余额</small>
				</h1>
			</div>
			<table id="table_bug_report"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>账户</th>
						<th>余额</th>
						<th class="center">操作</th>
					</tr>
				</thead>

				

				<tbody>
					<tr>
						<td>${account.ca_name}</td>
						<td><span>$</span>${account.ca_money}</td>
						<td class="center">
							<input type="hidden" id="caid" name="caid" value="${account.ca_id}">
							<div class="inline position-relative" data-toggle="modal"
								data-target="#myModal">
								<button class="btn btn-mini btn-info tixian" >提现</button>
							</div>
						</td>
						
					</tr>

				</tbody>
				

			
			</table>
			<div class="inline position-relative">
				<button class="btn btn-mini btn-info">
					<a href="brand-gmcwallerAcountlist.ftl">提现流水</a>
				</button>
			</div>


			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">提现</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal">

								<div class="control-group">
									<label class="control-label" for="form-field-1">提现：$</label>
									<div class="controls">
										<input type="text" id="form-field-1" name="money">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="form-field-1">密码：</label>
									<div class="controls">
										<input tid="form-field-1" type="password" name="ca_pwd">
									</div>
								</div>
								<input type="hidden" name="ca_id" id="ca_id"></input>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary queren"
								data-dismiss="modal">确认</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.min.js"></script>
	<script type="text/javascript">
	
	/* function queren(){
		var money=$(" input[ name='money' ] ").val();
		var ca_id=$(" input[ name='ca_id' ] ").val();
		var ca_pwd=$(" input[ name='ca_pwd' ] ").val();
        window.location.href = "/updateMoney?money="+money+"&ca_id="+ca_id+"&ca_pwd="+ca_pwd;
    }
     */
	
	$(function() {
		$('.tixian').click(
				function() {
					var ca_id=$(this).parents("tr").children("td").eq(2).find("input[type=hidden]").val();
					document.getElementById("ca_id").value= $(this).parents("tr").children("td").eq(2).find("input[type=hidden]").val();
				})
				
		$('.queren').click(function() {
					var money=$(" input[ name='money' ] ").val();
					var ca_id=$(" input[ name='ca_id' ] ").val();
					var ca_pwd=$(" input[ name='ca_pwd' ] ").val();
				
					$.ajax({
			            type:'post',
			            contentType:'application/json;charset=utf-8',
			            url:'/updateMoney',
			            data:'{"money":"'+money+'","ca_id":"'+ca_id+'","ca_pwd":"'+ca_pwd+'"}',
			            dataType:'text',
			            success:function (data) {
			            	if(data=="密码不正确"){
			            		 alert(data); 
			            	}
			            	else if(data=="余额不足"){
			            		alert(data); 
			            	}
			            	else if(data=="移交管理员审核"){
			            		alert(data); 
			            	}
			              window.location.href = "brand-gmcwallerAcount"
			                
			            }
			        	}) 		        
				})
	})

	
	</script>
</body>
</html>
