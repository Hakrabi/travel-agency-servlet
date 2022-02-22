<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="prevUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'page'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param  name="page" value="${page-1}"/>
</c:url>

<c:url var="nextUrl" value="">
    <c:forEach items="${param}" var="entry">
        <c:if test="${entry.key != 'page'}">
            <c:param name="${entry.key}" value="${entry.value}" />
        </c:if>
    </c:forEach>
    <c:param  name="page" value="${page+1}"/>
</c:url>


<ul class="uk-pagination uk-flex-center" uk-margin>
    <c:choose>
        <c:when test="${page - 1 > 0}">
            <li><a href="${prevUrl}"><span uk-pagination-previous></span></a></li>
        </c:when>
        <c:otherwise>
            <li><a href=""><span uk-pagination-previous></span></a></li>
        </c:otherwise>
    </c:choose>

    <c:forEach var="p" begin="1" end="${pageCount}">
        <c:choose>
            <c:when test="${page == p}">
                <li class="uk-active"><span>${p}</span></li>
            </c:when>
            <c:otherwise>

                <c:url var="currUrl" value="">
                    <c:forEach items="${param}" var="entry">
                        <c:if test="${entry.key != 'page'}">
                            <c:param name="${entry.key}" value="${entry.value}" />
                        </c:if>
                    </c:forEach>
                    <c:param  name="page" value="${p}"/>
                </c:url>

                <li><a href="${currUrl}">${p}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:choose>
        <c:when test="${page + 1 <= pageCount}">
            <li><a href="${nextUrl}"><span uk-pagination-next></span></a></li>
        </c:when>
        <c:otherwise>
            <li><a href=""><span uk-pagination-next></span></a></li>
        </c:otherwise>
    </c:choose>

</ul>