package model;

import java.sql.Date;
import java.sql.Timestamp;

public class OffertaTirocinio {
    private Integer IDOffertaTirocinio;
    private String LuogoEffettuazione;
    private String Titolo;
    private String DescrizioneBreve;
    private String Descrizione;
    private String Orario;
    private Integer DurataOra;
    private Integer DurataMesi;
    //s - a String object representing a date in in the format "yyyy-[m]m-[d]d". The leading zero for mm and dd may also be omitted.
    private Date PeriodoInizio;
    private Date PeriodoFine;

    private String Modalita;
    private String Obbiettivi;
    private String Rimborsi;

    private String Facilitazioni;
    private String AziendaOspitante;
    private Integer CodiceTirocinio;
    private String SettoreInserimento;
    private String TempoAccessoLocaliAziendali;
    private String NomeTutoreAziendale;

    private String CognomeTutoreAziendale;
    private String EmailTutoreAziendale;
    private  String TelefonoTutoreAzindale;
    private Integer Azienda;
    private Integer TutoreUniversitario;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;


    public OffertaTirocinio() {
        this.IDOffertaTirocinio = 0;
        LuogoEffettuazione = null;
        Titolo = null;
        DescrizioneBreve = null;
        Descrizione = null;
        Orario = null;
        DurataOra = null;
        DurataMesi = null;
        PeriodoInizio = null;
        PeriodoFine = null;
        Modalita = null;
        Obbiettivi = null;
        Rimborsi = null;
        Facilitazioni = null;
        AziendaOspitante = null;
        CodiceTirocinio = 0;
        SettoreInserimento = null;
        TempoAccessoLocaliAziendali = null;
        NomeTutoreAziendale = null;
        CognomeTutoreAziendale = null;
        EmailTutoreAziendale = null;
        TelefonoTutoreAzindale = null;
        Azienda = 0;
        TutoreUniversitario = 0;
        CreateDate = null;
        UpdateDate = null;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }






    public Integer getIDOffertaTirocinio() {
        return IDOffertaTirocinio;
    }

    public void setIDOffertaTirocinio(Integer IDOffertaTirocinio) {
        this.IDOffertaTirocinio = IDOffertaTirocinio;
    }

    public void setLuogoEffettuazione(String luogoEffettuazione) {
        LuogoEffettuazione = luogoEffettuazione;
    }

    public String getLuogoEffettuazione() {
        return LuogoEffettuazione;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public String getDescrizioneBreve() {
        return DescrizioneBreve;
    }

    public void setDescrizioneBreve(String descrizioneBreve) {
        DescrizioneBreve = descrizioneBreve;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public String getOrario() {
        return Orario;
    }

    public void setOrario(String orario) {
        Orario = orario;
    }

    public Integer getDurataOra() {
        return DurataOra;
    }

    public void setDurataOra(Integer durataOra) {
        DurataOra = durataOra;
    }

    public Integer getDurataMesi() {
        return DurataMesi;
    }

    public void setDurataMesi(Integer durataMesi) {
        DurataMesi = durataMesi;
    }

    public Date getPeriodoInizio() {
        return PeriodoInizio;
    }

    public void setPeriodoInizio(Date periodoInizio) {
        PeriodoInizio = periodoInizio;
    }

    public Date getPeriodoFine() {
        return PeriodoFine;
    }

    public void setPeriodoFine(Date periodoFine) {
        PeriodoFine = periodoFine;
    }

    public String getModalita() {
        return Modalita;
    }

    public void setModalita(String modalita) {
        Modalita = modalita;
    }

    public String getObbiettivi() {
        return Obbiettivi;
    }

    public void setObbiettivi(String obbiettivi) {
        Obbiettivi = obbiettivi;
    }

    public String getRimborsi() {
        return Rimborsi;
    }

    public void setRimborsi(String rimborsi) {
        Rimborsi = rimborsi;
    }

    public String getFacilitazioni() {
        return Facilitazioni;
    }

    public void setFacilitazioni(String facilitazioni) {
        Facilitazioni = facilitazioni;
    }

    public String getAziendaOspitante() {
        return AziendaOspitante;
    }

    public void setAziendaOspitante(String aziendaOspitante) {
        AziendaOspitante = aziendaOspitante;
    }

    public Integer getCodiceTirocinio() {
        return CodiceTirocinio;
    }

    public void setCodiceTirocinio(Integer codiceTirocinio) {
        CodiceTirocinio = codiceTirocinio;
    }

    public String getSettoreInserimento() {
        return SettoreInserimento;
    }

    public void setSettoreInserimento(String settoreInserimento) {
        SettoreInserimento = settoreInserimento;
    }

    public String getTempoAccessoLocaliAziendali() {
        return TempoAccessoLocaliAziendali;
    }

    public void setTempoAccessoLocaliAziendali(String tempoAccessoLocaliAziendali) {
        TempoAccessoLocaliAziendali = tempoAccessoLocaliAziendali;
    }

    public String getNomeTutoreAziendale() {
        return NomeTutoreAziendale;
    }

    public void setNomeTutoreAziendale(String nomeTutoreAziendale) {
        NomeTutoreAziendale = nomeTutoreAziendale;
    }

    public String getCognomeTutoreAziendale() {
        return CognomeTutoreAziendale;
    }

    public void setCognomeTutoreAziendale(String cognomeTutoreAziendale) {
        CognomeTutoreAziendale = cognomeTutoreAziendale;
    }

    public String getEmailTutoreAziendale() {
        return EmailTutoreAziendale;
    }

    public void setEmailTutoreAziendale(String emailTutoreAziendale) {
        EmailTutoreAziendale = emailTutoreAziendale;
    }

    public String getTelefonoTutoreAzindale() {
        return TelefonoTutoreAzindale;
    }

    public void setTelefonoTutoreAzindale(String telefonoTutoreAzindale) {
        TelefonoTutoreAzindale = telefonoTutoreAzindale;
    }

    public Integer getAzienda() {
        return Azienda;
    }

    public void setAzienda(Integer azienda) {
        Azienda = azienda;
    }

    public Integer getTutoreUniversitario() {
        return TutoreUniversitario;
    }

    public void setTutoreUniversitario(Integer tutoreUniversitario) {
        TutoreUniversitario = tutoreUniversitario;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }
}
