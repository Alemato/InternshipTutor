package model;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects;

public class Tirocinio {
    private Integer IDTirocinio;
    private Date DataConsegnaModuloRichiesta;
    private Integer DurataOre;
    private Integer CFU;
    /**
     * Lo stato può essere:
     * 0=il tirocinante ha fatto la richiesta ma l'azienda non ancora accetta la sua richieta
     * 1=L'azienda accetta la richiesta e comincia il tirocinio
     * 2=L'azienda dichiara finito il tirocinio
     * 3=Segreteria dichiara la conclusione amministrativa
     * 4=Votazione effettuata
     * 5=L'azienda rifiuta
     */
    private Integer Stato;
    private Date PeriodoEffettivoIniziale;
    private Date PeriodoEffettivoFinale;
    private String RisultatoConseguito;
    private String DescrizioneAttivitaSvolta;
    private String PdfTirocinante;
    private String PdfAzienda;
    private Date DataConsegnaModuloAzienda;
    private String PdfSegreteria;
    private Date DataConsegnaModuloSegreteria;
    private Date DataColloquioSegreteria;
    private String EsitoTirocinio;
    private Integer CreditiRiconosciuti;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;
    private Integer OffertaTirocinio;
    private Integer Tirocinante;
    private Integer TutoreUniversitario;

    public Tirocinio() {
        this.IDTirocinio = 0;
        this.DataConsegnaModuloRichiesta = null;
        this.DurataOre = 0;
        this.CFU = 0;
        this.Stato = 0;
        this.PeriodoEffettivoIniziale = null;
        this.PeriodoEffettivoFinale = null;
        this.RisultatoConseguito = null;
        this.DescrizioneAttivitaSvolta = null;
        this.PdfTirocinante=null;
        this.PdfAzienda=null;
        this.DataConsegnaModuloAzienda=null;
        this.PdfSegreteria=null;
        this.DataConsegnaModuloSegreteria = null;
        this.DataColloquioSegreteria =null;
        this.EsitoTirocinio =null;
        this.CreditiRiconosciuti =null;
        this.CreateDate = null;
        this.UpdateDate = null;
        this.OffertaTirocinio = 0;
        this.Tirocinante = 0;
        this.TutoreUniversitario = 0;
    }

    // GET DATA

    public Integer getIDTirocinio() {
        return IDTirocinio;
    }

