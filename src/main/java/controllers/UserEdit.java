package controllers;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.UserDAO;
import controllers.DAO.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pxjok on 15.11.2015.
 */
@WebServlet(name = "user_edit", urlPatterns = "/user_edit")
public class UserEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String role = request.getParameter("role");
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        user.setStatus(Integer.valueOf(status));
        user.setRole(role);
        DAOFactory factory = new MySQLDaoFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updateById(id, user);
        response.sendRedirect("/user_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        DAOFactory factory = new MySQLDaoFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/user_edit.jsp").forward(request, response);
    }
}
