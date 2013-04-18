package daos;

import models.Dish;
import models.DishSort;
import models.Order;
import models.OrderItem;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 18:35
 * To change this template use File | Settings | File Templates.
 */
public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (instance == null)
            instance = new DaoFactory();
        return instance;
    }

    public IGenericDao<Dish, Integer> getDishDao() {
        return new GenericDao<Dish, Integer>(Dish.class);
    }

    public IDishSortDao getDishSortDao() {
        return new DishSortDao();
    }

    public IGenericDao<Order, Integer> getOrderDao() {
        return new GenericDao<Order, Integer>(Order.class);
    }

    public IGenericDao<OrderItem, Integer> getOrderItemDao() {
        return new GenericDao<OrderItem, Integer>(OrderItem.class);
    }
}
