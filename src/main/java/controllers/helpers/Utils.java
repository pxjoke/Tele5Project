package controllers.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pxjok on 19.11.2015.
 */
public class Utils<T> {
    public static int idParamCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("id") == null) {
            response.sendError(400);
            return -1;
        }

        int id = 0;
        try {
            id = Integer.valueOf(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(400);
            return -1;
        }
        return id;
    }

}
