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
    private Boolean ModuloConvenzione;
    private String Descrizione;
    private String Link;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;
    private Integer User;

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
        this.ModuloConvenzione = false;
        this.Descrizione = null;
        this.Link = null;
        this.CreateDate = null;
        this.UpdateDate = null;
        this.User = 0;
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

    public Boolean getAttivo() {
        return Attivo;
    }

    public Boolean getModuloConvenzione() {
        return ModuloConvenzione;
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
        this.RagioneSociale = ragioneSociale;
    }

    public void setIndirizzoSedeLegale(String indirizzoSedeLegale) {
        this.IndirizzoSedeLegale = indirizzoSedeLegale;
    }

    public void setCFiscalePIva(String CFiscalePIva) {
        this.CFiscalePIva = CFiscalePIva;
    }

    public void setNomeLegaleRappresentante(String nomeLegaleRappresentante) {
        this.NomeLegaleRappresentante = nomeLegaleRappresentante;
    }

    public void setCognomeLegaleRappresentante(String cognomeLegaleRappresentante) {
        this.CognomeLegaleRappresentante = cognomeLegaleRappresentante;
    }

    public void setNomeResponsabileConvenzione(String nomeResponsabileConvenzione) {
        this.NomeResponsabileConvenzione = nomeResponsabileConvenzione;
    }

    public void setCognomeResponsabileConvenzione(String cognomeResponsabileConvenzione) {
        this.CognomeResponsabileConvenzione = cognomeResponsabileConvenzione;
    }

    public void setTelefonoResponsabileConvenzione(String telefonoResponsabileConvenzione) {
        this.TelefonoResponsabileConvenzione = telefonoResponsabileConvenzione;
    }

    public void setEmailResponsabileConvenzione(String emailResponsabileConvenzione) {
        this.EmailResponsabileConvenzione = emailResponsabileConvenzione;
    }

    public void setPathPDFConvenzione(String pathPDFConvenzione) {
        this.PathPDFConvenzione = pathPDFConvenzione;
    }

    public void setDurataConvenzione(Integer durataConvenzione) {
        this.DurataConvenzione = durataConvenzione;
    }

    public void setForoControversia(String foroControversia) {
        this.ForoControversia = foroControversia;
    }

    public void setDataConvenzione(Date dataConvenzione) {
        this.DataConvenzione = dataConvenzione;
    }

    public void setAttivo(Boolean attivo) {
        this.Attivo = attivo;
    }

    public void setModuloConvenzione(Boolean moduloConvenzione) {
        this.ModuloConvenzione = moduloConvenzione;
    }

    public void setDescrizione(String descrizione) {
        this.Descrizione = descrizione;
    }

    public void setLink( String link) {
        this.Link = link;
    }

    public void setCreateDate(Timestamp createDate) {
        this.CreateDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.UpdateDate = updateDate;
    }

    public void setUser(Integer user) {
        User = user;
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
                Objects.equals(NomeResponsabileConvenzione, azienda.NomeResponsabileConvenzione) &&
                Objects.equals(CognomeResponsabileConvenzione, azienda.CognomeResponsabileConvenzione) &&
                Objects.equals(TelefonoResponsabileConvenzione, azienda.TelefonoResponsabileConvenzione) &&
                Objects.equals(EmailResponsabileConvenzione, azienda.EmailResponsabileConvenzione) &&
                Objects.equals(PathPDFConvenzione, azienda.PathPDFConvenzione) &&
                Objects.equals(DurataConvenzione, azienda.DurataConvenzione) &&
                Objects.equals(ForoControversia, azienda.ForoControversia) &&
                Objects.equals(DataConvenzione, azienda.DataConvenzione) &&
                Attivo.equals(azienda.Attivo) &&
                ModuloConvenzione.equals(azienda.ModuloConvenzione) &&
                Objects.equals(Descrizione, azienda.Descrizione) &&
                Objects.equals(Link, azienda.Link) &&
                CreateDate.equals(azienda.CreateDate) &&
                UpdateDate.equals(azienda.UpdateDate) &&
                User.equals(azienda.User);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDAzienda, RagioneSociale, IndirizzoSedeLegale, CFiscalePIva, NomeLegaleRappresentante, CognomeLegaleRappresentante, NomeResponsabileConvenzione, CognomeResponsabileConvenzione, TelefonoResponsabileConvenzione, EmailResponsabileConvenzione, PathPDFConvenzione, DurataConvenzione, ForoControversia, DataConvenzione, Attivo, ModuloConvenzione, Descrizione, Link, CreateDate, UpdateDate, User);
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
                ", ModuloConvenzione=" + ModuloConvenzione +
                ", Descrizione='" + Descrizione + '\'' +
                ", Link='" + Link + '\'' +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                ", User=" + User +
                '}';
    }
}
