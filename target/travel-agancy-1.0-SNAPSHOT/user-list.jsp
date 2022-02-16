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
                <th>Table Heading</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${userList}" var="user" varStatus="status">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.user_role_id}</td>
                    <td>${user.login}</td>
                    <td>${user.name}</td>
                    <td><button class="uk-button uk-button-default" type="button">Block</button></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</section>

</body>
</html>