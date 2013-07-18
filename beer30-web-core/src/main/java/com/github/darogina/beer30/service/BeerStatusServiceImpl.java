package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.BeerStatus;
import com.github.darogina.beer30.repository.BeerStatusRepository;
import org.resthub.common.service.CrudServiceImpl;

import javax.inject.Inject;
import javax.inject.Named;

@Named("beerStatusService")
public class BeerStatusServiceImpl extends CrudServiceImpl<BeerStatus, Long, BeerStatusRepository> implements BeerStatusService {

    @Override @Inject
    public void setRepository(BeerStatusRepository beerStatusRepository) {
        super.setRepository(beerStatusRepository);
    }

}
