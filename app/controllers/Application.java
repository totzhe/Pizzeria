package controllers;

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
        Order order = CacheController.loadOrder();
        return ok(index.render(ServiceFactory.getInstance().getShowMenuService().getDishSorts(), order.getSum()));
    }

    static java.util.Random random = new java.util.Random();

    @Transactional
    public static Result menu(int id) {
        Order order = CacheController.loadOrder();
        List<Integer> selectedItems = new LinkedList<Integer>();

        for (Iterator<OrderItem> i = order.getItems().iterator(); i.hasNext(); ) {
            OrderItem item = i.next();
            selectedItems.add(item.getDishId());
        }
        return ok(menu.render(id, ServiceFactory.getInstance().getShowMenuService().getDishSorts(),
                ServiceFactory.getInstance().getShowMenuService().getDishSortById(id).getDishes(),
                selectedItems, order.getSum()));
    }

    public static Result user(Long id) {
        return ok("You selected id = " + id);
    }

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

    final static Form<User> userForm = form(User.class);

    @Transactional
    public static Result cart() {
        Order order = CacheController.loadOrder();
        return ok(cart.render(order, userForm));
    }

    @Transactional
    public static Result submit() {
        Form<User> filledForm = userForm.bindFromRequest();
        Order order = CacheController.loadOrder();

        if(filledForm.hasErrors()) {
            return badRequest(cart.render(order, filledForm));
        } else {
            User created = filledForm.get();
            return ok(cart.render(order, filledForm));
        }
    }

    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
                Routes.javascriptRouter("jsRoutes",
                        // Routes
                        //controllers.routes.javascript.Application.JsonExample(),
                        //controllers.routes.javascript.Application.JsonExampleGET(),
                        //controllers.routes.javascript.Application.JsonExamplePOST(),
                        controllers.routes.javascript.Application.user(),
                        controllers.routes.javascript.OrderController.addItem(),
                        controllers.routes.javascript.OrderController.editItem(),
                        controllers.routes.javascript.OrderController.removeItem()
                )
        );
    }
}