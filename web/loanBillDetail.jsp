<%-- 
    Document   : loanBillDetail
    Created on : Apr 13, 2023, 11:49:53 PM
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
        <title>Chi tiết khoản vay</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script>
            function doPay(id, loan_id, account_id) {
                if (confirm("Thanh toán lần trả này?")) {
                    window.location = "payment?id=" + id + "&lid=" + loan_id + "&aid=" + account_id;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <c:set var="a" value="${sessionScope.account}"/>
        <c:set var="l" value="${requestScope.loan}"/>
        <c:set var="listpayment" value="${requestScope.listpayment}"/>
        <div class="container col-12">
            <input hidden name="accountid" value="${sessionScope.account.id}"/>
            <div class="text-center mt-3">
                <h3>THÔNG TIN VAY LÃI</h3>
            </div>
            <table class="table text-center col-8 m-auto">
                <tr>
                    <td class="col-4">Số tiền vay: ${l.amount} VND</td>
                    <td class="col-4">Thời gian vay: ${l.interestDetail.tenor} tháng</td>
                    <td class="col-4">Lãi suất: ${l.interestDetail.rate}%/năm</td>
                </tr>
                <tr>
                    <td class="col-4">Thời gian bắt đầu: ${l.begin_date}</td>                   
                    <td class="col-4">Thời gian kết thúc: ${requestScope.end_date}</td>
                    <td class="col-4">Tổng số tiền phải trả: ${requestScope.sum} VND</td>
                </tr>
            </table>
            <p style="color: red; text-align: center" >${sessionScope.message != null ? sessionScope.message: ""}</p>   
            <%
                if(session.getAttribute("message") != null){
                    session.removeAttribute("message");
                }
            %>
            <table class="table align-middle">
                <tr>
                    <th scope="col">Tiền gốc (VND)</th>
                    <th scope="col">Tiền lãi (VND)</th>                    
                    <th scope="col">Tổng tiền (VND)</th>
                    <th scope="col">Ngày đến hạn</th>
                    <th scope="col">Tiền trả (VND)</th>
                    <th scope="col">Phí phạt (VND)</th>
                    <th scope="col">Ngày trả</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col"></th>
                </tr>
                <c:forEach items="${listpayment}" var="lp">
                    <tr>
                        <td>${Math.round(lp.amount_per_month)}</td>
                        <td>${Math.round(lp.interest_per_month)}</td>                         
                        <td>${Math.round(lp.amount_per_month + lp.interest_per_month + lp.fine)}</td>
                        <td>${lp.payment_date}</td>
                        <td>${lp.payment_amount}</td>
                        <td>${Math.round(lp.fine)}</td>
                        <td>${lp.pay_date}</td>
                        <td>${lp.status ? "Đã trả" : "Chưa trả"}</td>
                        <td><a class="btn btn-primary" href="#" onclick="doPay(${lp.id}, ${l.id}, ${a.id})" style="${lp.status ? 'pointer-events: none' : ''}">Thanh toán</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>