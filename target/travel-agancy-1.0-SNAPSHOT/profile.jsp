<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Profile - ${user.name}" scope="request"/>
<jsp:include page="/parts/_head.jsp"/>

<body>

<%--<jsp:include page="/parts/_header.jsp"/>--%>

<body>
<div class="uk-section uk-section-muted uk-flex uk-flex-middle uk-animation-fade" uk-height-viewport>
    <div class="uk-width-1-1">
        <div class="uk-container">
            <div class="uk-grid-margin uk-grid uk-grid-stack" uk-grid>
                <div class="uk-width-1-1@m">
                    <div class="uk-margin uk-width-large uk-margin-auto uk-card uk-card-default uk-card-body uk-box-shadow-large">
                        <p><b>ID: </b>${sessionScope.user.id}</p>
                        <p><b>Role: </b>${sessionScope.user.user_role_id}</p>
                        <p><b>Login: </b>${sessionScope.user.login}</p>
                        <p><b>Name: </b>${sessionScope.user.name}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
