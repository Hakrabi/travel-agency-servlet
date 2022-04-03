<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h3 class="uk-card-title uk-text-center">Add Tour</h3>
<form action="${pageContext.request.contextPath}/api/add-tour-action" method="post">

    <div class="uk-margin">
        <input class="uk-input uk-form-large" type="text" placeholder="Name" name="name">
    </div>
    <div class="uk-margin">
        <textarea class="uk-textarea uk-form-large"  placeholder="Description" name="description"></textarea>
    </div>

    <div class="uk-margin">
        <div class="uk-grid">
            <div class="uk-width-1-2@s">
                <input class="uk-input uk-form-large" type="number" min="1" placeholder="Price" name="price" >
            </div>
            <div class="uk-width-1-2@s">
                <input  class="uk-input uk-form-large" type="number" placeholder="Persons" id="persons" name="persons"
                        min="1" max="10" value="">
            </div>
        </div>
    </div>

    <div class="uk-margin">
        <div class="uk-grid" uk-grid>
            <div class="uk-width-auto@m">
                <label class="uk-form-label" for="hotel_type">Hotel</label>
            </div>
            <div class="uk-width-expand@m">
                <input id="hotel_type" class="uk-range" type="range" value="2" min="1" max="5" step="1" name="hotel_type">
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
        <label><input class="uk-radio" type="radio" name="tour_type" value="1"> Excursion</label>
        <label><input class="uk-radio" type="radio" name="tour_type" value="2"> Vacation</label>
        <label><input class="uk-radio" type="radio" name="tour_type" value="3"> Shopping</label>
    </div>

    <div class="uk-margin">
        <div class="uk-grid">
            <div class="uk-width-1-2@s">
                <input class="uk-input uk-form-large" type="text" placeholder="Discount limit" name="discount_limit"
                       min="1" max="100">
            </div>
            <div class="uk-width-1-2@s">
                <input  class="uk-input uk-form-large" type="number" placeholder="Discount step" name="discount_step"
                        min="1" max="10">
            </div>
        </div>
    </div>

    <div class="uk-margin uk-grid-small uk-child-width-auto uk-grid">
        <label><input class="uk-checkbox" type="checkbox" name="hot" value="true"> Hot</label>
    </div>

    <div class="uk-margin uk-align-center">
        <div uk-form-custom >
            <input type="file" name="img">
            <button class="uk-button uk-button-large" type="button" tabindex="-1">Change Image</button>
        </div>
    </div>


    <div class="uk-margin-large-top">
        <button type="submit" class="uk-button uk-button-primary uk-button-large uk-width-1-1">Add Tour</button>
    </div>


    <c:choose>
        <c:when test="${sessionScope.error != null}">
            <div class="uk-alert-danger" uk-alert>
                <a class="uk-alert-close" uk-close></a>
                <p>${sessionScope.error}</p>
            </div>
        </c:when>
    </c:choose>

</form>