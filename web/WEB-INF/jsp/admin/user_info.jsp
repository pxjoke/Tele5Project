<jsp:useBean id="user" class="controllers.DAO.beans.User" scope="request" type="controllers.DAO.beans.User"/>
<jsp:useBean id="tariff" class="controllers.DAO.beans.Tariff" scope="request" type="controllers.DAO.beans.Tariff"/>
<jsp:useBean id="user_services" scope="request" type="java.util.List<controllers.DAO.beans.UserService>"/>
<jsp:useBean id="accounts" scope="request" type="java.util.List<controllers.DAO.beans.Account>"/>
<div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">
            Dashboard
        </h1>
        <hr>
    </div>
</div>

<div class="row">
    <div class="col-lg-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-male fa-fw"></i> User Info</h3>
            </div>
            <div class="panel-body">
                <div class="list-group">
                    <div class="list-group-item list-group

                    <c:choose>
                            <c:when test="${user.status == 0}">
                                list-group-item-danger
                            </c:when>
                            <c:when test="${user.status == 1}">
                                list-group-item-success
                            </c:when>
                    <c:when test="${user.status == 2}">
                         list-group-item-info
                    </c:when>
                    </c:choose>  ">

                        <c:choose>
                            <c:when test="${user.status == 0}">
                                <span class="badge">blocked</span>
                            </c:when>
                            <c:when test="${user.status == 1}">
                                <span class="badge">active</span>
                            </c:when>
                            <c:when test="${user.status == 2}">
                                <span class="badge">vip</span>
                            </c:when>
                        </c:choose>

                        <i class="fa fa-fw fa-mobile-phone"></i>
                        <jsp:getProperty name="user" property="phone"/>
                    </div>


                    <div href="#" class="list-group-item">
                        <span class="badge"> <jsp:getProperty name="user" property="role"/></span>
                        <i class="fa fa-fw fa-user"></i>
                        <jsp:getProperty name="user" property="name"/>
                    </div>
                </div>
                <div class="text-right">
                    <a href="/admin/user_edit?phone=${user.phone}">Change <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
        </div>
    </div>


    <div class="col-lg-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-bar-chart fa-fw"></i> Free packs: </h3>
            </div>
            <div class="panel-body">
                <div class="list-group">
                    <div class="list-group-item list-group">
                        <span class="badge"> <jsp:getProperty name="user" property="minutes"/></span>
                        <i class="fa fa-fw fa-phone"></i> Free minutes:
                    </div>

                    <div class="list-group-item list-group">
                        <span class="badge"> <jsp:getProperty name="user" property="sms"/></span>
                        <i class="fa fa-fw fa-envelope"></i> Free sms:
                    </div>

                    <div class="list-group-item list-group">
                        <span class="badge"> <jsp:getProperty name="user" property="internet"/></span>
                        <i class="fa fa-fw fa-globe"></i> Free internet:
                    </div>
                </div>

            </div>
        </div>
    </div>


    <div class="col-lg-4">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-mobile-phone fa-fw"></i> Tariff "${tariff.name}" </h3>
            </div>
            <div class="panel-body">
                <div class="list-group">
                    <div class="list-group-item list-group">
                        <span class="badge"> <jsp:getProperty name="tariff" property="minutes"/></span>
                        <i class="fa fa-fw fa-phone"></i> Minute cost:
                    </div>

                    <div class="list-group-item list-group">
                        <span class="badge"> <jsp:getProperty name="tariff" property="sms"/></span>
                        <i class="fa fa-fw fa-envelope"></i> SMS cost:
                    </div>

                    <div class="list-group-item list-group">
                        <span class="badge"> <jsp:getProperty name="tariff" property="internet"/></span>
                        <i class="fa fa-fw fa-globe"></i> Mb cost:
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

<div class="row">
    <div class="col-lg-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-bar-chart fa-fw"></i> Services: </h3>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Cost</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${user_services}" var="user_service" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${user_service.serviceName}</td>
                                <td>${user_service.serviceCost}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="col-lg-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-bar-chart fa-fw"></i> Orders: </h3>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Open</th>
                            <th>Close</th>
                            <th>Status</th>
                            <th>Total price:</th>

                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${accounts}" var="account" varStatus="status1">
                            <tr>
                                <td><a href="/order_info?id=${account.id}"><c:out value="${account.id}"/></a></td>
                                <td><c:out value="${account.openDate}"/></td>
                                <td>
                                    <c:if test="${account.closed}">
                                        <c:out value="${account.closeDate}"/>
                                    </c:if>
                                </td>
                                <td><c:out value="${account.closed}"/></td>
                                <td><c:out value="${account.totalPrice}$"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>



