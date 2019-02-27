package model;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects;

public class Tirocinio {
    private Integer IDTirocinio;
    private Date DataConsegnaModulo;
    private Date PeriodoEffettivoIniziale;
    private Date PeriodoEffettivoFinale;
    private String RisultatoConseguito;
    private String DescrizioneAttivitaSvolta;
    private Integer DurataOre;
    private Integer CFU;
    private Integer Stato;
    private Integer OffertaTirocinio;
    private Integer Tirocinante;
    private Integer TutoreUniveritario;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public Tirocinio() {
        this.IDTirocinio = 0;
        DataConsegnaModulo = null;
        PeriodoEffettivoIniziale = null;
        PeriodoEffettivoFinale = null;
        RisultatoConseguito = null;
        DescrizioneAttivitaSvolta = null;
        DurataOre = 0;
        this.CFU = 0;
        Stato = 0;
        OffertaTirocinio = 0;
        Tirocinante = 0;
        CreateDate = null;
        UpdateDate = null;
        this.TutoreUniveritario = 0;
    }

    public Integer getOffertaTirocinio() {
        return OffertaTirocinio;
    }

    public void setOffertaTirocinio(Integer offertaTirocinio) {
        OffertaTirocinio = offertaTirocinio;
    }

    public Integer getTirocinante() {
        return Tirocinante;
    }

    public void setTirocinante(Integer tirocinante) {
        Tirocinante = tirocinante;
    }



    public Integer getIDTirocinio() {
        return IDTirocinio;
    }

    public void setIDTirocinio(Integer IDTirocinio) {
        this.IDTirocinio = IDTirocinio;
    }

    public Integer getDurataOre() {
        return DurataOre;
    }

    public void setDurataOre(Integer durataOre) {
        DurataOre = durataOre;
    }

    public Integer getCFU() {
        return CFU;
    }

    public void setCFU(Integer CFU) {
        this.CFU = CFU;
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
    public Integer getTutoreUniveritario() {
        return TutoreUniveritario;
    }

    public void setTutoreUniveritario(Integer tutoreUniveritario) {
        TutoreUniveritario = tutoreUniveritario;
    }

    public Date getDataConsegnaModulo() {
        return DataConsegnaModulo;
    }

    public void setDataConsegnaModulo(Date dataConsegnaModulo) {
        DataConsegnaModulo = dataConsegnaModulo;
    }

    public Date getPeriodoEffettivoIniziale() {
        return PeriodoEffettivoIniziale;
    }

    public void setPeriodoEffettivoIniziale(Date periodoEffettivoIniziale) {
        PeriodoEffettivoIniziale = periodoEffettivoIniziale;
    }

    public Date getPeriodoEffettivoFinale() {
        return PeriodoEffettivoFinale;
    }

    public void setPeriodoEffettivoFinale(Date periodoEffettivoFinale) {
        PeriodoEffettivoFinale = periodoEffettivoFinale;
    }

    public String getRisultatoConseguito() {
        return RisultatoConseguito;
    }

    public void setRisultatoConseguito(String risultatoConseguito) {
        RisultatoConseguito = risultatoConseguito;
    }

    public String getDescrizioneAttivitaSvolta() {
        return DescrizioneAttivitaSvolta;
    }

    public void setDescrizioneAttivitaSvolta(String descrizioneAttivitaSvolta) {
        DescrizioneAttivitaSvolta = descrizioneAttivitaSvolta;
    }

    public Integer getStato() {
        return Stato;
    }

    public void setStato(Integer stato) {
        Stato = stato;
    }

    @Override
    public String toString() {
        return "Tirocinio{" +
                "IDTirocinio=" + IDTirocinio +
                ", DataConsegnaModulo=" + DataConsegnaModulo +
                ", PeriodoEffettivoIniziale=" + PeriodoEffettivoIniziale +
                ", PeriodoEffettivoFinale=" + PeriodoEffettivoFinale +
                ", RisultatoConseguito='" + RisultatoConseguito + '\'' +
                ", DescrizioneAttivitaSvolta='" + DescrizioneAttivitaSvolta + '\'' +
                ", DurataOre=" + DurataOre +
                ", CFU=" + CFU +
                ", Stato=" + Stato +
                ", OffertaTirocinio=" + OffertaTirocinio +
                ", Tirocinante=" + Tirocinante +
                ", TutoreUniveritario=" + TutoreUniveritario +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tirocinio tirocinio = (Tirocinio) o;
        return Objects.equals(IDTirocinio, tirocinio.IDTirocinio) &&
                Objects.equals(DataConsegnaModulo, tirocinio.DataConsegnaModulo) &&
                Objects.equals(PeriodoEffettivoIniziale, tirocinio.PeriodoEffettivoIniziale) &&
                Objects.equals(PeriodoEffettivoFinale, tirocinio.PeriodoEffettivoFinale) &&
                Objects.equals(RisultatoConseguito, tirocinio.RisultatoConseguito) &&
                Objects.equals(DescrizioneAttivitaSvolta, tirocinio.DescrizioneAttivitaSvolta) &&
                Objects.equals(DurataOre, tirocinio.DurataOre) &&
                Objects.equals(CFU, tirocinio.CFU) &&
                Objects.equals(Stato, tirocinio.Stato) &&
                Objects.equals(OffertaTirocinio, tirocinio.OffertaTirocinio) &&
                Objects.equals(Tirocinante, tirocinio.Tirocinante) &&
                Objects.equals(TutoreUniveritario, tirocinio.TutoreUniveritario) &&
                Objects.equals(CreateDate, tirocinio.CreateDate) &&
                Objects.equals(UpdateDate, tirocinio.UpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDTirocinio, DataConsegnaModulo, PeriodoEffettivoIniziale, PeriodoEffettivoFinale, RisultatoConseguito, DescrizioneAttivitaSvolta, DurataOre, CFU, Stato, OffertaTirocinio, Tirocinante, TutoreUniveritario, CreateDate, UpdateDate);
    }
}
