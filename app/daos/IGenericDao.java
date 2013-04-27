package daos;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Artyom
 * Date: 06.04.13
 * Time: 1:01
 * To change this template use File | Settings | File Templates.
 */
public interface IGenericDao<T, PK extends Serializable> {

    /** Сохранить объект newInstance в базе данных */
    void create(T newInstance);

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T read(PK id);

    /** Сохранить изменения, сделанные в объекте.  */
    void update(T object);

    /** Удалить объект из базы данных */
    void delete(T object);
}
