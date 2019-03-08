package model;
import java.sql.Timestamp;
import java.util.Objects;

public class Admin {
    private Integer IDadmin;
    private String Nome;
    private String Cognome;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;
    private Integer User;

    public Admin() {
        this.IDadmin = 0;
        this.Nome = null;
        this.Cognome = null;
        this.CreateDate = null;
        this.UpdateDate = null;
        this.User = 0;
    }

    // SET ADMIN
    public void setIDadmin(Integer IDadmin) {
        this.IDadmin = IDadmin;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setCognome(String cognome) {
        this.Cognome = cognome;
    }

    public void setCreateDate(Timestamp createDate) {
        this.CreateDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.UpdateDate = updateDate;
    }

    public void setUser(Integer user) {
        this.User = user;
    }

    //GET ADMIN
    public Integer getIDadmin() {
        return IDadmin;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    public Integer getUser() {
        return User;
    }

    // EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(IDadmin, admin.IDadmin) &&
                Objects.equals(Nome, admin.Nome) &&
                Objects.equals(Cognome, admin.Cognome) &&
                Objects.equals(CreateDate, admin.CreateDate) &&
                Objects.equals(UpdateDate, admin.UpdateDate) &&
                Objects.equals(User, admin.User);
    }

    // HASHCODE
    @Override
    public int hashCode() {
        return Objects.hash(IDadmin, Nome, Cognome, CreateDate, UpdateDate, User);
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Admin{" +
                "IDadmin=" + IDadmin +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                ", User=" + User +
                '}';
    }
}
