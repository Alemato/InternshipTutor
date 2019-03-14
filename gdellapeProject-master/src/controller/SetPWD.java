package controller;

import controller.baseController;
import controller.utility.SecurityHash;
import dao.exception.DaoException;
import dao.implementation.UserDaoImp;
import model.User;
import view.TemplateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetPWD extends baseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.init(request, response);
        int i = Integer.parseInt(request.getParameter("id"));
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User();
        try {
            user = userDaoImp.getUserByid(i);
            userDaoImp.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        User user1 = new User();
        user1.setIDUser(user.getIDUser());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setTipologiaAccount(user.getTipologiaAccount());
        user1.setCreateDate(user.getCreateDate());
        user1.setUpdateDate(user.getUpdateDate());
        UserDaoImp userDaoImp1 = new UserDaoImp();
        user.setPassword(SecurityHash.SetHash(user.getPassword()));
        try {
            userDaoImp1.update(user);
            userDaoImp1.destroy();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        datamodel.put("User", user);
        datamodel.put("User1", user1);
        TemplateController.process("setpwdgetpwd.ftl", datamodel, response, getServletContext());}
}
