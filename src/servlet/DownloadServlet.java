package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//  for text-file
//        resp.setHeader("Content-Disposition", "attachment; filename=\"file.txt\"");
//        resp.setContentType("text/plain");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//        try(var printWriter =  resp.getWriter()){
//            printWriter.write("Data from file");
//        }

//  for pdf-file (different file)
        resp.setHeader("Content-Disposition", "attachment; filename=\"file3.txt\"");
        resp.setContentType("application/pdf");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var outputStream = resp.getOutputStream()) {
            var stream = DownloadServlet.class
                    .getClassLoader()
                    .getResourceAsStream("87f536bb-4fa0-43da-ac20-6ae45ec4c875.pdf");
            outputStream.write(stream.readAllBytes());
        }
    }
}
