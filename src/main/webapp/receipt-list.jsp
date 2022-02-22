<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Users" scope="request"/>
<jsp:include page="/parts/_head.jsp"/>

<body>

<jsp:include page="/parts/_header.jsp"/>


<section id="tours">
    <div class="uk-container">

        <table class="uk-table uk-table-middle uk-table-divider">
            <thead>
            <tr>
                <th class="uk-width-small">ID</th>
                <th>User</th>
                <th>Tour</th>
                <th>Create Time</th>
                <th>Status</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${receiptList}" var="receipt" varStatus="status">
                <tr>
                    <td>${receipt.id}</td>
                    <td>${receipt.userId}</td>
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
                    <td>
                        <button class="uk-button uk-button-default" type="button">Edit Status</button>
                        <div uk-dropdown>
                            <ul class="uk-nav uk-dropdown-nav">
                                <form action="${pageContext.request.contextPath}/api/edit-receipt-status-action" method="post">
                                    <input type="hidden" value="${receipt.id}" name="tourId">
                                    <div class="uk-margin uk-grid-small uk-child-width-auto uk-grid">
                                        <label><input class="uk-radio" type="radio" name="statusId" value="1"
                                                      <c:if test="${receipt.receiptStatusId == 1}">checked</c:if>> Registered</label>
                                        <label><input class="uk-radio" type="radio" name="statusId" value="2"
                                                      <c:if test="${receipt.receiptStatusId == 2}">checked</c:if>> Paid</label>
                                        <label><input class="uk-radio" type="radio" name="statusId" value="3"
                                                      <c:if test="${receipt.receiptStatusId == 3}">checked</c:if>> Executed</label>
                                        <label><input class="uk-radio" type="radio" name="statusId" value="4"
                                                      <c:if test="${receipt.receiptStatusId == 4}">checked</c:if>> Canceled</label>
                                    </div>

                                    <button type="submit" class="uk-button uk-button-default uk-width-1-1" >Change</button>
                                </form>
                            </ul>
                        </div>

                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</section>

</body>
</html>