
<jsp:useBean id="users" scope="request" type="java.util.List<controllers.DAO.beans.User>"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"><fmt:message key='user_list'/> <a class="btn btn-success" href="/admin/add_user">+ <i class="fa fa-user"></i> </a> </h1>
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
                        <th><fmt:message key='name'/></th>
                        <th><fmt:message key='phone'/></th>
                        <th><fmt:message key='signin.password'/></th>
                        <th><fmt:message key='minutes'/></th>
                        <th><fmt:message key='status'/></th>
                        <th><fmt:message key='role'/></th>
                        <th><fmt:message key='internet'/></th>
                        <th><fmt:message key='sms'/></th>
                        <th><fmt:message key='tariff'/> ID</th>
                        <th><fmt:message key='edit'/></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${users}" var="user" varStatus="status1">
                        <tr>
                            <td><c:out value="${user.id}"/></td>
                            <td><a href="/admin/user_info?phone=${user.phone}"><c:out value="${user.name}"/></a></td>
                            <td><c:out value="${user.phone}"/></td>
                            <td><c:out value="${user.password}"/></td>
                            <td><c:out value="${user.minutes}"/></td>
                            <td><c:out value="${user.status}"/></td>
                            <td><c:out value="${user.role}"/></td>
                            <td><c:out value="${user.internet}"/></td>
                            <td><c:out value="${user.sms}"/></td>
                            <td class="text-center"><c:out value="${user.tariffId}"/></td>
                            <td>
                                <a class="btn btn-warning btn-xs" href="/admin/user_edit?phone=${user.phone}"><i class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-xs" href="/admin/user_delete?id=${user.id}"><i class="fa fa-remove"></i></a>
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