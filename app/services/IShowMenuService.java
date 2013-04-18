package services;

import models.Dish;
import models.DishSort;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public interface IShowMenuService {
    List<DishSort> getDishSorts();

    DishSort getDishSortById(int id);

    Dish getDishById(int id);
}
