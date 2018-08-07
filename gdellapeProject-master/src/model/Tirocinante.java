package model;

import java.util.Date;

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
}
