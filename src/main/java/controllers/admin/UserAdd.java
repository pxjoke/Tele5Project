package controllers.admin;

import controllers.Connections;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.MySQLDAO.MySQLUserDAO;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.UserDAO;
import controllers.DAO.beans.Account;
import controllers.DAO.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by pxjok on 09.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager"}))
@WebServlet(name = "add_user", urlPatterns = "/admin/add_user")
public class UserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String role = request.getParameter("role");

        if(name.isEmpty() || phone.isEmpty() || password.isEmpty() || status.isEmpty() ||
                role.isEmpty()){
            response.sendRedirect("/validation_error.jsp");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        user.setStatus(Integer.valueOf(status));
        user.setRole(role);
        user.setTariffId(1);
        Connections.getFactory().getUserDAO().insert(user);
        user = Connections.getFactory().getUserDAO().getByPhone(phone);

        controllers.DAO.beans.Account currentAccount = Connections.getFactory().getAccountDao().getCurrent(user.getId());
        if(currentAccount == null){
            controllers.DAO.beans.Account account = new Account();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            account.setOpenDate(format.format(new Date()));
            account.setCloseDate(format.format(new Date()));
            account.setClosed(false);
            account.setUserId(user.getId());
            Connections.getFactory().getAccountDao().insert(account);
            currentAccount = Connections.getFactory().getAccountDao().getCurrent(user.getId());
        }




        response.sendRedirect("/admin/user_list");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/admin/user_add.jsp").forward(request, response);
    }
}
