package model;

import java.sql.Timestamp;
import java.util.Date;

public class TirocinioEffettuato {

    private Integer IDTirocinioEffettuato;
    private Date DataConsegnaModulo;
    private Date PeriodoEffettivoInizio;
    private Date PeriodoEffettivoFine;
    private String RisultatoConseguito;
    private String DescrizioneAttivitaSvolta;
    private Integer RicTirocinio;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public TirocinioEffettuato() {
        this.IDTirocinioEffettuato = 0;
        DataConsegnaModulo = null;
        PeriodoEffettivoInizio = null;
        PeriodoEffettivoFine = null;
        RisultatoConseguito = null;
        DescrizioneAttivitaSvolta = null;
        RicTirocinio = 0;
        CreateDate = null;
        UpdateDate = null;
    }

    public Integer getIDTirocinioEffettuato() {
        return IDTirocinioEffettuato;
    }


    public Date getDataConsegnaModulo() {
        return DataConsegnaModulo;
    }

    public Date getPeriodoEffettivoInizio() {
        return PeriodoEffettivoInizio;
    }

    public Date getPeriodoEffettivoFine() {
        return PeriodoEffettivoFine;
    }

    public String getRisultatoConseguito() {
        return RisultatoConseguito;
    }

    public String getDescrizioneAttivitaSvolta() {
        return DescrizioneAttivitaSvolta;
    }

    public void setIDTirocinioEffettuato(Integer IDTirocinioEffettuato) {
        this.IDTirocinioEffettuato = IDTirocinioEffettuato;
    }


    public void setDataConsegnaModulo(Date dataConsegnaModulo) {
        DataConsegnaModulo = dataConsegnaModulo;
    }

    public void setPeriodoEffettivoInizio(Date periodoEffettivoInizio) {
        PeriodoEffettivoInizio = periodoEffettivoInizio;
    }

    public void setPeriodoEffettivoFine(Date periodoEffettivoFine) {
        PeriodoEffettivoFine = periodoEffettivoFine;
    }

    public void setRisultatoConseguito(String risultatoConseguito) {
        RisultatoConseguito = risultatoConseguito;
    }

    public void setDescrizioneAttivitaSvolta(String descrizioneAttivitaSvolta) {
        DescrizioneAttivitaSvolta = descrizioneAttivitaSvolta;
    }

    public Integer getRicTirocinio() {
        return RicTirocinio;
    }

    public void setRicTirocinio(Integer ricTirocinio) {
        RicTirocinio = ricTirocinio;
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
