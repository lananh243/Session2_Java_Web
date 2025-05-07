package com.example.session02_java;

import java.io.*;
import java.util.HashSet;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "GuessWordServlet", value = "/guess")
public class GuessWordServlet extends HttpServlet {
    private String[] secretWords = {"hà nội", "hồ chí minh", "huế", "đà nẵng", "nhatrang"};


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String secretWord = (String) session.getAttribute("secretWord");

        if (secretWord == null) {
            secretWord = secretWords[new Random().nextInt(secretWords.length)];
            session.setAttribute("secretWord", secretWord);
            session.setAttribute("attempts", 5);
            session.setAttribute("guessedLetters", new HashSet<String>());
        }

        String guess = request.getParameter("guess");
        if (guess != null && !guess.isEmpty()) {
            HashSet<String> guessedLetters = (HashSet<String>) session.getAttribute("guessedLetters");
            guessedLetters.add(guess);
            session.setAttribute("guessedLetters", guessedLetters);
            int attempts = (int) session.getAttribute("attempts") - 1;
            session.setAttribute("attempts", attempts);
        }

        boolean isWin = true;
        for (char c : secretWord.toCharArray()) {
            if (!session.getAttribute("guessedLetters").toString().contains(String.valueOf(c))) {
                isWin = false;
                break;
            }
        }

        boolean isLost = (int) session.getAttribute("attempts") <= 0;

        request.setAttribute("isWin", isWin);
        request.setAttribute("isLost", isLost);
        request.setAttribute("secretWord", secretWord);
        request.setAttribute("attempts", session.getAttribute("attempts"));
        request.getRequestDispatcher("game.jsp").forward(request, response);
    }
}