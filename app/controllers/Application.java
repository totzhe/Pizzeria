package controllers;

import daos.DaoFactory;
import daos.DishSortDao;
import daos.GenericDao;
import flexjson.JSONDeserializer;
import models.*;
import org.codehaus.jackson.JsonNode;
import play.*;
import play.api.templates.Html;
import play.data.Form;
import play.db.jpa.*;

import services.ServiceFactory;
import views.html.*;
import views.html.helper.form;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;
import flexjson.JSONSerializer;


public class Application extends Controller {
    @Transactional(readOnly = true)
    public static Result index() {
        return ok(index.render(ServiceFactory.getInstance().getShowMenuService().getDishSorts()));
    }

    static java.util.Random random = new java.util.Random();

    @Transactional//(readOnly = true)
    public static Result menu(int id) {
        /*GenericDao<Order, Integer> dao = new GenericDao<Order, Integer>(Order.class);
        Order o = new Order();
        o.setCustomerName("Тестов Тест Тестович");
        o.setCustomerAddress("ул. Тестовая, дом 0");
        o.setCustomerPhone("+71234567890");
        Date now = new Date();
        o.setRecievingTime(now);
        o.setSendingTime(now);
        dao.create(o);
        GenericDao<OrderItem, Integer> dao1 = new GenericDao<OrderItem, Integer>(OrderItem.class);
        OrderItem oi = new OrderItem();
        oi.setCost(50);
        oi.setDish(DaoFactory.getInstance().getDishDao().read(1));
        oi.setQuantity(1);
        oi.setOrderId(1);
        //dao1.create(oi);
        o.getItems().add(oi);
        //o.getItems().add(oi);
        DaoFactory.getInstance().getOrderDao().create(o); */

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
        String data = session("order");
        Order order = data == null ? new Order() : new JSONDeserializer<Order>().deserialize(data);
        List<Integer> selectedItems = new LinkedList<Integer>();

        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            selectedItems.add(item.getDishId());
        }
        return ok(menu.render(id, ServiceFactory.getInstance().getShowMenuService().getDishSortById(id).getDishes(), selectedItems));
    }

    public static Result user(Long id) {
        return ok("You selected id = " + id);
    }

    //final static Form<User> orderForm = form(User.class);

    /*public static Result blank() {
        return ok(form.render(orderForm));
    } */

    @BodyParser.Of(play.mvc.BodyParser.Json.class)
    @Transactional
    public static Result JsonExample() {
        response().setContentType("application/json");
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting Json data");
        } else {
            String name = json.findPath("name").getTextValue();
            if (name == null) {
                return badRequest("Missing parameter [name]");
            } else {
                List<DishSort> sorts = new DishSortDao().getAll();
                JSONSerializer serializer = new JSONSerializer().exclude("dishes", "class");
                return ok("Server received: " + json.toString() + System.getProperty("line.separator") + "Server sent: " + serializer.serialize(sorts));
            }
        }
    }

    @BodyParser.Of(play.mvc.BodyParser.Json.class)
    public static Result JsonExamplePOST() {
        response().setContentType("application/json");
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest("Expecting Json data");
        } else {
            String name = json.findPath("name").getTextValue();
            if (name == null) {
                return badRequest("Missing parameter [name]");
            } else {
                return ok("Server received: " + json.toString());
            }
        }
    }

    @Transactional
    public static Result JsonExampleGET() {
        List<DishSort> sorts = new DishSortDao().getAll();
        JSONSerializer serializer = new JSONSerializer().exclude("dishes", "class");
        return ok(serializer.serialize(sorts));
    }

    @Transactional
    public static Result cart() {
        Dish d;
        GenericDao<Dish, Integer> dao = new GenericDao<Dish, Integer>(Dish.class);

        //change dish sort
        d = dao.read(1);
        List<Dish> dishes = new LinkedList<Dish>();
        for (int i = 1; i < 4; i++) {
            dishes.add(d);
        }

        //User defaulUser = new User("name", "address", new User.Phone("01.23.45.67.89"));

        return ok(cart.render(dishes)/*, form.render(orderForm.fill(defaulUser))*/);
    }


    /*public static Result submit() {
        Form<User> filledForm = orderForm.bindFromRequest();

        if(filledForm.hasErrors()) {
            return badRequest(form.render(filledForm));
        } else {
            User created = filledForm.get();
            return ok();
        }
    } */

    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
                Routes.javascriptRouter("jsRoutes",
                        // Routes
                        controllers.routes.javascript.Application.JsonExample(),
                        controllers.routes.javascript.Application.JsonExampleGET(),
                        controllers.routes.javascript.Application.JsonExamplePOST(),
                        controllers.routes.javascript.Application.user(),
                        controllers.routes.javascript.OrderController.addItem(),
                        controllers.routes.javascript.OrderController.removeItem()
                )
        );
    }
}