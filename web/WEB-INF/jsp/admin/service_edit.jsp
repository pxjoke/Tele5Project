<jsp:useBean id="service" scope="request" class="controllers.DAO.beans.Service" />
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Update Tariff</h1>
        <%--<ol class="breadcrumb">--%>
            <%--<li><a href="index.html">Home</a>--%>
            <%--</li>--%>
            <%--<li class="active">About</li>--%>
        <%--</ol>--%>
    </div>
</div>
<div class="row">
    <div class="col-lg-7">
        <div class="well bs-component">
            <form class="form-horizontal" action="service_edit" method="post">
                <fieldset>
                    <legend>Add new tariff</legend>
                    <div class="form-group">
                        <label for="inputName" class="col-lg-2 control-label">Name</label>

                        <div class="col-lg-9">
                            <input type="text" id="inputName" class="form-control" value="${service.name}" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputMinute" class="col-lg-2 control-label">Minute cost: </label>

                        <div class="col-lg-9">
                            <input type="text" id="inputMinute" class="form-control" value="${service.minutes}" name="minutes">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputSMS" class="col-lg-2 control-label">SMS cost</label>

                        <div class="col-lg-9">
                            <input type="text" id="inputSMS" class="form-control" value="${service.sms}" name="sms">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputInternet" class="col-lg-2 control-label">Internet cost</label>

                        <div class="col-lg-9">
                            <input type="text" id="inputInternet" class="form-control" value="${service.internet}" name="internet">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="inputPrice" class="col-lg-2 control-label">Price:</label>

                        <div class="col-lg-9">
                            <input type="text" id="inputPrice" class="form-control" value="${service.cost}" name="cost">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputDescription" class="col-lg-2 control-label">Description:</label>

                        <div class="col-lg-9">
                            <textarea id="inputDescription" class="form-control" rows="4"  name="description"><c:out value="${service.description}"/></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputType" class="col-lg-2 control-label">Type: </label>

                        <div class="col-lg-9">
                            <select id="inputType" class="form-control" name="type">
                                <option>passive</option>
                                <option>package</option>
                            </select>
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-lg-8 col-lg-offset-2">--%>
                            <%--<input type="checkbox" name="userStatus" id="inputStatus" value="1">--%>
                            <%--<input type="checkbox" name="userStatus"  value="0" hidden checked>--%>
                            <%--For VIP only--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <input type="text" name="serviceId" value="${service.id}" hidden>
                    <div class="form-group">
                        <div class="col-lg-8 col-lg-offset-2">
                            <button type="submit" class="btn btn-primary">Submit</button>
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