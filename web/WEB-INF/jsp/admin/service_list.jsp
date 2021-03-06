<jsp:useBean id="services" scope="request" type="java.util.List<controllers.DAO.beans.Service>"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"><fmt:message key='service_list'/> <a class="btn btn-success" href="/admin/service_add">+ <i class="fa fa-asterisk"></i> </a> </h1>
        <hr>
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
                            <th><fmt:message key='name'/></th>
                            <th><fmt:message key='cost'/></th>
                            <th><fmt:message key='type'/></th>
                            <th><fmt:message key='minutes'/></th>
                            <th><fmt:message key='sms'/></th>
                            <th><fmt:message key='internet'/></th>
                            <th><fmt:message key='user_status'/></th>
                            <th><fmt:message key='edit'/></th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${services}" var="service" varStatus="status1">
                            <tr>
                                <td><c:out value="${service.id}"/></td>
                                <td><a href="/admin/service_info?id=${service.id}"><c:out value="${service.name}"/></a></td>
                                <td><c:out value="${service.cost}"/></td>
                                <td><c:out value="${service.type}"/></td>
                                <td><c:out value="${service.minutes}"/></td>
                                <td><c:out value="${service.sms}"/></td>
                                <td><c:out value="${service.internet}"/></td>
                                <td><c:out value="${service.userStatus}"/></td>
                                <td>
                                    <a class="btn btn-warning btn-xs" href="/admin/service_edit?id=${service.id}"><i class="fa fa-edit"></i></a>
                                    <a class="btn btn-danger btn-xs" href="/admin/service_delete?id=${service.id}"><i class="fa fa-remove"></i></a>
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