package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.OffertaTirocinio;
import model.Tirocinio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Azienda;
import model.Tirocinante;

import javax.servlet.http.HttpServletRequest;

public class TirocinioDaoImp extends DaoDataMySQLImpl {
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


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectRichiestatrByID = connection.prepareStatement("SELECT * FROM  tirocinio WHERE IDTirocinio = ?");

            this.selectAllRichiestatr = connection.prepareStatement("SELECT * FROM tirocinio ORDER BY UpdateDate ASC ");

            // TODO controllare utilità e funzionalità
            this.insertFisrtRichiesta = connection.prepareStatement("INSERT INTO tirocinio(OffertaTirocinio,Tirocinante) VALUES (?,?)");

            this.insertRichiestatr = connection.prepareStatement("INSERT INTO tirocinio(DataConsegnaModulo," +
                    "DurataOre,CFU,Stato,PeriodoEffettivoIniziale,PeriodoEffettivoFinale,RisultatoConseguito," +
                    "DescrizioneAttivitaSvolta,PdfTirocinante,PdfAzienda,PdfSegreteria ,OffertaTirocinio," +
                    "Tirocinante,TutoreUniversitario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            this.selectTrByStatoAndOfferta= connection.prepareStatement("SELECT * FROM tirocinio WHERE Stato = ? AND OffertaTirocinio = ? " );

            this.selectAllTrByOfferta = connection.prepareStatement("SELECT * FROM tirocinio WHERE OffertaTirocinio = ?");

            this.ifinsertTirocinio = connection.prepareStatement("SELECT * FROM tirocinio WHERE Tirocinio = ? AND Stato > 2 ");

            this.selectAllTirocinioByStato=connection.prepareStatement("SELECT * FROM tirocinio WHERE Stato = ?");

            this.selectOffertaTirByIDTirocinante = connection.prepareStatement("SELECT * FROM tirocinio WHERE Tirocinante = ?");

            this.updateTirocinio = connection.prepareStatement("UPDATE tirocinio SET DataConsegnaModulo = ?," +
                    " DurataOre = ?, CFU = ?, Stato = ?, PeriodoEffettivoIniziale = ?, PeriodoEffettivoFinale = ?," +
                    " RisultatoConseguito = ?, DescrizioneAttivitaSvolta = ?, PdfTirocinante = ?, PdfAzienda = ?," +
                    " PdfSegreteria = ?, CreateDate = ?, UpdateDate = ?, OffertaTirocinio = ?, Tirocinante = ?, " +
                    " TutoreUniversitario = ? WHERE  IDTirocinio = ?");
        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    private void setTirocinioObject(Tirocinio tirocinio, ResultSet resultSet) throws DaoException {
        try{
            tirocinio.setIDTirocinio(resultSet.getInt("IDTirocinio"));
            tirocinio.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
            tirocinio.setDurataOre(resultSet.getInt("DurataOre"));
            tirocinio.setCFU(resultSet.getInt("CFU"));
            tirocinio.setStato(resultSet.getInt("Stato"));
            tirocinio.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
            tirocinio.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
            tirocinio.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
            tirocinio.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
            tirocinio.setPdfTirocinante(resultSet.getString("PdfTirocinante"));
            tirocinio.setPdfAzienda(resultSet.getString("PdfAzienda"));
            tirocinio.setPdfSegreteria(resultSet.getString("PdfSegreteria"));
            tirocinio.setCreateDate(resultSet.getTimestamp("CreateDate"));
            tirocinio.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
            tirocinio.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
            tirocinio.setTirocinante(resultSet.getInt("Tirocinante"));
            tirocinio.setTutoreUniversitario(resultSet.getInt("TutoreUniversitario"));
        } catch (SQLException e){
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
            throw new DaoException("Errore nel creare Lista oggetti Azienda", e);
        }
    }
    public Tirocinio getRichiestatrByID (int ID) throws DaoException{
        try {
            this.init();
            Tirocinio tr = new Tirocinio();
            selectRichiestatrByID.setInt(1,ID);
            ResultSet resultSet = selectRichiestatrByID.executeQuery();
            if(resultSet.next()) {
                setTirocinioObject(tr, resultSet);
            }else{
                throw new DaoException("Query con risultato vuoto");
            }
            return tr;

        }catch (SQLException e){
            throw new DaoException("Errore query dato",e);
        }
    }

    public List<Tirocinio> gettrbyStatoandOfferta (OffertaTirocinio offerta,int stato) throws DaoException{
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            this.init();
            this.selectTrByStatoAndOfferta.setInt(1,stato);
            this.selectTrByStatoAndOfferta.setInt(2,offerta.getIDOffertaTirocinio());
            ResultSet resultSet = selectTrByStatoAndOfferta.executeQuery();
            setListTirocinio(listRT,resultSet);

        } catch (SQLException e){
            throw new DaoException("Errore query lista stato e offerta",e);
        }
        return listRT;
    }

