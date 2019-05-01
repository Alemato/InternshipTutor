package controller.adm.Azienda;

import controller.baseController;
import controller.sessionController.SingSessionContoller;
import controller.utility.UploadFilePDF;
import dao.exception.DaoException;
import dao.implementation.AziendaDaoImp;
import model.Azienda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
public class UploadConvenzioneController extends baseController {
    private void er500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/500");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        Part convenzione = request.getPart("filetoupload");
        System.out.println("part convenzione: "+convenzione);
        if(convenzione!=null){
            SingSessionContoller session = SingSessionContoller.getInstance();
            Azienda azienda = session.getAzienda(request, response);
            UploadFilePDF uploadFilePDF = new UploadFilePDF();
            String nomefile = uploadFilePDF.uploadPDF(request, convenzione, 0, azienda);
            AziendaDaoImp aziendaDaoImp = new AziendaDaoImp();
            azienda.setPathPDFConvenzione(nomefile);
            azienda.setModuloConvenzione(true);
            try {
                aziendaDaoImp.updateAzienda(azienda);
                aziendaDaoImp.destroy();
                response.sendRedirect("/account/moduli");
            } catch (DaoException e) {
                e.printStackTrace();
                er500(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        er500(request, response);
    }
}
