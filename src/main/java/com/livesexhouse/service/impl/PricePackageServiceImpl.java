package com.livesexhouse.service.impl;

import com.livesexhouse.DAO.GenericDao;
import com.livesexhouse.DAO.PricePackageDao;
import com.livesexhouse.model.PricePackage;
import com.livesexhouse.service.PricePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author nstankovic
 */
@Service("pricePackageService")
public class PricePackageServiceImpl extends AbstractGenericService<PricePackage> implements PricePackageService {

    @Autowired
    private PricePackageDao pricePackageDao;

    @Override
    @Transactional(readOnly = true)
    public List<PricePackage> findAllActive() {
        return getPricePackageDao().findAllActive();
    }

    @Override
    protected GenericDao<PricePackage> getEntityDao() {
        return getPricePackageDao();
    }

    private PricePackageDao getPricePackageDao() {
        return pricePackageDao;
    }
}