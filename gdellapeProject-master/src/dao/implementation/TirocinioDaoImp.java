package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.Tirocinio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Azienda;
import model.Tirocinante;

public class TirocinioDaoImp extends DaoDataMySQLImpl {
    private PreparedStatement selectRichiestatrByID;
    private PreparedStatement selectAllRichiestatr;
    private PreparedStatement insertRichiestatr;
    private PreparedStatement selectNOTActiveRTRbuyAzeinda;
    private PreparedStatement insertFisrtRichiesta;
    private PreparedStatement selectActiveRichiestaByTR;


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectRichiestatrByID = connection.prepareStatement("SELECT * FROM  richiestatirocinio WHERE IDRichiestaTirocinio = ?");

            this.selectAllRichiestatr = connection.prepareStatement("SELECT * FROM richiestatirocinio ORDER BY UpdateDate ASC ");

            this.insertFisrtRichiesta = connection.prepareStatement("INSERT INTO richiestatirocinio(OffertaTirocinio,Tirocinante) VALUES (?,?)");

            this.insertRichiestatr = connection.prepareStatement("INSERT INTO richiestatirocinio(DataConsegnaModulo,DurataOre,CFU,Stato,PeriodoEffettivoIniziale,PeriodoEffettivoFinale,RisultatoConseguito,DescrizioneAttivitaSvolta,OffertaTirocinio,Tirocinante) VALUES (?,?,?,?,?,?,?,?,?,?)");

            this.selectActiveRichiestaByTR= connection.prepareStatement("SELECT * FROM richiestatirocinio WHERE Active = true AND Tirocinante = ? " );

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

                tr.setIDricTironinio(resultSet.getInt("IDRichiestaTirocinio"));
                tr.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setStato(resultSet.getInt("Stato"));
                tr.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
                tr.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
                tr.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
                tr.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));
            }
            return tr;

        }catch (SQLException e){
            throw new DaoException("Errore query dato",e);
        }
    }

    public List<Tirocinio> getnotActiveByAzienda (Azienda azienda) throws DaoException{
        try {this.init();
            List<Tirocinio> listRT = new ArrayList<>();

            selectNOTActiveRTRbuyAzeinda.setInt(1,azienda.getIDAzienda());
            ResultSet resultSet = selectNOTActiveRTRbuyAzeinda.executeQuery();

            while (resultSet.next()){

                Tirocinio tr = new Tirocinio();
                tr.setIDricTironinio(resultSet.getInt("IDRichiestaTirocinio"));
                tr.setDataConsegnaModulo(resultSet.getDate("DataConsegnaModulo"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setStato(resultSet.getInt("Stato"));
                tr.setPeriodoEffettivoIniziale(resultSet.getDate("PeriodoEffettivoIniziale"));
                tr.setPeriodoEffettivoFinale(resultSet.getDate("PeriodoEffettivoFinale"));
                tr.setRisultatoConseguito(resultSet.getString("RisultatoConseguito"));
                tr.setDescrizioneAttivitaSvolta(resultSet.getString("DescrizioneAttivitaSvolta"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocinio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));

                listRT.add(tr);
            }

            return listRT;

        }catch (SQLException e){
            throw new DaoException("Errore query lista tr active",e);
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
    public boolean ifAreactiveOfferteByTr (Tirocinante tr) throws DaoException {
        try {
            this.init();
            selectActiveRichiestaByTR.setInt(1,tr.getIDTirocinante());
            ResultSet re = selectActiveRichiestaByTR.executeQuery();
            if(re.next()){return true;}
            else{return false;}

            } catch (SQLException e) {
            throw new DaoException("Errore controllo tabella", e);

        }
    }


    public void destroy() throws DaoException {

        try {

            this.selectActiveRichiestaByTR.close();
            this.selectAllRichiestatr.close();
            this.selectRichiestatrByID.close();
            this.insertRichiestatr.close();
            this.insertFisrtRichiesta.close();


            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy ", ex);


        }

    }


}
