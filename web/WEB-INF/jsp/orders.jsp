<jsp:useBean id="accounts" type="java.util.List<controllers.DAO.beans.Account>" scope="request"/>
<div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">
            Orders
        </h1>
        <hr>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-success">

            <div class="panel-body">

                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Open</th>
                        <th>Close</th>
                        <th>Status</th>
                        <th>Total price:</th>

                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${accounts}" var="account" varStatus="status1">
                        <tr>
                            <td><a href="/order_info?id=${account.id}"><c:out value="${account.id}"/></a></td>
                            <td><c:out value="${account.openDate}"/></td>
                            <td>
                                <c:if test="${account.closed}">
                                    <c:out value="${account.closeDate}"/>
                                </c:if>
                            </td>
                            <td><c:out value="${account.closed}"/></td>
                            <td><c:out value="${account.totalPrice}$"/></td>
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


<hr>

<!-- Pagination -->
<div class="row text-center">
    <div class="col-lg-12">
        <ul class="pagination">
            <li>
                <a href="#">&laquo;</a>
            </li>
            <li class="active">
                <a href="#">1</a>
            </li>
            <li>
                <a href="#">2</a>
            </li>
            <li>
                <a href="#">3</a>
            </li>
            <li>
                <a href="#">4</a>
            </li>
            <li>
                <a href="#">5</a>
            </li>
            <li>
                <a href="#">&raquo;</a>
            </li>
        </ul>
    </div>
</div>
<!-- /.row -->
