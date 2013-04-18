package services;

import daos.DaoFactory;
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
public class ShowMenuService implements IShowMenuService {

    public ShowMenuService() {
    }

    @Override
    public List<DishSort> getDishSorts() {
        return DaoFactory.getInstance().getDishSortDao().getAll();
    }

    @Override
    public DishSort getDishSortById(int id) {
        return DaoFactory.getInstance().getDishSortDao().read(id);
    }

    @Override
    public Dish getDishById(int id) {
        return DaoFactory.getInstance().getDishDao().read(id);
    }
}
