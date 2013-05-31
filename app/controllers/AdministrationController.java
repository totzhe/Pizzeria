package controllers;

import daos.LoginDao;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.MD5;
import views.html.indexadmin;
import views.html.notification;

import java.io.Console;

/**
 * Created with IntelliJ IDEA.
 * User: Alina
 * Date: 29.05.13
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class AdministrationController extends Controller {

    public static Result indexadmin() {
        return ok(indexadmin.render());
    }

    @Transactional
    public static Result login(String login, String password) {
        LoginDao loginDao = new LoginDao();
        if (loginDao.Verify(login, /*MD5.getHash(password)*/password))
            return ok("Checked");
        else
            return badRequest("Login or password is wrong");
    }

    public static Result notification() {
        return ok(notification.render());
    }
}
