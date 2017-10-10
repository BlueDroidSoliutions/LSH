package com.livesexhouse.DAO.impl;

import com.livesexhouse.DAO.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nstankovic
 */
public abstract class AbstractGenericDao<E extends Serializable> implements GenericDao<E> {

    private final Class<E> entityType;

    @Autowired
    private SessionFactory sessionFactory;

    protected AbstractGenericDao(Class<E> entityType) {
        this.entityType = entityType;
    }

    @Override
    public E findById(Long id) {
        return getCurrentSession().find(getEntityType(), id);
    }

    @Override
    public List<E> findAll() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(getEntityType());
        Root<E> root = criteriaQuery.from(getEntityType());
        CriteriaQuery<E> selectAllQuery = criteriaQuery.select(root);
        TypedQuery<E> allQuery = getCurrentSession().createQuery(selectAllQuery);
        return allQuery.getResultList();
    }

    @Override
    public void save(E entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(E entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(E entity) {
        getCurrentSession().remove(entity);
    }

    protected Class<E> getEntityType() {
        return entityType;
    }

    protected Session getCurrentSession() {
        return getSessionFactory().getCurrentSession();
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}