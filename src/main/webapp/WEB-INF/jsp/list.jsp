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
<script type="text/javascript">
	function page(cpage){
		$("[name='cpage']").val(cpage);
		$("#cpage").submit();
		
	}
	
	function del (){
		
		var mids = $("[name='mids']:checked").val()
		
		
			$.post(
					"delete.do",
					{mids:mids},
					function(obj){
						if(obj > 0){
							alert("删除成功")
							location='list.do'
						}
					}
				)
		
	}
</script>
<body>
<form action="list.do" id="cpage" method="post">
	<input type="hidden" name="cpage" value="${page.pageNum }">
	电影名称:<input type="text" name="mname" value="${mname }">
	<button>搜索</button>
	<input type="button" value="批量删除" onclick="del()">
</form>
	<form action="" method="post">
		<table>
		<tr>
			<td>
				<input type="button" value="选择" >
			</td>
			<td>电影编号</td>
			<td>电影名称</td>
			<td>剧情介绍</td>
			<td>导演</td>
			<td>发行日期</td>
			<td>电影分类</td>
			<td>
				<input type="button" value="添加电影" onclick="location='toadd.do'">
			</td>
		</tr>
		<c:forEach items="${getmovieAll }" var="m">
			<tr>
			<td>
				<input type="checkbox" name="mids" value="${m.mid }">
			</td>
			<td>${m.mid }</td>
			<td>${m.mname }</td>
			<td>${m.content }</td>
			<td>${m.daoyan }</td>
			<td>${m.mdate }</td>
			<td>${m.tname }</td>
			<td>
				<input type="button" value="修改电影" onclick="location='toupdate.do?mid=${m.mid}'">
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="11">
				<input type="button" value="首页" onclick="page('1')">
				<input type="button" value="上一页" onclick="page('${page.pageNum-1}')">
				<input type="button" value="下一页" onclick="page('${page.pageNum+1}')">
				<input type="button" value="首页" onclick="page('${page.pages}')">
			</td> 
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
	$("[value='选择']").click(function(){
		
		$("[name='mids']").each(function(){
			this.checked= !this.checked
		})
		
	})


</script>
</html>