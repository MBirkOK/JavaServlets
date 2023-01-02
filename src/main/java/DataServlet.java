import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String salutation = request.getParameter("salutation");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String birthday = request.getParameter("birthday");

            PrintWriter out= response.getWriter();
            out.print("<head><link rel=\"stylesheet\" href=\"styles.css\"></head>");
            out.println("<body><div class=\"form-container\">" +
                "<div class=\"grid-container\">" +
                "<div class=\"grid-item\">" +
                    "<label>Anrede:</label>" +
                "</div>" +
                "<div class=\"grid-item\">"+salutation+
                "</div>" +
                "<div class=\"grid-item\"><label>Vorname:</label></div>" +
                "<div class=\"grid-item\">"+name+
                "</div>" +
                "<div class=\"grid-item\"><label>Nachname:</label></div>" +
                "<div class=\"grid-item\">"+surname+
                "</div>" +
                "<div class=\"grid-item\"><label>Geburtstag:</label></div>" +
                "<div class=\"grid-item\">"+birthday+
                "</div>" +
                "</div>" +
                "</div>" +
                "<form action=\"/JavaServlets_war/login.html\">" +
                "<input type=\"submit\" value=\"Back\" class=\"button\">" +
                "</form>" +
                "</body>");
        }
}
