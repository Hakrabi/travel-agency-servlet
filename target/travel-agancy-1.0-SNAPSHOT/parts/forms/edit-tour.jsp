<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3 class="uk-card-title uk-text-center">Edit Tour</h3>
<form action="${pageContext.request.contextPath}/api/edit-tour-action" method="POST">
    <input type="hidden" value="${tour.id}" name="id">

    <div class="uk-margin">
        <input class="uk-input uk-form-large" type="text" placeholder="Name" name="name" value="${tour.name}">
    </div>
    <div class="uk-margin">
        <textarea class="uk-textarea uk-form-large"  placeholder="Description" name="description">${tour.description}</textarea>
    </div>
    <div class="uk-margin">
        <div class="uk-grid">
            <div class="uk-width-1-2@s">
                <input class="uk-input uk-form-large" type="text" placeholder="Price" name="price" value="${tour.price}">
            </div>
            <div class="uk-width-1-2@s">
                <input  class="uk-input uk-form-large" type="number" placeholder="Persons" id="persons" name="persons"
                        min="1" max="10" value="${tour.persons}">
            </div>
        </div>
    </div>

    <div class="uk-margin">
        <div class="uk-grid" uk-grid>
            <div class="uk-width-auto@m">
                <label class="uk-form-label" for="hotel_type">Hotel</label>
            </div>
            <div class="uk-width-expand@m">
                <input id="hotel_type" class="uk-range" type="range" value="${tour.hotelTypeId}" min="1" max="5" step="1" name="hotel_type">
                <div class="uk-flex uk-flex-between">
                    <div>1</div>
                    <div>2</div>
                    <div>3</div>
                    <div>4</div>
                    <div>5</div>
                </div>
            </div>
        </div>
    </div>

    <div class="uk-margin uk-grid-small uk-child-width-auto uk-grid">
        <label><input class="uk-radio" type="radio" name="tour_type" value="1"
                      <c:if test="${tour.tourTypeId == 1}">checked</c:if>> Excursion</label>
        <label><input class="uk-radio" type="radio" name="tour_type" value="2"
                      <c:if test="${tour.tourTypeId == 2}">checked</c:if>> Vacation</label>
        <label><input class="uk-radio" type="radio" name="tour_type" value="3"
                      <c:if test="${tour.tourTypeId == 3}">checked</c:if>> Shopping</label>
    </div>

    <div class="uk-margin uk-grid-small uk-child-width-auto uk-grid">

        <label><input class="uk-checkbox" type="checkbox" name="hot" value="true"
                      <c:if test="${tour.hot}">checked</c:if>> Hot</label>
    </div>

    <div class="uk-margin uk-align-center">
        <div uk-form-custom >
            <input type="file" name="img">
            <button class="uk-button uk-button-large" type="button" tabindex="-1">Change Image</button>
        </div>
    </div>


    <div class="uk-margin-large-top">
        <button type="submit" class="uk-button uk-button-primary uk-button-large uk-width-1-1">Edit Tour</button>
    </div>

</form>