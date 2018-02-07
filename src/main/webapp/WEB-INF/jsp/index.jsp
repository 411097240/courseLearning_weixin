<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>中南民大学习交流平台</title>
<link rel="stylesheet" href="css/style.css">
<body>

<div class="login-container">
	<h1>中南民大学习交流平台</h1>
	
	<div class="connect">
		<p>Link the world. Share to world.</p>
		<p class="red">${msg}</p>	
	</div>
	
	<form action="userlogin" method="post" id="loginForm">
		<div>
			<input type="text" name="userName" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="passWord" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit">登 陆</button>
	</form>


</div>

</body>
<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证
<script src="js/jquery.validate.min.js?var1.14.0"></script>
-->
</html>