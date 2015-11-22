package controllers;

import controllers.DAO.beans.*;
import controllers.DAO.beans.Account;

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
@WebServlet(name = "spend", urlPatterns = "/spend")
public class Spend extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m = request.getParameter("minutes");
        String s = request.getParameter("sms");
        String i = request.getParameter("internet");

        int minutes = (m.isEmpty()) ? 0 : Integer.valueOf(m);
        int sms = (s.isEmpty()) ? 0 : Integer.valueOf(s);
        int internet = (i.isEmpty()) ? 0 : Integer.valueOf(i);

        User user = (User) request.getSession().getAttribute("user_session");
        if(user.getStatus() == 0){
            response.sendError(400);
            return;
        }

        Tariff userTariff = Connections.getFactory().getTariffDao().getById(user.getTariffId());
        Account userAccount = Connections.getFactory().getAccountDao().getCurrent(user.getId());
        if(minutes > 0){
            Operation operation = new Operation();
            operation.setAmount(minutes);
            operation.setType("minutes");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            operation.setTime(format.format(new Date()));
            operation.setAccountId(userAccount.getId());
            operation.setServiceId(38);
            int tmp = user.getMinutes() - minutes;
            if(tmp >= 0) {
                user.setMinutes(tmp);
                operation.setCost(0);
            }else{
                operation.setCost(userTariff.getMinutes() * Math.abs(tmp));
                user.setMinutes(0);
            }
            Connections.getFactory().getOperationDao().insert(operation);
        }

        if(sms > 0){
            Operation operation = new Operation();
            operation.setAmount(sms);
            operation.setType("sms");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            operation.setTime(format.format(new Date()));
            operation.setAccountId(userAccount.getId());
            operation.setServiceId(38);
            int tmp = user.getSms() - sms;
            if(tmp >= 0) {
                user.setSms(tmp);
                operation.setCost(0);
            }else{
                operation.setCost(userTariff.getSms() * Math.abs(tmp));
                user.setSms(0);
            }
            Connections.getFactory().getOperationDao().insert(operation);
        }

        if(internet > 0){
            Operation operation = new Operation();
            operation.setAmount(internet);
            operation.setType("internet");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            operation.setTime(format.format(new Date()));
            operation.setAccountId(userAccount.getId());
            operation.setServiceId(38);
            int tmp = user.getInternet() - internet;
            if(tmp >= 0) {
                user.setInternet(tmp);
                operation.setCost(0);
            }else{
                operation.setCost(userTariff.getInternet()   * Math.abs(tmp));
                user.setInternet(0);
            }
            Connections.getFactory().getOperationDao().insert(operation);
        }
        Connections.getFactory().getUserDAO().updateById(user.getId(), user);
        request.getSession().setAttribute("user_session", user);



        response.sendRedirect("/account");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

}
