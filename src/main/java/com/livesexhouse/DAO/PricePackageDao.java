package com.livesexhouse.DAO;

import com.livesexhouse.model.PricePackage;

import java.util.List;

/**
 *
 * @author nstankovic
 */
public interface PricePackageDao extends GenericDao<PricePackage> {

    List<PricePackage> findAllActive();

}
