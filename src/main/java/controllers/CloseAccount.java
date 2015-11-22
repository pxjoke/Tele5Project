package controllers;

import controllers.DAO.beans.Account;
import controllers.DAO.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pxjok on 09.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager", "user"}))
@WebServlet(name = "close_account", urlPatterns = "/close_account")
public class CloseAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = (User) request.getSession().getAttribute("user_session");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        controllers.DAO.beans.Account currentAccount = Connections.getFactory().getAccountDao().getCurrent(user.getId());
        currentAccount.setClosed(true);
        currentAccount.setCloseDate(format.format(new Date()));
        Connections.getFactory().getAccountDao().updateById(currentAccount.getId(), currentAccount);


        controllers.DAO.beans.Account account = new Account();
        account.setOpenDate(format.format(new Date()));
        account.setCloseDate(format.format(new Date()));
        account.setClosed(false);
        account.setUserId(user.getId());
        Connections.getFactory().getAccountDao().insert(account);






        response.sendRedirect("/orders");

//        Connections.getFactory().getAccountDao().getListByCriteria();


    }

}
