package com.example.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet(urlPatterns = "/user")
public class UserServlet  extends HttpServlet {
    private static final String FILE_PATH = "user.ser";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Deserialize User
        User user = null;
        try (FileInputStream fileIn = new FileInputStream(FILE_PATH);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            user = (User) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (user != null) {
            response.getWriter().println("Deserialized User: " + user);
        } else {
            response.getWriter().println("No user found");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Serialize User
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        User user = new User(username, email);

        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.getWriter().println("Serialized User: " + user);
    }
}
