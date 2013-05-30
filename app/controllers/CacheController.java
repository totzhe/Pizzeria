package controllers;

import models.Order;
import play.cache.Cache;

import static play.mvc.Controller.session;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 20.04.13
 * Time: 1:51
 * To change this template use File | Settings | File Templates.
 */
public class CacheController {

    public static Order loadOrder() {
        String uuid=session("uuid");
        if(uuid==null) {
            return new Order();
        }
        Order order =  (Order) Cache.get(uuid);
        return order == null? new Order() : order;
    }

    public static void saveOrder(Order order) {
        String uuid=session("uuid");
        if(uuid==null) {
            uuid=java.util.UUID.randomUUID().toString();
            session("uuid", uuid);
        }
        Cache.set(uuid, order);
    }

    public static void deleteOrder(Order order) {
        String uuid=session("uuid");
        if(uuid!=null) {
            Cache.set(uuid, null, 0);
        }
    }
}
