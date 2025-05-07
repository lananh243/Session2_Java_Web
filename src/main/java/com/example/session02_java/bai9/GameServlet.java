package com.example.session02_java.bai9;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;
@WebServlet(name = "GameServlet", value = "/guess")
public class GameServlet extends HttpServlet {
    private static final List<String> WORDS = Arrays.asList("java", "spring", "servlet", "jsp");
    private static final int MAX_ATTEMPTS = 3;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String word = WORDS.get(new Random().nextInt(WORDS.size()));
        HttpSession session = request.getSession();
        session.setAttribute("word", word);
        session.setAttribute("guesses", new HashSet<Character>());
        session.setAttribute("attemptsLeft", MAX_ATTEMPTS);

        updateAndForward(request, response, session);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String word = (String) session.getAttribute("word");
        Set<Character> guesses = (Set<Character>) session.getAttribute("guesses");
        int attemptsLeft = (int) session.getAttribute("attemptsLeft");

        String input = request.getParameter("guess");
        if (input != null && input.length() == 1) {
            char ch = input.toLowerCase().charAt(0);
            if (!word.contains(String.valueOf(ch))) {
                attemptsLeft--;
                session.setAttribute("attemptsLeft", attemptsLeft);
            }
            guesses.add(ch);
        }

        updateAndForward(request, response, session);
    }

    private void updateAndForward(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {

        String word = (String) session.getAttribute("word");
        Set<Character> guesses = (Set<Character>) session.getAttribute("guesses");
        int attemptsLeft = (int) session.getAttribute("attemptsLeft");

        // Tạo chuỗi từ bí mật dạng H _ l _ o
        StringBuilder masked = new StringBuilder();
        boolean win = true;
        for (char ch : word.toCharArray()) {
            if (guesses.contains(ch)) {
                masked.append(ch).append(' ');
            } else {
                masked.append("_ ");
                win = false;
            }
        }

        boolean lose = attemptsLeft <= 0;

        request.setAttribute("maskedWord", masked.toString());
        request.setAttribute("attemptsLeft", attemptsLeft);
        request.setAttribute("win", win);
        request.setAttribute("lose", lose);
        request.setAttribute("word", word);

        request.getRequestDispatcher("/guess.jsp").forward(request, response);
    }
}
