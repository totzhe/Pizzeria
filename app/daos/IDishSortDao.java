package daos;

import models.DishSort;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 17.04.13
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public interface IDishSortDao extends IGenericDao<DishSort, Integer> {
    List<DishSort> getAll();
}
