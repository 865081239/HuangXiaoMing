<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.min.js"></script>
<body>
   <form method="post" enctype="multipart/form-data">
      <p>用户名：<input type="text" name="username"></p>
      <p>身份证：<input type="file" name="useridpic"></p>
      <p>工作证：<input type="file" name="useridpic"/></p>
      <p><select>
      		<option value=1 id="select">请选择</option>
      
      </select></p>
      <p>日期：<input type="text" id="date" value=""/></p>
      <p><button type="submit">提交</button></p>
   </form>
   
   
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			type:"post",
			url:"getSelect",
			data:{id:"select"},
			dataType:"json",
			success:function(data){
				for(var i = 0;i < data.length;i ++){
					$("#select").after("<option value="+data[i].id+">"+data[i].name+"</option>");
					$("#date").attr("value",data[i].date);
				}
			}
			
		});
	});

</script>
</html>