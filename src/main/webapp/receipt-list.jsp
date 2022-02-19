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
                        <a  class="uk-button uk-button-default"
                            href="${pageContext.request.contextPath}/api/edit-receipt?id=${receipt.id}">
                            Edit Tour
                        </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</section>

</body>
</html>