package daos;

import play.db.jpa.JPA;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 06.04.13
 * Time: 1:04
 * To change this template use File | Settings | File Templates.
 */
public class GenericDaoJPAImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {
    private Class<T> type;
    private EntityManager em;

    public GenericDaoJPAImpl(Class<T> type) {
        this.type = type;
        em = JPA.em();
    }

    public void create(T o) {
        em.persist(o);
    }

    public T read(PK id) {
        return (T) em.find(type, id);
    }

    public void update(T o) {
        //em.refresh(o);
        em.merge(o);
    }

    public void delete(T o) {
        em.remove(o);
    }
}