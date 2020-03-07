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
    <link rel="stylesheet" href="webuploader/webuploader.css">
  <style>
    body,html{
      background: #fff;
      width: 100%;
      height: 100%;
    }
      a:hover{
        cursor: pointer;
      }



  </style>
    <body>

<div id="main-content" class="clearfix">
    <div id="page-content" class="clearfix">

    <div class="page-header position-relative">
      <h1 style="color: #2679b5;">管理员<small><i class="icon-double-angle-right"></i> 提现审核</small></h1>
    </div>
    <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th class="center">
            <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
          </th>
          <th>账户名</th>
          <th>业务类型</th>
          <th class="hidden-480">金额</th>
          <th class="hidden-phone">申请时间</th>
          <th>状态</th>
          <th>操作</th>
        </tr>
      </thead>

      <tbody>

		<#list calist as c >
        <tr>
          <td class="center">
            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
          </td>
          <td>${c.ca.ca_name}
          <input type="hidden" name="cid" value="${c.ca.cid}">
          </td>
          <td id="type">${c.cr_type}
          	
          </td>
          <td class="hidden-480">${c.cr_money?c}</td>
          <td class="hidden-phone">${c.cr_time}</td>
          <td class="state">
          	<#if c.cr_status==0>    等待审核
          	<#elseif c.cr_status==1> 审核通过
          	<#elseif c.cr_status==2> 未通过审核
         	</#if>
          </td>
          <td>

              <a class="aa" data-toggle="modal"  data-target="#myModal">审核</a>

          </td>
        </tr>
		</#list>
		<#list salist as s >
        <tr>
          <td class="center">
            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
          </td>
          <td >${s.sa.sa_name}
          	<input type="hidden" name="sid" value="${s.sa.sid}">
          </td>
          <td id="type">${s.sr_type}
          	
          </td>
          <td class="hidden-480">${s.sr_money?c}</td>
          <td class="hidden-phone">${s.sr_time}</td>
          <td class="state">
          	<#if s.sr_status==0>    等待审核
          	<#elseif s.sr_status==1> 审核通过
          	<#elseif s.sr_status==2> 未通过审核
         	</#if>
         </td>
          <td>
              <a class="aa" data-toggle="modal"  data-target="#myModal">审核</a>

          </td>
        </tr>
        </#list>
      </tbody>
    </table>


        <!--modal-->
        <div class="modal fade in hide" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title" id="myModalLabel">审核</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div style="text-align: center">
                                <label style="display: inline-block;margin-right: 20px">
                                    <input name="form-field-radio" type="radio" value="1"><span class="lbl"> 通过</span>
                                </label>
                                <label style="display: inline-block">
                                    <input name="form-field-radio" type="radio" value="2"><span class="lbl"> 不通过</span>
                                </label>
                            </div>
							<input type="hidden" name="ccid">
							<input type="hidden" name="cctype">
							<input type="hidden" name="money">
                            <small>如不通过，请填写原因：</small>
                            <textarea style="width: 90%" class="span12" id="form-field-8" placeholder="Default Text"></textarea>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary save" data-dismiss="modal">保存</button>
                    </div>
                </div>
            </div>
        </div>
  </div>
</div>

    <script src="js/jquery-1.9.1.js"></script>
    <script src="webuploader/webuploader.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootbox.min.js"></script>
    <script>
      $(function(){

        $('.ace-checkbox-2').change(function(){
          if($('.ace-checkbox-2').prop('checked')){
            $('.input').prop('checked',true);
          }else{
            $('.input').prop('checked',false);
          }
        })
        
        $('.aa').click(function(){
        	$(" input[ name='cctype'] ").val(document.getElementById("type").innerText);    		
      		$(" input[ name='ccid'] ").val($(this).parents("tr").children("td").eq(1).find("input[type=hidden]").val());     		
      		$(" input[ name='money'] ").val($(this).parents("tr").children("td").eq(3).html());       		
        })
        
        $('.save').click(function(){
        	var type=$(" input[ name='cctype'] ").val();
        	var id=$(" input[ name='ccid'] ").val();
        	var status = $('input[name="form-field-radio"]:checked').val(); 
        	var money=$(" input[ name='money'] ").val();
        
        	$.ajax({
	              type:'post',
	              contentType:'application/json;charset=utf-8',
	              url:'/updateAudit',
	              data:'{"type":"'+type+'","id":"'+id+'","status":"'+status+'","money":"'+money+'"}', 
	              success:function(){
	              		window.location.reload();
	              }         
	          }) 
        	
        })
      
})



    </script>
    </body>
</html>
