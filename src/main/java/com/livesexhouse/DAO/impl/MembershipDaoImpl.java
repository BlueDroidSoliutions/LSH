package com.livesexhouse.DAO.impl;

import com.livesexhouse.DAO.MembershipDao;
import com.livesexhouse.model.Membership;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nstankovic
 */
@Repository("membershipDao")
public class MembershipDaoImpl extends AbstractGenericDao<Membership> implements MembershipDao {

    protected MembershipDaoImpl() {
        super(Membership.class);
    }

}