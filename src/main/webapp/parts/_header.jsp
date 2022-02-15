<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <div class="uk-container">
        <nav class="uk-navbar-container" uk-navbar>
            <div class="uk-navbar-left">

                <a class="uk-navbar-item uk-logo" href="#">Logo</a>

            </div>


            <div class="uk-navbar-right">
                <c:choose>
                    <c:when test="${condition1}">
                        ...
                    </c:when>
                    <c:when test="${condition2}">
                        ...
                    </c:when>
                    <c:otherwise>
                        ...
                    </c:otherwise>
                </c:choose>
                <button class="uk-button uk-button-default uk-margin-small-right" type="button" uk-toggle="target: #modal-login">Sign In</button>
                <a class="uk-button uk-button-default uk-margin-small-right" href="${pageContext.request.contextPath}?action=registration">Sign Up</a>
<%--                <button  type="button" uk-toggle="target: #modal-reg"></button>--%>
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

<div id="modal-reg" uk-modal>
    <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">
        <button class="uk-modal-close-default" type="button" uk-close></button>
        <h3>reg</h3>
    </div>
</div>
