<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>学员详情</title>
  <base href=" <%=basePath%>">
  <%@include file="../inc/href.inc"%>
  <script type="text/javascript" src="public/detail/detail.js"></script>
</head>
<body>
  <%@include file="../inc/header.inc"%>
  <%@include file="../detail/detail.inc"%>
  <%@include file="../inc/footer.inc"%>
</body>
</html>