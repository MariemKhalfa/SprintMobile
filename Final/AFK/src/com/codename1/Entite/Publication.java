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
public class Publication {
    
    int id_pub;
    int iduser;
    String titre;
    String contenu;
    Date date;
    String picpath;
   

  

    public Publication() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Publication(int iduser, String titre, String contenu, Date date, String picpath) {
    
        this.iduser = iduser;
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.picpath = picpath;
       
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    
    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

   

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

 
    @Override
    public String toString() {
        return "Publication{" + "id_pub=" + id_pub + ", iduser=" + iduser + ", titre=" + titre + ", contenu=" + contenu + ", date=" + date + ", picpath=" + picpath + '}';
    } 
}
