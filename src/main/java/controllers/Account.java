package controllers;

import controllers.DAO.api.DAOFactory;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.TariffDAO;
import controllers.DAO.api.UserDAO;
import controllers.DAO.api.UserServiceDAO;
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
import java.security.Principal;
import java.util.List;

/**
 * Created by pxjok on 09.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager", "user"}))
@WebServlet(name = "account", urlPatterns = "/account")
public class Account extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String phone = request.getUserPrincipal().getName();

        User user = Connections.getFactory().getUserDAO().getByPhone(phone);
        Tariff tariff = Connections.getFactory().getTariffDao().getById(user.getTariffId());
        List<UserService> userServices = Connections.getFactory().getUserServiceDao()
                .getAllByUserId(user.getId());
        request.setAttribute("user_services", userServices);
        request.setAttribute("user", user);
        request.setAttribute("tariff", tariff);
        request.getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(request, response);
    }

}
