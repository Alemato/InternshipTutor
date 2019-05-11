package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import dao.interfaces.TirocinioDaoInterface;
import model.OffertaTirocinio;
import model.Tirocinante;
import model.Tirocinio;
import model.TutoreUniversitario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TirocinioDaoImp extends DaoDataMySQLImpl implements TirocinioDaoInterface {
    private PreparedStatement selectRichiestatrByID;
    private PreparedStatement selectAllRichiestatr;
    private PreparedStatement insertRichiestatr;
    private PreparedStatement insertFisrtRichiesta;
    private PreparedStatement selectTrByStatoAndOfferta;
    private PreparedStatement selectAllTrByOfferta;
    private PreparedStatement ifinsertTirocinio;
    private PreparedStatement selectAllTirocinioByStato;
    private PreparedStatement selectOffertaTirByIDTirocinante;
    private PreparedStatement updateTirocinio;
    private PreparedStatement selectAllTrByTutore;


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectRichiestatrByID = connection.prepareStatement("SELECT * FROM  tirocinio WHERE IDTirocinio = ?");

            this.selectAllRichiestatr = connection.prepareStatement("SELECT * FROM tirocinio ORDER BY UpdateDate ASC ");

            // TODO controllare utilità e funzionalità
            this.insertFisrtRichiesta = connection.prepareStatement("INSERT INTO tirocinio(OffertaTirocinio,Tirocinante) VALUES (?,?)");

            this.insertRichiestatr = connection.prepareStatement("INSERT INTO tirocinio(DataConsegnaModuloRichiesta," +
                    "DurataOre,CFU,Stato,PeriodoEffettivoIniziale,PeriodoEffettivoFinale,RisultatoConseguito," +
                    "DescrizioneAttivitaSvolta,PdfTirocinante,PdfAzienda,DataConsegnaModuloAzienda,PdfSegreteria," +
                    "DataConsegnaModuloSegreteria,DataColloquioSegreteria, EsitoTirocinio,CreditiRiconosciuti," +
                    "OffertaTirocinio,Tirocinante,TutoreUniversitario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            this.selectTrByStatoAndOfferta = connection.prepareStatement("SELECT * FROM tirocinio WHERE Stato = ? AND OffertaTirocinio = ? ");

            this.selectAllTrByOfferta = connection.prepareStatement("SELECT * FROM tirocinio WHERE OffertaTirocinio = ?");

            this.selectAllTrByTutore = connection.prepareStatement("SELECT * FROM tirocinio WHERE TutoreUniversitario = ?");

            this.ifinsertTirocinio = connection.prepareStatement("SELECT * FROM tirocinio WHERE tirocinante = ? AND Stato < 3");

            this.selectAllTirocinioByStato = connection.prepareStatement("SELECT * FROM tirocinio WHERE Stato = ?");

            this.selectOffertaTirByIDTirocinante = connection.prepareStatement("SELECT * FROM tirocinio WHERE Tirocinante = ?");

            this.updateTirocinio = connection.prepareStatement("UPDATE tirocinio SET DataConsegnaModuloRichiesta = ?," +
                    " DurataOre = ?, CFU = ?, Stato = ?, PeriodoEffettivoIniziale = ?, PeriodoEffettivoFinale = ?," +
                    " RisultatoConseguito = ?, DescrizioneAttivitaSvolta = ?, PdfTirocinante = ?, PdfAzienda = ?," +
                    " DataConsegnaModuloAzienda = ?, PdfSegreteria = ?, DataConsegnaModuloSegreteria = ?," +
                    " DataColloquioSegreteria = ?, EsitoTirocinio = ?, CreditiRiconosciuti = ?, CreateDate = ?," +
                    " UpdateDate = ?, OffertaTirocinio = ?, Tirocinante = ?, TutoreUniversitario = ? WHERE  IDTirocinio = ?");
        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    private void setTirocinioObject(Tirocinio tirocinio, ResultSet resultSet) throws DaoException {
        try {
            tirocinio.setIDTirocinio(resultSet.getInt("IDTirocinio"));
            tirocinio.setDataConsegnaModuloRichiesta(resultSet.getDate("DataConsegnaModuloRichiesta"));
            tirocinio.setDurataOre(resultSet.getInt("DurataOre"));
            tirocinio.setCFU(resultSet.getInt("CFU"));
            tirocinio.setStato(resultSet.getInt("Stato"));
            tirocinio.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
            tirocinio.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
            tirocinio.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
            tirocinio.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
            tirocinio.setPdfTirocinante(resultSet.getString("PdfTirocinante"));
            tirocinio.setPdfAzienda(resultSet.getString("PdfAzienda"));
            tirocinio.setDataConsegnaModuloAzienda(resultSet.getDate("DataConsegnaModuloAzienda"));
            tirocinio.setPdfSegreteria(resultSet.getString("PdfSegreteria"));
            tirocinio.setDataConsegnaModuloSegreteria(resultSet.getDate("DataConsegnaModuloSegreteria"));
            tirocinio.setDataColloquioSegreteria(resultSet.getDate("DataColloquioSegreteria"));
            tirocinio.setEsitoTirocinio(resultSet.getString("EsitoTirocinio"));
            tirocinio.setCreditiRiconosciuti(resultSet.getInt("CreditiRiconosciuti"));
            tirocinio.setCreateDate(resultSet.getTimestamp("CreateDate"));
            tirocinio.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
            tirocinio.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
            tirocinio.setTirocinante(resultSet.getInt("Tirocinante"));
            tirocinio.setTutoreUniversitario(resultSet.getInt("TutoreUniversitario"));
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare oggetto Tirocinio", e);
        }
    }

    private void setListTirocinio(List<Tirocinio> tirocinios, ResultSet resultSet) throws DaoException {
        try {
            while (resultSet.next()) {
                Tirocinio tirocinio = new Tirocinio();
                setTirocinioObject(tirocinio, resultSet);
                tirocinios.add(tirocinio);
            }
        } catch (SQLException e) {
            throw new DaoException("Errore nel creare Lista oggetti Tirocinio", e);
        }
    }

    @Override
    public Tirocinio getRichiestatrByID(int ID) throws DaoException {
        try {
            this.init();
            Tirocinio tr = new Tirocinio();
            selectRichiestatrByID.setInt(1, ID);
            ResultSet resultSet = selectRichiestatrByID.executeQuery();
            if (resultSet.next()) {
                setTirocinioObject(tr, resultSet);
            } else {
                throw new DaoException("Query con risultato vuoto");
            }
            return tr;

        } catch (SQLException e) {
            throw new DaoException("Errore query dato", e);
        }
    }

    @Override
    public List<Tirocinio> gettrbyStatoandOfferta(OffertaTirocinio offerta, int stato) throws DaoException {
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            this.init();
            this.selectTrByStatoAndOfferta.setInt(1, stato);
            this.selectTrByStatoAndOfferta.setInt(2, offerta.getIDOffertaTirocinio());
            ResultSet resultSet = selectTrByStatoAndOfferta.executeQuery();
            setListTirocinio(listRT, resultSet);

        } catch (SQLException e) {
            throw new DaoException("Errore query lista stato e offerta", e);
        }
        return listRT;
    }

    @Override
    public List<Tirocinio> getTirociniByStato(Integer stato) throws DaoException {
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            this.init();
            this.selectAllTirocinioByStato.setInt(1, stato);
            ResultSet resultSet = selectAllTirocinioByStato.executeQuery();
            setListTirocinio(listRT, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return listRT;
    }

    @Override
    public List<Tirocinio> getAllTirocinioByTutore(TutoreUniversitario tutore) throws DaoException {
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            this.init();
            this.selectAllTrByTutore.setInt(1, tutore.getIDTutoreUni());
            ResultSet resultSet = selectAllTrByTutore.executeQuery();
            setListTirocinio(listRT, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return listRT;
    }
    @Override
    public List<Tirocinio> getAllTirocinio() throws DaoException {
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            this.init();
            ResultSet resultSet = selectAllRichiestatr.executeQuery();
            setListTirocinio(listRT, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query", e);
        }
        return listRT;
    }


    @Override
    public List<Tirocinio> getTrByOfferta(OffertaTirocinio offertaTirocinio) throws DaoException {
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            System.out.println("query inizio");
            this.init();
            this.selectAllTrByOfferta.setInt(1, offertaTirocinio.getIDOffertaTirocinio());
            ResultSet resultSet = selectAllTrByOfferta.executeQuery();
            setListTirocinio(listRT, resultSet);
            System.out.println("query fine");
            System.out.println(listRT);
        } catch (SQLException e) {
            throw new DaoException("Errore query lista tr by offerta tr", e);
        }
        return listRT;
    }


    @Override
    public boolean ifTirocinanteSendRichiesta(Tirocinante tr) throws DaoException {
        try {
            this.init();
            ifinsertTirocinio.setInt(1, tr.getIDTirocinante());
            ResultSet resultSet = ifinsertTirocinio.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException("Problema data base", e);
        }

    }


    @Override
    public List<Tirocinio> getOffertaTirByIDTirocinante(int IDTr) throws DaoException {
        List<Tirocinio> listIDOff = new ArrayList<>();
        try {
            this.init();
            this.selectOffertaTirByIDTirocinante.setInt(1, IDTr);
            ResultSet resultSet = selectOffertaTirByIDTirocinante.executeQuery();
            setListTirocinio(listIDOff, resultSet);
        } catch (SQLException e) {
            throw new DaoException("Errore query lista stato e offerta", e);
        }
        return listIDOff;
    }


    @Override
    public void setRichiestatr(Tirocinio tirocinio) throws DaoException {
//        INSERT INTO tirocinio(DataConsegnaModuloRichiesta,
//                DurataOre,CFU,Stato,PeriodoEffettivoIniziale,PeriodoEffettivoFinale,RisultatoConseguito,
//                DescrizioneAttivitaSvolta,PdfTirocinante,PdfAzienda,DataConsegnaModuloAzienda,PdfSegreteria,
//                DataConsegnaModuloSegreteria,DataColloquioSegreteria, EsitoTirocinio,CreditiRiconosciuti,
//                OffertaTirocinio,Tirocinante,TutoreUniversitario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
        try {
            this.init();
            insertRichiestatr.setDate(1, tirocinio.getDataConsegnaModuloRichiesta());
            insertRichiestatr.setInt(2, tirocinio.getDurataOre());
            insertRichiestatr.setInt(3, tirocinio.getCFU());
            insertRichiestatr.setInt(4, tirocinio.getStato());
            insertRichiestatr.setDate(5, tirocinio.getPeriodoEffettivoIniziale());
            insertRichiestatr.setDate(6, tirocinio.getPeriodoEffettivoFinale());
            insertRichiestatr.setString(7, tirocinio.getRisultatoConseguito());
            insertRichiestatr.setString(8, tirocinio.getDescrizioneAttivitaSvolta());
            insertRichiestatr.setString(9, tirocinio.getPdfTirocinante());
            insertRichiestatr.setString(10, tirocinio.getPdfAzienda());
            insertRichiestatr.setDate(11, tirocinio.getDataConsegnaModuloAzienda());
            insertRichiestatr.setString(12, tirocinio.getPdfSegreteria());
            insertRichiestatr.setDate(13, tirocinio.getDataConsegnaModuloSegreteria());
            insertRichiestatr.setDate(14, tirocinio.getDataColloquioSegreteria());
            insertRichiestatr.setString(15, tirocinio.getEsitoTirocinio());
            insertRichiestatr.setInt(16, tirocinio.getCreditiRiconosciuti());
            insertRichiestatr.setInt(17, tirocinio.getOffertaTirocinio());
            insertRichiestatr.setInt(18, tirocinio.getTirocinante());
            insertRichiestatr.setInt(19, tirocinio.getTutoreUniversitario());
            insertRichiestatr.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("Errore inserimento dato", e);

        }
    }

    @Override
    public void firstRichiestatr(Tirocinio tr) throws DaoException {
        try {
            this.init();

            insertFisrtRichiesta.setInt(1, tr.getOffertaTirocinio());
            insertFisrtRichiesta.setInt(2, tr.getTirocinante());
            insertFisrtRichiesta.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("Errore inserimento dato", e);

        }
    }

    @Override
    public void updateTirocinio(Tirocinio tirocinio) throws DaoException {
//        UPDATE tirocinio SET DataConsegnaModuloRichiesta = ?,
//                 DurataOre = ?, CFU = ?, Stato = ?, PeriodoEffettivoIniziale = ?, PeriodoEffettivoFinale = ?,
//                 RisultatoConseguito = ?, DescrizioneAttivitaSvolta = ?, PdfTirocinante = ?, PdfAzienda = ?,
//                 DataConsegnaModuloAzienda = ?, PdfSegreteria = ?, DataConsegnaModuloSegreteria = ?,
//                 DataColloquioSegreteria = ?, EsitoTirocinio = ?, CreditiRiconosciuti = ?, CreateDate = ?,
//                 UpdateDate = ?, OffertaTirocinio = ?, Tirocinante = ?, TutoreUniversitario = ? WHERE  IDTirocinio = ?
        try {
            this.init();
            this.updateTirocinio.setDate(1, tirocinio.getDataConsegnaModuloRichiesta());
            this.updateTirocinio.setInt(2, tirocinio.getDurataOre());
            this.updateTirocinio.setInt(3, tirocinio.getCFU());
            this.updateTirocinio.setInt(4, tirocinio.getStato());
            this.updateTirocinio.setDate(5, tirocinio.getPeriodoEffettivoIniziale());
            this.updateTirocinio.setDate(6, tirocinio.getPeriodoEffettivoFinale());
            this.updateTirocinio.setString(7, tirocinio.getRisultatoConseguito());
            this.updateTirocinio.setString(8, tirocinio.getDescrizioneAttivitaSvolta());
            this.updateTirocinio.setString(9, tirocinio.getPdfTirocinante());
            this.updateTirocinio.setString(10, tirocinio.getPdfAzienda());
            this.updateTirocinio.setDate(11, tirocinio.getDataConsegnaModuloAzienda());
            this.updateTirocinio.setString(12, tirocinio.getPdfSegreteria());
            this.updateTirocinio.setDate(13, tirocinio.getDataConsegnaModuloSegreteria());
            this.updateTirocinio.setDate(14, tirocinio.getDataColloquioSegreteria());
            this.updateTirocinio.setString(15, tirocinio.getEsitoTirocinio());
            this.updateTirocinio.setInt(16, tirocinio.getCreditiRiconosciuti());
            this.updateTirocinio.setTimestamp(17, tirocinio.getCreateDate());
            this.updateTirocinio.setTimestamp(18, tirocinio.getUpdateDate());
            this.updateTirocinio.setInt(19, tirocinio.getOffertaTirocinio());
            this.updateTirocinio.setInt(20, tirocinio.getTirocinante());
            this.updateTirocinio.setInt(21, tirocinio.getTutoreUniversitario());
            this.updateTirocinio.setInt(22, tirocinio.getIDTirocinio());
            this.updateTirocinio.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Errore esecuzione update", e);
        }

    }

    public void destroy() throws DaoException {

        try {
            this.selectRichiestatrByID.close();
            this.selectAllRichiestatr.close();
            this.insertRichiestatr.close();
            this.insertFisrtRichiesta.close();
            this.selectTrByStatoAndOfferta.close();
            this.selectAllTrByOfferta.close();
            this.ifinsertTirocinio.close();
            this.selectAllTirocinioByStato.close();
            this.selectOffertaTirByIDTirocinante.close();
            this.updateTirocinio.close();
            this.selectAllTrByTutore.close();
            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy ", ex);


        }

    }


}
