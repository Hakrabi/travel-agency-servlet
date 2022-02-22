<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="allUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'type'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>

    <c:param  name="type" value="all"/>
</c:url>

<c:url var="excursionUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'type'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="type" value="excursion"/>
</c:url>

<c:url var="vacationUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'type'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="type" value="vacation"/>
</c:url>

<c:url var="shoppingUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'type'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="type" value="shopping"/>
</c:url>

<c:url var="priceUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'sort'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="sort" value="price"/>
</c:url>

<c:url var="personsUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'sort'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="sort" value="persons"/>
</c:url>

<c:url var="hotelUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'sort'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="sort" value="hotel"/>
</c:url>


<c:url var="ascUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'order'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="order" value="asc"/>
</c:url>

<c:url var="descUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'order'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param name="order" value="desc"/>
</c:url>



<div class="uk-grid-small uk-flex-middle" uk-grid>
    <div class="uk-width-expand">

        <div class="uk-grid-small uk-grid-divider uk-child-width-auto" uk-grid>
            <div>
                <ul class="uk-subnav uk-subnav-pill" uk-margin>
                    <li <c:if test="${param.type == null || param.type == 'all'}">class="uk-active"</c:if>>
                        <a href="${allUrl}">All</a></li>
                </ul>
            </div>
            <div>
                <ul class="uk-subnav uk-subnav-pill" uk-margin>
                    <li <c:if test="${param.type == 'excursion' }">class="uk-active"</c:if>>
                        <a href="${excursionUrl}">Excursion</a></li>
                    <li <c:if test="${param.type == 'vacation' }">class="uk-active"</c:if>>
                        <a href="${vacationUrl}">Vacation</a></li>
                    <li <c:if test="${param.type == 'shopping' }">class="uk-active"</c:if>>
                        <a href="${shoppingUrl}">Shopping</a></li>
                </ul>
            </div>
            <div>
                <ul class="uk-subnav uk-subnav-pill" uk-margin>
                    <li <c:if test="${param.sort == 'price'}">class="uk-active"</c:if>>
                        <a href="${priceUrl}">Price</a></li>
                    <li <c:if test="${param.sort == 'persons'}">class="uk-active"</c:if>>
                        <a href="${personsUrl}">Persons</a></li>
                    <li <c:if test="${param.sort == 'hotel'}">class="uk-active"</c:if>>
                        <a href="${hotelUrl}">Hotel</a></li>
                </ul>
            </div>
        </div>

    </div>
    <div class="uk-width-auto uk-text-nowrap">
        <span <c:if test="${param.order == 'desc'}">class="uk-active"</c:if>>
            <a class="uk-icon-link" href="${descUrl}" uk-icon="icon: arrow-down"></a></span>
        <span <c:if test="${param.order == 'asc'}">class="uk-active"</c:if>>
            <a class="uk-icon-link" href="${ascUrl}" uk-icon="icon: arrow-up"></a></span>
    </div>
</div>