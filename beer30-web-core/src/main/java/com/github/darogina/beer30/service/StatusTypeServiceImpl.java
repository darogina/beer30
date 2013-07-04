package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.StatusType;
import com.github.darogina.beer30.repository.StatusTypeRepository;
import org.resthub.common.service.CrudServiceImpl;

import javax.inject.Inject;
import javax.inject.Named;

@Named("statusTypeService")
public class StatusTypeServiceImpl extends CrudServiceImpl<StatusType, Long, StatusTypeRepository> implements StatusTypeService {

    @Override @Inject
    public void setRepository(StatusTypeRepository statusTypeRepository) {
        super.setRepository(statusTypeRepository);
    }

}
