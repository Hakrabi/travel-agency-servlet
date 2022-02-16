<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="uk-pagination" uk-margin>

    <c:forEach items="${tourList}" var="tour" varStatus="status">
        <tr>
            <td>${tour.id}</td>
            <td><a href="${pageContext.request.contextPath}/tour?id=${tour.id}">${tour.name}</a></td>
            <td>
                <a  class="uk-button uk-button-default"
                    href="${pageContext.request.contextPath}/edit-tour?id=${tour.id}">
                    Edit Tour
                </a>
            </td>

        </tr>
    </c:forEach>


    <li><a href="#"><span uk-pagination-previous></span></a></li>
    <li><a href="#">1</a></li>
    <li class="uk-disabled"><span>...</span></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">6</a></li>
    <li class="uk-active"><span>7</span></li>
    <li><a href="#">8</a></li>
    <li><a href="#">9</a></li>
    <li><a href="#">10</a></li>
    <li class="uk-disabled"><span>...</span></li>
    <li><a href="#">20</a></li>
    <li><a href="#"><span uk-pagination-next></span></a></li>
</ul>