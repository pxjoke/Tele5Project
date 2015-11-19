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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pxjok on 09.11.2015.
 */
@WebServlet(name = "account", urlPatterns = "/account")
public class Account extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("phone") == null){
            response.sendError(400);
            return;
        }
        String phone = request.getParameter("phone");
        DAOFactory factory = new MySQLDaoFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user  = userDAO.getByPhone(phone);
        TariffDAO tariffDAO = factory.getTariffDao();
        Tariff tariff = tariffDAO.getById(user.getTariffId());
        UserServiceDAO userServiceDAO = factory.getUserServiceDao();
        List<UserService> userServices = userServiceDAO.getAllByUserId(id);
        request.setAttribute("user_services", userServices);
        request.setAttribute("user", user);
        request.setAttribute("tariff", tariff);
        request.getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(request, response);
    }
}
