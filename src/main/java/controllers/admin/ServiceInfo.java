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
 * Created by pxjok on 18.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
@WebServlet(name = "service_info", urlPatterns = "/admin/service_info")
public class ServiceInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        if((id = controllers.helpers.Utils.idParamCheck(request, response)) < 0) return;


        Service service = Connections.getFactory().getServiceDAO().getById(id);
        if(service == null){
            response.sendRedirect("/no_such_element.jsp");
            return;
        }
        Tariff tariff = new Tariff();
        if(service.getType().equals("tariff")){
            tariff = Connections.getFactory().getTariffDao().getByServiceId(service.getId());
        }

        request.setAttribute("service", service);
        request.setAttribute("tariff", tariff);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/service_info.jsp").forward(request, response);
    }
}