    public Date getDataConsegnaModuloRichiesta() {
        return DataConsegnaModuloRichiesta;
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

    public Date getDataConsegnaModuloAzienda() {
        return DataConsegnaModuloAzienda;
    }

    public String getPdfSegreteria() {
        return PdfSegreteria;
    }

    public Date getDataConsegnaModuloSegreteria() {
        return DataConsegnaModuloSegreteria;
    }

    public Date getDataColloquioSegreteria() {
        return DataColloquioSegreteria;
    }

    public String getEsitoTirocinio() {
        return EsitoTirocinio;
    }

    public Integer getCreditiRiconosciuti() {
        return CreditiRiconosciuti;
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

    public Integer getTutoreUniversitario() {
        return TutoreUniversitario;
    }

    // SET DATA

    public void setIDTirocinio(Integer IDTirocinio) {
        this.IDTirocinio = IDTirocinio;
    }

    public void setDataConsegnaModuloRichiesta(Date dataConsegnaModuloRichiesta) {
        DataConsegnaModuloRichiesta = dataConsegnaModuloRichiesta;
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

    public void setDataConsegnaModuloAzienda(Date dataConsegnaModuloAzienda) {
        DataConsegnaModuloAzienda = dataConsegnaModuloAzienda;
    }

    public void setPdfSegreteria(String pdfSegreteria) {
        PdfSegreteria = pdfSegreteria;
    }

    public void setDataConsegnaModuloSegreteria(Date dataConsegnaModuloSegreteria) {
        DataConsegnaModuloSegreteria = dataConsegnaModuloSegreteria;
    }

    public void setDataColloquioSegreteria(Date dataColloquioSegreteria) {
        DataColloquioSegreteria = dataColloquioSegreteria;
    }

    public void setEsitoTirocinio(String esitoTirocinio) {
        EsitoTirocinio = esitoTirocinio;
    }

    public void setCreditiRiconosciuti(Integer creditiRiconosciuti) {
        CreditiRiconosciuti = creditiRiconosciuti;
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

    public void setTutoreUniversitario(Integer tutoreUniversitario) {
        TutoreUniversitario = tutoreUniversitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tirocinio tirocinio = (Tirocinio) o;
        return IDTirocinio.equals(tirocinio.IDTirocinio) &&
                Objects.equals(DataConsegnaModuloRichiesta, tirocinio.DataConsegnaModuloRichiesta) &&
                DurataOre.equals(tirocinio.DurataOre) &&
                CFU.equals(tirocinio.CFU) &&
                Stato.equals(tirocinio.Stato) &&
                Objects.equals(PeriodoEffettivoIniziale, tirocinio.PeriodoEffettivoIniziale) &&
                Objects.equals(PeriodoEffettivoFinale, tirocinio.PeriodoEffettivoFinale) &&
                Objects.equals(RisultatoConseguito, tirocinio.RisultatoConseguito) &&
                Objects.equals(DescrizioneAttivitaSvolta, tirocinio.DescrizioneAttivitaSvolta) &&
                Objects.equals(PdfTirocinante, tirocinio.PdfTirocinante) &&
                Objects.equals(PdfAzienda, tirocinio.PdfAzienda) &&
                Objects.equals(DataConsegnaModuloAzienda, tirocinio.DataConsegnaModuloAzienda) &&
                Objects.equals(PdfSegreteria, tirocinio.PdfSegreteria) &&
                Objects.equals(DataConsegnaModuloSegreteria, tirocinio.DataConsegnaModuloSegreteria) &&
                Objects.equals(DataColloquioSegreteria, tirocinio.DataColloquioSegreteria) &&
                Objects.equals(EsitoTirocinio, tirocinio.EsitoTirocinio) &&
                Objects.equals(CreditiRiconosciuti, tirocinio.CreditiRiconosciuti) &&
                CreateDate.equals(tirocinio.CreateDate) &&
                UpdateDate.equals(tirocinio.UpdateDate) &&
                OffertaTirocinio.equals(tirocinio.OffertaTirocinio) &&
                Tirocinante.equals(tirocinio.Tirocinante) &&
                TutoreUniversitario.equals(tirocinio.TutoreUniversitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDTirocinio, DataConsegnaModuloRichiesta, DurataOre, CFU, Stato, PeriodoEffettivoIniziale, PeriodoEffettivoFinale, RisultatoConseguito, DescrizioneAttivitaSvolta, PdfTirocinante, PdfAzienda, DataConsegnaModuloAzienda, PdfSegreteria, DataConsegnaModuloSegreteria, DataColloquioSegreteria, EsitoTirocinio, CreditiRiconosciuti, CreateDate, UpdateDate, OffertaTirocinio, Tirocinante, TutoreUniversitario);
    }

    @Override
    public String toString() {
        return "Tirocinio{" +
                "IDTirocinio=" + IDTirocinio +
                ", DataConsegnaModuloRichiesta=" + DataConsegnaModuloRichiesta +
                ", DurataOre=" + DurataOre +
                ", CFU=" + CFU +
                ", Stato=" + Stato +
                ", PeriodoEffettivoIniziale=" + PeriodoEffettivoIniziale +
                ", PeriodoEffettivoFinale=" + PeriodoEffettivoFinale +
                ", RisultatoConseguito='" + RisultatoConseguito + '\'' +
                ", DescrizioneAttivitaSvolta='" + DescrizioneAttivitaSvolta + '\'' +
                ", PdfTirocinante='" + PdfTirocinante + '\'' +
                ", PdfAzienda='" + PdfAzienda + '\'' +
                ", DataConsegnaModuloAzienda=" + DataConsegnaModuloAzienda +
                ", PdfSegreteria='" + PdfSegreteria + '\'' +
                ", DataConsegnaModuloSegreteria=" + DataConsegnaModuloSegreteria +
                ", DataColloquioSegreteria=" + DataColloquioSegreteria +
                ", EsitoTirocinio='" + EsitoTirocinio + '\'' +
                ", CreditiRiconosciuti=" + CreditiRiconosciuti +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                ", OffertaTirocinio=" + OffertaTirocinio +
                ", Tirocinante=" + Tirocinante +
                ", TutoreUniversitario=" + TutoreUniversitario +
                '}';
    }
}
