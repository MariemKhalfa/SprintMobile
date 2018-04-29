/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;

import java.util.Date;

/**
 *
 * @author User
 */
public class Evenement {
    int id;
    private String intitule;
    private int nbParticipants;
    private int budget ;
    private Date date;
    private String categorie;
    private String description;
    private String adresse;

    public Evenement(){
    
    }
    
    public Evenement(int id, String intitule, int nbParticipants, int budget, Date date, String categorie, String description, String adresse) {
        this.id = id;
        this.intitule = intitule;
        this.nbParticipants = nbParticipants;
        this.budget = budget;
        this.date = date;
        this.categorie = categorie;
        this.description = description;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Evenements{" + "id=" + id + ", intitule=" + intitule + ", nbParticipants=" + nbParticipants + ", budget=" + budget + ", date=" + date + ", categorie=" + categorie + ", description=" + description + ", adresse=" + adresse + '}';
    }
    
    
    
    
    
}
