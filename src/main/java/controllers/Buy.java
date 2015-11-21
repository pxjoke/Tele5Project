package controllers;

import controllers.DAO.api.criteria.AccountCriteria;
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
import java.util.List;

/**
 * Created by pxjok on 09.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager", "user"}))
@WebServlet(name = "buy", urlPatterns = "/buy")
public class Buy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id") == null) {
            response.sendError(400);
            return;
        }

        int serviceId = Integer.valueOf(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user_session");
        Service service = Connections.getFactory().getServiceDAO().getById(serviceId);

        if (service == null) {
            response.sendError(400);
            return;
        }

        if (user.getStatus() != service.getUserStatus()) {
            response.sendError(400);
            return;
        }

        controllers.DAO.beans.Account currentAccount = Connections.getFactory().getAccountDao().getCurrent(user.getId());

        Operation operation = new Operation();
        operation.setServiceId(serviceId);
        operation.setType(service.getType());
        operation.setCost(service.getCost());
        operation.setAmount(1);
        operation.setAccountId(currentAccount.getId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        operation.setTime(format.format(new Date()));
        Connections.getFactory().getOperationDao().insert(operation);

        if (service.getType().equals("tariff")) {
            user.setTariffId(serviceId);
            Connections.getFactory().getUserDAO().updateById(user.getId(), user);
            request.getSession().setAttribute("user_session", user);
        } else if (service.getType().equals("package")) {
            user.setMinutes(service.getMinutes());
            user.setSms(service.getSms());
            user.setInternet(service.getInternet());
            Connections.getFactory().getUserDAO().updateById(user.getId(), user);
            request.getSession().setAttribute("user_session", user);
        }else if(service.getType().equals("passive")){
            UserService userService = new UserService();
            userService.setServiceId(serviceId);
            userService.setUserId(user.getId());
            Connections.getFactory().getUserServiceDao().insert(userService);
        }

        response.sendRedirect("/account");

//        Connections.getFactory().getAccountDao().getListByCriteria();


    }

}
