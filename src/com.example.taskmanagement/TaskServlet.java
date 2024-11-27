package com.example.taskmanagement;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TaskServlet extends HttpServlet {
    private final TaskDao taskDao = new TaskDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Task> tasks = taskDao.getAllTasks();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        out.println("[");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            out.printf("{\"id\":%d,\"name\":\"%s\",\"dueDate\":\"%s\"}",
                    task.getId(), task.getName(), task.getDueDate());
            if (i < tasks.size() - 1)
                out.println(",");
        }
        out.println("]");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dueDate = request.getParameter("dueDate");

        if (name != null && dueDate != null) {
            Task task = new Task();
            task.setName(name);
            task.setDueDate(dueDate);
            taskDao.addTask(task);
        }
        response.sendRedirect("/");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            taskDao.deleteTask(id);
        }
        response.sendRedirect("/");
    }
}
