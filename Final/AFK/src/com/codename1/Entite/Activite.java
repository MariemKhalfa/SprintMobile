    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;


import java.util.Date;

/**
 *
 * @author Lynda
 */
public class Activite {
    private int id;
    private String type;
    private int age_min;
    private Date date;
    private String heure;
    private String description;
    private String adresse;

     
      public Activite() {
    }
      
    public Activite(int id, String type, int age_min, Date date, String heure, String description, String adresse) {
        this.id = id;
        this.type = type;
        this.age_min = age_min;
        this.date = date;
        this.heure = heure;
        this.description = description;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge_min() {
        return age_min;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
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
        return "Activite{" + "id=" + id + ", type=" + type + ", age_min=" + age_min + ", date=" + date + ", heure=" + heure + ", description=" + description + ", adresse=" + adresse + '}';
    }

    
    
    
    
    
    
    
    
    
    
}
