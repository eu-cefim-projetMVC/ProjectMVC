package eu.cefim.java.model.organisateurs;


import eu.cefim.java.model.evenements.Evenement;
import eu.cefim.java.model.typeCompte.TypeCompte;

import java.util.Date;
import java.util.List;

public class Organisateur {
    private int id;
    private int typeCompteId;
    private int parrainId;
    private String mail;
    private String password;
    private Date dateDerniereConnexion;
    private TypeCompte typeCompte;
    private Organisateur parrainMail;
    private List<Evenement> evenements;

    public Organisateur() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeCompteId() {
        return typeCompteId;
    }

    public void setTypeCompteId(int typeCompteId) {
        this.typeCompteId = typeCompteId;
    }

    public int getParrainId() {
        return parrainId;
    }

    public void setParrainId(int parrainId) {
        this.parrainId = parrainId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateDerniereConnexion() {
        return dateDerniereConnexion;
    }

    public void setDateDerniereConnexion(Date dateDerniereConnexion) {
        this.dateDerniereConnexion = dateDerniereConnexion;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Organisateur getParrainMail() {
        return parrainMail;
    }

    public void setParrainMail(Organisateur parrainMail) {
        this.parrainMail = parrainMail;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    @Override
    public String toString() {
        return  "{ " + parrainMail + "}";
    }
}
