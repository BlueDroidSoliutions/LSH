package com.livesexhouse.DAO.impl;

import com.livesexhouse.DAO.OrderPaymentDao;
import com.livesexhouse.model.OrderPayment;
<<<<<<< .merge_file_yhau5C
import org.springframework.stereotype.Repository;

=======
import com.livesexhouse.model.PricePackage;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

>>>>>>> .merge_file_bj3Ene
/**
 *
 * @author nstankovic
 */
@Repository("orderPaymentDao")
public class OrderPaymentDaoImpl extends AbstractGenericDao<OrderPayment> implements OrderPaymentDao {

    protected OrderPaymentDaoImpl() {
        super(OrderPayment.class);
    }

<<<<<<< .merge_file_yhau5C
=======
    @Override
    public OrderPayment findByTransactionId(String transactionId) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<OrderPayment> criteriaQuery = criteriaBuilder.createQuery(getEntityType());
        Root<OrderPayment> root = criteriaQuery.from(getEntityType());
        CriteriaQuery<OrderPayment> queryByTransactionId = criteriaQuery.select(root).
                where(criteriaBuilder.equal(root.get("transactionId"), transactionId));
        TypedQuery<OrderPayment> query = getCurrentSession().createQuery(queryByTransactionId);
        return query.getSingleResult();
    }
>>>>>>> .merge_file_bj3Ene
}
