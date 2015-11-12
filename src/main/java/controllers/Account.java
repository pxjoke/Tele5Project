package controllers;

import controllers.DAO.DAOFactory;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.UserDAO;
import controllers.DAO.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pxjok on 09.11.2015.
 */
@WebServlet(name = "account", urlPatterns = "/account")
public class Account extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory factory = new MySQLDaoFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user  = userDAO.getById(1);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(request, response);
    }
}
