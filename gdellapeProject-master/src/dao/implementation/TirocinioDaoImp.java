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


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectRichiestatrByID = connection.prepareStatement("SELECT * FROM  tirocinio WHERE IDTirocinio = ?");

            this.selectAllRichiestatr = connection.prepareStatement("SELECT * FROM tirocinio ORDER BY UpdateDate ASC ");

            this.insertFisrtRichiesta = connection.prepareStatement("INSERT INTO tirocinio(OffertaTirocinio,Tirocinante) VALUES (?,?)");

            this.insertRichiestatr = connection.prepareStatement("INSERT INTO tirocinio(DataConsegnaModulo,DurataOre,CFU,Stato,PeriodoEffettivoIniziale,PeriodoEffettivoFinale,RisultatoConseguito,DescrizioneAttivitaSvolta,OffertaTirocinio,Tirocinante,TutoreUniveristario) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            this.selectTrByStatoAndOfferta= connection.prepareStatement("SELECT * FROM tirocinio WHERE Stato = ? AND OffertaTirocinio = ? " );
            this.selectAllTrByOfferta = connection.prepareStatement("SELECT * FROM tirocinio WHERE OffertaTirocinio = ?");

            this.ifinsertTirocinio = connection.prepareStatement("SELECT * FROM tirocinio WHERE Tirocinio = ? AND Stato > 2 ");

            this.selectAllTirocinioByStato=connection.prepareStatement("SELECT * FROM tirocinio WHERE Stato = ?");

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    public Tirocinio getRichiestatrByID (int ID) throws DaoException{
        try {
            this.init();
            Tirocinio tr = new Tirocinio();
            selectRichiestatrByID.setInt(1,ID);
            ResultSet resultSet = selectRichiestatrByID.executeQuery();
            if(resultSet.next()){

                tr.setIDTirocinio(resultSet.getInt("IDTirocinio"));
                tr.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setStato(resultSet.getInt("Stato"));
                tr.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
                tr.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
                tr.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
                tr.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
                tr.setCreateDate(resultSet.getTimestamp("CreateDate"));
                tr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));
                tr.setTutoreUniveritario(resultSet.getInt("TutoreUniversitario"));
            }else{
                throw new DaoException("Query con risultato vuoto");
            }
            return tr;

        }catch (SQLException e){
            throw new DaoException("Errore query dato",e);
        }
    }

    public List<Tirocinio> gettrbyStatoandOfferta (OffertaTirocinio offerta,int stato) throws DaoException{
        try {this.init();
            List<Tirocinio> listRT = new ArrayList<>();

            this.selectTrByStatoAndOfferta.setInt(1,stato);
            this.selectTrByStatoAndOfferta.setInt(2,offerta.getIDOffertaTirocinio());
            ResultSet resultSet = selectTrByStatoAndOfferta.executeQuery();

            while (resultSet.next()){

                Tirocinio tr = new Tirocinio();
                tr.setIDTirocinio(resultSet.getInt("IDTirocinio"));
                tr.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setStato(resultSet.getInt("Stato"));
                tr.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
                tr.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
                tr.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
                tr.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
                tr.setCreateDate(resultSet.getTimestamp("CreateDate"));
                tr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));
                tr.setTutoreUniveritario(resultSet.getInt("TutoreUniversitario"));


                listRT.add(tr);
            }

            return listRT;

        }catch (SQLException e){
            throw new DaoException("Errore query lista stato e offerta",e);
        }
    }

    public List<Tirocinio> getTirociniByStato (Integer stato) throws DaoException{
        try {this.init();
            List<Tirocinio> listRT = new ArrayList<>();

            this.selectAllTirocinioByStato.setInt(1,stato);
            ResultSet resultSet = selectAllTirocinioByStato.executeQuery();

            while (resultSet.next()){

                Tirocinio tr = new Tirocinio();
                tr.setIDTirocinio(resultSet.getInt("IDTirocinio"));
                tr.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setStato(resultSet.getInt("Stato"));
                tr.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
                tr.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
                tr.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
                tr.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
                tr.setCreateDate(resultSet.getTimestamp("CreateDate"));
                tr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));
                tr.setTutoreUniveritario(resultSet.getInt("TutoreUniversitario"));


                listRT.add(tr);
            }

            return listRT;

        }catch (SQLException e){
            throw new DaoException("Errore query",e);
        }
    }


    public List<Tirocinio> getTrByOfferta (OffertaTirocinio offertaTirocinio) throws DaoException{
        try {
            this.init();
            List<Tirocinio> listRT = new ArrayList<>();
            this.selectAllTrByOfferta.setInt(1,  offertaTirocinio.getIDOffertaTirocinio());
            ResultSet resultSet = selectAllTrByOfferta.executeQuery();

            while (resultSet.next()){
                Tirocinio tr = new Tirocinio();
                tr.setIDTirocinio(resultSet.getInt("IDTirocinio"));
                tr.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setStato(resultSet.getInt("Stato"));
                tr.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
                tr.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
                tr.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
                tr.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
                tr.setCreateDate(resultSet.getTimestamp("CreateDate"));
                tr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));
                tr.setTutoreUniveritario(resultSet.getInt("TutoreUniversitario"));
                listRT.add(tr);
            }

            return listRT;

        }catch (SQLException e){
            throw new DaoException("Errore query lista tr by offerta tr",e);
        }
    }
    public boolean ifTirocinanteSendRichiesta(Tirocinante tr) throws DaoException{
        try {
            ifinsertTirocinio.setInt(1, tr.getIDTirocinante());
            ResultSet resultSet = ifinsertTirocinio.executeQuery();
            if(resultSet.next()){
                return false;
            }else{return true;}
        }catch (SQLException e){
            throw new DaoException("Problema data base",e);
        }

    }



    public List<Tirocinio> getOffertaTirByIDTirocinante(int IDTr) throws DaoException {
        try {
            this.init();
            List<Tirocinio> listIDOff = new ArrayList<>();
            this.selectOffertaTirByIDTirocinante.setInt(1, IDTr);
            ResultSet resultSet = selectOffertaTirByIDTirocinante.executeQuery();
            while (resultSet.next()){

                Tirocinio tr = new Tirocinio();
                tr.setIDTirocinio(resultSet.getInt("IDTirocinio"));
                tr.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setStato(resultSet.getInt("Stato"));
                tr.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
                tr.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
                tr.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
                tr.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
                tr.setCreateDate(resultSet.getTimestamp("CreateDate"));
                tr.setUpdateDate(resultSet.getTimestamp("UpdateDate"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));
                tr.setTutoreUniveritario(resultSet.getInt("TutoreUniversitario"));
                listIDOff.add(tr);
            }

            return listIDOff;
        }catch (SQLException e){
            throw new DaoException("Errore query lista stato e offerta",e);
        }
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
            insertRichiestatr.setInt(9, tr.getOffertaTirocinio());
            insertRichiestatr.setInt(10, tr.getTirocinante());
            insertRichiestatr.setInt(11,tr.getTutoreUniveritario());
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



    public void destroy() throws DaoException {

        try {

            this.selectTrByStatoAndOfferta.close();
            this.selectAllRichiestatr.close();
            this.selectRichiestatrByID.close();
            this.insertRichiestatr.close();
            this.insertFisrtRichiesta.close();
            this.selectAllTirocinioByStato.close();
            this.selectOffertaTirByIDTirocinante.close();


            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy ", ex);


        }

    }


}
