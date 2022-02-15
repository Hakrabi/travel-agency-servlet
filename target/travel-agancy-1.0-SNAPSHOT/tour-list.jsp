<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Users" scope="page"/>
<jsp:include page="/parts/_head.jsp"/>

<body>

<jsp:include page="/parts/_header.jsp"/>


<section id="tours">
    <div class="uk-container">

        <table class="uk-table uk-table-middle uk-table-divider">
            <thead>
            <tr>
                <th class="uk-width-small">ID</th>
                <th>Name</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${tourList}" var="tour" varStatus="status">
                <tr>
                    <td>${tour.id}</td>
                    <td><a href="${pageContext.request.contextPath}?action=singleTour&tourId=${tour.id}">${tour.name}</a></td>
                    <td>
                        <a  class="uk-button uk-button-default"
                            href="${pageContext.request.contextPath}?action=editTourPage&tourId=${tour.id}">
                            Edit Tour
                        </a>
                    </td>

                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</section>

</body>
</html>