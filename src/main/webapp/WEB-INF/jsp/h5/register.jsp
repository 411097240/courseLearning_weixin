<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>中南民大学习交流平台</title>
<link rel="stylesheet" href="css/style.css?version=1">
<body>

<div class="register-container">
	<h1>申请入班</h1>
	
	<div class="connect">
		<p class="red">${msg}</p>	
	</div>
	
	<form action="joinClass" method="post" id="registerForm">
		<div>
			<p>选择班级</p>
			<select name="select" id="select_k1" class="xla_k" autocomplete="off">
				<option value="数据结构1" autocomplete="off">数据结构1</option>
				<option value="计算机网络1" autocomplete="off">计算机网络1</option>
				<option value="离散数学2" autocomplete="off">离散数学2</option>
			</select>
		</div>
		<div>
			<input type="text" name="schoolCode" class="schoolCode" placeholder="您的学号" autocomplete="off"/>
		</div>
		<div>
			<input type="text" name="userName" class="username" placeholder="您的真实姓名" autocomplete="off"/>
		</div>
		<button id="submit" type="submit">提交申请</button>
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