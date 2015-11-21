package filters;

import com.sun.deploy.net.HttpRequest;
import controllers.Connections;
import controllers.DAO.beans.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by pxjok on 20.11.2015.
 */
@WebFilter(filterName = "security_filter", urlPatterns = "/*")
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Principal userPhone = request.getUserPrincipal();
        HttpSession session = request.getSession(false);


        if (userPhone != null) {
            User sessionUser = (User) session.getAttribute("user_session");
            if (sessionUser == null || sessionUser.getPhone() == null
                    || sessionUser.getPhone() != userPhone.getName()) {
                User user = Connections.getFactory().getUserDAO().getByPhone(userPhone.getName());
                request.getSession().setAttribute("user_session", user);
            }
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }


}
