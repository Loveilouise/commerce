<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
    </head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/ace.min.css">
    <link rel="stylesheet" href="../css/ace-skins.min.css">
    <link rel="stylesheet" href="../css/ace-responsive.min.css">
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
              <h1 style="color: #2679b5;">借卖方 <small><i class="icon-double-angle-right"></i> 钱包流水</small></h1>
            </div>
    <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th>Transaction Number</th>

          <th>Available Money</th>
          <th>Create Time</th>
          <th class="center">State</th>
        </tr>
      </thead>

       <tbody>
       <#list turnovers as t>
        <tr>
          <td>${t.sr_transact}</td>

          <td>${t.sr_money}</td>
          <td>
            ${t.sr_time}
          </td>
          <td class="center">          
            <#if t.sr_status==0> waiting
          	<#elseif t.sr_status==1> succeed
          	<#elseif t.sr_status==2> failed
         	</#if>
          </td>
        </tr>
         </#list>
      </tbody>
              
    </table>
  </div></div>
    <script src="../js/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script>
      $(function(){
        $('.nav li').click(function(){
          $(this).addClass('active').siblings().removeClass('active');
        })
})



    </script>
    </body>
</html>
