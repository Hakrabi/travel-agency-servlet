<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="uk-table uk-table-middle uk-table-divider">
    <thead>
    <tr>
        <th class="uk-table-shrink">ID</th>
        <th>Tour</th>
        <th>Create Time</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${userReceiptList}" var="receipt" varStatus="status">
        <tr>
            <td>${receipt.id}</td>
            <td>${receipt.tourId}</td>
            <td>${receipt.createTime}</td>
            <td>
                <c:choose>
                    <c:when test="${receipt.receiptStatusId == 1}">
                        <span class="uk-label uk-label-warning">Registered</span>
                    </c:when>
                    <c:when test="${receipt.receiptStatusId == 2}">
                        <span class="uk-label">Paid</span>
                    </c:when>
                    <c:when test="${receipt.receiptStatusId == 3}">
                        <span class="uk-label uk-label-success">Executed</span>
                    </c:when>
                    <c:when test="${receipt.receiptStatusId == 4}">
                        <span class="uk-label uk-label-danger">Canceled</span>
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>