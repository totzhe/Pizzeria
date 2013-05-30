package models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 18.04.13
 * Time: 0:06
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }


    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name = "order_id")
    @OrderBy("id ASC")
    private List<OrderItem> items;

    public List<OrderItem> getItems() {
        if (items == null)
            items = new LinkedList<OrderItem>();
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Column(name = "customer_name")
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "customer_address")
    private String customerAddress;

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Column(name = "customer_phone")
    private String customerPhone;

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Column(name = "recieving_time")
    private Date recievingTime;

    public Date getRecievingTime() {
        return recievingTime;
    }

    public void setRecievingTime(Date recievingTime) {
        this.recievingTime = recievingTime;
    }

    @Column(name = "sending_time")
    private Date sendingTime;

    public Date getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Date sendingTime) {
        this.sendingTime = sendingTime;
    }

    public int getSum() {
        int sum = 0;
        if (items != null) {
            for (Iterator<OrderItem> i = items.iterator(); i.hasNext(); ) {
                OrderItem item = i.next();
                sum += item.getCost();
            }
        }
        return sum;
    }
}
