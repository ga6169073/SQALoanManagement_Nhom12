<%-- 
    Document   : contract
    Created on : Apr 13, 2023, 5:57:19 PM
    Author     : Legion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <c:set var="account" value="${sessionScope.account}"/>
        <div class="container col-6">
            <c:if test="${requestScope.error != null}">
                <h3>${requestScope.error}</h3>
            </c:if>
            <form action="contract" method="post">
                <input hidden name="accountid" value="${sessionScope.account.id}">
                <input hidden name="interestDetailId" value="${requestScope.interestDetail.id}">
                <div class="form-group text-center mt-3">
                    <h3 >HỢP ĐỒNG VAY</h3>
                </div>
                <div class="form-row">
                    <div class="form-group col-6">
                        <label for="name">Họ và tên: </label>
                        <input name="name" class="form-text form-control" value="${account.customer.name}" readonly ><br>
                    </div>
                    <div class="form-group col-6">
                        <label for="gender">Giới tính:  </label>                
                        <input name="gender" class="form-text form-control" value="${(account.customer.gender ? "Nam" : "Nữ")}" readonly  ><br>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-6">
                        <label for="dob">Ngày sinh:  </label>

                        <input name="dob" class="form-text form-control" value="${account.customer.dob}" readonly  ><br>
                    </div>
                    <div class="form-group col-6">
                        <label for="email">Email:  </label>
                        <input name="email" class="form-text form-control" value="${account.customer.email}" readonly  ><br>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-6">
                        <label for="phone">Số điện thoại:  </label>
                        <input name="phone" class="form-text form-control" value="${account.customer.phonenumber}" readonly ><br>
                    </div>

                    <div class="form-group col-6">
                        <label for="address">Địa chỉ:  </label>
                        <input name="address" class="form-text form-control" value="${account.customer.address}" readonly ><br>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-6">
                        <label for="loantype">Loại vay:</label>
                        <input name="loantype" class="form-text form-control" value="${requestScope.interestDetail.loanType ? "Vay nợ trả nợ giảm dần": "Vay nợ trả đều theo tháng"}" readonly ><br>
                    </div>

                    <div class="form-group col-6">
                        <label for="amount">Số tiền muốn vay(VND): </label>
                        <input name="amount"  value="${requestScope.amount}" hidden/>
                        <input class="form-text form-control"  value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${requestScope.amount}"/>" readonly  ><br>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-6">
                        <label for="rate">Lãi suất(%): </label>
                        <input name="rate" class="form-text form-control" value="${requestScope.rate}" readonly ><br>
                    </div>

                    <div class="form-group col-6">
                        <label for="tenor">Kỳ hạn vay(tháng):</label>                                    
                        <input name="tenor" class="form-text form-control" value="${requestScope.tenor} " readonly > <br>
                    </div>
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary text-center">ĐỒNG Ý</button>
                </div>
            </form>
        </div>
    </body>
</html>
