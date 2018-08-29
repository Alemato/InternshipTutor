package model;

import java.sql.Timestamp;

public class TutoreUniversitario {
    private Integer IDTutoreUni;
    private String Nome;
    private String Cognome;
    private String Telefono;
    private String Email;
    private Integer OffTirocinio;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public TutoreUniversitario() {
        this.IDTutoreUni = 0;
        Nome = null;
        Cognome = null;
        Telefono = null;
        Email = null;
        OffTirocinio = 0;
        CreateDate = null;
        UpdateDate = null;
    }

    public Integer getIDTutoreUni() {
        return IDTutoreUni;
    }

    public void setIDTutoreUni(Integer IDTutoreUni) {
        this.IDTutoreUni = IDTutoreUni;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getOffTirocinio() {
        return OffTirocinio;
    }

    public void setOffTirocinio(Integer offTirocinio) {
        OffTirocinio = offTirocinio;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }
}
