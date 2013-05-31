package controllers;

import daos.AdminDao;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.indexadmin;
import views.html.orders;

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
        AdminDao adminDao = new AdminDao();
        if (adminDao.Verify(login, /*MD5.getHash(password)*/password))
            return ok("Checked");
        else
            return badRequest("Login or password is wrong");
    }

    public static Result orders() {
        return ok(orders.render());
    }
}
