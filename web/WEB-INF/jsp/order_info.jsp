<jsp:useBean id="operations" type="java.util.List<controllers.DAO.beans.Operation>" scope="request"/>
<jsp:useBean id="account" type="controllers.DAO.beans.Account" class="controllers.DAO.beans.Account" scope="request"/>
<div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">
            Order info <span class="btn btn-info"><i class="fa fa-credit-card"></i> ${account.totalPrice}$</span>
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
                        <th><fmt:message key='id'/></th>
                        <th><fmt:message key='name'/></th>
                        <th><fmt:message key='type'/></th>
                        <th><fmt:message key='cost'/></th>
                        <th><fmt:message key='date'/></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${operations}" var="operation" varStatus="status1">
                        <tr>
                            <td><c:out value="${operation.id}"/></td>
                            <td><c:out value="${operation.serviceName}"/></td>
                            <td><c:out value="${operation.type}"/></td>
                            <td><c:out value="${operation.cost}"/></td>
                            <td><c:out value="${operation.time}"/></td>
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
