<jsp:useBean id="tariffs" scope="request" type="java.util.List<controllers.DAO.beans.Tariff>"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Tariff List <a class="btn btn-success" href="/tariff_add">+ <i class="fa fa-phone"></i> </a> </h1>

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
                            <th>User Status</th>
                            <th>Minutes</th>
                            <th>SMS</th>
                            <th>Internet</th>
                            <th>Service ID</th>
                            <th>Count</th>
                            <th>Edit</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${tariffs}" var="tariff" varStatus="status1">
                            <tr>
                                <td><c:out value="${tariff.id}"/></td>
                                <td><a href="/tariff_info?id=${tariff.id}"><c:out value="${tariff.name}"/></a></td>
                                <td><c:out value="${tariff.userStatus}"/></td>
                                <td><c:out value="${tariff.minutes}"/></td>
                                <td><c:out value="${tariff.sms}"/></td>
                                <td><c:out value="${tariff.internet}"/></td>
                                <td><c:out value="${tariff.serviceId}"/></td>
                                <td><c:out value="${tariff.count}"/></td>
                                <td>
                                    <a class="btn btn-warning btn-xs" href="/tariff_edit?id=${tariff.id}"><i class="fa fa-edit"></i></a>
                                    <a class="btn btn-danger btn-xs" href="/tariff_delete?id=${tariff.id}"><i class="fa fa-remove"></i></a>
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