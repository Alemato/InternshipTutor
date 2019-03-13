package model;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects;

public class Tirocinante {
    private Integer IDTirocinante;
    private String Nome;
    private String Cognome;
    private String LuogoDiNascita;
    private Date DataDiNascita;
    private String LuogoDiResidenza;
    private String ProvinciaDiResidenza;
    private String ProvinciaDiNascita;
    private String CodiceFiscale;
    private String Telefono;
    private String CorsoDiLaurea;
    private String DiplomaUniversitario;
    private String Laureato;
    private String DottoratoDiRicerca;
    private String ScuolaAltro;
    private Boolean Handicap;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;
    private Integer User;

    public Tirocinante() {
        this.IDTirocinante = 0;
        this.Nome = null;
        this.Cognome = null;
        this.LuogoDiNascita = null;
        this.DataDiNascita = null;
        this.LuogoDiResidenza = null;
        this.ProvinciaDiResidenza = null;
        this.ProvinciaDiNascita = null;
        this.CodiceFiscale = null;
        this.Telefono = null;
        this.CorsoDiLaurea = null;
        this.DiplomaUniversitario = null;
        this.Laureato = null;
        this.DottoratoDiRicerca = null;
        this.ScuolaAltro = null;
        this.Handicap = null;
        this.CreateDate = null;
        this.UpdateDate = null;
        this.User = 0;
    }


    // GET DATA
    public Integer getIDTirocinante() {
        return IDTirocinante;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public String getLuogoDiNascita() {
        return LuogoDiNascita;
    }

    public Date getDataDiNascita() {
        return DataDiNascita;
    }

    public String getLuogoDiResidenza() {
        return LuogoDiResidenza;
    }

    public String getProvinciaDiResidenza() {
        return ProvinciaDiResidenza;
    }

    public String getProvinciaDiNascita() {
        return ProvinciaDiNascita;
    }

    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getCorsoDiLaurea() {
        return CorsoDiLaurea;
    }

    public String getDiplomaUniversitario() {
        return DiplomaUniversitario;
    }

    public String getLaureato() {
        return Laureato;
    }

    public String getDottoratoDiRicerca() {
        return DottoratoDiRicerca;
    }

    public String getScuolaAltro() {
        return ScuolaAltro;
    }

    public Boolean getHandicap() {
        return Handicap;
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

    public void setIDTirocinante(Integer IDTirocinante) {
        this.IDTirocinante = IDTirocinante;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public void setLuogoDiNascita(String luogoDiNascita) {
        LuogoDiNascita = luogoDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        DataDiNascita = dataDiNascita;
    }

    public void setLuogoDiResidenza(String luogoDiResidenza) {
        LuogoDiResidenza = luogoDiResidenza;
    }

    public void setProvinciaDiResidenza(String provinciaDiResidenza) {
        ProvinciaDiResidenza = provinciaDiResidenza;
    }

    public void setProvinciaDiNascita(String provinciaDiNascita) {
        ProvinciaDiNascita = provinciaDiNascita;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        CodiceFiscale = codiceFiscale;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public void setCorsoDiLaurea(String corsoDiLaurea) {
        CorsoDiLaurea = corsoDiLaurea;
    }

    public void setDiplomaUniversitario(String diplomaUniversitario) {
        DiplomaUniversitario = diplomaUniversitario;
    }

    public void setLaureato(String laureatoUniversitario) {
        Laureato = laureatoUniversitario;
    }

    public void setDottoratoDiRicerca(String dottoratoDiRicerca) {
        DottoratoDiRicerca = dottoratoDiRicerca;
    }

    public void setScuolaAltro(String scuolaAltro) {
        ScuolaAltro = scuolaAltro;
    }

    public void setHandicap(Boolean handicap) {
        Handicap = handicap;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }

    public void setUser(Integer user) {
        User = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tirocinante that = (Tirocinante) o;
        return IDTirocinante.equals(that.IDTirocinante) &&
                Nome.equals(that.Nome) &&
                Cognome.equals(that.Cognome) &&
                LuogoDiNascita.equals(that.LuogoDiNascita) &&
                DataDiNascita.equals(that.DataDiNascita) &&
                LuogoDiResidenza.equals(that.LuogoDiResidenza) &&
                ProvinciaDiResidenza.equals(that.ProvinciaDiResidenza) &&
                ProvinciaDiNascita.equals(that.ProvinciaDiNascita) &&
                CodiceFiscale.equals(that.CodiceFiscale) &&
                Telefono.equals(that.Telefono) &&
                Objects.equals(CorsoDiLaurea, that.CorsoDiLaurea) &&
                Objects.equals(DiplomaUniversitario, that.DiplomaUniversitario) &&
                Objects.equals(Laureato, that.Laureato) &&
                Objects.equals(DottoratoDiRicerca, that.DottoratoDiRicerca) &&
                Objects.equals(ScuolaAltro, that.ScuolaAltro) &&
                Handicap.equals(that.Handicap) &&
                CreateDate.equals(that.CreateDate) &&
                UpdateDate.equals(that.UpdateDate) &&
                User.equals(that.User);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDTirocinante, Nome, Cognome, LuogoDiNascita, DataDiNascita, LuogoDiResidenza, ProvinciaDiResidenza, ProvinciaDiNascita, CodiceFiscale, Telefono, CorsoDiLaurea, DiplomaUniversitario, Laureato, DottoratoDiRicerca, ScuolaAltro, Handicap, CreateDate, UpdateDate, User);
    }

    @Override
    public String toString() {
        return "Tirocinante{" +
                "IDTirocinante=" + IDTirocinante +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", LuogoDiNascita='" + LuogoDiNascita + '\'' +
                ", DataDiNascita=" + DataDiNascita +
                ", LuogoDiResidenza='" + LuogoDiResidenza + '\'' +
                ", ProvinciaDiResidenza='" + ProvinciaDiResidenza + '\'' +
                ", ProvinciaDiNascita='" + ProvinciaDiNascita + '\'' +
                ", CodiceFiscale='" + CodiceFiscale + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", CorsoDiLaurea='" + CorsoDiLaurea + '\'' +
                ", DiplomaUniversitario='" + DiplomaUniversitario + '\'' +
                ", LaureatoUniversitario='" + Laureato + '\'' +
                ", DottoratoDiRicerca='" + DottoratoDiRicerca + '\'' +
                ", ScuolaAltro='" + ScuolaAltro + '\'' +
                ", Handicap=" + Handicap +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                ", User=" + User +
                '}';
    }
}