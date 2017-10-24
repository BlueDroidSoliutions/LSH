package com.livesexhouse.service;

import com.livesexhouse.model.PricePackage;

import java.util.List;

/**
 *
 * @author nstankovic
 */
public interface PricePackageService extends GenericService<PricePackage> {

    List<PricePackage> findAllActive();
    
    PricePackage findVipMembershipPackage();
    
}