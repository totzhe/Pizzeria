package controllers;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import models.Order;
import models.OrderItem;
import org.codehaus.jackson.node.ObjectNode;
import play.cache.Cache;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ServiceFactory;
import views.html.menu;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 */
public class OrderController extends Controller {

    @Transactional
    public static Result addItem(int id, int quantity) {
        Order order = CacheController.loadOrder();
        ServiceFactory.getInstance().getMakeOrderService().AddItem(order, id, quantity);
        CacheController.saveOrder(order);

        return ok(String.valueOf(order.getSum()));
    }

    @Transactional
    public static Result editItem(int id, int quantity) {
        Order order = CacheController.loadOrder();
        int itemCost = ServiceFactory.getInstance().getMakeOrderService().EditItem(order, id, quantity);
        CacheController.saveOrder(order);
        ObjectNode result = Json.newObject();
            result.put("item_cost", itemCost);
            result.put("sum", order.getSum());
        return ok(result);
    }

    @Transactional
    public static Result removeItem(int id) {
        Order order = CacheController.loadOrder();
        ServiceFactory.getInstance().getMakeOrderService().RemoveItem(order, id);
        CacheController.saveOrder(order);
        return ok(String.valueOf(order.getSum()));
    }
}
