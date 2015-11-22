package controllers;

import controllers.DAO.api.criteria.AccountCriteria;
import controllers.DAO.api.criteria.OperationCriteria;
import controllers.DAO.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pxjok on 10.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager", "user"}))
@WebServlet(name = "order_info", urlPatterns = "/order_info")
public class OrderInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null) {
            response.sendError(400);
            return;
        }

        int accountId = Integer.valueOf(request.getParameter("id"));
        OperationCriteria criteria = Connections.getFactory().getOperationCriteria();
        criteria.setAccountId(request.getParameter("id"));
        List<Operation> operations = Connections.getFactory().getOperationDao().getListByCriteria(criteria);
        controllers.DAO.beans.Account account = Connections.getFactory().getAccountDao().getById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("operations", operations);
        request.setAttribute("account", account);
        request.getRequestDispatcher("/WEB-INF/jsp/order_info.jsp").forward(request, response);
    }
}
