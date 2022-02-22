<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3 class="uk-card-title uk-text-center">Welcome back!</h3>
<form action="${pageContext.request.contextPath}/api/login-action" method="post">
    <div class="uk-margin">
        <div class="uk-inline uk-width-1-1">
            <span class="uk-form-icon" uk-icon="icon: mail"></span>
            <input class="uk-input uk-form-large" type="text" name="login" placeholder="Email">
        </div>
    </div>
    <div class="uk-margin">
        <div class="uk-inline uk-width-1-1">
            <span class="uk-form-icon" uk-icon="icon: lock"></span>
            <input class="uk-input uk-form-large" type="password" name="password" placeholder="Password">
        </div>
    </div>
    <div class="uk-margin">
        <button type="submit" class="uk-button uk-button-primary uk-button-large uk-width-1-1">Sign In</button>
    </div>
    <div class="uk-text-small uk-text-center">
        Not registered? <a href="${pageContext.request.contextPath}/api/registration">Create an account</a>
    </div>

    <c:choose>
        <c:when test="${sessionScope.error != null}">
            <div class="uk-alert-danger" uk-alert>
                <a class="uk-alert-close" uk-close></a>
                <p>${sessionScope.error}</p>
            </div>
        </c:when>
    </c:choose>

</form>