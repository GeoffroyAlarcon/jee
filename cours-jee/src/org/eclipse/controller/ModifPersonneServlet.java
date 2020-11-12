package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Personne;
import org.eclipse.service.PersonneService;

@WebServlet("/modifPersonne")
public class ModifPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneService personneService = new PersonneService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/modifPersonne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Personne personne = new Personne(num, nom, prenom);
		request.setAttribute("personne", personne);
		personneService.update(personne);
		request.setAttribute("participePasse", "modifiée");
		request.setAttribute("personnes", personneService.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/confirmation.jsp").forward(request, response);
	}

}
