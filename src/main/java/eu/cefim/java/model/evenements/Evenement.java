package eu.cefim.java.model.evenements;

import eu.cefim.java.model.organisateurs.Organisateur;

import java.util.Date;

public class Evenement {
    private int id;
    private int organisateurId;
    private String nom;
    private Date dateEvenement;
    private Organisateur organisateur;

    public Evenement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrganisateurId() {
        return organisateurId;
    }

    public void setOrganisateurId(int organisateurId) {
        this.organisateurId = organisateurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    public void find(){

    }

    @Override
    public String toString() {
        return "{Evenement :\n " +
                "id=" + id + ", " +
                "organisateurId=" + organisateurId + ", " +
                "nom : '" + nom + "\' | " +
                "dateEvenement : '" + dateEvenement + "\' | " +
                "organisateur : '" + organisateur + "\'" +
                "}" +
                "\n";
    }
}
