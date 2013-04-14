package controllers;

import daos.DishSortDao;
import daos.GenericDaoJPAImpl;
import models.*;
import play.*;
import play.db.jpa.*;
import play.mvc.*;

import views.html.*;

import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

public class Application extends Controller {

    @Transactional
    public static Result index() {

        DishSort ds;// = JPA.em().find(DishSort.class, 1);
        //Dish ds;

        //List<DishSort> sorts = JPA.em().createQuery("SELECT e FROM DishSort e order by id").getResultList();

        DishSortDao dao1 = new DishSortDao(DishSort.class);
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

        //change dish sort
        d = dao.read(1);
        d.getSort();
        d.setSort(ds);
        dao.update(d);

        /*List<DishSort> sorts = new LinkedList<DishSort>();
        for(int i = 1; i < 7; i++)
        {
            ds = dao1.read(i);
            sorts.add(ds);
        }  */
        //return ok(index.render(ds.getId(), d.getName(), d.getSort().getName()));
        return ok(index.render(dao1.getAll()));
    }

    @Transactional
    public static Result menu() {
        Dish d;
        GenericDaoJPAImpl<Dish, Integer> dao = new GenericDaoJPAImpl<Dish, Integer>(Dish.class);

        //change dish sort
        d = dao.read(1);
        List<Dish> dishes = new LinkedList<Dish>();
        for(int i = 1; i < 7; i++)
        {
            dishes.add(d);
        }
        return ok(menu.render(0, dishes, null));
    }
}