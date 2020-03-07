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
        <link rel="stylesheet" href="css/ace.min.css">
        
        <script src="js/jquery-1.9.1.js"></script>
        
        <style type="text/css">
            body,html{
                width: 100%;
                height: 100%;
                background: #fff;
            }
            li{
                list-style: none;
            }

            .main{margin-left: 190px;padding: 8px 20px 24px;}
            .main ul{overflow: hidden;}
            .main li{width: 25%;padding:0 2.5%;box-sizing: border-box;float:left;margin-bottom: 30px;}
            .main li p{font-size: 15px;color:#666;height: 36px;overflow: hidden;text-overflow: -o-ellipsis-lastline;overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;}
              .main li:hover,
           :focus {
                background-color: #f5f5f5;
                box-shadow: 2px 2px 5px #999;
            }
            .main li a{display:inline;}
            .main li span{color:#d72439;line-height: 40px;}
            .main li img{width: 100%;}
            .main h5{line-height: 40px;padding-left: 2%;box-sizing: border-box;font-size: 20px;}
        </style>
    </head>
    <body>

        <div class="main">
        
        
		<#if category_map?exists>
            <#list category_map?keys as category> 
 				
                  <#if ((category_map[category]))??&&((category_map[category])?has_content)>
                  
                  	<h5 style="margin-top: 45px;">${category}</h5>

						<ul>
                        
                        <#list (category_map[category]) as good>
  
                              <li>			
 														
                    			<a href="/bvo-goodsdetail/${(good.gid)!}">
                    			<div class="img"></div><img src="/Path/${(good.category.gc_picture)!}"  alt="" />
                    			<p>${(good.gname)!}</p>
                    			<span><span>$</span>${(good.gprice)!}</span>
                    			</a>

                			</li>
                               
                        </#list>
                        
                        </ul>
                        
                  		<#if !((category_map[category])?has_content)><div class='clear'></div></#if>
                  </#if>
 
            </#list>
 		</#if>
        
 		
        </div>
    </body>
    
    <script src="js/bootstrap.min.js"></script>
</html>
