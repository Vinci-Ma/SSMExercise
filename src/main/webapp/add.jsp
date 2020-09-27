<%--
  Created by IntelliJ IDEA.
  User: VINCI
  Date: 2020/9/23
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>新增页面</title>
</head>
<body>
<h1>记账</h1>
<form action="insertBill" method="post">
    <p>类型:
        <c:forEach items="${types}" var="ty">
            <input type="radio" value="${ty.id}" name="typeid">${ty.bname}
        </c:forEach>
    </p>
    <!--name的名称需要和bean中bills的名称相同-->
    <p>标题:<input type="text" style="width: 500px" name="title" > </p>
    <p>日期：<input type="text" name="billtime" value="<fmt:formatDate value="${bills.billtime}" pattern="yyyy/MM/dd"></fmt:formatDate>"> 金额:<input type="text" name="price"> </p>
    <p>说明:<textarea cols="50" rows="4" name="explains"></textarea></p>
    <input type="reset"   value="重置">
    <input type="submit" value="保存">
</form>
</body>
</html>
