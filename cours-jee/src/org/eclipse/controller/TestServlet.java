package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Personne;

// mapage?num=4&nom=umtiti&prenom=samuel
@WebServlet({ "/mapage", "/" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Never trust user input
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Personne> personnes = new ArrayList<Personne>(Arrays.asList(new Personne(1, "glou", "mitro"),
				new Personne(2, "thauvin", "florian"), new Personne(3, "mbappé", "kylian")));
		if (request.getServletPath().equals("/mapage")) {
			int num = Integer.parseInt(request.getParameter("num"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Personne personne = new Personne(num, nom, prenom);
			personnes.add(personne);

			request.setAttribute("perso", personne);
			request.setAttribute("firstName", prenom);
			request.setAttribute("lastName", nom);
		}

		request.setAttribute("personnes", personnes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue2.jsp").forward(request, response);
	}
}