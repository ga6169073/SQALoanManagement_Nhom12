<%-- 
    Document   : index
    Created on : Apr 10, 2023, 5:46:29 PM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Ngân hàng</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-light ">
            <div class="navbar-brand">Loan System</div>
            <ul class="navbar-nav">
                <c:if test="${sessionScope.account != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="homePage">TRANG CHỦ</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="loanBill">HÓA ĐƠN</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="loan">VAY TIÊU DÙNG</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="calculator">CÔNG CỤ TÍNH TOÁN</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">ĐĂNG XUẤT</a></li>
                    </c:if>

                <c:if test="${sessionScope.account == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login">ĐĂNG NHẬP</a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="calculator">CÔNG CỤ TÍNH TOÁN</a></li>
                    </c:if>
            </ul>
        </nav>
    </body>
</html>
