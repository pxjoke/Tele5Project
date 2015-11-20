
<jsp:useBean id="users" scope="request" type="java.util.List<controllers.DAO.beans.User>"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">User List <a class="btn btn-success" href="/signup">+ <i class="fa fa-user"></i> </a> </h1>
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
                        <th>Phone</th>
                        <th>Password</th>
                        <th>Minutes</th>
                        <th>Status</th>
                        <th>Role</th>
                        <th>Internet</th>
                        <th>SMS</th>
                        <th>Tariff ID</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${users}" var="user" varStatus="status1">
                        <tr>
                            <td><c:out value="${user.id}"/></td>
                            <td><a href="/account?phone=${user.phone}"><c:out value="${user.name}"/></a></td>
                            <td><c:out value="${user.phone}"/></td>
                            <td><c:out value="${user.password}"/></td>
                            <td><c:out value="${user.minutes}"/></td>
                            <td><c:out value="${user.status}"/></td>
                            <td><c:out value="${user.role}"/></td>
                            <td><c:out value="${user.internet}"/></td>
                            <td><c:out value="${user.sms}"/></td>
                            <td class="text-center"><c:out value="${user.tariffId}"/></td>
                            <td>
                                <a class="btn btn-warning btn-xs" href="/user_edit?id=${user.id}"><i class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-xs" href="/user_delete?id=${user.id}"><i class="fa fa-remove"></i></a>
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