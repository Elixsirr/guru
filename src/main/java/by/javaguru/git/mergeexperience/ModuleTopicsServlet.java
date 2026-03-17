package by.javaguru.git.mergeexperience;

import by.javaguru.git.mergeexperience.topics.Module1Topics;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/module1/topic")
public class ModuleTopicsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String topicId = req.getParameter("id");
        Module1Topics selectedTopic = null;
        for (Module1Topics topic: Module1Topics.values()) {
            if (topic.getOrder() == Integer.parseInt(topicId))
                selectedTopic = topic;
        }

        PrintWriter out = resp.getWriter();
        if (selectedTopic != null) {
            out.println("<html><body>");
            switch (selectedTopic) {
                case GIT -> out.println("<p>Git - распределенная система управления версиями, которая позволяет отслеживать изменения в файлах и координировать работу над проектами.</p>");
                default -> out.println("<h2>⚠️ Функционал еще не реализован</h2>");
            }
            out.println("</body></html>");
        }
    }
}
