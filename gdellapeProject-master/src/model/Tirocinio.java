package model;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects;

public class Tirocinio {
    private Integer IDTirocinio;
    private Date DataConsegnaModulo;
    private Integer DurataOre;
    private Integer CFU;
    private Integer Stato;
    private Date PeriodoEffettivoIniziale;
    private Date PeriodoEffettivoFinale;
    private String RisultatoConseguito;
    private String DescrizioneAttivitaSvolta;
    private String PdfTirocinante;
    private String PdfAzienda;
    private String PdfSegreteria;
    private Integer OffertaTirocinio;
    private Integer Tirocinante;
    private Integer TutoreUniveritario;
    private Timestamp CreateDate;

    public String getPdfTirocinante() {
        return PdfTirocinante;
    }

    public void setPdfTirocinante(String pdfTirocinante) {
        PdfTirocinante = pdfTirocinante;
    }

    public String getPdfAzienda() {
        return PdfAzienda;
    }

    public void setPdfAzienda(String pdfAzienda) {
        PdfAzienda = pdfAzienda;
    }

    public String getPdfSegreteria() {
        return PdfSegreteria;
    }

    public void setPdfSegreteria(String pdfSegreteria) {
        PdfSegreteria = pdfSegreteria;
    }

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
        this.PdfAzienda=null;
        this.PdfSegreteria=null;
        this.PdfTirocinante=null;
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
                ", DurataOre=" + DurataOre +
                ", CFU=" + CFU +
                ", Stato=" + Stato +
                ", PeriodoEffettivoIniziale=" + PeriodoEffettivoIniziale +
                ", PeriodoEffettivoFinale=" + PeriodoEffettivoFinale +
                ", RisultatoConseguito='" + RisultatoConseguito + '\'' +
                ", DescrizioneAttivitaSvolta='" + DescrizioneAttivitaSvolta + '\'' +
                ", PdfTirocinante='" + PdfTirocinante + '\'' +
                ", PdfAzienda='" + PdfAzienda + '\'' +
                ", PdfSegreteria='" + PdfSegreteria + '\'' +
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
        return Objects.equals(getIDTirocinio(), tirocinio.getIDTirocinio()) &&
                Objects.equals(getDataConsegnaModulo(), tirocinio.getDataConsegnaModulo()) &&
                Objects.equals(getDurataOre(), tirocinio.getDurataOre()) &&
                Objects.equals(getCFU(), tirocinio.getCFU()) &&
                Objects.equals(getStato(), tirocinio.getStato()) &&
                Objects.equals(getPeriodoEffettivoIniziale(), tirocinio.getPeriodoEffettivoIniziale()) &&
                Objects.equals(getPeriodoEffettivoFinale(), tirocinio.getPeriodoEffettivoFinale()) &&
                Objects.equals(getRisultatoConseguito(), tirocinio.getRisultatoConseguito()) &&
                Objects.equals(getDescrizioneAttivitaSvolta(), tirocinio.getDescrizioneAttivitaSvolta()) &&
                Objects.equals(getPdfTirocinante(), tirocinio.getPdfTirocinante()) &&
                Objects.equals(getPdfAzienda(), tirocinio.getPdfAzienda()) &&
                Objects.equals(getPdfSegreteria(), tirocinio.getPdfSegreteria()) &&
                Objects.equals(getOffertaTirocinio(), tirocinio.getOffertaTirocinio()) &&
                Objects.equals(getTirocinante(), tirocinio.getTirocinante()) &&
                Objects.equals(getTutoreUniveritario(), tirocinio.getTutoreUniveritario()) &&
                Objects.equals(getCreateDate(), tirocinio.getCreateDate()) &&
                Objects.equals(getUpdateDate(), tirocinio.getUpdateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDTirocinio(), getDataConsegnaModulo(), getDurataOre(), getCFU(), getStato(), getPeriodoEffettivoIniziale(), getPeriodoEffettivoFinale(), getRisultatoConseguito(), getDescrizioneAttivitaSvolta(), getPdfTirocinante(), getPdfAzienda(), getPdfSegreteria(), getOffertaTirocinio(), getTirocinante(), getTutoreUniveritario(), getCreateDate(), getUpdateDate());
    }
}
