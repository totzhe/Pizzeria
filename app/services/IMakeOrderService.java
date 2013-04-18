package services;

import models.Order;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 18.04.13
 * Time: 3:47
 * To change this template use File | Settings | File Templates.
 */
public interface IMakeOrderService {
    void AddItem(Order order, int dishId, int quantity);

    void RemoveItem(Order order, int dishId);

    void EditItem(Order order, int dishId, int quantity);

    void ConfirmOrder(Order order);
}
