<%@ page import="controllers.DAO.beans.User" %>
<jsp:useBean id="user" class="controllers.DAO.beans.User" scope="request" type="controllers.DAO.beans.User"/>
<div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">
            Dashboard
        </h1>
        <hr>
    </div>
</div>
<div class="row">
    <div class="col-lg-8">
        <div class="row">
            <div class="col-lg-6">
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
                            <a href="#">Change <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>


            <div class="col-lg-6">
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
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-lg-6">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-bar-chart fa-fw"></i> Tariff info: </h3>
                    </div>
                    <div class="panel-body">
                        <div class="list-group">
                            <div class="list-group-item list-group">
                                <span class="badge"> <jsp:getProperty name="user" property="minutes"/></span>
                                <i class="fa fa-fw fa-phone"></i> Minute cost:
                            </div>

                            <div class="list-group-item list-group">
                                <span class="badge"> <jsp:getProperty name="user" property="sms"/></span>
                                <i class="fa fa-fw fa-envelope"></i> SMS cost:
                            </div>

                            <div class="list-group-item list-group">
                                <span class="badge"> <jsp:getProperty name="user" property="internet"/></span>
                                <i class="fa fa-fw fa-globe"></i> Mb cost:
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="col-lg-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-tasks fa-fw"></i> Actions</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">Buy minutes</label>

                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">Buy SMS</label>

                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">Internet</label>

                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">Password</label>

                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9 text-right">
                            <button type="submit" class="btn btn-danger">Buy</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </div>


</div>


