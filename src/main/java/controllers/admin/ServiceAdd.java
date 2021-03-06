package controllers.admin;

import controllers.Connections;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.TariffDAO;
import controllers.DAO.beans.Service;
import controllers.DAO.beans.Tariff;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pxjok on 09.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
@WebServlet(name = "service_add", urlPatterns = "/admin/service_add")
public class ServiceAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String minutes = request.getParameter("minutes");
        String sms = request.getParameter("sms");
        String internet = request.getParameter("internet");
        String img = request.getParameter("img");
        String userStatus = request.getParameter("user_status");

        Service service = new Service();
        service.setType(type);
        service.setDescription(description);

        if(name.isEmpty()){
            response.sendRedirect("/validation_error.jsp");
            return;
        }
        service.setName(name);

        if(img.isEmpty()){
            service.setImg("sample.jpg");
        }
        service.setImg(img);

        try {
            service.setCost(Double.valueOf(cost));
            service.setMinutes(Integer.valueOf(minutes));
            service.setSms(Integer.valueOf(sms));
            service.setInternet(Integer.valueOf(internet));
            service.setUserStatus(Integer.valueOf(userStatus));
        } catch (NumberFormatException e) {
            response.sendRedirect("/validation_error.jsp");
            return;
        }


        Connections.getFactory().getServiceDAO().insert(service);


        response.sendRedirect("/admin/service_list");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/admin/service_add.jsp").forward(request, response);
    }
}
