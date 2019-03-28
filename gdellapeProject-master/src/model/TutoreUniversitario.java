package model;

import java.sql.Timestamp;
import java.util.Objects;

public class TutoreUniversitario {
    private Integer IDTutoreUni;
    private String Nome;
    private String Cognome;
    private String Telefono;
    private String Email;
    private Boolean Attivo;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public TutoreUniversitario() {
        this.IDTutoreUni = 0;
        this.Nome = null;
        this.Cognome = null;
        this.Telefono = null;
        this.Email = null;
        this.Attivo = true;
        this.CreateDate = null;
        this.UpdateDate = null;
    }

    //GET DATA
    public Integer getIDTutoreUni() {
        return IDTutoreUni;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public Boolean getAttivo() {
        return Attivo;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    //SET DATA
    public void setIDTutoreUni(Integer IDTutoreUni) {
        this.IDTutoreUni = IDTutoreUni;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAttivo(Boolean attivo) {
        Attivo = attivo;
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
        TutoreUniversitario that = (TutoreUniversitario) o;
        return IDTutoreUni.equals(that.IDTutoreUni) &&
                Nome.equals(that.Nome) &&
                Cognome.equals(that.Cognome) &&
                Telefono.equals(that.Telefono) &&
                Email.equals(that.Email) &&
                Attivo.equals(that.Attivo) &&
                CreateDate.equals(that.CreateDate) &&
                UpdateDate.equals(that.UpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDTutoreUni, Nome, Cognome, Telefono, Email, Attivo, CreateDate, UpdateDate);
    }

    @Override
    public String toString() {
        return "TutoreUniversitario{" +
                "IDTutoreUni=" + IDTutoreUni +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Email='" + Email + '\'' +
                ", Attivo='" + Attivo + '\'' +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                '}';
    }
}
