<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Tours" scope="request"/>
<jsp:include page="/parts/_head.jsp"/>

<body>

<jsp:include page="/parts/_header.jsp"/>

<section id="tours">
    <div class="uk-container">

        <jsp:include page="/parts/_pagination.jsp"/>


        <div class="uk-child-width-1-3@m uk-margin" uk-grid uk-scrollspy="target: > div; cls: uk-animation-fade; delay: 500">

            <c:forEach items="${tourList}" var="tour" varStatus="status">
                <c:set var="tour" value="${tour}" scope="request"/>
                <c:import url="parts/_tour-card.jsp" />
            </c:forEach>

        </div>

    </div>
</section>



</body>
</html>