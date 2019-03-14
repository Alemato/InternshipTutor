package model;

import dao.data.DaoData;

import java.sql.Timestamp;
import java.util.Objects;

public class User {

    private Integer IDUser ;
    private String Email ;
    private String Password;
    private Integer TipologiaAccount;
    private String Token;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public User() {
        this.IDUser = 0;
        this.Email = null;
        this.Password = null;
        this.TipologiaAccount = 0;
        this.Token = null;
        this.CreateDate = null;
        this.UpdateDate = null;
    }
    // GET DATA


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

    public String getToken() {
        return Token;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    // SET DATA

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

    public void setToken(String token) {
        Token = token;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return IDUser.equals(user.IDUser) &&
                Email.equals(user.Email) &&
                Password.equals(user.Password) &&
                TipologiaAccount.equals(user.TipologiaAccount) &&
                Objects.equals(Token, user.Token) &&
                CreateDate.equals(user.CreateDate) &&
                UpdateDate.equals(user.UpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDUser, Email, Password, TipologiaAccount, Token, CreateDate, UpdateDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "IDUser=" + IDUser +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", TipologiaAccount=" + TipologiaAccount +
                ", Token='" + Token + '\'' +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                '}';
    }
}







