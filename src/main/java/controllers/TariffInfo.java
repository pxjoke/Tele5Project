package controllers;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.TariffDAO;
import controllers.DAO.beans.Service;
import controllers.DAO.beans.Tariff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pxjok on 18.11.2015.
 */
@WebServlet(name = "tariff_info", urlPatterns = "/tariff_info")
public class TariffInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") == null){
            response.sendError(400);
            return;
        }
        int id = Integer.valueOf(request.getParameter("id"));

        DAOFactory factory = new MySQLDaoFactory();
        TariffDAO tariffDAO = factory.getTariffDao();
        Tariff tariff = tariffDAO.getById(id);
        if(tariff == null){
            response.sendError(400);
            return;
        }
        ServiceDAO serviceDAO = factory.getServiceDAO();
        Service service = serviceDAO.getById(tariff.getServiceId()  );
        request.setAttribute("tariff", tariff);
        request.setAttribute("service", service);
        request.getRequestDispatcher("/WEB-INF/jsp/tariff_info.jsp").forward(request, response);
    }
}