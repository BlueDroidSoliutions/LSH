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
<<<<<<< .merge_file_krBerp
        return null;
=======
        return getEntityDao().findById(id);
>>>>>>> .merge_file_TzIbCk
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
<<<<<<< .merge_file_krBerp
        return null;
=======
        return getEntityDao().findAll();
>>>>>>> .merge_file_TzIbCk
    }

    @Override
    @Transactional
    public void save(E entity) {
<<<<<<< .merge_file_krBerp

=======
        getEntityDao().save(entity);
>>>>>>> .merge_file_TzIbCk
    }

    @Override
    @Transactional
    public void update(E entity) {
<<<<<<< .merge_file_krBerp

=======
        getEntityDao().update(entity);
>>>>>>> .merge_file_TzIbCk
    }

    @Override
    @Transactional
    public void delete(E entity) {
<<<<<<< .merge_file_krBerp

=======
        getEntityDao().delete(entity);
>>>>>>> .merge_file_TzIbCk
    }

    protected abstract GenericDao<E> getEntityDao();

}
