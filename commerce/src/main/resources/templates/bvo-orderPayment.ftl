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

  </style>
    <body>
<div id="main-content" class="clearfix">
<div id="page-content" class="clearfix">
    <div class="page-header position-relative">
              <h1 style="color: #2679b5;">借卖方<small><i class="icon-double-angle-right"></i> 支付订单</small></h1>
            </div>

<h4>商品名称：${pay.good.gname}</h4>

 <form class="form-horizontal" style="width: 60%; margin:20px auto">
            <div class="control-group">
             <label class="control-label" for="form-field-1">Receiver</label>
             <div class="controls">
                 <input type="text" id="form-field-4" placeholder="luji">
             </div>
         </div>
            <div class="control-group">
              <label class="control-label" for="form-field-1">Ship To</label>
                <div class="controls">
                    <input type="text" id="form-field-4" placeholder="Address">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <select>
                        <option value="0">State</option>
                        <option value="1">Alaska</option>
                        <option value="2">California</option>
                         <option value="3">Colorado</option>
                          <option value="4">Florida</option>
                    </select>
                </div>
             </div>
            <div class="control-group">
                    <div class="controls">
                        <select>
                            <option value="0">city</option>
                            <option value="1">Birmingham</option>
                            <option value="2">Phoenix</option>
                            <option value="3">LittleRock</option>
                            <option value="4">SanFrancisco</option>
                        </select>
                    </div>
               </div>
           <div class="control-group">
              <label class="control-label" for="form-field-1">Quantity</label>
              <div class="controls">
                <input type="text" id="form-field-4" value="${pay.ocounts}" readonly unselectable="on">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="form-field-1">Mobile</label>
              <div class="controls">
                <input type="text" id="form-field-4" placeholder="1354678655">
              </div>
            </div>
             <div class="control-group">
              <label class="control-label" for="form-field-1">ZIP code</label>
              <div class="controls">
                <input type="text" id="form-field-4" placeholder="510000">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="form-field-1">Shipping Method</label>
              <div class="controls ">
                <label>
                  <input name="form-field-radio" type="radio" class="radio" value="10"><span class="lbl"> 2-5天  $10 </span><br>
                </label>
                <label>
                  <input name="form-field-radio" type="radio" class="radio" value="5"><span class="lbl"> 5-10天  $5 </span><br>
                </label>
                <input type="hidden" value="${pay.ocost?c}" name="primary_total">
              </div>
            </div>


        </form>

              <h3 style="text-align: center"> 
                Total：<b class="red" id="total">${pay.ocost?c}</b>
              </h3>

<div style="text-align: center"><button class="btn btn-primary pay" data-toggle="modal" data-target="#myModal"><i class="icon-beaker"></i> Pay Now</button></div>



<!-- Modal -->
<div class="modal fade hide" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Payment</h4>
      </div>
      <div class="modal-body" >
          <form class="form-horizontal">
              <div class="control-group">
                  <h3>Total:<span class="red" id="paytotal">${pay.ocost}</span></h3>
                  
              </div>
              <div class="control-group">
                  Payment Method：
                  <div>
                      <img src="../image/gmc.png" alt="">My Wallet
                      <input name="sid" type="hidden" value="${pay.sid}">
                      <div class="blue">Account Balance:<span>$</span> ${balance.sa_money}</div>
                      <input type="hidden" value="${pay.good.cid}" name="cid">
                      <input type="hidden" value="${pay.good.gid}" name="gid">
                      <input type="hidden" value="${pay.oid}" name="oid">
                  </div>
                  

              </div>

            <div class="control-group">
              Enter Password：<input type="password" id="form-field-2" placeholder="Password">
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary sure" data-dismiss="modal">确定</button>
      </div>
    </div>
  </div>
</div>
  </div></div>
    <script src="../js/jquery-1.9.1.js"></script>

    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/bootbox.min.js"></script>
    <script>
      $(function(){
        //发货

        $('.sure').click(function(){
	        var money=$("#paytotal").text();
	        var sid=$(" input[ name='sid'] ").val();     
	        var cid=$(" input[ name='cid'] ").val();   
	        var gid=$(" input[ name='gid'] ").val();  
	        var oid=$(" input[ name='oid'] ").val();  
	        var pwd=document.getElementById('form-field-2').value;
	       
	        //alert(money+"zhujian"+sid+"cid"+cid+"gid"+gid+"oid"+oid);
	        //alert(pwd+"输入密码");
	        $.ajax({
	              type:'post',
	              contentType:'application/json;charset=utf-8',
	              url:'/checkBalance',
	              data:'{"money":"'+money+'","sid":"'+sid+'","cid":"'+cid+'","gid":"'+gid+'","oid":"'+oid+'","sa_pwd":"'+pwd+'"}',
	              dataType:'text',
	              success:function (data) {  
	              		 	    
	            	  alert(data); 	              		
	              		if(data="付款成功! ")    {
	              			window.location.href="/bvo-orderlist.ftl";
	              		} 
	              }
	        })      
        })
               
        $('.radio').click(function(){    
        	var money=$("input[type='radio']:checked").val();
        	var primary_total=$(" input[ name='primary_total'] ").val(); 
        	var total=parseInt(money)+parseInt(primary_total);    		
        	$("#total").text(total);
        	$("#paytotal").text(total);        	
        	//alert(money+"zhongjia"+primary_total);
   	
        })
        
        
   	
})



    </script>
    </body>
</html>
