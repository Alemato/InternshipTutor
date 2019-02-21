package controller;

import controller.sessionController.SingSessionContoller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class baseController extends HttpServlet {
    protected Map<String, Object> datamodel;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void init(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        this.datamodel = new HashMap<>();
        this.header(request,response);

    }
    protected void header(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
        SingSessionContoller session = SingSessionContoller.getInstance();
        boolean logger = session.isValidSession(request);
        datamodel.put("logged",logger);
        if(logger){
               String Nome =(String)request.getSession().getAttribute("Nome");
               datamodel.put("Nome",Nome);

        }

    }


}
