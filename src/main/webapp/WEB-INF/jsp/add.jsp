<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
</head>
<body>
	<form action="" method="post" >
		名称：<input type="text" name="mname"><br><br>
		介绍：<textarea rows="3" cols="30" name="content"></textarea><br><br>
		导演：<input type="text" name="daoyan"><br><br>
		发行日期：<input type="text" name="mdate" onclick="WdatePicker()"><br><br>
		电影分类：<select name="tid">
		</select>
		<br><br>
		<input type="button" value="保存">
	</form>
</body>
<script type="text/javascript">
	
	$(function(){
		$.post(
				"gettypesAll.do",
				function(obj){
					var select = $("[name='tid']")
					select.append('<option value="0">==请选择==</option>')
					for ( var i in obj) {
						select.append('<option value="'+obj[i].tid+'">'+obj[i].tname+'</option>')
					}
				}
			)
		})
	$("input[value='保存']").click(function(){
		
		$.post(
			"add.do",
			$("form").serialize(),
			function(obj){
				if(obj > 0 ){
					alert("保存成功")
					location='list.do'
				}else{
					alert("保存失败")
				}
				
			}
		)
	})
	
</script>
</html>