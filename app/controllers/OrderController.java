package controllers;

import daos.GenericDao;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import models.Order;
import models.OrderItem;
import models.User;
import org.codehaus.jackson.node.ObjectNode;
import play.cache.Cache;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.MakeOrderService;
import views.html.cart;
import views.html.menu;

import java.util.Date;
import java.util.Iterator;

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
        new MakeOrderService().AddItem(order, id, quantity);
        CacheController.saveOrder(order);

        return ok(String.valueOf(order.getSum()));
    }

    @Transactional
    public static Result editItem(int id, int quantity) {
        Order order = CacheController.loadOrder();
        int itemCost = new MakeOrderService().EditItem(order, id, quantity);
        CacheController.saveOrder(order);
        ObjectNode result = Json.newObject();
            result.put("item_cost", itemCost);
            result.put("sum", order.getSum());
        return ok(result);
    }

    @Transactional
    public static Result removeItem(int id) {
        Order order = CacheController.loadOrder();
        new MakeOrderService().RemoveItem(order, id);
        CacheController.saveOrder(order);
        return ok(String.valueOf(order.getSum()));
    }

    public final static Form<User> userForm = form(User.class);

    @Transactional
    public static Result submit() {
        Form<User> filledForm = userForm.bindFromRequest();
        Order order = CacheController.loadOrder();
        if (filledForm.hasErrors()) {
            return badRequest(cart.render(order, filledForm));
        } else {
            User user = filledForm.get();
            order.setCustomerAddress(user.address);
            order.setCustomerName(user.username);
            order.setCustomerPhone(user.phone);
            CacheController.deleteOrder(order);
            return ok(cart.render(order, filledForm));
        }
    }
}
