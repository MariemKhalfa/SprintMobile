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
public class Covoiturage {
	
	private int id;
    private Date date;
	private String titre;
	private int nbPlaces;
//	 private  Time heureDep;
	 private String lieuDep;
	 private String lieuDest;
	 private String description;
	 private Voiture voiture;
    private User covoitureur;
	private static Covoiturage currentCovoiturage;

	public Covoiturage() {
	}

	public Covoiturage(Date date, String titre, int nbPlaces,  String lieuDep, String lieuDest, String description) {
//		Time heureDep,
		this.date = date;
		this.titre = titre;
		this.nbPlaces = nbPlaces;
//		this.heureDep = heureDep;
		this.lieuDep = lieuDep;
		this.lieuDest = lieuDest;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

//	public Time getHeureDep() {
//		return heureDep;
//	}
//
//	public void setHeureDep(Time heureDep) {
//		this.heureDep = heureDep;
//	}

	public String getLieuDep() {
		return lieuDep;
	}

	public void setLieuDep(String lieuDep) {
		this.lieuDep = lieuDep;
	}

	public String getLieuDest() {
		return lieuDest;
	}

	public void setLieuDest(String lieuDest) {
		this.lieuDest = lieuDest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public User getCovoitureur() {
		return covoitureur;
	}

	public void setCovoitureur(User covoitureur) {
		this.covoitureur = covoitureur;
	}

	public static Covoiturage getCurrentCovoiturage() {
		return currentCovoiturage;
	}

	public static void setCurrentCovoiturage(Covoiturage currentCovoiturage) {
		Covoiturage.currentCovoiturage = currentCovoiturage;
	}

	

	@Override
	public String toString() {
//		 ", heureDep=" + heureDep +
		return "Covoiturage{" + "id=" + id + ", date=" + date + ", titre=" + titre + ", nbPlaces=" + nbPlaces + ", lieuDep=" + lieuDep + ", lieuDest=" + lieuDest + ", description=" + description + ", voiture=" + voiture + ", covoitureur=" + covoitureur + '}';
	}
	
	
	
}
