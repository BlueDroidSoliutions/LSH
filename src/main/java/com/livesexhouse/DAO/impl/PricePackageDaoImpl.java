package com.livesexhouse.DAO.impl;

import com.livesexhouse.DAO.PricePackageDao;
import com.livesexhouse.model.PricePackage;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author nstankovic
 */
@Repository("pricePackageDao")
public class PricePackageDaoImpl extends AbstractGenericDao<PricePackage> implements PricePackageDao {

    protected PricePackageDaoImpl() {
        super(PricePackage.class);
    }

    @Override
    public List<PricePackage> findAllActive() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<PricePackage> criteriaQuery = criteriaBuilder.createQuery(getEntityType());
        Root<PricePackage> root = criteriaQuery.from(getEntityType());
        CriteriaQuery<PricePackage> selectAllQuery = criteriaQuery.select(root).
                where(criteriaBuilder.equal(root.get("active"), Boolean.TRUE));
        TypedQuery<PricePackage> allQuery = getCurrentSession().createQuery(selectAllQuery);
        return allQuery.getResultList();
    }
}