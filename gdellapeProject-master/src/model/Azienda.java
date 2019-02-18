package model;

import dao.data.DaoData;
import dao.exception.DaoException;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects;


public class Azienda {

    private Integer IDAzienda;
    private String RagioneSociale;
    private String IndirizzoSedeLegale;
    private String CFiscalePIva;
    private String NomeLegaleRappresentante;
    private String CognomeLegaleRappresentante;
    private String NomeResponsabileConvenzione;
    private String CognomeResponsabileConvenzione;
    private String TelefonoResponsabileConvenzione;
    private String EmailResponsabileConvenzione;
    private String PathPDFConvenzione;
    private Integer DurataConvenzione;
    private String ForoControversia;
    private Date DataConvenzione;
    private Boolean Attivo;
    private String Descrizione;
    private String Link;
    private Integer User;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public Azienda() {
        this.IDAzienda = 0;
        this.RagioneSociale = null;
        this.IndirizzoSedeLegale = null;
        this.CFiscalePIva = null;
        this.NomeLegaleRappresentante = null;
        this.CognomeLegaleRappresentante = null;
        this.NomeResponsabileConvenzione = null;
        this.CognomeResponsabileConvenzione = null;
        this.TelefonoResponsabileConvenzione = null;
        this.EmailResponsabileConvenzione = null;
        this.PathPDFConvenzione = null;
        this.DurataConvenzione = null;
        this.ForoControversia = null;
        this.DataConvenzione = null;
        this.Attivo = false;
        this.Descrizione = null;
        this.Link = null;
        this.User = 0;
        this.CreateDate = null;
        this.UpdateDate = null;
    }

    // GET DATA
    public Integer getIDAzienda() {
        return IDAzienda;
    }

    public String getRagioneSociale() {
        return RagioneSociale;
    }

    public String getIndirizzoSedeLegale() {
        return IndirizzoSedeLegale;
    }

    public String getCFiscalePIva() {
        return CFiscalePIva;
    }

    public String getNomeLegaleRappresentante() {
        return NomeLegaleRappresentante;
    }

    public String getCognomeLegaleRappresentante() {
        return CognomeLegaleRappresentante;
    }

    public String getNomeResponsabileConvenzione() {
        return NomeResponsabileConvenzione;
    }

    public String getCognomeResponsabileConvenzione() {
        return CognomeResponsabileConvenzione;
    }

    public String getTelefonoResponsabileConvenzione() {
        return TelefonoResponsabileConvenzione;
    }

    public String getEmailResponsabileConvenzione() {
        return EmailResponsabileConvenzione;
    }

    public String getPathPDFConvenzione() {
        return PathPDFConvenzione;
    }

    public Integer getDurataConvenzione() {
        return DurataConvenzione;
    }

    public String getForoControversia() {
        return ForoControversia;
    }

