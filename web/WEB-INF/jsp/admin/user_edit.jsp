<jsp:useBean id="user" class="controllers.DAO.beans.User" scope="request" type="controllers.DAO.beans.User" />
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"><fmt:message key='user_update'/></h1>
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a>
            </li>
            <li class="active">About</li>
        </ol>
    </div>
</div>
<div class="row">
    <div class="col-lg-7">
        <div class="well bs-component">
            <form class="form-horizontal" action="user_edit" method="post">
                <fieldset>
                    <legend>Add new user</legend>
                    <input type="text" value="${user.id}" name="id" hidden>
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label"><fmt:message key='name'/></label>

                        <div class="col-lg-9">
                            <input type="text" id="inputName" class="form-control" name="name" value="${user.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPhone" class="col-lg-2 control-label" ><fmt:message key='phone'/></label>

                        <div class="col-lg-9">
                            <input type="text" id="inputPhone" class="form-control" name="phone" value="${user.phone}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label"><fmt:message key='signin.password'/></label>

                        <div class="col-lg-9">
                            <input type="text" id="inputPassword" class="form-control" name="password" value="${user.password}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputRole" class="col-lg-2 control-label"><fmt:message key='role'/></label>

                            <div class="col-lg-9">
                                <select id="inputRole" class="form-control" name="role" >
                                    <c:if test="${user_session.role.equals('manager')}">
                                        <option>${user.role}</option>
                                    </c:if>
                                    <c:if test="${user_session.role.equals('admin')}">
                                        <option><fmt:message key='user'/></option>
                                        <option>manager</option>
                                        <option>admin</option>
                                    </c:if>
                                </select>
                            </div>

                    </div>

                    <div class="form-group">
                        <label for="inputStatus" class="col-lg-2 control-label"><fmt:message key='status'/></label>
                        <%--<div class="col-lg-8 col-lg-offset-2">--%>
                            <%--<input type="checkbox" name="status" id="inputStatus" value="1">--%>
                            <%--<input type="checkbox" name="status"  value="0" hidden checked>--%>
                            <%--Status VIP--%>
                        <%--</div>--%>
                            <div class="col-lg-9">
                                <select id="inputStatus" class="form-control" name="status" >
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                </select>
                            </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-8 col-lg-offset-2">
                            <button type="submit" class="btn btn-primary"><fmt:message key='submit'/></button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    <div class="col-lg-5 ">
        <div class="well bs-component">
            <h3>Contact Details</h3>

            <p>
                3481 Melrose Place<br>Beverly Hills, CA 90210<br>
            </p>

            <p><i class="fa fa-phone"></i>
                <abbr title="Phone">P</abbr>: (123) 456-7890</p>

            <p><i class="fa fa-envelope-o"></i>
                <abbr title="Email">E</abbr>: <a href="mailto:name@example.com">name@example.com</a>
            </p>

            <p><i class="fa fa-clock-o"></i>
                <abbr title="Hours">H</abbr>: Monday - Friday: 9:00 AM to 5:00 PM</p>
            <ul class="list-unstyled list-inline list-social-icons">
                <li>
                    <a href="#"><i class="fa fa-facebook-square fa-2x"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-twitter-square fa-2x"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-google-plus-square fa-2x"></i></a>
                </li>
            </ul>
        </div>
    </div>
</div>