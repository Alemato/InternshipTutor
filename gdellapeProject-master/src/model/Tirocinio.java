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
    private Timestamp CreateDate;
    private Timestamp UpdateDate;
    private Integer OffertaTirocinio;
    private Integer Tirocinante;
    private Integer TutoreUniveritario;

    public Tirocinio() {
        this.IDTirocinio = 0;
        this.DataConsegnaModulo = null;
        this.DurataOre = 0;
        this.CFU = 0;
        this.Stato = 0;
        this.PeriodoEffettivoIniziale = null;
        this.PeriodoEffettivoFinale = null;
        this.RisultatoConseguito = null;
        this.DescrizioneAttivitaSvolta = null;
        this.PdfTirocinante=null;
        this.PdfAzienda=null;
        this.PdfSegreteria=null;
        this.CreateDate = null;
        this.UpdateDate = null;
        this.OffertaTirocinio = 0;
        this.Tirocinante = 0;
        this.TutoreUniveritario = 0;
    }

    // GET DATA


    public Integer getIDTirocinio() {
        return IDTirocinio;
    }

    public Date getDataConsegnaModulo() {
        return DataConsegnaModulo;
    }

    public Integer getDurataOre() {
        return DurataOre;
    }

    public Integer getCFU() {
        return CFU;
    }

    public Integer getStato() {
        return Stato;
    }

    public Date getPeriodoEffettivoIniziale() {
        return PeriodoEffettivoIniziale;
    }

    public Date getPeriodoEffettivoFinale() {
        return PeriodoEffettivoFinale;
    }

    public String getRisultatoConseguito() {
        return RisultatoConseguito;
    }

    public String getDescrizioneAttivitaSvolta() {
        return DescrizioneAttivitaSvolta;
    }

    public String getPdfTirocinante() {
        return PdfTirocinante;
    }

    public String getPdfAzienda() {
        return PdfAzienda;
    }

    public String getPdfSegreteria() {
        return PdfSegreteria;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    public Integer getOffertaTirocinio() {
        return OffertaTirocinio;
    }

    public Integer getTirocinante() {
        return Tirocinante;
    }

    public Integer getTutoreUniveritario() {
        return TutoreUniveritario;
    }

    // SET DATA

    public void setIDTirocinio(Integer IDTirocinio) {
        this.IDTirocinio = IDTirocinio;
    }

    public void setDataConsegnaModulo(Date dataConsegnaModulo) {
        DataConsegnaModulo = dataConsegnaModulo;
    }

    public void setDurataOre(Integer durataOre) {
        DurataOre = durataOre;
    }

    public void setCFU(Integer CFU) {
        this.CFU = CFU;
    }

    public void setStato(Integer stato) {
        Stato = stato;
    }

    public void setPeriodoEffettivoIniziale(Date periodoEffettivoIniziale) {
        PeriodoEffettivoIniziale = periodoEffettivoIniziale;
    }

    public void setPeriodoEffettivoFinale(Date periodoEffettivoFinale) {
        PeriodoEffettivoFinale = periodoEffettivoFinale;
    }

    public void setRisultatoConseguito(String risultatoConseguito) {
        RisultatoConseguito = risultatoConseguito;
    }

    public void setDescrizioneAttivitaSvolta(String descrizioneAttivitaSvolta) {
        DescrizioneAttivitaSvolta = descrizioneAttivitaSvolta;
    }

    public void setPdfTirocinante(String pdfTirocinante) {
        PdfTirocinante = pdfTirocinante;
    }

    public void setPdfAzienda(String pdfAzienda) {
        PdfAzienda = pdfAzienda;
    }

    public void setPdfSegreteria(String pdfSegreteria) {
        PdfSegreteria = pdfSegreteria;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }

    public void setOffertaTirocinio(Integer offertaTirocinio) {
        OffertaTirocinio = offertaTirocinio;
    }

    public void setTirocinante(Integer tirocinante) {
        Tirocinante = tirocinante;
    }

    public void setTutoreUniveritario(Integer tutoreUniveritario) {
        TutoreUniveritario = tutoreUniveritario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tirocinio tirocinio = (Tirocinio) o;
        return IDTirocinio.equals(tirocinio.IDTirocinio) &&
                Objects.equals(DataConsegnaModulo, tirocinio.DataConsegnaModulo) &&
                DurataOre.equals(tirocinio.DurataOre) &&
                CFU.equals(tirocinio.CFU) &&
                Stato.equals(tirocinio.Stato) &&
                Objects.equals(PeriodoEffettivoIniziale, tirocinio.PeriodoEffettivoIniziale) &&
                Objects.equals(PeriodoEffettivoFinale, tirocinio.PeriodoEffettivoFinale) &&
                Objects.equals(RisultatoConseguito, tirocinio.RisultatoConseguito) &&
                Objects.equals(DescrizioneAttivitaSvolta, tirocinio.DescrizioneAttivitaSvolta) &&
                Objects.equals(PdfTirocinante, tirocinio.PdfTirocinante) &&
                Objects.equals(PdfAzienda, tirocinio.PdfAzienda) &&
                Objects.equals(PdfSegreteria, tirocinio.PdfSegreteria) &&
                CreateDate.equals(tirocinio.CreateDate) &&
                UpdateDate.equals(tirocinio.UpdateDate) &&
                OffertaTirocinio.equals(tirocinio.OffertaTirocinio) &&
                Tirocinante.equals(tirocinio.Tirocinante) &&
                TutoreUniveritario.equals(tirocinio.TutoreUniveritario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDTirocinio, DataConsegnaModulo, DurataOre, CFU, Stato, PeriodoEffettivoIniziale, PeriodoEffettivoFinale, RisultatoConseguito, DescrizioneAttivitaSvolta, PdfTirocinante, PdfAzienda, PdfSegreteria, CreateDate, UpdateDate, OffertaTirocinio, Tirocinante, TutoreUniveritario);
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
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                ", OffertaTirocinio=" + OffertaTirocinio +
                ", Tirocinante=" + Tirocinante +
                ", TutoreUniveritario=" + TutoreUniveritario +
                '}';
    }

}
