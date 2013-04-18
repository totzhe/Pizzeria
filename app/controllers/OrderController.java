package controllers;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import models.Order;
import models.OrderItem;
import play.db.jpa.Transactional;
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
        String data = session("order");
        Order order = data == null? new Order() : new JSONDeserializer<Order>().deserialize(data);
        ServiceFactory.getInstance().getMakeOrderService().AddItem(order, id, quantity);
        JSONSerializer s = new JSONSerializer();
        session("order", s.deepSerialize(order));
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
        return ok(""+order.getSum());
    }

    @Transactional//(readOnly = true)
    public static Result removeItem(int id) {
        String data = session("order");
        if(data == null)
            return ok("0");
        Order order = new JSONDeserializer<Order>().deserialize(data);
        ServiceFactory.getInstance().getMakeOrderService().RemoveItem(order, id);
        JSONSerializer s = new JSONSerializer();
        session("order", s.deepSerialize(order));
        return ok(""+order.getSum());
    }
}
