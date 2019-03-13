package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

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
    private String CodiceTirocinio;
    private String SettoreInserimento;
    private String TempoAccessoLocaliAziendali;
    private String NomeTutoreAziendale;
    private String CognomeTutoreAziendale;
    private String TelefonoTutoreAzindale;
    private String EmailTutoreAziendale;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;
    private Integer Azienda;
    private Integer TutoreUniversitario;


    public OffertaTirocinio() {
        this.IDOffertaTirocinio = 0;
        this.LuogoEffettuazione = null;
        this.Titolo = null;
        this.DescrizioneBreve = null;
        this.Descrizione = null;
        this.Orario = null;
        this.DurataOra = null;
        this.DurataMesi = null;
        this.PeriodoInizio = null;
        this.PeriodoFine = null;
        this.Modalita = null;
        this.Obbiettivi = null;
        this.Rimborsi = null;
        this.Facilitazioni = null;
        this.AziendaOspitante = null;
        this.CodiceTirocinio = null;
        this.SettoreInserimento = null;
        this.TempoAccessoLocaliAziendali = null;
        this.NomeTutoreAziendale = null;
        this.CognomeTutoreAziendale = null;
        this.TelefonoTutoreAzindale = null;
        this.EmailTutoreAziendale = null;
        this.CreateDate = null;
        this.UpdateDate = null;
        this.Azienda = 0;
        this.TutoreUniversitario = 0;
    }

    //GET DATA


    public Integer getIDOffertaTirocinio() {
        return IDOffertaTirocinio;
    }

    public String getLuogoEffettuazione() {
        return LuogoEffettuazione;
    }

    public String getTitolo() {
        return Titolo;
    }

    public String getDescrizioneBreve() {
        return DescrizioneBreve;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public String getOrario() {
        return Orario;
    }

    public Integer getDurataOra() {
        return DurataOra;
    }

    public Integer getDurataMesi() {
        return DurataMesi;
    }

    public Date getPeriodoInizio() {
        return PeriodoInizio;
    }

    public Date getPeriodoFine() {
        return PeriodoFine;
    }

    public String getModalita() {
        return Modalita;
    }

    public String getObbiettivi() {
        return Obbiettivi;
    }

    public String getRimborsi() {
        return Rimborsi;
    }

    public String getFacilitazioni() {
        return Facilitazioni;
    }

    public String getAziendaOspitante() {
        return AziendaOspitante;
    }

    public String getCodiceTirocinio() {
        return CodiceTirocinio;
    }

    public String getSettoreInserimento() {
        return SettoreInserimento;
    }

    public String getTempoAccessoLocaliAziendali() {
        return TempoAccessoLocaliAziendali;
    }

    public String getNomeTutoreAziendale() {
        return NomeTutoreAziendale;
    }

    public String getCognomeTutoreAziendale() {
        return CognomeTutoreAziendale;
    }

    public String getTelefonoTutoreAzindale() {
        return TelefonoTutoreAzindale;
    }

    public String getEmailTutoreAziendale() {
        return EmailTutoreAziendale;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    public Integer getAzienda() {
        return Azienda;
    }

    public Integer getTutoreUniversitario() {
        return TutoreUniversitario;
    }

    // SET DATA

    public void setIDOffertaTirocinio(Integer IDOffertaTirocinio) {
        this.IDOffertaTirocinio = IDOffertaTirocinio;
    }

    public void setLuogoEffettuazione(String luogoEffettuazione) {
        LuogoEffettuazione = luogoEffettuazione;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public void setDescrizioneBreve(String descrizioneBreve) {
        DescrizioneBreve = descrizioneBreve;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public void setOrario(String orario) {
        Orario = orario;
    }

    public void setDurataOra(Integer durataOra) {
        DurataOra = durataOra;
    }

    public void setDurataMesi(Integer durataMesi) {
        DurataMesi = durataMesi;
    }

    public void setPeriodoInizio(Date periodoInizio) {
        PeriodoInizio = periodoInizio;
    }

    public void setPeriodoFine(Date periodoFine) {
        PeriodoFine = periodoFine;
    }

    public void setModalita(String modalita) {
        Modalita = modalita;
    }

    public void setObbiettivi(String obbiettivi) {
        Obbiettivi = obbiettivi;
    }

    public void setRimborsi(String rimborsi) {
        Rimborsi = rimborsi;
    }

    public void setFacilitazioni(String facilitazioni) {
        Facilitazioni = facilitazioni;
    }

    public void setAziendaOspitante(String aziendaOspitante) {
        AziendaOspitante = aziendaOspitante;
    }

    public void setCodiceTirocinio(String codiceTirocinio) {
        CodiceTirocinio = codiceTirocinio;
    }

    public void setSettoreInserimento(String settoreInserimento) {
        SettoreInserimento = settoreInserimento;
    }

    public void setTempoAccessoLocaliAziendali(String tempoAccessoLocaliAziendali) {
        TempoAccessoLocaliAziendali = tempoAccessoLocaliAziendali;
    }

    public void setNomeTutoreAziendale(String nomeTutoreAziendale) {
        NomeTutoreAziendale = nomeTutoreAziendale;
    }

    public void setCognomeTutoreAziendale(String cognomeTutoreAziendale) {
        CognomeTutoreAziendale = cognomeTutoreAziendale;
    }

    public void setTelefonoTutoreAzindale(String telefonoTutoreAzindale) {
        TelefonoTutoreAzindale = telefonoTutoreAzindale;
    }

    public void setEmailTutoreAziendale(String emailTutoreAziendale) {
        EmailTutoreAziendale = emailTutoreAziendale;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }

    public void setAzienda(Integer azienda) {
        Azienda = azienda;
    }

    public void setTutoreUniversitario(Integer tutoreUniversitario) {
        TutoreUniversitario = tutoreUniversitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffertaTirocinio that = (OffertaTirocinio) o;
        return IDOffertaTirocinio.equals(that.IDOffertaTirocinio) &&
                LuogoEffettuazione.equals(that.LuogoEffettuazione) &&
                Titolo.equals(that.Titolo) &&
                DescrizioneBreve.equals(that.DescrizioneBreve) &&
                Descrizione.equals(that.Descrizione) &&
                Orario.equals(that.Orario) &&
                DurataOra.equals(that.DurataOra) &&
                DurataMesi.equals(that.DurataMesi) &&
                PeriodoInizio.equals(that.PeriodoInizio) &&
                PeriodoFine.equals(that.PeriodoFine) &&
                Modalita.equals(that.Modalita) &&
                Obbiettivi.equals(that.Obbiettivi) &&
                Objects.equals(Rimborsi, that.Rimborsi) &&
                Objects.equals(Facilitazioni, that.Facilitazioni) &&
                AziendaOspitante.equals(that.AziendaOspitante) &&
                CodiceTirocinio.equals(that.CodiceTirocinio) &&
                SettoreInserimento.equals(that.SettoreInserimento) &&
                TempoAccessoLocaliAziendali.equals(that.TempoAccessoLocaliAziendali) &&
                NomeTutoreAziendale.equals(that.NomeTutoreAziendale) &&
                CognomeTutoreAziendale.equals(that.CognomeTutoreAziendale) &&
                TelefonoTutoreAzindale.equals(that.TelefonoTutoreAzindale) &&
                EmailTutoreAziendale.equals(that.EmailTutoreAziendale) &&
                CreateDate.equals(that.CreateDate) &&
                UpdateDate.equals(that.UpdateDate) &&
                Azienda.equals(that.Azienda) &&
                TutoreUniversitario.equals(that.TutoreUniversitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDOffertaTirocinio, LuogoEffettuazione, Titolo, DescrizioneBreve, Descrizione, Orario, DurataOra, DurataMesi, PeriodoInizio, PeriodoFine, Modalita, Obbiettivi, Rimborsi, Facilitazioni, AziendaOspitante, CodiceTirocinio, SettoreInserimento, TempoAccessoLocaliAziendali, NomeTutoreAziendale, CognomeTutoreAziendale, TelefonoTutoreAzindale, EmailTutoreAziendale, CreateDate, UpdateDate, Azienda, TutoreUniversitario);
    }

    @Override
    public String toString() {
        return "OffertaTirocinio{" +
                "IDOffertaTirocinio=" + IDOffertaTirocinio +
                ", LuogoEffettuazione='" + LuogoEffettuazione + '\'' +
                ", Titolo='" + Titolo + '\'' +
                ", DescrizioneBreve='" + DescrizioneBreve + '\'' +
                ", Descrizione='" + Descrizione + '\'' +
                ", Orario='" + Orario + '\'' +
                ", DurataOra=" + DurataOra +
                ", DurataMesi=" + DurataMesi +
                ", PeriodoInizio=" + PeriodoInizio +
                ", PeriodoFine=" + PeriodoFine +
                ", Modalita='" + Modalita + '\'' +
                ", Obbiettivi='" + Obbiettivi + '\'' +
                ", Rimborsi='" + Rimborsi + '\'' +
                ", Facilitazioni='" + Facilitazioni + '\'' +
                ", AziendaOspitante='" + AziendaOspitante + '\'' +
                ", CodiceTirocinio='" + CodiceTirocinio + '\'' +
                ", SettoreInserimento='" + SettoreInserimento + '\'' +
                ", TempoAccessoLocaliAziendali='" + TempoAccessoLocaliAziendali + '\'' +
                ", NomeTutoreAziendale='" + NomeTutoreAziendale + '\'' +
                ", CognomeTutoreAziendale='" + CognomeTutoreAziendale + '\'' +
                ", TelefonoTutoreAzindale='" + TelefonoTutoreAzindale + '\'' +
                ", EmailTutoreAziendale='" + EmailTutoreAziendale + '\'' +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                ", Azienda=" + Azienda +
                ", TutoreUniversitario=" + TutoreUniversitario +
                '}';
    }
}
