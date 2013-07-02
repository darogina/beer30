package com.github.darogina.beer30.controller;

import javax.inject.Inject;
import javax.inject.Named;

import com.github.darogina.beer30.service.SampleService;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.resthub.web.controller.ServiceBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.darogina.beer30.entity.Sample;
import com.github.darogina.beer30.repository.SampleRepository;

@Controller
@RequestMapping(value = "/api/sample")
public class SampleController extends ServiceBasedRestController<Sample, Long, SampleService> {

    @Override @Inject
    public void setService(SampleService service) {
        this.service = service;
    }
}
