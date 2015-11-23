<jsp:useBean id="tariffs" scope="request" type="java.util.List<controllers.DAO.beans.Tariff>"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"><fmt:message key='tariffs'/>
            <c:if test="${user_session.role.equals('admin')}">
                <a class="btn btn-success" href="/admin/tariff_add">+ <i class="fa fa-phone"></i></a>
            </c:if>
        </h1>

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
                        <th><fmt:message key='status'/></th>
                        <th><fmt:message key='minutes'/></th>
                        <th><fmt:message key='sms'/></th>
                        <th><fmt:message key='internet'/></th>
                        <th><fmt:message key='service'/> ID</th>
                        <c:if test="${user_session.role.equals('admin')}">
                            <th><fmt:message key='edit'/></th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${tariffs}" var="tariff" varStatus="status1">
                        <tr>
                            <td><c:out value="${tariff.id}"/></td>
                            <td><a href="/admin/tariff_info?id=${tariff.id}"><c:out value="${tariff.name}"/></a></td>
                            <td><c:out value="${tariff.userStatus}"/></td>
                            <td><c:out value="${tariff.minutes}"/></td>
                            <td><c:out value="${tariff.sms}"/></td>
                            <td><c:out value="${tariff.internet}"/></td>
                            <td><c:out value="${tariff.serviceId}"/></td>
                            <c:if test="${user_session.role.equals('admin')}">
                                <td>
                                    <a class="btn btn-warning btn-xs" href="/admin/tariff_edit?id=${tariff.id}"><i
                                            class="fa fa-edit"></i></a>
                                    <a class="btn btn-danger btn-xs" href="/admin/tariff_delete?id=${tariff.id}"><i
                                            class="fa fa-remove"></i></a>
                                </td>
                            </c:if>
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