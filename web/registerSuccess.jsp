<%-- 
    Document   : registerSuccess
    Created on : Apr 11, 2023, 9:52:04 PM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Đăng ký tài khoản</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <div class="container col-12 mt-5">     
            <form action="registersuccess" method="post">
                <h1 class="mt-3 text-center mb-5">ĐĂNG KÝ THÀNH CÔNG</h1>
                <input hidden name="customerusername" value="${requestScope.customer.username}">
                <div class="form-group text-center">
                    <input type="submit" class="btn btn-primary text-center" value="HOÀN TẤT">
                </div>
            </form>
        </div>
    </div>
</body>
</html>