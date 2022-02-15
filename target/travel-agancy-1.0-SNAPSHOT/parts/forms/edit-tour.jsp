<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h3 class="uk-card-title uk-text-center">Edit Tour</h3>
<form action="${pageContext.request.contextPath}?action=editTour" method="POST">

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
        <div class="uk-grid">
            <div class="uk-width-1-2@s" uk-form-custom="target: > * > span:first-child">
                <select name="tour_type">
                    <option value="">Tour Type</option>
                    <option value="1">Excursion</option>
                    <option value="2">Vacation</option>
                    <option value="3">Shopping</option>
                </select>
                <button class="uk-button uk-button-large" type="button" tabindex="-1">
                    <span></span>
                    <span uk-icon="icon: chevron-down"></span>
                </button>
            </div>

            <div class="uk-width-1-2@s" uk-form-custom="target: > * > span:first-child">
                <select name="hotel_type">
                    <option value="">Hotel Type</option>
                    <option value="1">★</option>
                    <option value="2">★★</option>
                    <option value="3">★★★</option>
                    <option value="4">★★★★</option>
                    <option value="5">★★★★★</option>
                </select>
                <button class="uk-button uk-button-large" type="button" tabindex="-1">
                    <span></span>
                    <span uk-icon="icon: chevron-down"></span>
                </button>
            </div>
        </div>
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