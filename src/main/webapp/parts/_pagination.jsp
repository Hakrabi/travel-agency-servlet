<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="uk-pagination uk-flex-center" uk-margin>

    <c:choose>
        <c:when test="${page - 1 > 0}">
            <li><a href="${origRequestURL}?page=${page-1}"><span uk-pagination-previous></span></a></li>
        </c:when>
        <c:otherwise>
            <li><a href=""><span uk-pagination-previous></span></a></li>
        </c:otherwise>
    </c:choose>

    <c:forEach var="p" begin="1" end="${pageCount+1}">
        <c:choose>
            <c:when test="${page == p}">
                <li class="uk-active"><span>${p}</span></li>
            </c:when>
            <c:otherwise>
                <li><a href="${origRequestURL}?page=${p}">${p}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:choose>
        <c:when test="${page + 1 <= pageCount}">
            <li><a href="${origRequestURL}?page=${page+1}"><span uk-pagination-next></span></a></li>
        </c:when>
        <c:otherwise>
            <li><a href=""><span uk-pagination-next></span></a></li>
        </c:otherwise>
    </c:choose>

</ul>