package flightproject.servlets;

import flightproject.dto.FlightDto;
import flightproject.service.FlightService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try(var printWriter = resp.getWriter()){
            printWriter.write("<h1>Список перелетов:</h1>");
            printWriter.write("<ul>");
            for (FlightDto flightDto : flightService.findAll()) {
                printWriter.write("""
                        <li>
                            <a href = "/tickets?flightId=%d"> %s</a>
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription()));
            }
            printWriter.write("</ul>");
        }
    }
}
