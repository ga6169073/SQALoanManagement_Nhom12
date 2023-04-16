<%-- 
    Document   : loanSuccess
    Created on : Apr 12, 2023, 1:08:37 AM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
    if (session.getAttribute("account") == null && session.getAttribute("accountid") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no, charset=UTF-8, text/html">
        <title>Vay lãi</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <div class="container col-12">
            <form action="loanSuccess" method="post">
                <input hidden name="accountid" value="${sessionScope.account.id}">
                <div class="text-center mt-3">
                    <h3>ĐĂNG KÝ VAY THÀNH CÔNG</h3>
                    <h4>Khoản vay của bạn sẽ được nhân viên ngân hàng xét duyệt và liên hệ</h4>
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary text-center">TRỞ LẠI TRANG CHỦ</button>
                </div>
            </form>
        </div>
    </body>
</html>