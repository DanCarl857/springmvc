package daniel.springframework.services;

import java.util.List;

/**
 * Created by daniel on 1/4/17.
 */
public interface CRUDService<T> {

    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
