package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.controller.api.Beer30ServiceBasedRestController;
import com.github.darogina.beer30.model.api.v1.Sample;
import com.github.darogina.beer30.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping(value = "/api/v1/sample")
public class SampleAPIv1Controller extends Beer30ServiceBasedRestController<Sample, Long, SampleService> {

    @Override @Inject
    public void setService(SampleService service) {
        this.service = service;
    }

}
