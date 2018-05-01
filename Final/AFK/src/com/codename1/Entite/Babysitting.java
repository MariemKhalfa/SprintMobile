/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;


import java.util.Date;

/**
 *
 * @author Mariem
 */
public class Babysitting  {

	private int id;
	private String titre;
	private Date date;
	private String heureDeb;
	private String heureFin;
	private String adresse;
	private int nbrEnfants;
	private String description;
	private User babysitteur;
	private static Babysitting currentBabysitting;
	

	public Babysitting() {
	}

	public Babysitting(Date date, String heureDeb, String heureFin, String adresse, int nbrEnfants) {
		this.date = date;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.adresse = adresse;
		this.nbrEnfants = nbrEnfants;
	}

	public String getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

//	public Babysitting(String titre, Date date, Time heureDeb, Time heureFin, String adresse, int nbrEnfants, String description) {
//		this.titre = titre;
//		this.date = date;
//		this.heureDeb = heureDeb;
//		this.heureFin = heureFin;
//		this.adresse = adresse;
//		this.nbrEnfants = nbrEnfants;
//		this.description = description;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public Time getHeureDeb() {
//		return heureDeb;
//	}
//
//	public void setHeureDeb(Time heureDeb) {
//		this.heureDeb = heureDeb;
//	}
//
//	public Time getHeureFin() {
//		return heureFin;
//	}
//
//	public void setHeureFin(Time heureFin) {
//		this.heureFin = heureFin;
//	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNbrEnfants() {
		return nbrEnfants;
	}

	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getBabysitteur() {
		return babysitteur;
	}

	public void setBabysitteur(User babysitteur) {
		this.babysitteur = babysitteur;
	}

	public static Babysitting getCurrentBabysitting() {
		return currentBabysitting;
	}

	public static void setCurrentBabysitting(Babysitting currentBabysitting) {
		Babysitting.currentBabysitting = currentBabysitting;
	}

	
	
//	@Override
//	public String toString() {
//		return "Babysitting{" + "id=" + id + ", titre=" + titre + ", date=" + date + ", heureDeb=" + heureDeb + ", heureFin=" + heureFin + ", adresse=" + adresse + ", nbrEnfants=" + nbrEnfants + ", description=" + description + ", babysitteur=" + babysitteur + '}';
//	}
	

}
