<%-- 
    Document   : register
    Created on : Apr 11, 2023, 4:19:53 PM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Đăng ký tài khoản</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <script>
        function check() {
            var p = document.getElementById("pw").value;
            var rp = document.getElementById("spw").value;
            if (p !== rp) {
                document.getElementById("error").innerHTML = "2 mật khẩu không khớp";
                return false;
            }
            return true;
        }
    </script>
    <body>
        <div class="container col-12 mt-5">
            <h1 class="mt-3 text-center mb-5">ĐĂNG KÝ TÀI KHOẢN TRỰC TUYẾN</h1>
            <div class="container col-5">
                <form action="register" name="registerform" method="post" onsubmit="return check()">
                    <div class="form-group">
                        <label for="username">Tên người dùng: </label><br>
                        <input type="text" class="form-text form-control" id="un" name="username" required>
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="password">Mật khẩu: </label><br>
                        <input type="password" class="form-text form-control" id="pw" name="password" required>
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="secondpassword">Nhập lại mật khẩu: </label><br>
                        <input type="password" class="form-text form-control" id="spw" name="secondpassword" required>
                    </div>

                    <h4 style="color:red; text-align: center" id="error"></h4>
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
    </body>
</html>
