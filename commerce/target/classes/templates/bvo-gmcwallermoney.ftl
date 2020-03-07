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
</style>
<body>

	<div id="main-content" class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="page-header position-relative">
				<h1 style="color: #2679b5;">
					借卖方 <small><i class="icon-double-angle-right"></i> 账户余额</small>
				</h1>
			</div>

			<table id="table_bug_report"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Account Name</th>
						<th>Available Money</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<input type="hidden" id="sid" value="${waller.sid}">
						<td><a href="#">${waller.sa_name}</a></td>
						<td><span>$</span>${waller.sa_money}</td>
						<td class="center">
						<input type="hidden" id="said" name="said" value="${waller.sa_id}">
							<div class="inline position-relative">
								<button class="btn btn-mini btn-info tixian" data-toggle="modal"
									data-target="#myModal">deposit</button>

							</div>
						</td>
					</tr>

				</tbody>
			</table>
			<div class="inline position-relative">
				<button class="btn btn-mini btn-info" data-toggle="modal"
					data-target="#myModal1">Change Password</button>
				<button class="btn btn-mini btn-info history">Record</button>
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
							<h4 class="modal-title" id="myModalLabel">Deposit Account</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal">

								<div class="control-group">
									<label class="control-label">Deposit Amount：$</label>
									<div class="controls">

										<input id="money" type="text" name="money"></input>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Password：</label>
									<div class="controls">
										<input type="password" id="sa_pwd" name="sa_pwd">
									</div>
								</div>
								<input type="hidden" name="sa_id" id="sa_id"></input>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">cancel</button>
							<button type="button" class="btn btn-primary queren"
								data-dismiss="modal" id="deposit">confirm</button>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal -->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Change Password</h4>
						</div>
						<div class="modal-body">
							<form id="modifyform" class="form-horizontal"
								action="/modifyDebitPassword" method="post">

								<div class="control-group">
									<label class="control-label" for="form-field-1">old
										password：</label>
									<div class="controls">
										
										<input type="password" id="form-field-1" name="sa_pwd" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="form-field-1">new
										password：</label>
									<div class="controls">
										<input type="password" id="form-field-1" name="newpassword" />
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">cancel</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="modify()">confirm</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
       $(function(){
     /*  
      $("#deposit").click(function () {
          //var id = $("#sa_id").val();
          var sa_pwd = $("#sa_pwd").val();
          //var sa_money = $("#sa_money").val();
          var money = $("#money").val();
          //alert(money);
          location.href="/debitWallerDeposit?sa_pwd="+sa_pwd+"&money="+money;
        }); */


        $('.history').click(function(){
          var sid = $("#sid").val();
          //alert(id);
          window.location.href = "/backDebitTurnOver/"+sid;
        })

}) 

$(function() {
		$('.tixian').click(
				function() {
					var sa_id=$(this).parents("tr").children("td").eq(2).find("input[type=hidden]").val();
					document.getElementById("sa_id").value= $(this).parents("tr").children("td").eq(2).find("input[type=hidden]").val();
				})
				
		$('.queren').click(function() {
					var money=$(" input[ name='money' ] ").val();
					var sa_id=$(" input[ name='sa_id' ] ").val();
					var sa_pwd=$(" input[ name='sa_pwd' ] ").val();
				
					$.ajax({
			            type:'post',
			            contentType:'application/json;charset=utf-8',
			            url:'/debitWallerDeposit',
			            data:'{"money":"'+money+'","sa_id":"'+sa_id+'","sa_pwd":"'+sa_pwd+'"}',
			            dataType:'text',
			            success:function (data) {
			            	if(data=="密码不正确"){
			            		 alert(data); 
			            	}     	
			            	else if(data=="移交管理员审核"){
			            		alert(data); 
			            	}
			              window.location.href = "bvo-gmcwallermoney"
			                
			            }
			        	}) 		        
				})
	})



function modify() {
    var form_date = $("#modifyform").serialize();
    window.location.href="/modifyDebitPassword?"+form_date;
  }


    </script>
</body>
</html>
