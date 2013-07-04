package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.controller.api.Beer30ServiceBasedRestController;
import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.model.api.v1.StatusType;
import com.github.darogina.beer30.service.StatusTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("/api/v1/statusType")
public class StatusTypeAPIv1Controller extends Beer30ServiceBasedRestController<StatusType, Long, StatusTypeService> {

    @Override @Inject
    public void setService(StatusTypeService service) {
        this.service = service;
    }

    @Override
    public BaseEntity toEntity(StatusType model) {
        if (model == null) {
            return null;
        }

        return modelMapper.map(model, com.github.darogina.beer30.entity.StatusType.class);
    }
}