    public List<Tirocinio> getTirociniByStato (Integer stato) throws DaoException{
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            this.init();
            this.selectAllTirocinioByStato.setInt(1,stato);
            ResultSet resultSet = selectAllTirocinioByStato.executeQuery();
            setListTirocinio(listRT,resultSet);
        } catch (SQLException e){
            throw new DaoException("Errore query",e);
        }
        return listRT;
    }


    public List<Tirocinio> getTrByOfferta (OffertaTirocinio offertaTirocinio) throws DaoException{
        List<Tirocinio> listRT = new ArrayList<>();
        try {
            System.out.println("query inizio");
            this.init();
            this.selectAllTrByOfferta.setInt(1,  offertaTirocinio.getIDOffertaTirocinio());
            ResultSet resultSet = selectAllTrByOfferta.executeQuery();
            setListTirocinio(listRT,resultSet);
            System.out.println("query fine");
            System.out.println(listRT);
        } catch (SQLException e){
            throw new DaoException("Errore query lista tr by offerta tr",e);
        }
        return listRT;
    }


    public boolean ifTirocinanteSendRichiesta(Tirocinante tr) throws DaoException{
        try {
            ifinsertTirocinio.setInt(1, tr.getIDTirocinante());
            ResultSet resultSet = ifinsertTirocinio.executeQuery();
            return !resultSet.next();
        }catch (SQLException e){
            throw new DaoException("Problema data base",e);
        }

    }



    public List<Tirocinio> getOffertaTirByIDTirocinante(int IDTr) throws DaoException {
        List<Tirocinio> listIDOff = new ArrayList<>();
        try {
            this.init();
            this.selectOffertaTirByIDTirocinante.setInt(1, IDTr);
            ResultSet resultSet = selectOffertaTirByIDTirocinante.executeQuery();
            setListTirocinio(listIDOff,resultSet);
        }catch (SQLException e){
            throw new DaoException("Errore query lista stato e offerta",e);
        }
        return listIDOff;
    }




    public void setRichiestatr(Tirocinio tr) throws DaoException {
        try {
            this.init();
            insertRichiestatr.setDate(1, tr.getDataConsegnaModulo());
            insertRichiestatr.setInt(2, tr.getDurataOre());
            insertRichiestatr.setInt(3, tr.getCFU());
            insertRichiestatr.setInt(4,tr.getStato());
            insertRichiestatr.setDate(5, tr.getPeriodoEffettivoIniziale());
            insertRichiestatr.setDate(6, tr.getPeriodoEffettivoFinale());
            insertRichiestatr.setString(7, tr.getRisultatoConseguito());
            insertRichiestatr.setString(8, tr.getDescrizioneAttivitaSvolta());
            insertRichiestatr.setString(9,tr.getPdfTirocinante());
            insertRichiestatr.setString(10,tr.getPdfAzienda());
            insertRichiestatr.setString(11,tr.getPdfSegreteria());
            insertRichiestatr.setInt(12, tr.getOffertaTirocinio());
            insertRichiestatr.setInt(13, tr.getTirocinante());
            insertRichiestatr.setInt(14,tr.getTutoreUniversitario());
            insertRichiestatr.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("Errore inserimento dato", e);

        }
    }

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

    public void setUpdateTirocinio(Tirocinio tirocinio) throws DaoException{
    /*
    UPDATE tirocinio SET DataConsegnaModulo = ?," +
                    " DurataOre = ?, CFU = ?, Stato = ?, PeriodoEffettivoIniziale = ?, PeriodoEffettivoFinale = ?," +
                    " RisultatoConseguito = ?, DescrizioneAttivitaSvolta = ?, PdfTirocinante = ?, PdfAzienda = ?," +
                    " PdfSegreteria = ?, CreateDate = ?, UpdateDate = ?, OffertaTirocinio = ?, Tirocinante = ?, " +
                    " TutoreUniversitario = ? WHERE  IDTirocinio = ?
     */
    try{
        this.init();
        this.updateTirocinio.setDate(1, tirocinio.getDataConsegnaModulo());
        this.updateTirocinio.setInt(2, tirocinio.getDurataOre());
        this.updateTirocinio.setInt(3, tirocinio.getCFU());
        this.updateTirocinio.setInt(4,tirocinio.getStato());
        this.updateTirocinio.setDate(5, tirocinio.getPeriodoEffettivoIniziale());
        this.updateTirocinio.setDate(6, tirocinio.getPeriodoEffettivoFinale());
        this.updateTirocinio.setString(7, tirocinio.getRisultatoConseguito());
        this.updateTirocinio.setString(8, tirocinio.getDescrizioneAttivitaSvolta());
        this.updateTirocinio.setString(9, tirocinio.getPdfTirocinante());
        this.updateTirocinio.setString(10, tirocinio.getPdfAzienda());
        this.updateTirocinio.setString(11, tirocinio.getPdfSegreteria());
        this.updateTirocinio.setTimestamp(12, tirocinio.getCreateDate());
        this.updateTirocinio.setTimestamp(13, tirocinio.getUpdateDate());
        this.updateTirocinio.setInt(14, tirocinio.getOffertaTirocinio());
        this.updateTirocinio.setInt(15, tirocinio.getTirocinante());
        this.updateTirocinio.setInt(16, tirocinio.getTutoreUniversitario());
        this.updateTirocinio.setInt(17, tirocinio.getIDTirocinio());
        this.updateTirocinio.executeUpdate();
    } catch (SQLException e){
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
            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy ", ex);


        }

    }


}
