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
                <input class="uk-input uk-form-large" type="text" placeholder="Price" name="price" >
            </div>
            <div class="uk-width-1-2@s">
                <input  class="uk-input uk-form-large" type="number" placeholder="Persons" id="persons" name="persons"
                        min="1" max="10" value="">
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
                <button class="uk-button uk-button-medium" type="button" tabindex="-1">
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
                <button class="uk-button uk-button-medium" type="button" tabindex="-1">
                    <span></span>
                    <span uk-icon="icon: chevron-down"></span>
                </button>
            </div>
        </div>
    </div>

    <div class="uk-margin">
        <input class="uk-range" type="range" value="2" min="0" max="5" step="1">
    </div>

    <div class="uk-margin">
        <div class="uk-form-controls uk-form-controls-text">
            <label><input class="uk-radio" type="radio" name="radio1"> Option 01</label><br>
            <label><input class="uk-radio" type="radio" name="radio1"> Option 02</label><br>
            <label><input class="uk-radio" type="radio" name="radio1"> Option 02</label>
        </div>
    <div class="uk-margin">

        <div class="uk-margin uk-grid-small uk-child-width-auto uk-grid">
            <label><input class="uk-checkbox" type="checkbox" checked> A</label>
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

</form>