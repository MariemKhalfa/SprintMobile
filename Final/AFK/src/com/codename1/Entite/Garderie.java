/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;


import java.util.Date;



/**
 *
 * @author botbot
 */
public class Garderie {
       private int id;
    private String nom;
    private String adresse;
    private int telephone;
    private String descriptif;
    private String langues;
    private Date date_ouverture;
    private Date date_fermeture;
    
    private String proprietaire;
    private String image;
    private int cout;
    private String repas;
    private int rating;
   
    private String etat;
    private String email;
    private float longitude;
    private float latitude;
    private  int nbInscriptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }

    public Date getDate_ouverture() {
        return date_ouverture;
    }

    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    public Date getDate_fermeture() {
        return date_fermeture;
    }

    public void setDate_fermeture(Date date_fermeture) {
        this.date_fermeture = date_fermeture;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getNbInscriptions() {
        return nbInscriptions;
    }

    public void setNbInscriptions(int nbInscriptions) {
        this.nbInscriptions = nbInscriptions;
    }

    @Override
    public String toString() {
        return "Garderie{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", descriptif=" + descriptif + ", langues=" + langues + ", date_ouverture=" + date_ouverture + ", date_fermeture=" + date_fermeture + ", proprietaire=" + proprietaire + ", image=" + image + ", cout=" + cout + ", repas=" + repas + ", rating=" + rating + ", etat=" + etat + ", email=" + email + ", longitude=" + longitude + ", latitude=" + latitude + ", nbInscriptions=" + nbInscriptions + '}';
    }
    

    
}
