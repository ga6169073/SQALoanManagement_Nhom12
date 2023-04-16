<%-- 
    Document   : loanBill
    Created on : Apr 12, 2023, 12:54:47 AM
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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Khoản vay</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <div class="container col-12">
            <input hidden name="accountid" value="${sessionScope.account.id}"/>
            <div class="text-center mt-3">
                <h3>DANH SÁCH KHOẢN VAY</h3>
            </div>    

            <c:set var="listLoan" value="${requestScope.listLoan}"/>
            <table class="table align-middle">
                <tr>
                    <th scope="col">Ngày vay</th>
                    <th scope="col">Loại vay</th>
                    <th scope="col">Số tiền vay</th>
                    <th scope="col">Thời gian vay (tháng)</th>
                    <th scope="col">Lãi suất (%/năm)</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Chi tiết</th>
                </tr>
                <c:forEach items="${requestScope.listLoan}" var="loan">
                    <tr >
                        <td class="align-middle">${loan.begin_date}</td>
                        <td class="align-middle">${loan.interestDetail.loanType ? "Vay nợ trả nợ giảm dần": "Vay nợ trả đều theo tháng"}</td>
                        <td class="align-middle">${loan.amount} VND</td>
                        <td class="align-middle">${loan.interestDetail.tenor}</td>
                        <td class="align-middle">${loan.interestDetail.rate}</td>
                        <td class="align-middle">${loan.status ? "Đã hoàn tất" : "Chưa hoàn tất"}</td>
                        <td><a class="btn btn-primary" href="loanBillDetail?id=${loan.id}">Xem chi tiết</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
