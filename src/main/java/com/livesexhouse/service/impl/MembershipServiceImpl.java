package com.livesexhouse.service.impl;

import com.livesexhouse.DAO.GenericDao;
import com.livesexhouse.DAO.MembershipDao;
import com.livesexhouse.model.Membership;
import com.livesexhouse.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nstankovic
 */
@Service("membershipService")
public class MembershipServiceImpl extends AbstractGenericService<Membership> implements MembershipService {

    @Autowired
    private MembershipDao membershipDao;

    @Override
    protected GenericDao<Membership> getEntityDao() {
        return getMembershipDao();
    }

    private MembershipDao getMembershipDao() {
        return membershipDao;
    }
}