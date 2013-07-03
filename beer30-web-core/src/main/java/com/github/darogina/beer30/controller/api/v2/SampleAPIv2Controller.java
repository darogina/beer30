package com.github.darogina.beer30.controller.api.v2;

import com.github.darogina.beer30.controller.api.Beer30ServiceBasedRestController;
import com.github.darogina.beer30.model.api.v2.Sample;
import com.github.darogina.beer30.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("/api/v2/sample")
public class SampleAPIv2Controller extends Beer30ServiceBasedRestController<Sample, Long, SampleService> {

    @Override @Inject
    public void setService(SampleService service) {
        this.service = service;
    }

}
