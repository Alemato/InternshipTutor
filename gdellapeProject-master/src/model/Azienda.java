package model;


import java.sql.Timestamp;
import java.sql.Date;

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

    public Integer getDurataConvenzione() {
        return DurataConvenzione;
    }

    public void setDurataConvenzione(Integer durataConvenzione) {
        DurataConvenzione = durataConvenzione;
    }

    public String getForoControversia() {
        return ForoControversia;
    }

    public void setForoControversia(String foroControversia) {
        ForoControversia = foroControversia;
    }

    public Date getDataConvenzione() {
        return DataConvenzione;
    }

    public void setDataConvenzione(Date dataConvenzione) {
        DataConvenzione = dataConvenzione;
    }

    public Integer getUser() {
        return User;
    }

    public void setUser(Integer user) {
        User = user;
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

    public Boolean getAttivo() {
        return Attivo;
    }

    public void setAttivo(Boolean attivo) {
        Attivo = attivo;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
