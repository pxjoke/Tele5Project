<jsp:useBean id="tariffs" type="java.util.List<controllers.DAO.beans.Service>" scope="request"/>
<jsp:useBean id="passive" type="java.util.List<controllers.DAO.beans.Service>" scope="request"/>
<jsp:useBean id="packages" type="java.util.List<controllers.DAO.beans.Service>" scope="request"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            <fmt:message key='header.catalog'/>
        </h1>
        <hr>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <img class="img-responsive" src="http://placehold.it/1200x300" alt="">
    </div>
</div>
<div class="well">
    <h3><fmt:message key='tariffs'/></h3>
    <hr>
    <div class="row">

        <c:forEach items="${tariffs}" var="tariff" varStatus="t">
            <div class="col-md-3 col-sm-6">
                <div class="thumbnail">
                    <img src="http://placehold.it/242x200" alt="">

                    <div class="caption">
                        <h3>${tariff.name}
                            <small class="text-success text-right">${tariff.cost}$</small>
                        </h3>
                        <hr>
                        <p>${tariff.description}</p>
                        <p>
                            <a href="/buy?id=${tariff.id}" class="btn btn-primary btn-sm"><fmt:message key='buy_now'/></a> <a href="/admin/service_info?id=${tariff.id}" class="btn btn-default btn-sm"><fmt:message key='more_info'/></a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
    <h3><fmt:message key='passive'/></h3>
    <hr>

    <div class="row">
        <c:forEach items="${passive}" var="pas" varStatus="p">
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://placehold.it/242x200" alt="">

                    <div class="caption">
                        <h3>${pas.name}
                            <small class="text-success">${pas.cost}$</small>
                        </h3>
                        <hr>
                        <p>${pas.description}</p>

                        <p>
                            <a href="/buy?id=${pas.id}" class="btn btn-primary btn-sm"><fmt:message key='buy_now'/></a> <a href="/admin/service_info?id=${pas.id}" class="btn btn-default btn-sm"><fmt:message key='more_info'/></a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <h3><fmt:message key='packages'/></h3>
    <hr>

    <div class="row">
        <c:forEach items="${packages}" var="pack" varStatus="p">
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://placehold.it/242x200" alt="">

                    <div class="caption">
                        <h3>${pack.name}
                            <small class="text-success">${pack.cost}$</small>
                        </h3>
                        <hr>
                        <p>${pack.description}</p>

                        <p>
                            <a href="/buy?id=${pack.id}" class="btn btn-primary btn-sm"><fmt:message key='buy_now'/></a> <a href="/admin/service_info?id=${pack.id}" class="btn btn-default btn-sm"><fmt:message key='more_info'/></a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

