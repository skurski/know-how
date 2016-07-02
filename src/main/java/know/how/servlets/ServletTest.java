package know.how.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by psk on 02.07.16.
 */
public class ServletTest extends HttpServlet {

    /**
     * This method is executed by Servlet Container.
     * Config is created by Servlet Container from DD file (web.xml) and put as argument.
     * Inside the method the second init() method is invoked.
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Convenient method, just for implementing in concrete servlet class, see above.
     */
    @Override
    public void init() {

    }

    /**
     * Method invoked by Servlet Container where HTTP request occur.
     * It casts ServletRequest and ServletResponse to HttpServletRequest and HttpServletResponse.
     * Then it executes the protected service(HttpServletRequest, HttpServletResponse) method.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        /*
         * Cookies are send with request and response (in header of HTTP request and response).
         * Max size of cookie is 4 KB.
         * For
         */
        Cookie[] cookies = request.getCookies();
        response.addCookie(new Cookie("key", "value"));
    }

    /**
     * Method invoked by Servlet Container when end's servlet life (e.a. when shutdown).
     */
    @Override
    public void destroy() {

    }
}
