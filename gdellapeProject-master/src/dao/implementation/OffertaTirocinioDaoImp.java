package dao.implementation;

import com.sun.deploy.net.DownloadException;
import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.Azienda;
import model.OffertaTirocinio;
import model.TutoreUniversitario;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class OffertaTirocinioDaoImp extends DaoDataMySQLImpl {
    private PreparedStatement selectOffertatrByID;
    private PreparedStatement insertOffertatr;
    private PreparedStatement selectAllOfferteditr;//le metto gia in ordine dal più nuovo al vecchio
    private PreparedStatement selectOffertetrByAzienda;
    private PreparedStatement selectLastFiveOfferte;


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectOffertatrByID = connection.prepareStatement("SELECT * FROM offertatirocinio WHERE IDOffertaTirocinio = ?");

            this.selectAllOfferteditr = connection.prepareStatement("SELECT * FROM offertatirocinio ORDER BY UpdateDate ASC ");

            this.selectOffertetrByAzienda = connection.prepareStatement("SELECT * FROM offertatirocinio WHERE  Azienda = ? ORDER BY UpdateDate ASC ");

            this.selectLastFiveOfferte = connection.prepareStatement("SELECT * FROM `offertatirocinio` ORDER BY UpdateDate ASC LIMIT 5");

            this.insertOffertatr = connection.prepareStatement("INSERT INTO offertatirocinio(LuogoEffettuazione,Titolo,DescrizioneBreve,Descrizione,Orari," +
                    "DurataOre,DurataMesi,PeriodoInizio,PeriodoFine,Modalita,Obbiettivi,Rimborsi,Facilitazioni,AziendaOspitante,CodIdentTirocinio,SettoreInserimento,TempoAccessoLocaliAziendali,NomeTutoreAziendale," +
                    "CognomeTutoreAziendale,TelefonoTutoreAziendale,EmailTutoreAziendale" +
                    "Azienda,TutoreUniversitario  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    public OffertaTirocinio getOffertatrByID(int ID) throws DaoException {
        try {
            OffertaTirocinio oftr = new OffertaTirocinio();
            this.init();
            selectOffertatrByID.setInt(1, ID);
            ResultSet resultSet = selectOffertatrByID.executeQuery();
            if (resultSet.next()) {
                oftr.setIDOffertaTirocinio(resultSet.getInt("IDOffertaTirocinio"));
                oftr.setLuogoEffettuazione(resultSet.getString("LuogoEffettuazione"));
                oftr.setTitolo(resultSet.getString("Titolo"));
                oftr.setDescrizioneBreve(resultSet.getString("DescrizioneBreve"));
                oftr.setDescrizione(resultSet.getString("Descrizione"));
                oftr.setOrario(resultSet.getString("Orari"));
                oftr.setDurataOra(resultSet.getInt("DurataOre"));
                oftr.setDurataMesi(resultSet.getInt("DurataMesi"));
                oftr.setPeriodoInizio(resultSet.getDate("PeriodoInizio"));
                oftr.setPeriodoFine(resultSet.getDate("PeriodoFine"));
                oftr.setModalita(resultSet.getString("Modalita"));
                oftr.setObbiettivi(resultSet.getString("Obbiettivi"));
                oftr.setRimborsi(resultSet.getString("Rimborsi"));
                oftr.setFacilitazioni(resultSet.getString("Facilitazioni"));
                oftr.setAziendaOspitante(resultSet.getString("AziendaOspitante"));
                oftr.setCodiceTirocinio(resultSet.getInt("CodIdentTirocinio"));
                oftr.setSettoreInserimento(resultSet.getString("SettoreInserimento"));
                oftr.setTempoAccessoLocaliAziendali(resultSet.getString("TempoAccessoLocaliAziendali"));
                oftr.setNomeTutoreAziendale(resultSet.getString("NomeTutoreAziendale"));
                oftr.setCognomeTutoreAziendale(resultSet.getString("CognomeTutoreAziendale"));
                oftr.setTelefonoTutoreAzindale(resultSet.getString("TelefonoTutoreAziendale"));
                oftr.setEmailTutoreAziendale(resultSet.getString("EmailTutoreAziendale"));
                oftr.setAzienda(resultSet.getInt("Azienda"));
                oftr.setTutoreUniversitario(resultSet.getInt("TutoreUniversitario"));
                oftr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));

            }
            return oftr;


        } catch (SQLException e) {
            throw new DaoException("Errore query inserimento dati", e);
        }
    }

    public List<OffertaTirocinio> getOffertatrBYAzienda(Azienda az) throws DaoException {
        List<OffertaTirocinio> Offerte = new ArrayList<OffertaTirocinio>();
        OffertaTirocinio oftr = new OffertaTirocinio();
        try {
            this.init();
            selectOffertetrByAzienda.setInt(1, az.getIDAzienda());
            ResultSet resultSet = selectOffertetrByAzienda.executeQuery();
            while (resultSet.next()) {
                oftr.setIDOffertaTirocinio(resultSet.getInt("IDOffertaTirocinio"));
                oftr.setLuogoEffettuazione(resultSet.getString("LuogoEffettuazione"));
                oftr.setTitolo(resultSet.getString("Titolo"));
                oftr.setDescrizioneBreve(resultSet.getString("DescrizioneBreve"));
                oftr.setDescrizione(resultSet.getString("Descrizione"));
                oftr.setOrario(resultSet.getString("Orari"));
                oftr.setDurataOra(resultSet.getInt("DurataOre"));
                oftr.setDurataMesi(resultSet.getInt("DurataMesi"));
                oftr.setPeriodoInizio(resultSet.getDate("PeriodoInizio"));
                oftr.setPeriodoFine(resultSet.getDate("PeriodoFine"));
                oftr.setModalita(resultSet.getString("Modalita"));
                oftr.setObbiettivi(resultSet.getString("Obbiettivi"));
                oftr.setRimborsi(resultSet.getString("Rimborsi"));
                oftr.setFacilitazioni(resultSet.getString("Facilitazioni"));
                oftr.setAziendaOspitante(resultSet.getString("AziendaOspitante"));
                oftr.setCodiceTirocinio(resultSet.getInt("CodIdentTirocinio"));
                oftr.setSettoreInserimento(resultSet.getString("SettoreInserimento"));
                oftr.setTempoAccessoLocaliAziendali(resultSet.getString("TempoAccessoLocaliAziendali"));
                oftr.setNomeTutoreAziendale(resultSet.getString("NomeTutoreAziendale"));
                oftr.setCognomeTutoreAziendale(resultSet.getString("CognomeTutoreAziendale"));
                oftr.setTelefonoTutoreAzindale(resultSet.getString("TelefonoTutoreAziendale"));
                oftr.setEmailTutoreAziendale(resultSet.getString("EmailTutoreAziendale"));
                oftr.setAzienda(resultSet.getInt("Azienda"));
                oftr.setTutoreUniversitario(resultSet.getInt("TutoreUniversitario"));
                oftr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));

                Offerte.add(oftr);
            }
            return Offerte;


        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
    }

    public List<OffertaTirocinio> getAllOffertatr() throws DaoException {
        List<OffertaTirocinio> Offerte = new ArrayList<OffertaTirocinio>();
        OffertaTirocinio oftr = new OffertaTirocinio();
        try {
            this.init();
            ResultSet resultSet = selectAllOfferteditr.executeQuery();
            while (resultSet.next()) {
                oftr.setIDOffertaTirocinio(resultSet.getInt("IDOffertaTirocinio"));
                oftr.setLuogoEffettuazione(resultSet.getString("LuogoEffettuazione"));
                oftr.setTitolo(resultSet.getString("Titolo"));
                oftr.setDescrizioneBreve(resultSet.getString("DescrizioneBreve"));
                oftr.setDescrizione(resultSet.getString("Descrizione"));
                oftr.setOrario(resultSet.getString("Orari"));
                oftr.setDurataOra(resultSet.getInt("DurataOre"));
                oftr.setDurataMesi(resultSet.getInt("DurataMesi"));
                oftr.setPeriodoInizio(resultSet.getDate("PeriodoInizio"));
                oftr.setPeriodoFine(resultSet.getDate("PeriodoFine"));
                oftr.setModalita(resultSet.getString("Modalita"));
                oftr.setObbiettivi(resultSet.getString("Obbiettivi"));
                oftr.setRimborsi(resultSet.getString("Rimborsi"));
                oftr.setFacilitazioni(resultSet.getString("Facilitazioni"));
                oftr.setAziendaOspitante(resultSet.getString("AziendaOspitante"));
                oftr.setCodiceTirocinio(resultSet.getInt("CodIdentTirocinio"));
                oftr.setSettoreInserimento(resultSet.getString("SettoreInserimento"));
                oftr.setTempoAccessoLocaliAziendali(resultSet.getString("TempoAccessoLocaliAziendali"));
                oftr.setNomeTutoreAziendale(resultSet.getString("NomeTutoreAziendale"));
                oftr.setCognomeTutoreAziendale(resultSet.getString("CognomeTutoreAziendale"));
                oftr.setTelefonoTutoreAzindale(resultSet.getString("TelefonoTutoreAziendale"));
                oftr.setEmailTutoreAziendale(resultSet.getString("EmailTutoreAziendale"));
                oftr.setAzienda(resultSet.getInt("Azienda"));
                oftr.setTutoreUniversitario(resultSet.getInt("TutoreUniversitario"));
                oftr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
                Offerte.add(oftr);
            }
            return Offerte;


        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
    }

    public List<OffertaTirocinio> getLastFiveOfferte() throws DaoException{
        List<OffertaTirocinio> Offerte = new ArrayList<OffertaTirocinio>();
        OffertaTirocinio offerte = new OffertaTirocinio();
        try {
            this.init();
            ResultSet resultSet = selectLastFiveOfferte.executeQuery();
            while (resultSet.next()){
                offerte.setIDOffertaTirocinio(resultSet.getInt("IDOffertaTirocinio"));
                offerte.setLuogoEffettuazione(resultSet.getString("LuogoEffettuazione"));
                offerte.setTitolo(resultSet.getString("Titolo"));
                offerte.setDescrizioneBreve(resultSet.getString("DescrizioneBreve"));
                offerte.setDescrizione(resultSet.getString("Descrizione"));
                offerte.setOrario(resultSet.getString("Orari"));
                offerte.setDurataOra(resultSet.getInt("DurataOre"));
                offerte.setDurataMesi(resultSet.getInt("DurataMesi"));
                offerte.setPeriodoInizio(resultSet.getDate("PeriodoInizio"));
                offerte.setPeriodoFine(resultSet.getDate("PeriodoFine"));
                offerte.setModalita(resultSet.getString("Modalita"));
                offerte.setObbiettivi(resultSet.getString("Obbiettivi"));
                offerte.setRimborsi(resultSet.getString("Rimborsi"));
                offerte.setFacilitazioni(resultSet.getString("Facilitazioni"));
                offerte.setAziendaOspitante(resultSet.getString("AziendaOspitante"));
                offerte.setCodiceTirocinio(resultSet.getInt("CodIdentTirocinio"));
                offerte.setSettoreInserimento(resultSet.getString("SettoreInserimento"));
                offerte.setTempoAccessoLocaliAziendali(resultSet.getString("TempoAccessoLocaliAziendali"));
                offerte.setNomeTutoreAziendale(resultSet.getString("NomeTutoreAziendale"));
                offerte.setCognomeTutoreAziendale(resultSet.getString("CognomeTutoreAziendale"));
                offerte.setTelefonoTutoreAzindale(resultSet.getString("TelefonoTutoreAziendale"));
                offerte.setEmailTutoreAziendale(resultSet.getString("EmailTutoreAziendale"));
                offerte.setAzienda(resultSet.getInt("Azienda"));
                offerte.setTutoreUniversitario(resultSet.getInt("TutoreUniversitario"));
                offerte.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
                Offerte.add(offerte);
            }
            return Offerte;
        }catch (SQLException e){
            throw new DaoException("Errore query", e);
        }
    }

    public void setOffertatr(OffertaTirocinio tr) throws DaoException {
        try {
            this.init();
            insertOffertatr.setString(1, tr.getLuogoEffettuazione());
            insertOffertatr.setString(2, tr.getTitolo());
            insertOffertatr.setString(3, tr.getDescrizioneBreve());
            insertOffertatr.setString(4, tr.getDescrizione());
            insertOffertatr.setString(5, tr.getOrario());
            insertOffertatr.setInt(6, tr.getDurataOra());
            insertOffertatr.setInt(7, tr.getDurataMesi());
            insertOffertatr.setDate(8, tr.getPeriodoInizio());
            insertOffertatr.setDate(9, tr.getPeriodoFine());
            insertOffertatr.setString(10, tr.getModalita());
            insertOffertatr.setString(11, tr.getObbiettivi());
            insertOffertatr.setString(12, tr.getRimborsi());
            insertOffertatr.setString(13, tr.getFacilitazioni());
            insertOffertatr.setString(14, tr.getAziendaOspitante());
            insertOffertatr.setInt(15, tr.getCodiceTirocinio());
            insertOffertatr.setString(16, tr.getSettoreInserimento());
            insertOffertatr.setString(17, tr.getTempoAccessoLocaliAziendali());
            insertOffertatr.setString(18, tr.getNomeTutoreAziendale());
            insertOffertatr.setString(19, tr.getCognomeTutoreAziendale());
            insertOffertatr.setString(20, tr.getTelefonoTutoreAzindale());
            insertOffertatr.setString(21, tr.getEmailTutoreAziendale());
            insertOffertatr.setInt(22, tr.getAzienda());
            insertOffertatr.setInt(23, tr.getTutoreUniversitario());
            insertOffertatr.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Errore inserimento", e);
        }

    }


    public void destroy() throws DaoException {

        try {

            this.selectOffertetrByAzienda.close();
            this.selectOffertatrByID.close();
            this.selectAllOfferteditr.close();
            this.insertOffertatr.close();


            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy in Offerta tr", ex);


        }

    }
}
