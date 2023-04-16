<%-- 
    Document   : loan
    Created on : Apr 12, 2023, 1:08:10 AM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.InterestDetail"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("account") == null && session.getAttribute("accountid") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Vay lãi</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script>
            function check() {
                var a = document.loanform.amount.value;
                if (a === "") {
                    document.getElementById("error").innerHTML = "Chưa nhập số tiền";
                    return false;
                }
            }
        </script>


    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <div class="container col-6">
            <c:if test="${requestScope.error != null}">
                <h3>${requestScope.error}</h3>
            </c:if>
            <div class="text-center mt-3">
                <h3>ĐĂNG KÝ VAY </h3>
            </div>
            <br>
            <form action="loan" name="loanform" method="post" onsubmit="return check()">
                <input hidden name="accountid" value="${sessionScope.account.id}"/>
                <div class="form-group">
                    <label for="inputType">Chọn kiểu vay:</label>
                    <select class="custom-select" id="inputType" name="loanType" >
                        <option value="0">Vay nợ trả đều theo tháng</option>
                        <option value="1">Vay nợ trả nợ giảm dần</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputTenor">Kỳ hạn vay :</label>
                    <select class="custom-select" id="inputTenor" name="loanTenor">
                        <option value="3">3 tháng</option>
                        <option value="6">6 tháng</option>
                        <option value="9">9 tháng</option>
                        <option value="12">12 tháng</option>
                        <option value="24">24 tháng</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputAmount">Số tiền muốn vay: </label>
                    <input class="form-text form-control" type="number" id="inputAmount" name="loanAmount" required min="100000"/>
                    <br>
                    <h4 style="color: red; text-align: center" id="error"></h4>
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary text-center">ĐĂNG KÝ VAY</button>
                </div>
            </form>
        </div>
    </body>
</html>

