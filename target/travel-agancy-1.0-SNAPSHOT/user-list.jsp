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
                <th>Role</th>
                <th>Login</th>
                <th>Name</th>
                <th>Create Time</th>
                <th>Block User</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${userList}" var="receipt" varStatus="status">
                <tr>
                    <td>${receipt.id}</td>
                    <td>${receipt.userRoleId}</td>
                    <td>${receipt.login}</td>
                    <td>${receipt.name}</td>
                    <td>${receipt.createTime}</td>
                    <td>
                        <c:if test = "${receipt.userRoleId != 1}">
                            <form action="${pageContext.request.contextPath}/api/block-user-action" method="post">
                                <input type="hidden" name="id" value="${receipt.id}">
                                <input type="hidden" name="block" value="${!receipt.blocked}">
                                <c:choose>
                                    <c:when test="${receipt.blocked}">
                                        <button class="uk-button uk-button-default" type="submit">Unblock</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="uk-button uk-button-default" type="submit">Block</button>
                                    </c:otherwise>
                                </c:choose>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</section>

</body>
</html>