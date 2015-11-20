package controllers.admin;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.MySQLDAO.MySQLUserDAO;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.UserDAO;
import controllers.DAO.beans.User;

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
@WebServlet(name = "user_list", urlPatterns = "/admin/user_list")
public class UserList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory factory = new MySQLDaoFactory();
        UserDAO userDAO = new MySQLUserDAO();
        List<User> userList = userDAO.getAll();
        request.setAttribute("users", userList);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/user_list.jsp").forward(request, response);
    }
}
