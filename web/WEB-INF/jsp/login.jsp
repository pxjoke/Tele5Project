<div class="container">

    <form class="form-signin" action="j_security_check" method="post">
        <h2 class="form-signin-heading"><fmt:message key='signin.welcome'/></h2>
        <label for="inputEmail" class="sr-only"><fmt:message key='phone'/></label>
        <input type="text" id="inputEmail" class="form-control" placeholder="<fmt:message key='signin.phone'/>"  name="j_username" required autofocus>
        <label for="inputPassword" class="sr-only"><fmt:message key='signin.password'/></label>
        <input type="password" id="inputPassword" class="form-control" placeholder="<fmt:message key='signin.password'/>" name="j_password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key='signin'/></button>
    </form>

</div> <!-- /container -->