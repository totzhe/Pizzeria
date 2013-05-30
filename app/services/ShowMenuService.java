package services;

import daos.DishSortDao;
import daos.GenericDao;
import daos.IGenericDao;
import models.Dish;
import models.DishSort;
import play.db.jpa.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class ShowMenuService {

    public ShowMenuService() {
    }


    public List<DishSort> getDishSorts() {
        return new DishSortDao().getAll();
    }


    public DishSort getDishSortById(int id) {
        return new DishSortDao().read(id);
    }


    public Dish getDishById(int id) {
        return new GenericDao<Dish, Integer>(Dish.class).read(id);
    }
}
