package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.controller.api.Beer30ServiceBasedRestController;
import com.github.darogina.beer30.entity.BaseEntity;
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

    @Override
    public BaseEntity toEntity(Sample model) {
        if (model == null) {
            return null;
        }

        return modelMapper.map(model, com.github.darogina.beer30.entity.StatusType.class);
    }
}
