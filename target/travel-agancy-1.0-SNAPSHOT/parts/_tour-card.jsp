
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div>
    <div class="uk-card uk-card-default ">
        <div class="uk-card-media-top">

            <c:if test="${requestScope.tour.hot}">
                <div class="uk-card-badge uk-label" style="background-color: #ff4e00;">Hot</div>
            </c:if>

            <div class="uk-cover-container">
                <canvas width="400" height="250"></canvas>
                <img src="${pageContext.request.contextPath}/img/${requestScope.tour.imgUrl}"  alt="" uk-cover>
            </div>

        </div>
        <div class="uk-card-body uk-card-small">

            <div class="uk-card-header uk-card-small">
                <div class="uk-grid-small uk-flex-between" uk-grid>
                    <div class="uk-width-auto">
                        <h3 class="uk-card-title uk-margin-remove-bottom">${requestScope.tour.name}</h3>
                        <p class="uk-text-meta uk-margin-remove-top">${requestScope.tour.tourTypeId}</p>
                    </div>
                    <div class="uk-width-auto">
                        <h3><b>$${requestScope.tour.price}</b></h3>
                    </div>
                </div>
            </div>

            <div class="uk-card-body uk-card-small">
                <p>${requestScope.tour.description}</p>
                <p class="uk-margin-small"><b>Hotel: </b>
                    <c:forEach var = "i" begin = "1" end = "${requestScope.tour.hotelTypeId}">
                        ★
                    </c:forEach>
                    </p>
                <p class="uk-margin-small"><b>Persons: </b>${requestScope.tour.persons}</p>
            </div>

            <div class="uk-card-footer uk-card-small">

                <c:choose>
                    <c:when test="${user == null}">
                        <button class="uk-button uk-button-default" type="button" uk-toggle="target: #modal-login">Book now</button>
                    </c:when>
                    <c:otherwise>
                        <form action="${pageContext.request.contextPath}/api/add-receipt-action" method="post">
                            <input type="hidden" name="tourId" value="${requestScope.tour.id}">
                            <button class="uk-button uk-button-default" type="submit">Book now</button>
                        </form>
                    </c:otherwise>
                </c:choose>

            </div>

        </div>
    </div>
</div>