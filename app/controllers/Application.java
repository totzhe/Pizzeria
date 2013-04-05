package controllers;

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

        DishSort ds = JPA.em().find(DishSort.class, 1);

        List<DishSort> sorts = JPA.em().createQuery("SELECT e FROM DishSort e order by id").getResultList();

        return ok(index.render(/*sorts.get(0).getId() + */ds.getName()));
    }

    public static Result menu() {
        return ok(menu.render());
    }
}