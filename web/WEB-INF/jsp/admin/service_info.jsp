<jsp:useBean id="service" class="controllers.DAO.beans.Service" scope="request" type="controllers.DAO.beans.Service"/>
<div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">
            Service <c:out value="${service.name}"/>
        </h1>
        <hr>
    </div>
</div>
<div class="row">

    <dev class="col-lg-8">
        <div class="well">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive img-rounded" src="http://placehold.it/900x350" alt="">
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col-lg-4">
                    <div class="panel panel-warning">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${service.minutes}$</div>
                                    <div>Minute cost</div>
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
                                    <div class="huge">${service.sms}$</div>
                                    <div>SMS cost</div>
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
                                    <div class="huge">${service.internet}$</div>
                                    <div>Mb cost</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </dev>

    <div class="col-lg-4 ">
        <div class="well">
            <div class="panel panel-success">

                <div class="panel-body">

                    <p>${service.description}</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                </div>
                <div class="panel-footer">
                    <a href="" class="btn btn-success">Buy for ${service.cost}$</a>
                </div>
            </div>
        </div>
    </div>

</div>


