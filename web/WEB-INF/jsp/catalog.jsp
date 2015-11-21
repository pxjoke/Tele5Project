<jsp:useBean id="tariffs" type="java.util.List<controllers.DAO.beans.Service>" scope="request"/>
<jsp:useBean id="passive" type="java.util.List<controllers.DAO.beans.Service>" scope="request"/>
<jsp:useBean id="packages" type="java.util.List<controllers.DAO.beans.Service>" scope="request"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Catalog
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
    <h3>Tariffs</h3>
    <hr>
    <div class="row">

        <c:forEach items="${tariffs}" var="tariff" varStatus="t">
            <div class="col-md-3 col-sm-6">
                <div class="thumbnail">
                    <img src="http://img11.nnm.me/c/c/9/1/a/8f3dfd17fe94b680678bc10547e.jpg" alt="">

                    <div class="caption">
                        <h3>${tariff.name}
                            <small class="label label-success">${tariff.cost}$</small>
                        </h3>
                        <p>${tariff.description}</p>

                        <p>
                            <a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More
                            Info</a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
    <h3>Passive</h3>
    <hr>

    <div class="row">
        <c:forEach items="${passive}" var="pas" varStatus="p">
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://www.kulturologia.ru/files/u16342/eyes.jpg" alt="">

                    <div class="caption">
                        <h3>${pas.name}
                            <small class="label label-success">${pas.cost}$</small>
                        </h3>
                        <p>${pas.description}</p>

                        <p>
                            <a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More
                            Info</a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <h3>Packages</h3>
    <hr>

    <div class="row">
        <c:forEach items="${packages}" var="pack" varStatus="p">
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://free-act.ru.images.1c-bitrix-cdn.ru/upload/iblock/ea3/ea322eaa820781d404a32d66bdfd28c9.jpg?1419843639228442"
                         alt="">

                    <div class="caption">
                        <h3>${pack.name}
                            <small class="label label-success">${pack.cost}$</small>
                        </h3>
                        <p>${pack.description}</p>

                        <p>
                            <a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More
                            Info</a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

