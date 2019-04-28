<%--
  Created by IntelliJ IDEA.
  User: 吕港
  Date: 2018/2/11
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>查询</title>
    <script src="<%=basePath%>js/echarts/echarts.min.js"></script>
    <script src="<%=basePath%>js/jquery/jquery-3.2.1.js"></script>
    <script src="<%=basePath%>js/echarts/vintage.js"></script>
</head>
<body>
    &nbsp;  &nbsp;  &nbsp;  &nbsp;
    请输入要查询的内容：<input type="text" name="lname" id="something"/>
    <button id="search">查询</button>
    <p id="displaySomething" style="display: none"></p>
    <div id="select" style="display: none;"></div>
    <div id="main" style="width:94%;height:568px;border: 1px solid black;margin-left: 3%;margin-top:1.5%;display: none"></div>
    <input value="<%=basePath%>" id="basePath" type="hidden">
    <script src="<%=basePath%>js/search/search.js"></script>
</body>
</html>
