package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.Azienda;
import model.OffertaTirocinio;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OffertaTirocinioDaoImp extends DaoDataMySQLImpl {
    private PreparedStatement selectOffertatrByID;
    private PreparedStatement insertOffertatr;
    private PreparedStatement selectAllOfferteditr;//le metto gia in ordine dal più nuovo al vecchio
    private PreparedStatement selectOffertetrByAzienda;
    private PreparedStatement selectLastFiveOfferte;
    private PreparedStatement updateOffertatr;


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectOffertatrByID = connection.prepareStatement("SELECT * FROM offertatirocinio WHERE IDOffertaTirocinio = ?");

            this.selectAllOfferteditr = connection.prepareStatement("SELECT * FROM offertatirocinio ORDER BY UpdateDate ASC ");

            this.selectOffertetrByAzienda = connection.prepareStatement("SELECT * FROM offertatirocinio WHERE  Azienda = ? ORDER BY UpdateDate ASC ");

            this.selectLastFiveOfferte = connection.prepareStatement("SELECT * FROM offertatirocinio WHERE Stato = 1 ORDER BY UpdateDate ASC LIMIT 5");

            this.insertOffertatr = connection.prepareStatement("INSERT INTO offertatirocinio(LuogoEffettuazione," +
                    "Titolo,DescrizioneBreve,Descrizione,Orari,DurataOre,DurataMesi,PeriodoInizio,PeriodoFine,Stato," +
                    "Modalita,Obbiettivi,Rimborsi,Facilitazioni,AziendaOspitante,CodIdentTirocinio,SettoreInserimento," +
                    "TempoAccessoLocaliAziendali,NomeTutoreAziendale,CognomeTutoreAziendale,TelefonoTutoreAziendale," +
                    "EmailTutoreAziendale,Azienda, TutoreUniversitario  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            this.updateOffertatr = connection.prepareStatement("UPDATE offertatirocinio SET LuogoEffettuazione = ?," +
                    "Titolo= ?,DescrizioneBreve= ?,Descrizione= ?,Orari = ?, DurataOre = ?, DurataMesi = ?, " +
                    "PeriodoInizio = ?, PeriodoFine = ?, Stato = ?, Modalita = ?, Obbiettivi = ?, Rimborsi = ?, " +
                    "Facilitazioni = ?, AziendaOspitante = ?, CodIdentTirocinio = ?, SettoreInserimento = ?, " +
                    "TempoAccessoLocaliAziendali = ?, NomeTutoreAziendale = ?, CognomeTutoreAziendale = ?, " +
                    "TelefonoTutoreAziendale = ?, EmailTutoreAziendale = ? WHERE IDOffertaTirocinio = ?");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    private void setOffertaTirocinioObject( OffertaTirocinio offertaTirocinio, ResultSet resultSet) throws DaoException {
        try{
            offertaTirocinio.setIDOffertaTirocinio(resultSet.getInt("IDOffertaTirocinio"));
            offertaTirocinio.setLuogoEffettuazione(resultSet.getString("LuogoEffettuazione"));
            offertaTirocinio.setTitolo(resultSet.getString("Titolo"));
            offertaTirocinio.setDescrizioneBreve(resultSet.getString("DescrizioneBreve"));
            offertaTirocinio.setDescrizione(resultSet.getString("Descrizione"));
            offertaTirocinio.setOrari(resultSet.getString("Orari"));
            offertaTirocinio.setDurataOre(resultSet.getInt("DurataOre"));
            offertaTirocinio.setDurataMesi(resultSet.getInt("DurataMesi"));
            offertaTirocinio.setPeriodoInizio(resultSet.getDate("PeriodoInizio"));
            offertaTirocinio.setPeriodoFine(resultSet.getDate("PeriodoFine"));
            offertaTirocinio.setStato(resultSet.getInt("Stato"));
            offertaTirocinio.setModalita(resultSet.getString("Modalita"));
            offertaTirocinio.setObbiettivi(resultSet.getString("Obbiettivi"));
            offertaTirocinio.setRimborsi(resultSet.getString("Rimborsi"));
            offertaTirocinio.setFacilitazioni(resultSet.getString("Facilitazioni"));
            offertaTirocinio.setAziendaOspitante(resultSet.getString("AziendaOspitante"));
            offertaTirocinio.setCodIdentTirocinio(resultSet.getString("CodIdentTirocinio"));
            offertaTirocinio.setSettoreInserimento(resultSet.getString("SettoreInserimento"));
            offertaTirocinio.setTempoAccessoLocaliAziendali(resultSet.getString("TempoAccessoLocaliAziendali"));
            offertaTirocinio.setNomeTutoreAziendale(resultSet.getString("NomeTutoreAziendale"));
            offertaTirocinio.setCognomeTutoreAziendale(resultSet.getString("CognomeTutoreAziendale"));
            offertaTirocinio.setTelefonoTutoreAziendale(resultSet.getString("TelefonoTutoreAziendale"));
            offertaTirocinio.setEmailTutoreAziendale(resultSet.getString("EmailTutoreAziendale"));
            offertaTirocinio.setCreateDate(resultSet.getTimestamp("CreateDate"));
            offertaTirocinio.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
            offertaTirocinio.setAzienda(resultSet.getInt("Azienda"));
            offertaTirocinio.setTutoreUniversitario(resultSet.getInt("TutoreUniversitario"));
        } catch (SQLException e){
            e.printStackTrace();
            throw new DaoException("Errore nel creare oggetto OffertaTirocinio", e);
        }
    }

    private void setListOffertaTirocinio(List<OffertaTirocinio> offertaTirocinios, ResultSet resultSet) throws DaoException {
        try {
            while (resultSet.next()) {
                OffertaTirocinio offertaTirocinio = new OffertaTirocinio();
                setOffertaTirocinioObject(offertaTirocinio, resultSet);
                offertaTirocinios.add(offertaTirocinio);
            }
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare Lista oggetti OffertaTirocinio", e);
        }
    }

    public OffertaTirocinio getOffertatrByID(int ID) throws DaoException {
        try {
            OffertaTirocinio oftr = new OffertaTirocinio();
            this.init();
            selectOffertatrByID.setInt(1, ID);
            ResultSet resultSet = selectOffertatrByID.executeQuery();
            if (resultSet.next()) {
                setOffertaTirocinioObject(oftr, resultSet);
            } else {
                throw new DaoException("Query con risultato vuoto");
            }
            return oftr;


        } catch (SQLException e) {
            throw new DaoException("Errore query inserimento dati", e);
        }
    }

    public List<OffertaTirocinio> getOffertatrBYAzienda(Azienda az) throws DaoException {
        List<OffertaTirocinio> Offerte = new ArrayList<OffertaTirocinio>();
        try {
            this.init();
            selectOffertetrByAzienda.setInt(1, az.getIDAzienda());
            ResultSet resultSet = selectOffertetrByAzienda.executeQuery();
            setListOffertaTirocinio(Offerte, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return Offerte;
    }

    public List<OffertaTirocinio> getAllOffertatr() throws DaoException {
        List<OffertaTirocinio> Offerte = new ArrayList<OffertaTirocinio>();
        try {
            this.init();
            ResultSet resultSet = selectAllOfferteditr.executeQuery();
            setListOffertaTirocinio(Offerte, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query getAllOffertatr", e);
        }
        return Offerte;
    }

    public List<OffertaTirocinio> getLastFiveOfferte() throws DaoException {
        List<OffertaTirocinio> offerte = new ArrayList<OffertaTirocinio>();
        try {
            this.init();
            ResultSet resultSet = selectLastFiveOfferte.executeQuery();
            setListOffertaTirocinio(offerte, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query getLastFiveOfferte", e);
        }
        return offerte;
    }

    public void setOffertatr(OffertaTirocinio tr) throws DaoException {
        /*
        "INSERT INTO offertatirocinio(LuogoEffettuazione," +
                    "Titolo,DescrizioneBreve,Descrizione,Orari,DurataOre,DurataMesi,PeriodoInizio,PeriodoFine,Stato" +
                    "Modalita,Obbiettivi,Rimborsi,Facilitazioni,AziendaOspitante,CodIdentTirocinio,SettoreInserimento," +
                    "TempoAccessoLocaliAziendali,NomeTutoreAziendale,CognomeTutoreAziendale,TelefonoTutoreAziendale," +
                    "EmailTutoreAziendale,Azienda, TutoreUniversitario  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
         */
        try {
            this.init();
            insertOffertatr.setString(1, tr.getLuogoEffettuazione());
            insertOffertatr.setString(2, tr.getTitolo());
            insertOffertatr.setString(3, tr.getDescrizioneBreve());
            insertOffertatr.setString(4, tr.getDescrizione());
            insertOffertatr.setString(5, tr.getOrari());
            insertOffertatr.setInt(6, tr.getDurataOre());
            insertOffertatr.setInt(7, tr.getDurataMesi());
            insertOffertatr.setDate(8, tr.getPeriodoInizio());
            insertOffertatr.setDate(9, tr.getPeriodoFine());
            insertOffertatr.setInt(10, tr.getStato());
            insertOffertatr.setString(11, tr.getModalita());
            insertOffertatr.setString(12, tr.getObbiettivi());
            insertOffertatr.setString(13, tr.getRimborsi());
            insertOffertatr.setString(14, tr.getFacilitazioni());
            insertOffertatr.setString(15, tr.getAziendaOspitante());
            insertOffertatr.setString(16, tr.getCodIdentTirocinio());
            insertOffertatr.setString(17, tr.getSettoreInserimento());
            insertOffertatr.setString(18, tr.getTempoAccessoLocaliAziendali());
            insertOffertatr.setString(19, tr.getNomeTutoreAziendale());
            insertOffertatr.setString(20, tr.getCognomeTutoreAziendale());
            insertOffertatr.setString(21, tr.getTelefonoTutoreAziendale());
            insertOffertatr.setString(22, tr.getEmailTutoreAziendale());
            insertOffertatr.setInt(23, tr.getAzienda());
            insertOffertatr.setInt(24, tr.getTutoreUniversitario());
            insertOffertatr.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Errore inserimento", e);
        }

    }

    public void updateOffertatr(OffertaTirocinio tr) throws DaoException {
    /**
    * UPDATE offertatirocinio SET LuogoEffettuazione = ?," +
    *                     "Titolo= ?,DescrizioneBreve= ?,Descrizione= ?,Orari = ?, DurataOre = ?, DurataMesi = ?, " +
    *                     "PeriodoInizio = ?, PeriodoFine = ?, Stato = ?, Modalita = ?, Obbiettivi = ?, Rimborsi = ?, " +
    *                     "Facilitazioni = ?, AziendaOspitante = ?, CodIdentTirocinio = ?, SettoreInserimento = ?, " +
    *                     "TempoAccessoLocaliAziendali = ?, NomeTutoreAziendale = ?, CognomeTutoreAziendale = ?, " +
    *                     "TelefonoTutoreAziendale = ?, EmailTutoreAziendale = ? WHERE IDOffertaTirocinio = ?
    */
        try{
            this.init();
            this.updateOffertatr.setString(1, tr.getLuogoEffettuazione());
            this.updateOffertatr.setString(2, tr.getTitolo());
            this.updateOffertatr.setString(3, tr.getDescrizioneBreve());
            this.updateOffertatr.setString(4, tr.getDescrizione());
            this.updateOffertatr.setString(5, tr.getOrari());
            this.updateOffertatr.setInt(6, tr.getDurataOre());
            this.updateOffertatr.setInt(7, tr.getDurataMesi());
            this.updateOffertatr.setDate(8, tr.getPeriodoInizio());
            this.updateOffertatr.setDate(9, tr.getPeriodoFine());
            this.updateOffertatr.setInt(10, tr.getStato());
            this.updateOffertatr.setString(11, tr.getModalita());
            this.updateOffertatr.setString(12, tr.getObbiettivi());
            this.updateOffertatr.setString(13, tr.getRimborsi());
            this.updateOffertatr.setString(14, tr.getFacilitazioni());
            this.updateOffertatr.setString(15, tr.getAziendaOspitante());
            this.updateOffertatr.setString(16, tr.getCodIdentTirocinio());
            this.updateOffertatr.setString(17, tr.getSettoreInserimento());
            this.updateOffertatr.setString(18, tr.getTempoAccessoLocaliAziendali());
            this.updateOffertatr.setString(19, tr.getNomeTutoreAziendale());
            this.updateOffertatr.setString(20, tr.getCognomeTutoreAziendale());
            this.updateOffertatr.setString(21, tr.getTelefonoTutoreAziendale());
            this.updateOffertatr.setString(22, tr.getEmailTutoreAziendale());
            this.updateOffertatr.setInt(23, tr.getIDOffertaTirocinio());
            this.updateOffertatr.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore esecuzione update", e);
        }
    }

    public void destroy() throws DaoException {
        try {
            this.selectOffertetrByAzienda.close();
            this.selectOffertatrByID.close();
            this.selectAllOfferteditr.close();
            this.insertOffertatr.close();
            this.selectLastFiveOfferte.close();
            this.updateOffertatr.close();
            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Error destroy in Offerta tr", ex);
        }

    }
}
