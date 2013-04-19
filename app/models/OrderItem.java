package models;

import daos.DaoFactory;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 23:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    @Column(name = "order_id")
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int id) {
        this.orderId = id;
    }

    @Column(name = "dish_id")
    private int dish_id;

    public int getDishId() {
        return dish_id;
    }

    public void setDishId(int dish_id) {
        this.dish_id = dish_id;
        Dish d = DaoFactory.getInstance().getDishDao().read(dish_id);
       if(d != null)
            cost = quantity*d.getPrice();
        else
            cost = 0;
    }

    public Dish getDish() {
        return DaoFactory.getInstance().getDishDao().read(dish_id);
    }

    @Column(name = "quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        Dish d = DaoFactory.getInstance().getDishDao().read(dish_id);
        if(d != null)
            cost = quantity*d.getPrice();
        else
            this.cost = 0;
    }

    @Column(name = "cost")
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
