package services;

import daos.GenericDao;
import models.Dish;
import models.Order;
import models.OrderItem;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 18.04.13
 * Time: 3:22
 * To change this template use File | Settings | File Templates.
 */
public class MakeOrderService {

    public int AddItem(Order order, int dishId, int quantity) {
        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            if (item.getDish().getId() == dishId) {
                item.setQuantity(item.getQuantity() + quantity);
                return item.getCost();
            }
        }
        OrderItem item = new OrderItem();
        item.setDish(new GenericDao<Dish, Integer>(Dish.class).read(dishId));
        item.setQuantity(quantity);
        order.getItems().add(item);
        return item.getCost();
    }



    public void RemoveItem(Order order, int dishId) {
        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            if (item.getDish().getId() == dishId) {
                order.getItems().remove(item);
                return;
            }
        }
    }


    public int EditItem(Order order, int dishId, int quantity) {
        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            if (item.getDish().getId() == dishId) {
                item.setQuantity(quantity);
                return item.getCost();
            }
        }
        return 0;
    }


    public void ConfirmOrder(Order order) {
        if (order.getItems().size() > 0) {
            GenericDao<Order, Integer> dao = new GenericDao<Order, Integer>(Order.class);
            dao.create(order);
        }
    }
}
