package eu.cefim.java.model.billets;
public class Billet {
    private long id;
    private long evenementId;
    private long categorieBilletId;
    private long panierClientId;
    private long achatClientId;
    private String code;
    private java.sql.Timestamp dateAction;
    private long nombrePassages;
    private long organisateurId;

    public Billet() {

    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getEvenementId() {
        return evenementId;
    }
    public void setEvenementId(long evenementId) {
        this.evenementId = evenementId;
    }
    public long getCategorieBilletId() {
        return categorieBilletId;
    }
    public void setCategorieBilletId(long categorieBilletId) {
        this.categorieBilletId = categorieBilletId;
    }
    public long getPanierClientId() {
        return panierClientId;
    }
    public void setPanierClientId(long panierClientId) {
        this.panierClientId = panierClientId;
    }
    public long getAchatClientId() {
        return achatClientId;
    }
    public void setAchatClientId(long achatClientId) {
        this.achatClientId = achatClientId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public java.sql.Timestamp getDateAction() {
        return dateAction;
    }
    public void setDateAction(java.sql.Timestamp dateAction) {
        this.dateAction = dateAction;
    }
    public long getNombrePassages() {
        return nombrePassages;
    }
    public void setNombrePassages(long nombrePassages) {
        this.nombrePassages = nombrePassages;
    }
    public long getOrganisateurId() {
        return organisateurId;
    }
    public void setOrganisateurId(long organisateurId) {
        this.organisateurId = organisateurId;
    }
}