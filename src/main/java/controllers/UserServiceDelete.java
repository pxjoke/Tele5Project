package controllers;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.*;
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

/**
 * Created by pxjok on 15.11.2015.
 */
@ServletSecurity (@HttpConstraint(rolesAllowed = {"admin", "manager", "user"}))
@WebServlet(name = "user_service_delete", urlPatterns = "/user_service_delete")
public class UserServiceDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id") == null) {
            response.sendError(400);
            return;
        }
        int id = Integer.valueOf(request.getParameter("id"));


        DAOFactory factory = new MySQLDaoFactory();
        UserServiceDAO userServiceDao = factory.getUserServiceDao();
        String userNumber = request.getUserPrincipal().getName();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getByPhone(userNumber);
        boolean status = userServiceDao.deleteByIdAndUserId(id, user.getId());

        if (!status) {
            response.sendError(400);
            return;
        }

        response.sendRedirect("/account?id=" + user.getId());
    }
}
