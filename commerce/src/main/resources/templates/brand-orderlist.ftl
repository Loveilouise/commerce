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
    body,html{
      width: 100%;
      height: 100%;
      background: #fff;
    }

    .info div{
        float: right;
    }

  </style>
    <body>

    <div id="main-content" class="clearfix">
  <div id="page-content" class="clearfix">

    <div class="page-header position-relative">
      <h1 style="color: #2679b5;">品牌商<small><i class="icon-double-angle-right"></i> 订单管理</small></h1>
    </div>
    <form action="queryByTitle" method="post" id="form-search" >
      	商品标题：
      	
      <input type="text" class="input-medium search-query" name="gname">
      <button onclick="search()" class="btn btn-purple btn-small">Search <i class="icon-search icon-on-right"></i></button>
    </form>

	<h4 style="color:red">${content}</h4><br>
    <div class="tabbable">
      <ul class="nav nav-tabs" id="myTab">
        <li class="active"><a data-toggle="tab" href="#AwaitingPayment"> 待支付</a></li>
        <li class="a"><a data-toggle="tab" href="#AwaitingShipment"> 待发货</a></li>
        <li class="b"><a data-toggle="tab" href="#shipped">已发货</a></li>
        <li class="c"><a data-toggle="tab" href="#complete">已完成</a></li>
        <li class="d"><a data-toggle="tab" href="#canceled">已取消</a></li>
      </ul>
      <div class="tab-content">
        <div id="AwaitingPayment" class="tab-pane active">
          <p>
          <table id="table_bug_report" class="table table-striped table-bordered table-hover">
          <thead>
            <tr>
            <th class="center">
              <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
            </th>
            <th>商品标题</th>
            <th>价格</th>
            <th class="hidden-480">数量</th>
            <th>sku</th>
             <th class="hidden-480">订单编号</th>
             <th class="hidden-480">订单创建时间</th>
            </tr>
          </thead>

          <tbody>
          <#list paylist as pay>
           	<tr>
           		<td class="center"><label><input type="checkbox" class="input"><span class="lbl"></span></label></td>
           		<td>${pay.good.gname}</td>
           		<td>${pay.good.gprice}</td>
           		<td class="hidden-480">${pay.ocounts}</td>
           		<td>${pay.good.gsku}</td>       		
           		<td class="hidden-480">${pay.orderno}</td>
           		<td class="hidden-480">${pay.createtime}</td>
           	</tr>
			</#list>
             </tbody>
            </table>
          </p>
        </div>
        <div id="AwaitingShipment" class="tab-pane">
          <p>
          <table id="table_bug_report" class="table table-striped table-bordered table-hover">
          <thead>
            <tr>
            <th class="center">
              <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
            </th>
            <th>商品标题</th>
            <th>价格</th>
            <th class="hidden-480">数量</th>
            <th>sku</th>
            <th class="hidden-480">订单编号</th>
            <th class="hidden-480">订单创建时间</th>
            <th>操作</th>
            </tr>
          </thead>

          <tbody>
            
            <#list sendlist as send>
            <tr>
              <td class="center">
                <label><input type="checkbox" class="input"><span class="lbl"></span></label>
              </td>
           		<td>${send.good.gname}</td>
           		<td>${send.good.gprice}</td>
           		<td class="hidden-480">${send.ocounts}</td>
           		<td>${send.good.gsku}</td>       		
           		<td class="hidden-480">${send.orderno}</td>
           		<td class="hidden-480">${send.createtime}</td>
           		<td>
           		<input type="hidden" value="${send.oid}" name="oid">
                <button class="btn btn-minier btn-purple send-out" >发货</button>
              </td>
              </tr>
              </#list>
           			
            </tbody>
            </table>
          </p>
        </div>
        <div id="shipped" class="tab-pane">
          <p>
            <table id="table_bug_report" class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th class="center">
                    <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                  </th>
                  <th>商品标题</th>
                  <th>价格</th>
                  <th class="hidden-480">数量</th>
                  <th>sku</th>
                  <th>订单编号</th>
                  <th class="hidden-480">订单创建时间</th>
                  <th class="hidden-480">物流跟踪号</th>
                  <th>操作</th>
                </tr>
              </thead>

              <tbody>
				<#list sendlist2 as send>
               <tr>
              <td class="center">
                <label><input type="checkbox" class="input"><span class="lbl"></span></label>
              </td>
           		<td>${send.good.gname}</td>
           		<td>${send.good.gprice}</td>
           		<td class="hidden-480">${send.ocounts}</td>
           		<td>${send.good.gsku}</td>       		
           		<td class="hidden-480">${send.orderno}</td>
           		<td class="hidden-480">${send.createtime}</td>
           		<td class="hidden-480"><a href="brand-ordertracking.ftl">${send.trackingno}</a></td>	
           		<td><input type="hidden" value="${send.oid}" name="oid">
           		<button class="btn btn-minier btn-yellow cancel">取消</button></td>
              </#list>
           	</tr>
                     
              </tbody>
            </table>
          </p>
        </div>
       <div id="complete" class="tab-pane">
          <p>
            <table id="table_bug_report" class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th class="center">
                    <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                  </th>
                  <th>商品标题</th>
                  <th>价格</th>
                  <th class="hidden-480">数量</th>
                  <th>sku</th>
                  <th>订单编号</th>
                  <th class="hidden-480">订单创建时间</th>
                  <th class="hidden-480">物流跟踪号</th>
                </tr>
              </thead>
              <tbody>
              <#list finishlist as finish>
                <tr>
                  <td class="center">
                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
                  </td>
	           		<td>${finish.good.gname}</td>
	           		<td>${finish.good.gprice}</td>
	           		<td class="hidden-480">${finish.ocounts}</td>
	           		<td>${finish.good.gsku}</td>       		
	           		<td class="hidden-480">${finish.orderno}</td>
	           		<td class="hidden-phone">${finish.createtime}</td>
	           		<td class="hidden-480"><a href="brand-ordertracking.ftl">${finish.trackingno}</a></td>
	              
	              </tr>
	              </#list>
               </tbody>
            </table>
          </p>
        </div>
       <div id="canceled" class="tab-pane">
          <p>
            <table id="table_bug_report" class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th class="center">
                    <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
                  </th>
                  <th>商品标题</th>
                  <th>价格</th>
                  <th class="hidden-480">数量</th>
                  <th>sku</th>
                  <th>订单编号</th>
                  <th class="hidden-480">订单创建时间</th>
                </tr>
              </thead>

              <tbody>
              <#list cancellist as cancel>
               		<tr>
	                  <td class="center">
	                    <label><input type="checkbox" class="input"><span class="lbl"></span></label>
	                  </td>       
		           		<td>${cancel.good.gname}</td>
		           		<td>${cancel.good.gprice}</td>
		           		<td class="hidden-480">${cancel.ocounts}</td>
		           		<td>${cancel.good.gsku}</td>       		
		           		<td class="hidden-480">${cancel.orderno}</td>
		           		<td class="hidden-phone">${cancel.createtime}</td>
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
    <script src="js/bootbox.min.js"></script>

    <script>

      $(function(){
	        $('.ace-checkbox-2').each(function(){
	              $('.ace-checkbox-2').change(function(){
	                if($(this).prop('checked')){
	                 $(this).parents('.tab-pane').find('.input').prop('checked',true);
	               }else{
	                $(this).parents('.tab-pane').find('.input').prop('checked',false);
	              }
	          })
	
	        })
	        $('.send-out').click(function(){
	          var oid=$(" input[ name='oid'] ").val();
	          var status=2;
	       	   $.ajax({
                type:'post',
                contentType:'application/json;charset=utf-8',
                url:'${PageContext.request.contextPath}/send',
                data:'{"oid":"'+oid+'","ostatus":"'+status+'"}',
                success:function (data) {
                    bootbox.alert("已发货!");
                    window.location.reload();   
                }
            })      
	         
	        })
	        $('.cancel').click(function(){
	          var oid=$(" input[ name='oid'] ").val();
	          var status=4;	          
	       	   $.ajax({
                type:'post',
                contentType:'application/json;charset=utf-8',
                url:'${PageContext.request.contextPath}/cancel',
                data:'{"oid":"'+oid+'","ostatus":"'+status+'"}',
                success:function (data) {       
                	bootbox.alert("订单已取消!");  
                	window.location.reload();   		 
                }
            })      
	          
	        })        
    })
	function search(){
		document.getElementById("form-search").submit();
	}
	

    </script>
    </body>
</html>
