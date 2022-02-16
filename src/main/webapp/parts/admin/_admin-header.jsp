<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <div class="uk-container">
        <nav class="uk-navbar-container" uk-navbar>
            <div class="uk-navbar-left">

                <a class="uk-navbar-item uk-logo" href="#">Logo</a>

            </div>


            <div class="uk-navbar-right">
                <li>
                    <a href="#">Tables</a>
                    <div class="uk-navbar-dropdown">
                        <ul class="uk-nav uk-navbar-dropdown-nav">
                            <li><a href="#">User List</a></li>
                            <li><a href="#">Tour List</a></li>
                            <li><a href="#">Receipt List</a></li>
                        </ul>
                    </div>
                </li>
            </div>
        </nav>
    </div>
</header>

<div id="modal-login" uk-modal>
    <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">
        <button class="uk-modal-close-default" type="button" uk-close></button>
        <jsp:include page="/parts/_login-form.jsp"/>
    </div>
</div>

<div id="modal-reg" uk-modal>
    <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">
        <button class="uk-modal-close-default" type="button" uk-close></button>
        <h3>reg</h3>
    </div>
</div>
