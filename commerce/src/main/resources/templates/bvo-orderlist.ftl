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
					借卖方<small><i class="icon-double-angle-right"></i> 订单管理</small>
				</h1>
			</div>


			<div class="form-search">
				Title：<input type="text" name="find_gname" id="find_gname"
					class="input-medium search-query" />
				<button type="submit" class="btn  btn-purple btn-small  find-out"
					data-toggle="modal" data-target="#myModal">
					Search <i class="icon-search icon-on-right"></i>
				</button>
			</div>
			<div>

		 
				<a href="/bvo-orderlist" class="btn  btn-success"
					style="margin-bottom: 30px"> <i class="icon-refresh"></i> Pull
					Orders
				</a>

				<!--搜索结果弹框-->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">搜索结果</h4>
							</div>
							<div class="modal-body">
								<table id="table_bug_report"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Title</th>
											<th>Price</th>
											<th class="hidden-480">QTY</th>
											<th>Sku</th>
											<th class="hidden-480">OrderNo</th>
											<th class="hidden-480">Total</th>
											<th class="hidden-480">TrackingNo</th>
											<th>Status</th>
										</tr>
									</thead>

									<tbody id="table_orders">

										<tr>
											<td>1111</td>
											<td>1111</td>
											<td>1111</td>
											<td>1111</td>
											<td>1111</td>
											<td>1111</td>
											<td>1111</td>
											<td>1111</td>
										</tr>

									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>



				<div class="tabbable">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active"><a data-toggle="tab"
							href="#AwaitingPayment"> Awaiting Payment</a></li>
						<li class=""><a data-toggle="tab" href="#AwaitingShipment">
								Awaiting Shipment</a></li>
						<li class=""><a data-toggle="tab" href="#shipped">Shiped</a></li>
						<li class=""><a data-toggle="tab" href="#complete">Completed
								Orders</a></li>
						<li class=""><a data-toggle="tab" href="#canceled">Cancelled
								Orders</a></li>
					</ul>
					<div class="tab-content">

						<!--等待支付-->
						<div id="AwaitingPayment" class="tab-pane active">
							<p>
							<table id="table_bug_report"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label><input type="checkbox"
												class="ace-checkbox-2"><span class="lbl"></span></label></th>
										<th>Title</th>
										<th>Price</th>
										<th class="hidden-480">QTY</th>
										<th>Sku</th>
										<th class="hidden-480">Order No</th>
										<th class="hidden-480">Total</th>
										<th></th>
									</tr>
								</thead>

								<tbody>
									<#list awaitPayOrders as a>
									<tr>
										<td class="center"><label><input type="checkbox"
												class="input"><span class="lbl"></span></label></td>
										<td><a href="bvo-goodsdetail.ftl">${a.good.gname}</a></td>
										<td>${a.good.gprice?c}</td>
										<td class="hidden-480">${a.ocounts}</td>
										<td class="hidden-phone">${a.good.gsku}</td>
										<td class="hidden-480">${a.orderno}</td>
										<td>${a.ocost?c}</td>
										<td><a href="/bvo-orderPayment/${a.oid}">Pay Now</a></td>
									</tr>
									</#list>
								</tbody>
							</table>
							</p>
						</div>

						<!--等待发货-->
						<div id="AwaitingShipment" class="tab-pane">
							<p>
							<table id="table_bug_report"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label><input type="checkbox"
												class="ace-checkbox-2"><span class="lbl"></span></label></th>
										<th>Title</th>
										<th>Price</th>
										<th class="hidden-480">QTY</th>
										<th>Sku</th>
										<th>Order No</th>
										<th class="hidden-480">Total</th>
									</tr>
								</thead>


								<tbody>
									<#list awaitShipOrders as aso>
									<tr>
										<td class="center"><label><input type="checkbox"
												class="input"><span class="lbl"></span></label></td>
										<td><a href="bvo-goodsdetail.ftl">${aso.good.gname}</a></td>
										<td>${aso.good.gprice}</td>
										<td>${aso.ocounts}</td>
										<td>${aso.good.gsku}</td>
										<td>${aso.orderno}</td>
										<td>${aso.ocost}</td>
									</tr>
									</#list>
								</tbody>
							</table>
							</p>
						</div>

						<!--已发货-->
						<div id="shipped" class="tab-pane">
							<p>
							<table id="table_bug_report"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label><input type="checkbox"
												class="ace-checkbox-2"><span class="lbl"></span></label></th>
										<th>Title</th>
										<th>Price</th>
										<th>QTY</th>
										<th>Sku</th>
										<th>Total</th>
										<th>Order No</th>
										<th>Tracking No</th>
									</tr>
								</thead>


								<tbody>
									<#list shipedOrders as so>
									<tr>
										<td class="center"><label><input type="checkbox"
												class="input"><span class="lbl"></span></label></td>
										<td><a href="bvo-goodsdetail.ftl">${so.good.gname}</a></td>
										<td>${so.good.gprice}</td>
										<td>${so.ocounts}</td>
										<td>${so.good.gsku}</td>

										<td>${so.ocost}</td>
										<td>${so.orderno}</td>
										<td><a href="bvo-ordertracking.ftl">${so.trackingno}</a></td>
									</tr>
									</#list>
								</tbody>
							</table>
							</p>
						</div>

						<!--已完成-->
						<div id="complete" class="tab-pane">
							<p>
							<table id="table_bug_report"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label><input type="checkbox"
												class="ace-checkbox-2"><span class="lbl"></span></label></th>
										<th>Title</th>
										<th>Price</th>
										<th>QTY</th>
										<th>Sku</th>
										<th>Total</th>
										<th>Order No</th>
										<th>Tracking No</th>

									</tr>
								</thead>

								<tbody>
									<#list finishedOrders as co>
									<tr>
										<td class="center"><label><input type="checkbox"
												class="input"><span class="lbl"></span></label></td>
										<td><a href="bvo-goodsdetail.ftl">${co.good.gname}</a></td>
										<td>${co.good.gprice}</td>
										<td class="hidden-480">${co.ocounts}</td>
										<td>${co.good.gsku}</td>
										<td>${co.ocost}</td>
										<td>${co.orderno}</td>
										<td class="hidden-480"><a href="bvo-ordertracking.ftl">${co.trackingno}</a></td>

									</tr>
									</#list>
								</tbody>
							</table>
							</p>
						</div>

						<!--取消的-->
						<div id="canceled" class="tab-pane">
							<p>
							<table id="table_bug_report"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label><input type="checkbox"
												class="ace-checkbox-2"><span class="lbl"></span></label></th>
										<th>Title</th>
										<th>Price</th>
										<th class="hidden-480">QTY</th>
										<th>Sku</th>
										<th class="hidden-480">Total</th>
										<th class="hidden-480">Order No</th>
									</tr>
								</thead>

								<tbody>
									<#list cancelledOrders as cco>
									<tr>
										<td class="center"><label><input type="checkbox"
												class="input"><span class="lbl"></span></label></td>
										<td><a href="bvo-goodsdetail.ftl">${cco.good.gname}</a></td>
										<td>${cco.good.gprice}</td>
										<td class="hidden-480">${cco.ocounts}</td>
										<td>${cco.good.gsku}</td>
										<td>${cco.ocost}</td>
										<td>${cco.orderno}</td>
									</tr>
									</#list>
								</tbody>
							</table>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>


	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(function() {

			$('.ace-checkbox-2').each(
					function() {
						$('.ace-checkbox-2')
								.change(
										function() {
											if ($(this).prop('checked')) {
												$(this).parents('.tab-pane')
														.find('.input')
														.prop('checked', true);
											} else {
												$(this).parents('.tab-pane')
														.find('.input').prop(
																'checked',
																false);
											}
										})
					})
					       

        
		     /**
           * 查找
           */
          $('.find-out').click(function(){

              var gname  = $('input[name=find_gname]').val();
              $.ajax({
                  type: 'post',
                  contentType: 'application/json;charset=utf-8',
                  url: "find",
                  data:'{  "gname":"' + gname +'"}',
                  success: function (result) {
                      if (result.code === '200') {
                          var trTxt = "";
                          for (var i = 0; i < result.data.length; i++) {
                              var orders = result.data[i];
                              trTxt += "<tr>\n" +
                                  "                                <td>" + orders.good.gname + "</td>\n" +
                                  "                                <td>" +orders.good.gprice + "</td>\n" +
                                  "                                <td>" +orders.ocounts + "</td>\n" +
                                  "                                <td>" +orders.good.gsku + "</td>\n" +
                                  "                                <td>" +orders.orderno + "</td>\n" +
                                  "                                <td>" +orders.ocost + "</td>\n" +
                                  "                                <td>" +orders.trackingno + "</td>\n";
                              if(orders.ostatus===0)
                              {
                                  trTxt+="<td>待支付</td>";
                              }else if(orders.ostatus ===1)
                              {
                                  trTxt+="<td>待发货</td>";
                              }else if(orders.ostatus ===2)
                              {
                                  trTxt+="<td>已发货</td>";
                              }else if(orders.ostatus ===3)
                              {
                                  trTxt+="<td>已完成</td>";
                              }else {

                                  trTxt+="<td>已取消</td>";
                              }

                              trTxt+="</tr>";

                          }
                          $("#table_orders").html(trTxt);
                      }

                  }
              })

          })

		})
	</script>

</body>
</html>
