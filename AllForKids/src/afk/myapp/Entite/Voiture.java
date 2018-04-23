/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afk.myapp.Entite;

/**
 *
 * @author Mariem
 */
public class Voiture {
	
	private String matricule;
	private String marque;
	private String modele;
	private String couleur;
	private int nbSieges;
	private User proprio;
	public static Voiture currentVoiture;

	public Voiture() {
	}

	public Voiture(String matricule, String marque, String modele, String couleur, int nbSieges) {
		this.matricule = matricule;
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
		this.nbSieges = nbSieges;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getNbSieges() {
		return nbSieges;
	}

	public void setNbSieges(int nbSieges) {
		this.nbSieges = nbSieges;
	}

	public User getProprio() {
		return proprio;
	}

	public void setProprio(User proprio) {
		this.proprio = proprio;
	}

	public static Voiture getCurrentVoiture() {
		return currentVoiture;
	}

	public static void setCurrentVoiture(Voiture currentVoiture) {
		Voiture.currentVoiture = currentVoiture;
	}

	
	@Override
	public String toString() {
		return "Voiture{" + "matricule=" + matricule + ", marque=" + marque + ", modele=" + modele + ", couleur=" + couleur + ", nbSieges=" + nbSieges + ", proprio=" + proprio + '}';
	}
	
	
}