    public Date getDataConvenzione() {
        return DataConvenzione;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public String getLink() {
        return Link;
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





    // SET DATA
    public void setIDAzienda(Integer IDAzienda) {
        this.IDAzienda = IDAzienda;
    }

    public void setRagioneSociale(String ragioneSociale) {
        RagioneSociale = ragioneSociale;
    }

    public void setIndirizzoSedeLegale(String indirizzoSedeLegale) {
        IndirizzoSedeLegale = indirizzoSedeLegale;
    }

    public void setCFiscalePIva(String CFiscalePIva) {
        this.CFiscalePIva = CFiscalePIva;
    }

    public void setNomeLegaleRappresentante(String nomeLegaleRappresentante) {
        NomeLegaleRappresentante = nomeLegaleRappresentante;
    }

    public void setCognomeLegaleRappresentante(String cognomeLegaleRappresentante) {
        CognomeLegaleRappresentante = cognomeLegaleRappresentante;
    }

    public void setNomeResponsabileConvenzione(String nomeResponsabileConvenzione) {
        NomeResponsabileConvenzione = nomeResponsabileConvenzione;
    }

    public void setCognomeResponsabileConvenzione(String cognomeResponsabileConvenzione) {
        CognomeResponsabileConvenzione = cognomeResponsabileConvenzione;
    }

    public void setTelefonoResponsabileConvenzione(String telefonoResponsabileConvenzione) {
        TelefonoResponsabileConvenzione = telefonoResponsabileConvenzione;
    }

    public void setEmailResponsabileConvenzione(String emailResponsabileConvenzione) {
        EmailResponsabileConvenzione = emailResponsabileConvenzione;
    }

    public void setPathPDFConvenzione(String pathPDFConvenzione) {
        PathPDFConvenzione = pathPDFConvenzione;
    }

    public void setDurataConvenzione(Integer durataConvenzione) {
        DurataConvenzione = durataConvenzione;
    }

    public void setForoControversia(String foroControversia) {
        ForoControversia = foroControversia;
    }

    public void setDataConvenzione(Date dataConvenzione) {
        DataConvenzione = dataConvenzione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public void setLink( String link) {
         Link = link;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }

    public Boolean getAttivo() {
        return Attivo;
    }

    public void setAttivo(Boolean attivo) {
        Attivo = attivo;
    }

    public void setUser(Integer user) {
        User = user;
    }

    @Override
    public String toString() {
        return "Azienda{" +
                "IDAzienda=" + IDAzienda +
                ", RagioneSociale='" + RagioneSociale + '\'' +
                ", IndirizzoSedeLegale='" + IndirizzoSedeLegale + '\'' +
                ", CFiscalePIva='" + CFiscalePIva + '\'' +
                ", NomeLegaleRappresentante='" + NomeLegaleRappresentante + '\'' +
                ", CognomeLegaleRappresentante='" + CognomeLegaleRappresentante + '\'' +
                ", NomeResponsabileConvenzione='" + NomeResponsabileConvenzione + '\'' +
                ", CognomeResponsabileConvenzione='" + CognomeResponsabileConvenzione + '\'' +
                ", TelefonoResponsabileConvenzione='" + TelefonoResponsabileConvenzione + '\'' +
                ", EmailResponsabileConvenzione='" + EmailResponsabileConvenzione + '\'' +
                ", PathPDFConvenzione='" + PathPDFConvenzione + '\'' +
                ", DurataConvenzione=" + DurataConvenzione +
                ", ForoControversia='" + ForoControversia + '\'' +
                ", DataConvenzione=" + DataConvenzione +
                ", Attivo=" + Attivo +
                ", Descrizione='" + Descrizione + '\'' +
                ", Link='" + Link + '\'' +
                ", User=" + User +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Azienda azienda = (Azienda) o;
        return IDAzienda.equals(azienda.IDAzienda) &&
                RagioneSociale.equals(azienda.RagioneSociale) &&
                IndirizzoSedeLegale.equals(azienda.IndirizzoSedeLegale) &&
                CFiscalePIva.equals(azienda.CFiscalePIva) &&
                NomeLegaleRappresentante.equals(azienda.NomeLegaleRappresentante) &&
                CognomeLegaleRappresentante.equals(azienda.CognomeLegaleRappresentante) &&
                NomeResponsabileConvenzione.equals(azienda.NomeResponsabileConvenzione) &&
                CognomeResponsabileConvenzione.equals(azienda.CognomeResponsabileConvenzione) &&
                TelefonoResponsabileConvenzione.equals(azienda.TelefonoResponsabileConvenzione) &&
                EmailResponsabileConvenzione.equals(azienda.EmailResponsabileConvenzione) &&
                PathPDFConvenzione.equals(azienda.PathPDFConvenzione) &&
                DurataConvenzione.equals(azienda.DurataConvenzione) &&
                ForoControversia.equals(azienda.ForoControversia) &&
                DataConvenzione.equals(azienda.DataConvenzione) &&
                Attivo.equals(azienda.Attivo) &&
                Descrizione.equals(azienda.Descrizione) &&
                Link.equals(azienda.Link) &&
                User.equals(azienda.User) &&
                CreateDate.equals(azienda.CreateDate) &&
                UpdateDate.equals(azienda.UpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDAzienda, RagioneSociale, IndirizzoSedeLegale, CFiscalePIva, NomeLegaleRappresentante, CognomeLegaleRappresentante, NomeResponsabileConvenzione, CognomeResponsabileConvenzione, TelefonoResponsabileConvenzione, EmailResponsabileConvenzione, PathPDFConvenzione, DurataConvenzione, ForoControversia, DataConvenzione, Attivo, Descrizione, Link, User, CreateDate, UpdateDate);
    }
}
