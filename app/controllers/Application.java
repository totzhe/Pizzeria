package controllers;

import daos.GenericDaoJPAImpl;
import models.*;
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
        //Dish ds;

        //List<DishSort> sorts = JPA.em().createQuery("SELECT e FROM DishSort e order by id").getResultList();

        GenericDaoJPAImpl<DishSort, Integer> dao1 = new GenericDaoJPAImpl<DishSort, Integer>(DishSort.class);
        //GenericDaoJPAImpl<Dish, Integer> dao = new GenericDaoJPAImpl<Dish, Integer>(Dish.class);


        //read
        ds = dao1.read(1);

        //create
        /*ds = new DishSort();
        ds.setName("Hello World!");
        dao.create(ds);   */

        //update
        /*ds.setName("12345");
        dao.update(ds);*/

        //delete
        //dao.delete(ds);

        //return ok(index.render(ds.getId(), ds.getName(), /*ds.getPicturePath()*/ds.dishes.get(0).getName()));

        Dish d;
        GenericDaoJPAImpl<Dish, Integer> dao = new GenericDaoJPAImpl<Dish, Integer>(Dish.class);
        d = dao.read(1);

        //change dish sort
        d.getSort();
        d.setSort(ds);
        dao.update(d);
        return ok(index.render(ds.getId(), d.getName(), d.getSort().getName()));
    }

    public static Result menu() {
        return ok(menu.render());
    }
}