package daos;

import models.DishSort;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 14.04.13
 * Time: 2:46
 * To change this template use File | Settings | File Templates.
 */
public class DishSortDao extends GenericDaoJPAImpl<DishSort, Integer> {
    public DishSortDao(Class type) {
        super(type);
    }

    public List<DishSort> getAll()
    {
        Query query = em.createQuery("select ds from DishSort ds");
        return query.getResultList();
    }
}
