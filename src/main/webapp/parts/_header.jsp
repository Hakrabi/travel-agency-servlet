<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <div class="uk-container">
        <nav class="uk-navbar-container" uk-navbar>
            <div class="uk-navbar-left">

                <a class="uk-navbar-item uk-logo" href="${pageContext.request.contextPath}">Tours</a>

                <c:choose>
                    <c:when test="${sessionScope.user.user_role_id == 1}">
                        <ul class="uk-navbar-nav">
                            <li>
                                <a href="#">Tables</a>
                                <div class="uk-navbar-dropdown">
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li><a href="${pageContext.request.contextPath}/api/user-list">User List</a></li>
                                        <li><a href="${pageContext.request.contextPath}/api/tour-list">Tour List</a></li>
                                        <li><a href="${pageContext.request.contextPath}/api/user-list">Receipt List</a></li>
                                    </ul>
                                </div>
                            </li>

                            <li>
                                <a href="#">Create</a>
                                <div class="uk-navbar-dropdown">
                                    <ul class="uk-nav uk-navbar-dropdown-nav">
                                        <li><a href="${pageContext.request.contextPath}/api/add-tour">Tour</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </c:when>
                </c:choose>



            </div>


            <div class="uk-navbar-right">
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <button class="uk-button uk-button-default uk-margin-small-right" type="button" uk-toggle="target: #modal-login">Sign In</button>
                        <a class="uk-button uk-button-default uk-margin-small-right" href="${pageContext.request.contextPath}/api/registration">Sign Up</a>
                    </c:when>
                    <c:otherwise>
                        <div class="uk-margin-medium-right">Hi, ${sessionScope.user.name}</div>
                        <a class="uk-button uk-button-default uk-margin-small-right" href="${pageContext.request.contextPath}/api/profile">Profile</a>
                        <form action="${pageContext.request.contextPath}/api/logout-action" method="post">
                            <button class="uk-button uk-button-default uk-margin-small-right" type="submit">Logout</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>
    </div>
</header>

<div id="modal-login" uk-modal>
    <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">
        <button class="uk-modal-close-default" type="button" uk-close></button>
        <jsp:include page="/parts/_login-form.jsp"/>
    </div>
</div>
