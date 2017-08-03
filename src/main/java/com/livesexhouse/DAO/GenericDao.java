package com.livesexhouse.DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nstankovic
 */
public interface GenericDao<E extends Serializable> {

    E findById(Long id);

    List<E> findAll();

    void save(E entity);

    void update(E entity);

    void delete(E entity);

}
