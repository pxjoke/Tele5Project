package controllers;

import controllers.DAO.api.criteria.AccountCriteria;
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
@WebServlet(name = "orders", urlPatterns = "/orders")
public class Orders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user_session");
        AccountCriteria criteria = Connections.getFactory().getAccountCriteria();
        criteria.setUserId(String.valueOf(user.getId()));
        List<controllers.DAO.beans.Account> accountList = Connections.getFactory().getAccountDao().getListByCriteria(criteria);
        request.setAttribute("accounts", accountList);
        request.getRequestDispatcher("/WEB-INF/jsp/orders.jsp").forward(request, response);
    }
}
