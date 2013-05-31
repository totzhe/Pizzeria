package daos;

import models.Admin;

import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Alina
 * Date: 29.05.13
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
public class AdminDao extends GenericDao<Admin, Integer> {

    public AdminDao() {
        super(Admin.class);
    }

    public boolean Verify(String login, String password) {
        Query query = em.createQuery("from Admin where login = :log and password_hash = :pass");
        //Query query = em.createQuery("select adm from Admin adm where adm.login = :log and ...");
        if (query.setParameter("log", login).setParameter("pass", password).getSingleResult() != null)
            return false;

        return true;
    }
}
