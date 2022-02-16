<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h3 class="uk-card-title uk-text-center">Sign Up</h3>
<form>
    <div class="uk-margin">
        <div class="uk-inline uk-width-1-1">
            <span class="uk-form-icon" uk-icon="icon: mail"></span>
            <input class="uk-input uk-form-large" type="text" placeholder="Email">
        </div>
    </div>
    <div class="uk-margin">
        <div class="uk-inline uk-width-1-1">
            <span class="uk-form-icon" uk-icon="icon: lock"></span>
            <input class="uk-input uk-form-large" type="password" placeholder="Password">
        </div>
    </div>
    <div class="uk-margin">
        <div class="uk-inline uk-width-1-1">
            <span class="uk-form-icon" uk-icon="icon: user"></span>
            <input class="uk-input uk-form-large" type="password" placeholder="Name">
        </div>
    </div>

    <div class="uk-margin">
        <button class="uk-button uk-button-primary uk-button-large uk-width-1-1">Sign Up</button>
    </div>

    <div class="uk-text-small uk-text-center">
        Already have an account? <a href="${pageContext.request.contextPath}/login" >Sign In</a>
    </div>
</form>