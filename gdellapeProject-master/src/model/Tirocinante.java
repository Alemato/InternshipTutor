package model;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects;

public class Tirocinante {
    private Integer IDTirocinante;
    private String nome;
    private String Cognome;
    private String LuogoDiNascita;
    private String LuogoDiResidenza;
    private String ProvinciaDiNascita;
    private Date DataDiNascita;
    private String ProvinciaDiResidenza;
    private String CodiceFiscale;
    private String Telefono;
    private String CorsoDiLaurea;
    private String DiplomaUniversitario;
    private String LaureatoUniversitario;
    private String ScuolaAltro;
    private String DottoratoDiRicerca;
    private Boolean Handicap;
    private Integer User;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public Tirocinante() {
        this.IDTirocinante = 0;
        this.nome = null;
        Cognome = null;
        LuogoDiNascita = null;
        LuogoDiResidenza = null;
        ProvinciaDiNascita = null;
        DataDiNascita = null;
        ProvinciaDiResidenza = null;
        CodiceFiscale = null;
        Telefono = null;
        CorsoDiLaurea = null;
        DiplomaUniversitario = null;
        LaureatoUniversitario = null;
        ScuolaAltro = null;
        DottoratoDiRicerca = null;
        Handicap = null;
        User = 0;
        CreateDate = null;
        UpdateDate = null;
    }

    public Integer getIDTirocinante() {
        return IDTirocinante;
    }

    public void setIDTirocinante(Integer IDTirocinante) {
        this.IDTirocinante = IDTirocinante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getLuogoDiNascita() {
        return LuogoDiNascita;
    }

    public void setLuogoDiNascita(String luogoDiNascita) {
        LuogoDiNascita = luogoDiNascita;
    }

    public String getProvinciaDiNascita() {
        return ProvinciaDiNascita;
    }

    public void setProvinciaDiNascita(String provinciaDiNascita) {
        ProvinciaDiNascita = provinciaDiNascita;
    }

    public Date getDataDiNascita() {
        return DataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        DataDiNascita = dataDiNascita;
    }

    public String getProvinciaDiResidenza() {
        return ProvinciaDiResidenza;
    }

    public void setProvinciaDiResidenza(String provinciaDiResidenza) {
        ProvinciaDiResidenza = provinciaDiResidenza;
    }

    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        CodiceFiscale = codiceFiscale;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorsoDiLaurea() {
        return CorsoDiLaurea;
    }

    public void setCorsoDiLaurea(String corsoDiLaurea) {
        CorsoDiLaurea = corsoDiLaurea;
    }

    public String getDiplomaUniversitario() {
        return DiplomaUniversitario;
    }

    public void setDiplomaUniversitario(String diplomaUniversitario) {
        DiplomaUniversitario = diplomaUniversitario;
    }

    public String getLaureatoUniversitario() {
        return LaureatoUniversitario;
    }

    public void setLaureatoUniversitario(String laureatoUniversitario) {
        LaureatoUniversitario = laureatoUniversitario;
    }

    public String getScuolaAltro() {
        return ScuolaAltro;
    }

    public void setScuolaAltro(String scuolaAltro) {
        ScuolaAltro = scuolaAltro;
    }

    public boolean getHandicap() {
        return Handicap;
    }

    public void setHandicap(boolean handicap) {
        Handicap = handicap;
    }

    public void setDottoratoDiRicerca(String dottoratoDiRicerca) {
        DottoratoDiRicerca = dottoratoDiRicerca;
    }

    public void setLuogoDiResidenza(String luogoDiResidenza) {
        LuogoDiResidenza = luogoDiResidenza;
    }

    public String getDottoratoDiRicerca() {
        return DottoratoDiRicerca;
    }

    public String getLuogoDiResidenza() {
        return LuogoDiResidenza;
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

    @Override
    public String toString() {
        return "Tirocinante{" +
                "IDTirocinante=" + IDTirocinante +
                ", nome='" + nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", LuogoDiNascita='" + LuogoDiNascita + '\'' +
                ", LuogoDiResidenza='" + LuogoDiResidenza + '\'' +
                ", ProvinciaDiNascita='" + ProvinciaDiNascita + '\'' +
                ", DataDiNascita=" + DataDiNascita +
                ", ProvinciaDiResidenza='" + ProvinciaDiResidenza + '\'' +
                ", CodiceFiscale='" + CodiceFiscale + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", CorsoDiLaurea='" + CorsoDiLaurea + '\'' +
                ", DiplomaUniversitario='" + DiplomaUniversitario + '\'' +
                ", LaureatoUniversitario='" + LaureatoUniversitario + '\'' +
                ", ScuolaAltro='" + ScuolaAltro + '\'' +
                ", DottoratoDiRicerca='" + DottoratoDiRicerca + '\'' +
                ", Handicap=" + Handicap +
                ", User=" + User +
                ", CreateDate=" + CreateDate +
                ", UpdateDate=" + UpdateDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tirocinante that = (Tirocinante) o;
        return Objects.equals(IDTirocinante, that.IDTirocinante) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(Cognome, that.Cognome) &&
                Objects.equals(LuogoDiNascita, that.LuogoDiNascita) &&
                Objects.equals(LuogoDiResidenza, that.LuogoDiResidenza) &&
                Objects.equals(ProvinciaDiNascita, that.ProvinciaDiNascita) &&
                Objects.equals(DataDiNascita, that.DataDiNascita) &&
                Objects.equals(ProvinciaDiResidenza, that.ProvinciaDiResidenza) &&
                Objects.equals(CodiceFiscale, that.CodiceFiscale) &&
                Objects.equals(Telefono, that.Telefono) &&
                Objects.equals(CorsoDiLaurea, that.CorsoDiLaurea) &&
                Objects.equals(DiplomaUniversitario, that.DiplomaUniversitario) &&
                Objects.equals(LaureatoUniversitario, that.LaureatoUniversitario) &&
                Objects.equals(ScuolaAltro, that.ScuolaAltro) &&
                Objects.equals(DottoratoDiRicerca, that.DottoratoDiRicerca) &&
                Objects.equals(Handicap, that.Handicap) &&
                Objects.equals(User, that.User) &&
                Objects.equals(CreateDate, that.CreateDate) &&
                Objects.equals(UpdateDate, that.UpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDTirocinante, nome, Cognome, LuogoDiNascita, LuogoDiResidenza, ProvinciaDiNascita, DataDiNascita, ProvinciaDiResidenza, CodiceFiscale, Telefono, CorsoDiLaurea, DiplomaUniversitario, LaureatoUniversitario, ScuolaAltro, DottoratoDiRicerca, Handicap, User, CreateDate, UpdateDate);
    }
}