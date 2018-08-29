package model;

import dao.data.DaoData;

import java.sql.Timestamp;

public class User {

    private Integer IDUser ;
    private String Email ;
    private String Password;
    private Integer TipologiaAccount;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public User() {
        this.IDUser = 0;
        Email = null;
        Password = null;
        TipologiaAccount = 0;
        CreateDate = null;
        UpdateDate = null;
    }

    public Integer getIDUser() {
        return IDUser;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public Integer getTipologiaAccount() {
        return TipologiaAccount;
    }

    public void setIDUser(Integer IDUser) {
        this.IDUser = IDUser;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setTipologiaAccount(Integer tipologiaAccount) {
        TipologiaAccount = tipologiaAccount;
    }



    @Override
    public String toString() {
        return "User{" +
                "ID=" + IDUser +
                ", email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", TipologiaAccount='" + TipologiaAccount + '\'' +
                '}';
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






