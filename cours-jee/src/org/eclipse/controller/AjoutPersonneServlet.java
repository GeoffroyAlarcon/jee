package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Personne;
import org.eclipse.service.PersonneService;

@WebServlet("/ajoutPersonne")
public class AjoutPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneService personneService = new PersonneService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/searchPersonne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean test = true;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		try {
			verifChaine(nom);
		} catch (Exception e) {
			request.setAttribute("nomIncorrect", e.getMessage());
			test = false;
		}
		try {
			verifChaine(prenom);
		} catch (Exception e) {
			request.setAttribute("prenomIncorrect", e.getMessage());
			test = false;
		}
		if (!test) {

			request.setAttribute("nomSaisi", nom);
			request.setAttribute("prenomSaisi", prenom);
			this.getServletContext().getRequestDispatcher("/WEB-INF/personne/ajoutPersonne.jsp").forward(request, response);
		} else {
			Personne personne = new Personne(nom, prenom);
			request.setAttribute("personne", personne);
			personneService.save(personne);
			request.setAttribute("personnes", personneService.findAll());
			request.setAttribute("participePasse", "ajoutée");
			this.getServletContext().getRequestDispatcher("/WEB-INF/personne/confirmation.jsp").forward(request, response);
		}
	}

	public void verifChaine(String s) throws Exception {
		if (s == null || s.length() < 2)
			throw new Exception("La chaîne doit comporter au moins deux caractères");
		char c = s.charAt(0);
		if (!(c >= 'A' && c <= 'Z'))
			throw new Exception("La chaîne doit commencer par une lettre en majuscule");
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z'))
				throw new Exception("La chaîne ne peut contenir que des lettres");
		}
	}
}
