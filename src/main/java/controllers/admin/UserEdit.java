package controllers.admin;

import controllers.Connections;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
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

/**
 * Created by pxjok on 15.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager"}))
@WebServlet(name = "user_edit", urlPatterns = "/admin/user_edit")
public class UserEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tmp = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String role = request.getParameter("role");

        int id = Integer.valueOf(tmp);
        User user = Connections.getFactory().getUserDAO().getById(id);
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        user.setStatus(Integer.valueOf(status));
        user.setRole(role);
        Connections.getFactory().getUserDAO().updateById(id, user);
        response.sendRedirect("/admin/user_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        if (phone == null) {
            response.sendError(400);
            return;
        }

        User user = Connections.getFactory().getUserDAO().getByPhone(phone);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/user_edit.jsp").forward(request, response);
    }
}
