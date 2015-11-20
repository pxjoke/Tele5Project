package controllers.admin;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.UserDAO;

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
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager"}))
@WebServlet(name = "user_delete", urlPatterns = "/admin/user_delete")
public class UserDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        DAOFactory factory = new MySQLDaoFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.deleteById(id);
        response.sendRedirect("/user_list");
    }
}
