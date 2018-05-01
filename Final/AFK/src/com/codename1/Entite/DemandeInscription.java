/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;

import java.util.Date;

/**
 *
 * @author Sofien
 */
public class DemandeInscription {

    int id;

    int enfantId;

    int medecinId;

    String descriptionDifficulte;

    Date $dateDebut;

    String $etat = "ATTENTE";

    public DemandeInscription(int id, int enfantId, int medecinId, String descriptionDifficulte, Date $dateDebut) {
        this.id = id;
        this.enfantId = enfantId;
        this.medecinId = medecinId;
        this.descriptionDifficulte = descriptionDifficulte;
        this.$dateDebut = $dateDebut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnfantId() {
        return enfantId;
    }

    public void setEnfantId(int enfantId) {
        this.enfantId = enfantId;
    }

    public int getMedecinId() {
        return medecinId;
    }

    public void setMedecinId(int medecinId) {
        this.medecinId = medecinId;
    }

    public String getDescriptionDifficulte() {
        return descriptionDifficulte;
    }

    public void setDescriptionDifficulte(String descriptionDifficulte) {
        this.descriptionDifficulte = descriptionDifficulte;
    }

    public Date get$dateDebut() {
        return $dateDebut;
    }

    public void set$dateDebut(Date $dateDebut) {
        this.$dateDebut = $dateDebut;
    }

    public String get$etat() {
        return $etat;
    }

    public void set$etat(String $etat) {
        this.$etat = $etat;
    }

    public DemandeInscription() {
    }
    

}
