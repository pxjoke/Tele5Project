<jsp:useBean id="service" class="controllers.DAO.beans.Service" scope="request" type="controllers.DAO.beans.Service"/>
<jsp:useBean id="tariff" class="controllers.DAO.beans.Tariff" scope="request" type="controllers.DAO.beans.Tariff"/>
<div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">
            <c:if test="${service.type.equals('tariff')}">
                Tariff <c:out value="${service.name}"/>
            </c:if>
            <c:if test="${service.type.equals('package')}">
                Package <c:out value="${service.name}"/>
            </c:if>
            <c:if test="${service.type.equals('passive')}">
                Service <c:out value="${service.name}"/>
            </c:if>
        </h1>
        <hr>
    </div>
</div>
<div class="row">

    <div class="col-lg-8">
        <div class="well">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive img-rounded" src="/img/sample_900_350.png" alt="">
                </div>
            </div>
            <hr/>
            <c:if test="${service.type.equals('tariff') || service.type.equals('package')}">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="panel panel-warning">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-4x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <c:if test="${service.type.equals('tariff')}">
                                            <div class="huge">${tariff.minutes}$</div>
                                            <div>Minute cost</div>
                                        </c:if>
                                        <c:if test="${service.type.equals('package')}">
                                            <div class="huge">${service.minutes}</div>
                                            <div>Minutes</div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="panel panel-success">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-envelope fa-4x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <c:if test="${service.type.equals('tariff')}">
                                            <div class="huge">${tariff.sms}$</div>
                                            <div>SMS cost</div>
                                        </c:if>
                                        <c:if test="${service.type.equals('package')}">
                                            <div class="huge">${service.sms}</div>
                                            <div>SMS</div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="panel panel-info">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-globe fa-4x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <c:if test="${service.type.equals('tariff')}">
                                            <div class="huge">${tariff.internet}$</div>
                                            <div>Mb cost</div>
                                        </c:if>
                                        <c:if test="${service.type.equals('package')}">
                                            <div class="huge">${service.internet}</div>
                                            <div>Mb</div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

    <div class="col-lg-4 ">
        <div class="well">
            <div class="panel panel-success">

                <div class="panel-body">

                    <p>${service.description}</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                </div>
                <div class="panel-footer">
                    <a href="/buy?id=${service.id}" class="btn btn-success">Buy for ${service.cost}$</a>
                    <c:if test="${user_session.role.equals('admin')}">
                        <div class="pull-right">
                            <a href="/admin/service_edit?id=${service.id}" class="btn btn-warning"><i class="fa fa-edit"></i></a>
                            <a href="/admin/service_delete?id=${service.id}" class="btn btn-danger"><i class="fa fa-remove"></i></a>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

</div>


