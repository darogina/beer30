package com.github.darogina.beer30;

import com.github.darogina.beer30.entity.Sample;
import com.github.darogina.beer30.repository.SampleRepository;
import org.resthub.common.util.PostInitialize;

import javax.inject.Inject;
import javax.inject.Named;

@Named("sampleInitializer")
public class SampleInitializer {

    @Inject
    @Named("sampleRepository")
    private SampleRepository sampleRepository;

    @PostInitialize
    public void init() {
        sampleRepository.save(new Sample("testSample1"));
        sampleRepository.save(new Sample("testSample2"));
        sampleRepository.save(new Sample("testSample3"));
        sampleRepository.save(new Sample("testSample4"));
        sampleRepository.save(new Sample("testSample5"));
        sampleRepository.save(new Sample("testSample6"));
        sampleRepository.save(new Sample("testSample7"));
        sampleRepository.save(new Sample("testSample8"));
        sampleRepository.save(new Sample("testSample9"));
        sampleRepository.save(new Sample("testSample10"));
        sampleRepository.save(new Sample("testSample11"));
        sampleRepository.save(new Sample("testSample12"));
        sampleRepository.save(new Sample("testSample13"));
        sampleRepository.save(new Sample("testSample14"));
        sampleRepository.save(new Sample("testSample15"));
        sampleRepository.save(new Sample("testSample16"));
        sampleRepository.save(new Sample("testSample17"));
        sampleRepository.save(new Sample("testSample18"));

    }
}
