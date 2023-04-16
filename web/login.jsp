<%-- 
    Document   : login
    Created on : Apr 10, 2023, 9:57:33 PM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Đăng nhập</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <div>
            <div class="container col-12 mt-5">
                <h1 class="mt-3 text-center mb-5">ĐĂNG NHẬP</h1>
                <div class="container col-5">
                    <form action="login" name="loginform" method="post" onsubmit="return validate()">
                        <div class="form-group">
                            <label for="username">Tên người dùng: </label><br>
                            <input class="form-text form-control" type="text" id="username" name="username" required>
                        </div>
                        <br/>
                        <div class="form-group">
                            <label for="password">Mật khẩu: </label><br>
                            <input class="form-text form-control" type="password" id="password" name="password" required>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="loginType" value="admin">
                            <label class="form-check-label" >Admin login?</label>
                        </div>
                        <br/>
                        <div class="form-group text-center">
                            <button type="submit" class="btn btn-primary text-center">ĐĂNG NHẬP</button>
                        </div>
                    </form>
                    <h4 style="color: red; text-align: center" id="error"></h4>
                    <c:if test="${requestScope.message != null}">
                        <h4 style="color: red; text-align: center">${requestScope.message}</h4>
                    </c:if>
                    <br/>
                    <div class="text-center">
                        <label class="register" for="register">Chưa có tài khoản?</label>
                        <a id="register" href="register">ĐĂNG KÝ</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        function validate() {
            var u = document.loginform.username.value;
            var p = document.loginform.password.value;
            if (u == "") {
                document.getElementById("error").innerHTML = "Chưa nhập tên người dùng";
                return false;
            }
            if (p == "") {
                document.getElementById("error").innerHTML = "Chưa nhập mật khẩu";
                return false;
            }
            return true;
        }
    </script>
</html>