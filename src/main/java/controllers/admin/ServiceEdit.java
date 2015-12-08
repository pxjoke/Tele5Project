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
 * Created by pxjok on 15.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
@WebServlet(name = "service_edit", urlPatterns = "/admin/service_edit")
public class ServiceEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String minutes = request.getParameter("minutes");
        String sms = request.getParameter("sms");
        String internet = request.getParameter("internet");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        String serviceId = request.getParameter("serviceId");
        String img = request.getParameter("img");
        String userStatus = request.getParameter("user_status");

        Service service = null;
        try {
            service = Connections.getFactory().getServiceDAO().getById(Integer.valueOf(serviceId));
        } catch (NumberFormatException e) {
            response.sendRedirect("/validation_error.jsp");
        }

        service.setDescription(description);
        service.setImg(img);

        if(!service.getType().equals("tariff")){
            if(name == null || name.isEmpty()){
                response.sendRedirect("/validation_error.jsp");
                return;
            }
            service.setName(name);
        }

        try {
            service.setCost(Double.valueOf(cost));
        } catch (NumberFormatException e) {
            response.sendRedirect("/validation_error.jsp");
            return;
        }

        if(service.getType().equals("package")){
            try {
                service.setMinutes(Integer.valueOf(minutes));
                service.setInternet(Integer.valueOf(internet));
                service.setSms(Integer.valueOf(sms));

            } catch (NumberFormatException e) {
                response.sendRedirect("/validation_error.jsp");
                return;
            }
        }
        if(!service.getType().equals("tariff")){

            service.setUserStatus(Integer.valueOf(userStatus));
        }


        Connections.getFactory().getServiceDAO().updateById(Integer.valueOf(serviceId), service);

        response.sendRedirect("/admin/service_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null) {
            response.sendError(400);
            return;
        }

        int id = Integer.valueOf(request.getParameter("id"));

        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO serviceDAO = factory.getServiceDAO();
        Service service = serviceDAO.getById(id);

        if (service == null) {
            response.sendRedirect("/no_such_element.jsp");
            return;
        }


        request.setAttribute("service", service);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/service_edit.jsp").forward(request, response);
    }
}
