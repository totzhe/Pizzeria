package models;


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

    //@Column(name = "order_id", nullable = false)
    @ManyToOne
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrderId(Order order) {
        this.order = order;
    }

    //@Column(name = "dish_id")
    @ManyToOne
    private Dish dish;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
       if(dish != null)
            cost = quantity*dish.getPrice();
        else
            cost = 0;
    }

    @Column(name = "quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        if(dish != null)
            cost = quantity*dish.getPrice();
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
