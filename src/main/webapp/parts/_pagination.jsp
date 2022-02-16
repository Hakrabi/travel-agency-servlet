<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="uk-pagination" uk-margin>

    <c:choose>
        <c:when test="${page - 1 > 0}">
            <li><a href="${pageContext.request.contextPath}/tour?page=${page-1}"><span uk-pagination-previous></span></a></li>
        </c:when>
        <c:otherwise>
            <li><span uk-pagination-previous></span></li>
        </c:otherwise>
    </c:choose>

    <c:forEach var="p" begin="${minPossiblePage}" end="${maxPossiblePage}">
        <c:choose>
            <c:when test="${page == p}">
                <li class="uk-active"><span>${p}</span></li>
            </c:when>
            <c:otherwise>
                <li><a href="page?page=${p}">${p}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:choose>
        <c:when test="${page + 1 <= pageCount}">
            <li><a href="${pageContext.request.requestUri}/?page=${page+1}"><span uk-pagination-next></span></a></li>
        </c:when>
        <c:otherwise>
            <li><span uk-pagination-next></span></li>
        </c:otherwise>
    </c:choose>

</ul>