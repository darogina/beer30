package com.github.darogina.beer30.service;

import com.github.darogina.beer30.entity.Sample;
import com.github.darogina.beer30.repository.SampleRepository;
import org.resthub.common.service.CrudServiceImpl;

import javax.inject.Inject;
import javax.inject.Named;

@Named("sampleService")
public class SampleServiceImpl extends CrudServiceImpl<Sample, Long, SampleRepository> implements SampleService {

    @Override @Inject
    public void setRepository(SampleRepository sampleRepository) {
        super.setRepository(sampleRepository);
    }

}
