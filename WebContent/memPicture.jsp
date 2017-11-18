<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css" media="all">

</style>
<script language="javascript" type="text/javascript">
	/*
	 power by: http://www.wxwdesign.cn
	 */
	//主函数
	var s = function() {
		var interv = 5000; //切换间隔时间
		var interv2 = 10; //切换速速
		var opac1 = 80; //文字背景的透明度
		var source = "fade_focus" //焦点轮换图片容器的id名称
		//获取对象
		function getTag(tag, obj) {
			if (obj == null) {
				return document.getElementsByTagName(tag)
			} else {
				return obj.getElementsByTagName(tag)
			}
		}
		function getid(id) {
			return document.getElementById(id)
		}
		;
		var opac = 0, j = 0, t = 63, num, scton = 0, timer, timer2, timer3;
		var id = getid(source);
		id.removeChild(getTag("div", id)[0]);
		var li = getTag("li", id);
		var div = document.createElement("div");
		var title = document.createElement("div");
		var span = document.createElement("span");
		var button = document.createElement("div");
		button.className = "button";
		for (var i = 0; i < li.length; i++) {
			var a = document.createElement("a");
			a.innerHTML = i + 1;
			a.onclick = function() {
				clearTimeout(timer);
				clearTimeout(timer2);
				clearTimeout(timer3);
				j = parseInt(this.innerHTML) - 1;
				scton = 0;
				t = 63;
				opac = 0;
				fadeon();
			};
			a.className = "b1";
			a.onmouseover = function() {
				this.className = "b2"
			};
			a.onmouseout = function() {
				this.className = "b1";
				sc(j)
			};
			button.appendChild(a);
		}
		//控制图层透明度
		function alpha(obj, n) {
			if (document.all) {
				obj.style.filter = "alpha(opacity=" + n + ")";
			} else {
				obj.style.opacity = (n / 100);
			}
		}
		//控制焦点按钮
		function sc(n) {
			for (var i = 0; i < li.length; i++) {
				button.childNodes[i].className = "b1"
			}
			;
			button.childNodes[n].className = "b2";
		}
		title.className = "num_list";
		title.appendChild(span);
		alpha(title, opac1);
		id.className = "d1";
		div.className = "d2";
		id.appendChild(div);
		id.appendChild(title);
		id.appendChild(button);
		//渐显
		var fadeon = function() {
			opac += 5;
			div.innerHTML = li[j].innerHTML;
			span.innerHTML = getTag("img", li[j])[0].alt;
			alpha(div, opac);
			if (scton == 0) {
				sc(j);
				num = -2;
				scrolltxt();
				scton = 1
			}
			;
			if (opac < 100) {
				timer = setTimeout(fadeon, interv2)
			} else {
				timer2 = setTimeout(fadeout, interv);
			}
			;
		}
		//渐隐
		var fadeout = function() {
			opac -= 5;
			div.innerHTML = li[j].innerHTML;
			alpha(div, opac);
			if (scton == 0) {
				num = 2;
				scrolltxt();
				scton = 1
			}
			;
			if (opac > 0) {
				timer = setTimeout(fadeout, interv2)
			} else {
				if (j < li.length - 1) {
					j++
				} else {
					j = 0
				}
				;
				fadeon()
			}
			;
		}
		//滚动文字
		var scrolltxt = function() {
			t += num;
			span.style.marginTop = t + "px";
			if (num<0 && t>3) {
				timer3 = setTimeout(scrolltxt, interv2)
			} else if (num > 0 && t < 62) {
				timer3 = setTimeout(scrolltxt, interv2)
			} else {
				scton = 0
			}
		};
		fadeon();
	}
	//初始化
	window.onload = s;
</script>
<title>Javascript图片幻灯效果——wxwdesign.cn</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />
<link rel="stylesheet" type="text/css" href="css/picture.css" />
</head>
<body class="login_body">
	<div id="fade_focus">
		<div class="loading">
			Loading...<br /> <img src="MemBarChartAction.action"
				width="100" height="100" />
		</div>
		<ul>
			<li><a href="" target="_blank"><img
					src="MemBarChartAction.action" width="600"
					height="500" alt="展示图片1" /></a></li>
			<li><a href="" target="_blank"><img
					src="MemPieChartAction.action" width="600"
					height="500" alt="展示图片2" /></a></li>
			<li><a href="" target="_blank"><img
					src="MemLineChartAction.action" width="600"
					height="500" alt="展示图片3" /></a></li>
		
		</ul>
	</div>
</body>
</html>