package org.eclipse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.Personne;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Personne personne = new Personne (100, "wick", "john");
		HttpSession session = request.getSession();
		session.setAttribute("perso", personne);
		this.getServletContext().getRequestDispatcher("/WEB-INF/session/vue.jsp").forward(request, response);
	}

}
