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
              <h1 style="color: #2679b5;">品牌商 <small><i class="icon-double-angle-right"></i> 提现明细</small></h1>
            </div>
    <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th>交易流水号</th>
          <th>提现金额</th>
          <th>时间</th>
          <th class="center">状态</th>
        </tr>
      </thead>

      <tbody>
      <#list crlist as c>
        <tr>
          <td>${c.cr_transact}</td>
          <td>${c.cr_money}</td>
          <td>
            ${c.cr_time}
          </td>
          <td class="center">
          	<#if c.cr_status==0>    处理中
          	<#elseif c.cr_status==1> 提现成功
          	<#elseif c.cr_status==2> 未通过审核
         	</#if>
          </td>
        </tr>
		</#list>
              </tbody>
    </table>
  </div></div>

    <script src="js/jquery-1.9.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
      $(function(){

})



    </script>
    </body>
</html>
