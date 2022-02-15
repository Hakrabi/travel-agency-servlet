
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div>
    <div class="uk-card uk-card-default ">
        <div class="uk-card-media-top">

            <c:if test="${requestScope.tour.hot}">
                <div class="uk-card-badge uk-label">Палаючий</div>
            </c:if>

            <img data-src="img/${requestScope.tour.imgUrl}" width="100%" height="80%" alt="" uk-img>
        </div>
        <div class="uk-card-body uk-card-small">

            <div class="uk-card-header uk-card-small">
                <div class="uk-grid-small uk-flex-between" uk-grid>
                    <div class="uk-width-auto">
                        <h3 class="uk-card-title uk-margin-remove-bottom">${requestScope.tour.name}</h3>
                        <p class="uk-text-meta uk-margin-remove-top">${requestScope.tour.tour_type_id}</p>
                    </div>
                    <div class="uk-width-auto">
                        <h3><b>$${requestScope.tour.price}</b></h3>
                    </div>
                </div>
            </div>

            <div class="uk-card-body uk-card-small">
                <p>${requestScope.tour.description}</p>
                <p class="uk-margin-small"><b>Hotel: </b>
                    <c:forEach var = "i" begin = "1" end = "${requestScope.tour.hotel_type_id}">
                        ★
                    </c:forEach>
                    </p>
                <p class="uk-margin-small"><b>Persons: </b>${requestScope.tour.persons}</p>
            </div>

            <div class="uk-card-footer uk-card-small">
                <a href="#" class="uk-button uk-button-text">Book now</a>
            </div>

        </div>
    </div>
</div>