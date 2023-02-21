package flightproject.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //******************   forward  *******************
//        req.getRequestDispatcher("/flights")
//                .forward(req, resp);

        //******************   include (often use)  ******************
//        req.getRequestDispatcher("/flights")
//                .include(req, resp);
//        var writer = resp.getWriter();
//        writer.write("Hello 2");

        //******************   redirect  ******************
        resp.sendRedirect("/flights");
        var writer2 = resp.getWriter();
        writer2.write("Hello 2");

       // System.out.println();


    }
}
