package com.livesexhouse.service.impl;

import com.livesexhouse.DAO.GenericDao;
import com.livesexhouse.service.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nstankovic
 */
public abstract class AbstractGenericService<E extends Serializable> implements GenericService<E> {

    @Override
    @Transactional(readOnly = true)
    public E findById(Long id) {
        return getEntityDao().findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return getEntityDao().findAll();
    }

    @Override
    @Transactional
    public void save(E entity) {
        getEntityDao().save(entity);
    }

    @Override
    @Transactional
    public void update(E entity) {
        getEntityDao().update(entity);
    }

    @Override
    @Transactional
    public void delete(E entity) {
        getEntityDao().delete(entity);
    }

    protected abstract GenericDao<E> getEntityDao();

}