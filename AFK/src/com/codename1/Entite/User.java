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
public class User {

	private int id;
	public String username;
	public String username_canonical;
	private String email;
	public String email_canonical;
	public int enabled;
	public String salt;
	public String password;
	public Date last_login;
	public String confirmation_token;
	public Date password_requested_at;
	public String[] roles;
	public String cin;
	private String nom;
	public String prenom;
	public String sexe;
	public Date date_naissance;
	public String rue;
	public String ville;
	public int code_postal;
	public int telephone;
	public String babysitter;
	public String covoiturage;
	private String photo;
	public String specialite;
	public String description;
	public int nbre_enfants;
	private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }
        
        

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername_canonical() {
		return username_canonical;
	}

	public void setUsername_canonical(String username_canonical) {
		this.username_canonical = username_canonical;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_canonical() {
		return email_canonical;
	}

	public void setEmail_canonical(String email_canonical) {
		this.email_canonical = email_canonical;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getConfirmation_token() {
		return confirmation_token;
	}

	public void setConfirmation_token(String confirmation_token) {
		this.confirmation_token = confirmation_token;
	}

	public Date getPassword_requested_at() {
		return password_requested_at;
	}

	public void setPassword_requested_at(Date password_requested_at) {
		this.password_requested_at = password_requested_at;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getBabysitter() {
		return babysitter;
	}

	public void setBabysitter(String babysitter) {
		this.babysitter = babysitter;
	}

	public String getCovoiturage() {
		return covoiturage;
	}

	public void setCovoiturage(String covoiturage) {
		this.covoiturage = covoiturage;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbre_enfants() {
		return nbre_enfants;
	}

	public void setNbre_enfants(int nbre_enfants) {
		this.nbre_enfants = nbre_enfants;
	}

  
	

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", last_login=" + last_login + ", confirmation_token=" + confirmation_token + ", password_requested_at=" + password_requested_at + ", roles=" + roles + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", date_naissance=" + date_naissance + ", rue=" + rue + ", ville=" + ville + ", code_postal=" + code_postal + ", telephone=" + telephone + ", babysitter=" + babysitter + ", covoiturage=" + covoiturage + ", photo=" + photo + ", specialite=" + specialite + ", description=" + description + ", nbre_enfants=" + nbre_enfants + '}';
	}

	
}
