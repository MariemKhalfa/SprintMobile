/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.Entite;

/**
 *
 * @author Sofien
 */
public class Recette {

    int id;

    String video;

    String description;

    String titre;
    
    String photo;

    int likeCount = 0;

    int dislikeCount = 0;

    public Recette() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Recette(int id, String video, String description, String titre, String photo) {
        this.id = id;
        this.video = video;
        this.description = description;
        this.titre = titre;
        this.photo = photo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public Recette(int id, String video, String description, String titre) {
        this.id = id;
        this.video = video;
        this.description = description;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Recette{" + "id=" + id + ", video=" + video + ", description=" + description + ", titre=" + titre + ", likeCount=" + likeCount + ", dislikeCount=" + dislikeCount + '}';
    }
    

}
