package controllers.admin;

import controllers.Connections;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.MySQLDAO.MySQLUserDAO;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.TariffDAO;
import controllers.DAO.api.UserDAO;
import controllers.DAO.api.UserServiceDAO;
import controllers.DAO.api.criteria.AccountCriteria;
import controllers.DAO.beans.Account;
import controllers.DAO.beans.Tariff;
import controllers.DAO.beans.User;
import controllers.DAO.beans.UserService;

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
 * Created by pxjok on 15.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager"}))
@WebServlet(name = "user_info", urlPatterns = "/admin/user_info")
public class UserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        if (phone == null) {
            response.sendError(400);
            return;
        }

        User user = Connections.getFactory().getUserDAO().getByPhone(phone);
        Tariff tariff = Connections.getFactory().getTariffDao().getById(user.getTariffId());
        UserServiceDAO userServiceDAO = Connections.getFactory().getUserServiceDao();
        List<UserService> userServices = userServiceDAO.getAllByUserId(user.getId());
        AccountCriteria accountCriteria = Connections.getFactory().getAccountCriteria();
        accountCriteria.setUserId(String.valueOf(user.getId()));
        List<Account> accounts = Connections.getFactory().getAccountDao().getListByCriteria(accountCriteria);
        request.setAttribute("user_services", userServices);
        request.setAttribute("user", user);
        request.setAttribute("tariff", tariff);
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/user_info.jsp").forward(request, response);
    }
}
