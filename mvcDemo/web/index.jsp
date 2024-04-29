<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>综合项目示例</title>
  <base href=" <%=basePath%>">
  <%@include file="public/inc/href.inc"%>
  <script type="text/javascript" src="public/index/index.js"></script>
</head>
<body>
  <%@include file="public/inc/header.inc"%>
  <%@include file="public/inc/carousel.inc"%>
  <%@include file="public/inc/rnd.inc"%>
  <%@include file="public/inc/jumbotron.inc"%>
  <%@include file="public/inc/info.inc"%>
  <%@include file="public/inc/footer.inc"%>
</body>
</html>