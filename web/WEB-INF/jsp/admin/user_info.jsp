<jsp:useBean id="user" class="controllers.DAO.beans.User" scope="request" type="controllers.DAO.beans.User"/>
<jsp:useBean id="tariff" class="controllers.DAO.beans.Tariff" scope="request" type="controllers.DAO.beans.Tariff"/>
<jsp:useBean id="user_services" scope="request" type="java.util.List<controllers.DAO.beans.UserService>"/>
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
                    <div class="list-group-item list-group list-group-item-success">
                        <span class="badge">active</span>
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
    <div class="col-lg-12">
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
</div>



