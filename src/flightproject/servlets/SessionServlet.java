package flightproject.servlets;

import flightproject.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    public static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        var session = req.getSession();
        var user = (UserDto) session.getAttribute(USER);

        if(user == null){

            user = UserDto.builder()
                    .id(25L)
                    .mail("JohnDoe@mail.com")
                    .build();                           // usually set once in login page using email and password

            session.setAttribute(USER, user);
        }
    }
}
