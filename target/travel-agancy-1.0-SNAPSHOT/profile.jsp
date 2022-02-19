<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Profile - ${user.name}" scope="request"/>
<jsp:include page="/parts/_head.jsp"/>


<body>
<jsp:include page="/parts/_header.jsp"/>

<div class="uk-section uk-section-muted uk-flex uk-flex-middle uk-animation-fade" uk-height-viewport="expand: true">

    <div class="uk-width-1-1">
        <div class="uk-container">
            <div class="uk-grid-margin uk-grid uk-grid-stack" uk-grid>
                <div class="uk-width-1-1@m">
                    <div class="uk-margin uk-width-large uk-margin-auto uk-card uk-card-default uk-card-body uk-box-shadow-large">

                        <div class="uk-card-header uk-card-large">
                            <div class="uk-width-auto">
                                <h3 class="uk-card-title uk-margin-remove-bottom">${sessionScope.user.name}, ${sessionScope.user.userRoleId}</h3>
                                <p class="uk-text-meta uk-margin-remove-top">${sessionScope.user.login}</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
