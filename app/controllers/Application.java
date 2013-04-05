package controllers;

import daos.GenericDaoJPAImpl;
import models.DishSort;
import play.*;
import play.db.jpa.*;
import play.mvc.*;

import views.html.*;

import javax.persistence.criteria.*;
import java.util.List;

public class Application extends Controller {

    @Transactional
    public static Result index() {

        DishSort ds;// = JPA.em().find(DishSort.class, 1);

        //List<DishSort> sorts = JPA.em().createQuery("SELECT e FROM DishSort e order by id").getResultList();

        GenericDaoJPAImpl<DishSort, Integer> dao = new GenericDaoJPAImpl<DishSort, Integer>(DishSort.class);

        //read
        ds = dao.read(1);

        //create
        /*ds = new DishSort();
        ds.setName("Hello World!");
        dao.create(ds);   */

        //update
        /*ds.setName("12345");
        dao.update(ds);*/

        //delete
        //dao.delete(ds);

        return ok(index.render(/*sorts.get(0).getId() + */ds.getId(), ds.getName(), ds.getPicturePath()));
    }

    public static Result menu() {
        return ok(menu.render());
    }
}