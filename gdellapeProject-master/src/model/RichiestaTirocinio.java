package model;

import java.sql.Timestamp;

public class RichiestaTirocinio {
    private Integer IDricTironinio;
    private Integer DurataOre;
    private Integer CFU;
    private Boolean Active;
    private Integer OffertaTirocinio;
    private Integer Tirocinante;
    private Timestamp CreateDate;
    private Timestamp UpdateDate;

    public RichiestaTirocinio() {
        this.IDricTironinio = 0;
        DurataOre = 0;
        this.CFU = 0;
        Active = false;
        OffertaTirocinio = 0;
        Tirocinante = 0;
        CreateDate = null;
        UpdateDate = null;
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


    public void setActive(Boolean active) {
        Active = active;
    }

    public Boolean getActive() {
        return Active;
    }


    public Integer getIDricTironinio() {
        return IDricTironinio;
    }

    public void setIDricTironinio(Integer IDricTironinio) {
        this.IDricTironinio = IDricTironinio;
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
}
