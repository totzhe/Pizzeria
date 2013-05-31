package daos;

import models.DishSort;
import models.Order;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 14.04.13
 * Time: 2:46
 * To change this template use File | Settings | File Templates.
 */
public class OrderDao extends GenericDao<Order, Integer> {
    public OrderDao() {
        super(Order.class);
    }

    public List<Order> getAll()
    {
        Query query = em.createQuery("select order from Order order");
        return query.getResultList();
    }
}
