<%-- 
    Document   : calculator
    Created on : Apr 12, 2023, 12:46:25 AM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Tính toán vay</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <div class="container col-6">
            <input hidden name="accountid" value="${sessionScope.account.id}"/>
            <div class="text-center mt-3">
                <h3>TÍNH TOÁN VAY</h3>
            </div>
            <c:if test="${requestScope.error != null}">
                <p style="color: red">${requestScope.error}</p>
            </c:if>
            <form action="calculator" name="calculatorform" method="post" onsubmit="return check()">
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
                </div>
                <div class="form-group">
                    <label for="inputRate">Lãi suất(%/năm): </label>
                    <input class="form-text form-control" type="number" step="any" id="inputRate" name="loanRate" required min="0"/>
                    <br>                  
                </div>
                <h4 style="color: red; text-align: center" id="error"></h4>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary text-center">TÍNH TOÁN</button>
                </div>
            </form>
            <br>
            <c:if test="${requestScope.listPayment!=null}">
                <table class="table text-center col-8 m-auto">
                    <tr>
                        <td class="col-4">Số tiền vay: <fmt:formatNumber type="number" maxFractionDigits="3" value="${requestScope.amount}"/> VND</td>
                        <td class="col-4">Thời gian vay: ${requestScope.tenor} tháng</td>
                        <td class="col-4">Lãi suất: ${requestScope.rate}%/năm</td>
                    </tr>
                    <tr>
                        <td class="col-4">Thời gian bắt đầu: ${requestScope.begin_date}</td>                   
                        <td class="col-4">Thời gian kết thúc: ${requestScope.end_date}</td>
                        <td class="col-4">Tổng số tiền phải trả: <fmt:formatNumber type="number" maxFractionDigits="3" value="${requestScope.sum}"/> VND</td>
                    </tr>
                </table>
                <table class="table align-middle">
                    <tr>
                        <th scope="col">Tiền gốc (VND)</th>
                        <th scope="col">Tiền lãi (VND)</th>                    
                        <th scope="col">Tổng tiền (VND)</th>
                        <th scope="col">Ngày đến hạn</th>
                    </tr>
                    <c:forEach items="${listPayment}" var="lp">
                        <tr>
                            <td> <fmt:formatNumber type="number" maxFractionDigits="3" value="${Math.round(lp.amount_per_month)}" /></td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${Math.round(lp.interest_per_month)}"/></td>                         
                            <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${Math.round(lp.amount_per_month + lp.interest_per_month)}"/></td>
                            <td>${lp.payment_date}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>s