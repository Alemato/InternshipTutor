package dao.implementation;

import dao.data.DaoDataMySQLImpl;
import dao.exception.DaoException;
import model.RichiestaTirocinio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Azienda;

public class RichiestaTirocinioDaoImp extends DaoDataMySQLImpl {
    private PreparedStatement selectRichiestatrByID;
    private PreparedStatement selectAllRichiestatr;
    private PreparedStatement insertRichiestatr;
    private PreparedStatement selectNOTActiveRTRbuyAzeinda;


    @Override
    public void init() throws DaoException {
        try {

            super.init();

            this.selectRichiestatrByID = connection.prepareStatement("SELECT * FROM  richiestatirocinio WHERE IDRichiestaTirocinio = ?");

            this.selectAllRichiestatr = connection.prepareStatement("SELECT * FROM richiestatirocinio ORDER BY UpdateDate ASC ");



            this.insertRichiestatr = connection.prepareStatement("INSERT INTO richiestatirocinio (DurataOre,CFU,Active,OffertaTirocionio,Tirocinante) VALUES (?,?,?,?,?)");

            this.selectNOTActiveRTRbuyAzeinda= connection.prepareStatement("" );

        } catch (SQLException ex) {
            throw new DaoException("Error:PrepareStatement error", ex);

        }
    }

    public RichiestaTirocinio getRichiestatrByID (int ID) throws DaoException{
        try {
            RichiestaTirocinio tr = new RichiestaTirocinio();
            selectRichiestatrByID.setInt(1,ID);
            ResultSet resultSet = selectRichiestatrByID.executeQuery();
            if(resultSet.next()){
                tr.setIDricTironinio(resultSet.getInt("IDRichiestaTirocinio"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setActive(resultSet.getBoolean("Active"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocionio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));
            }
            return tr;

        }catch (SQLException e){
            throw new DaoException("Errore query dato",e);
        }
    }

    public List<RichiestaTirocinio> getnotActiveByAzienda (Azienda azienda) throws DaoException{
        try {
            List<RichiestaTirocinio> listRT = new ArrayList<>();

            selectNOTActiveRTRbuyAzeinda.setInt(1,azienda.getIDAzienda());
            ResultSet resultSet = selectNOTActiveRTRbuyAzeinda.executeQuery();

            while (resultSet.next()){

                RichiestaTirocinio tr = new RichiestaTirocinio();
                tr.setIDricTironinio(resultSet.getInt("IDRichiestaTirocinio"));
                tr.setDurataOre(resultSet.getInt("DurataOre"));
                tr.setActive(resultSet.getBoolean("Active"));
                tr.setCFU(resultSet.getInt("CFU"));
                tr.setOffertaTirocinio(resultSet.getInt("OffertaTirocionio"));
                tr.setTirocinante(resultSet.getInt("Tirocinante"));

                listRT.add(tr);
            }

            return listRT;

        }catch (SQLException e){
            throw new DaoException("Errore query lista tr active",e);
        }
    }


    public void setRichiestatr(RichiestaTirocinio tr) throws DaoException {
        try {
            insertRichiestatr.setInt(1, tr.getDurataOre());
            insertRichiestatr.setInt(2, tr.getCFU());
            insertRichiestatr.setBoolean(3,tr.getActive());
            insertRichiestatr.setInt(4, tr.getOffertaTirocinio());
            insertRichiestatr.setInt(5, tr.getTirocinante());
            insertRichiestatr.executeUpdate();


        } catch (SQLException e) {
            throw new DaoException("Errore inserimento dato", e);

        }
    }
    public void destroy() throws DaoException {

        try {

            this.selectAllRichiestatr.close();
            this.selectRichiestatrByID.close();
            this.insertRichiestatr.close();
            this.selectNOTActiveRTRbuyAzeinda.close();


            super.destroy();

        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DaoException("Error destroy ", ex);


        }

    }


}
