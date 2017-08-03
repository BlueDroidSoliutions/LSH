package com.livesexhouse.DAO.impl;

import com.livesexhouse.DAO.PricePackageDao;
import com.livesexhouse.model.PricePackage;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nstankovic
 */
@Repository("pricePackageDao")
public class PricePackageDaoImpl extends AbstractGenericDao<PricePackage> implements PricePackageDao {

    protected PricePackageDaoImpl() {
        super(PricePackage.class);
    }

}
