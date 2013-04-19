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

/*public class SessionManager {

    private static JSONSerializer s = new JSONSerializer();

    public static void addSession(String key, Object value) {

        if(value != null) {
            Http.Session session = Http.Context.current().session();
            session.put(key, s.deepSerialize(value));
        } else {
            Logger.info("Value for " + key + " is null");
        }
    }

    public static <T> T get(String key) {

        Http.Session session = Http.Context.current().session();
        final String value = session.get(key);

        if (value == null) {
            return null;
        }

        return new JSONDeserializer<T>().deserialize(value);
    }

}*/

public class OrderController extends Controller {

    @Transactional
    public static Result addItem(int id, int quantity) {
        Order order = CacheController.loadOrder();
        ServiceFactory.getInstance().getMakeOrderService().AddItem(order, id, quantity);
        CacheController.saveOrder(order);
        //Нарандомить блюд
        /*GenericDao<Dish, Integer> dao = new GenericDao<Dish, Integer>(Dish.class);
        DishSortDao dao1 = new DishSortDao();
        for (int i = 1; i < 7; i++) {
            Dish d = new Dish();
            DishSort ds = dao1.read(id);
            d.setSort(ds);
            d.setName(ds.getName() + i);
            d.setDescription("Описание " + d.getName());
            d.setIngredients("Состав " + d.getName());
            d.setPicturePath("images/pizzas/null.jpg");
            d.setWeight(random.nextInt(1500)%1200);
            d.setPrice(random.nextInt(1500)%600);
            dao.create(d);
        } */
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

    @Transactional//(readOnly = true)
    public static Result removeItem(int id) {
        Order order = CacheController.loadOrder();
        ServiceFactory.getInstance().getMakeOrderService().RemoveItem(order, id);
        CacheController.saveOrder(order);
        return ok(String.valueOf(order.getSum()));
    }
}
