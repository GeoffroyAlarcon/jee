package org.eclipse.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.model.Personne;

public class PersonneService {
	private ArrayList<Personne> personnes = new ArrayList<>();

	public PersonneService() {
		this.personnes.addAll(List.of(new Personne(1, "glou", "mitro"), new Personne(2, "thauvin", "florian"),
				new Personne(3, "mbappé", "kylian")));
	}

	public ArrayList<Personne> findAll() {
		return this.personnes;
	}

	public void save(Personne personne) {
		this.personnes.add(personne);
	}

	public void update(Personne p) {
		for (int i = 0; i < personnes.size(); i++) {
			if (personnes.get(i).getNum() == p.getNum()) {
				personnes.set(i, p);
			}
		}
	}
	public Personne findById(int num) {
		for (int i = 0; i < personnes.size(); i++) {
			if (personnes.get(i).getNum() == num) {
				return personnes.get(i);
			}
		}
		return null;
	}
	public boolean findByNom(String nom) {
		for (int i = 0; i < personnes.size(); i++) {
			if (personnes.get(i).getNom().equals(nom)) {
				return true;
			}
		}
		return false;
	}
	public boolean findByPrenom(String prenom) {
		for (int i = 0; i < personnes.size(); i++) {
			if (personnes.get(i).getPrenom().equals(prenom)) {
				return true;
			}
		}
		return false;
	}
	public void remove(int num) {
		for (int i = 0; i < personnes.size(); i++) {
			if (personnes.get(i).getNum() == num) {
				personnes.remove(personnes.get(i));
			}
		}
	}
}
