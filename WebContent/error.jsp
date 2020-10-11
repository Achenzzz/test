<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
<!--   <meta http-equiv="refresh" content="5;url=login.html"> -->
</head>

<script>
	function countDown() {
		//获取初始时间
		var time = document.getElementById("Time");

		//获取到id为time标签中的数字时间
		if (time.innerHTML == 0) {
			//等于0时清除计时，并跳转该指定页面
			window.location.href = "login.html";
		} else {
			time.innerHTML = time.innerHTML - 1;
		}
	}
	//1000毫秒调用一次
	window.setInterval("countDown()", 1000);
</script>
<style>
div{
 margin: 0 auto;
            text-align: center;
}
.girl{
    width:100%;
    height:100%;
}
</style>

<body>
<div>
	<h3>抱歉！你的${result}</h3>
	<font color="red"><p id="Time">5</p></font>
	<h3>秒后将跳转至主页</h3>
	<hr>
</div>
<div class="girl">
<img width=100% height=100% src="img/errorbeauty.jpg" title="害羞的凤姐"/>
</div>
</body>
</html>
