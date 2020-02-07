package eu.cefim.java.model.clients;

import eu.cefim.java.model.billets.Billet;

import java.util.List;

public class Client {
    private int id;
    private String mail;
    private String password;
    private List<Billet> billetsAchetes;


    public List<Billet> getBilletsAchetes() {
        return billetsAchetes;
    }

    public void setBilletsAchetes(List<Billet> billetsAchetes) {
        this.billetsAchetes = billetsAchetes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Client (){

    }

    public void find(){

    }

    public void findOne(int id){

    }

    @Override
    public String toString() {
        return "Client{" +
                "id =" + id +
                ", mail ='" + mail + '\'' +
                ", password ='" + password + '\'' +
                ", billetsAchetes ='" + billetsAchetes.size() + '\'' +
                '}' +
                '\n';
    }
}
