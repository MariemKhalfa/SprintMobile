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
public class Inscription {
    private int id;
    private Date date_arriv;
    private String commentaires;
    private String nurserie;
    private String repas;
    private int id_garderie;
    private String adresse;
   private String id_parent;
   private String nomParent;
   private String id_enfant;
private int telephone;

  private String etat;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_arriv() {
        return date_arriv;
    }

    public void setDate_arriv(Date date_arriv) {
        this.date_arriv = date_arriv;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public String getNurserie() {
        return nurserie;
    }

    public void setNurserie(String nurserie) {
        this.nurserie = nurserie;
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public int getId_garderie() {
        return id_garderie;
    }

    public void setId_garderie(int id_garderie) {
        this.id_garderie = id_garderie;
    }

    public String getId_parent() {
        return id_parent;
    }

    public void setId_parent(String id_parent) {
        this.id_parent = id_parent;
    }

    public String getNomParent() {
        return nomParent;
    }

    public void setNomParent(String nomParent) {
        this.nomParent = nomParent;
    }

    public String getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(String id_enfant) {
        this.id_enfant = id_enfant;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Inscription(Date date_arriv, String commentaires, String nurserie, String repas, int id_garderie, String adresse, String id_parent, String nomParent, String id_enfant) {
        this.date_arriv = date_arriv;
        this.commentaires = commentaires;
        this.nurserie = nurserie;
        this.repas = repas;
        this.id_garderie = id_garderie;
        this.adresse = adresse;
        this.id_parent = id_parent;
        this.nomParent = nomParent;
        this.id_enfant = id_enfant;
       
    }

    @Override
    public String toString() {
        return "Inscription{" +  ", date_arriv=" + date_arriv + ", commentaires=" + commentaires + ", nurserie=" + nurserie + ", repas=" + repas + ", id_garderie=" + id_garderie + ", adresse=" + adresse + ", id_parent=" + id_parent + ", nomParent=" + nomParent + ", id_enfant=" + id_enfant + ", telephone=" + telephone + ", etat=" + etat + '}';
    }
    
  

    
}
