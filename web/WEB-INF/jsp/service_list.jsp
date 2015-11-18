<jsp:useBean id="services" scope="request" type="java.util.List<controllers.DAO.beans.Service>"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Services List <a class="btn btn-success" href="/service_add">+ <i class="fa fa-asterisk"></i> </a> </h1>
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a>
            </li>
            <li class="active">About</li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-success">

            <div class="panel-body">

                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Cost</th>
                            <th>Type</th>
                            <th>Minutes</th>
                            <th>SMS</th>
                            <th>Internet</th>
                            <th>Edit</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${services}" var="service" varStatus="status1">
                            <tr>
                                <td><c:out value="${service.id}"/></td>
                                <td><a href="/service_info?id=${service.id}"><c:out value="${service.name}"/></a></td>
                                <td><c:out value="${service.cost}"/></td>
                                <td><c:out value="${service.type}"/></td>
                                <td><c:out value="${service.minutes}"/></td>
                                <td><c:out value="${service.sms}"/></td>
                                <td><c:out value="${service.internet}"/></td>
                                <td>
                                    <a class="btn btn-warning btn-xs" href="/service_edit?id=${service.id}"><i class="fa fa-edit"></i></a>
                                    <a class="btn btn-danger btn-xs" href="/service_delete?id=${service.id}"><i class="fa fa-remove"></i></a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>


            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->