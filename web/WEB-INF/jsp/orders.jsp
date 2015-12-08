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
                        <th><fmt:message key='id'/></th>
                        <th><fmt:message key='open'/></th>
                        <th><fmt:message key='close'/></th>
                        <th><fmt:message key='status'/></th>
                        <th><fmt:message key='total_price'/>:</th>

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

