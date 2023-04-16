<%-- 
    Document   : information.
    Created on : Apr 11, 2023, 9:57:45 PM
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
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Đăng ký tài khoản</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <div class="container col-12 mt-5">
            <h1 class="mt-3 text-center mb-5">KHAI BÁO THÔNG TIN CÁ NHÂN</h1>
            <form class="container col-6" action="information" name="informationform" method="post" onsubmit="return check()">
                <input hidden name="username" value="${requestScope.username}">
                <input hidden name="password" value="${requestScope.password}">
                <div class="form-group">
                    <label for="ln">Họ và tên: </label><br>
                    <input type="text" class="form-text form-control" id="ln"class="register-form_input" name="name" required>
                </div>
                <div class="form-group">
                    <label for="la">Địa chỉ: </label><br>
                    <input type="text" class="form-text form-control" id="la" class="register-form_input" name="address" required>
                </div>

                <div class="form-group">
                    <label for="ldob">Ngày tháng năm sinh (dd-MM-yyyy): </label><br>
                    <input type="date" class="form-text form-control" id="ldob" class="register-form_DOB_input" name="dob" required>
                </div>
                <div class="form-group">
                    <label>Giới tính: </label>
                    <div class="form-check-inline">
                        <input type="radio" class="form-check-input ml-2" id="male" value="1" name="gender" checked> 
                        <label class="form-check-label">Nam</label>                            
                        <input type="radio" class="form-check-input ml-2" id="female" value="0" name="gender"> 
                        <label class="form-check-label">Nữ</label>      
                    </div>
                </div>
                <div class="form-group">
                    <label for="lid">Số CCCD: </label><br>
                    <input type="text" class="form-text form-control" id="lid" class="register-form_input" name="id_card" required>
                </div>
                <div class="form-group">
                    <label for="lp">Số điện thoại: </label><br>
                    <input type="text" class="form-text form-control" id="lp" class="register-form_input" name="phone" required>
                </div>
                <div class="form-group">
                    <label for="le">Email: </label><br>
                    <input type="text" class="form-text form-control" id="le" class="register-form_input" name="email" required>
                </div>
                <h4 style="color: red; text-align: center" id="error"></h4>
                <c:if test="${requestScope.message != null}">
                    <h4 style="color: red; text-align: center">${requestScope.message}</h4>
                </c:if>
                <br>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary text-center">ĐĂNG KÝ</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>

