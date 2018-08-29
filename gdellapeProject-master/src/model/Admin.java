package model;
import java.sql.Timestamp;

public class Admin {
    private Integer IDadmin;
    private String Nome;
    private String Cognome;
    private Integer User;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public Admin() {
        this.IDadmin = 0;
        Nome = null;
        Cognome = null;
        User = 0;
        CreateDate = null;
        UpdateDate = null;
    }

    public Integer getIDadmin() {
        return IDadmin;
    }

    public void setIDadmin(Integer IDadmin) {
        this.IDadmin = IDadmin;
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

    public Integer getUser() {
        return User;
    }

    public void setUser(Integer user) {
        User = user;
    }
}
