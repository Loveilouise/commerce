<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	 <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	 <link href="asserts/css/signin.css" rel="stylesheet">
	 <link href="asserts/css/bootstrap.min.css" rel="stylesheet">
   <script type="text/javascript" th:src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" th:src="/js/jquery.min.js"></script>
    <script  src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="static/js/regist.js"></script>
<meta charset="UTF-8">
<title>注册</title>
</head>
<html>
<body class="text-center">

<br><br><br><br>
<h1>用户注册</h1><br><br>
用户名 ：<input type="text" class="form-control" placeholder="请输入用户名" name="userName" id="userName" required="" autofocus=""><br><br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" class="form-control" placeholder="请输入密码" name="userPwd" id="userPwd" required=""><br><br>
确认密码：<input type="password" class="form-control" placeholder="再次确认密码" id="userPwdConfirm" required=""><br><br>

         <div class="btn-group" data-toggle="buttons">
   				<label class="btn  btn-lg">
        		     <input type="radio" name="userRole" value="1"> 品牌商
    			</label>
                <label class="btn  btn-lg">
                     <input type="radio" name="userRole" value="2"> 借卖方
                </label>
		  </div>
<br><br>
<button class="btn  btn-lg" type="submit" onclick="submit()">注册</button><br><br>
<a href="login.ftl">已有账号？…</a>

</body>
</html>