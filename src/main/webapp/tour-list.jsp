<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<c:set var="title" value="Users" scope="request"/>
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
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${tourList}" var="tour" varStatus="status">
                <tr>
                    <td>${tour.id}</td>
                    <td><a href="${pageContext.request.contextPath}/api/tour?id=${tour.id}">${tour.name}</a></td>
                    <td>
                        <a  class="uk-button uk-button-default"
                            href="${pageContext.request.contextPath}/api/edit-tour?id=${tour.id}">
                            Edit Tour
                        </a>
                    </td>
                    <td>
                        <button class="uk-button uk-button-default" type="button">Delete Tour</button>
                        <div uk-dropdown>
                            <form action="${pageContext.request.contextPath}/api/delete-tour-action" method="post">
                                <input type="hidden" value="${tour.id}" name="tourId">

                                <button type="submit" class="uk-button uk-button-default uk-width-1-1" >Delete</button>
                            </form>
                        </div>

                    </td>

                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</section>

</body>
</html>