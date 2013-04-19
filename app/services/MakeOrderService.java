package services;

import daos.DaoFactory;
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
public class MakeOrderService implements IMakeOrderService {
    @Override
    public int AddItem(Order order, int dishId, int quantity) {
        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            if (item.getDishId() == dishId) {
                item.setQuantity(item.getQuantity() + quantity);
                return item.getCost();
            }
        }
        OrderItem item = new OrderItem();
        item.setDishId(DaoFactory.getInstance().getDishDao().read(dishId).getId());
        item.setQuantity(quantity);
        order.getItems().add(item);
        return item.getCost();
    }


    @Override
    public void RemoveItem(Order order, int dishId) {
        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            if (item.getDishId() == dishId) {
                order.getItems().remove(item);
                return;
            }
        }
    }

    @Override
    public int EditItem(Order order, int dishId, int quantity) {
        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            if (item.getDishId() == dishId) {
                item.setQuantity(quantity);
                return item.getCost();
            }
        }
        return 0;
    }

    @Override
    public void ConfirmOrder(Order order) {

    }
}
