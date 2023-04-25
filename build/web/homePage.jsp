<%-- 
    Document   : homePage
    Created on : Apr 10, 2023, 3:15:29 PM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Trang chủ</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <div class="container col-12 mt-3">
            <div class="container col-3">
                <input hidden name="accountid" value="${sessionScope.account.id}"/>
                <h3>Xin chào: ${sessionScope.account.customer.name}</h3>
                <h4>Tài khoản: ${sessionScope.account.number}</h4>
                <h4>Số dư: <fmt:formatNumber type="number" maxFractionDigits="3" value="${sessionScope.account.balance}"/> VND</h4>
            </div>
        </div>
    </body>
</html>
