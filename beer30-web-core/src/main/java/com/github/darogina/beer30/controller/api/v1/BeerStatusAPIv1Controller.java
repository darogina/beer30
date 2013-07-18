package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.controller.api.Beer30ServiceBasedRestController;
import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.entity.StatusType;
import com.github.darogina.beer30.entity.User;
import com.github.darogina.beer30.model.api.v1.BeerStatus;
import com.github.darogina.beer30.service.BeerStatusService;
import com.github.darogina.beer30.service.StatusTypeService;
import com.github.darogina.beer30.service.UserService;
import org.modelmapper.AbstractConverter;
import org.modelmapper.PropertyMap;
import org.resthub.common.exception.NotImplementedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Controller
@RequestMapping("/api/v1/beerStatus")
public class BeerStatusAPIv1Controller extends Beer30ServiceBasedRestController<BeerStatus, Long, BeerStatusService> {

    @Inject
    private UserService userService;

    @Inject
    private StatusTypeService statusTypeService;

    @Override @Inject
    public void setService(BeerStatusService service) {
        this.service = service;
    }

    @Override
    public BeerStatus update(@PathVariable Long aLong, @RequestBody BeerStatus resource) {
        throw new NotImplementedException("Update is currently not implemented");
    }

    @Override
    public void delete(@PathVariable Long aLong) {
        throw new NotImplementedException("Delete is currently not implemented");
    }

    @Override
    public BaseEntity toEntity(BeerStatus model) {
        if (model == null) {
            return null;
        }

        return modelMapper.map(model, com.github.darogina.beer30.entity.BeerStatus.class);
    }

    @PostConstruct
    private void init() {
        // Setup custom mapping
        modelMapper.addMappings(new PropertyMap<BeerStatus, com.github.darogina.beer30.entity.BeerStatus>() {
            @Override
            protected void configure() {
                using(new AbstractConverter<Long, StatusType>() {
                    @Override
                    protected StatusType convert(Long source) {
                        return statusTypeService.findById(source);
                    }
                }).map(source.getStatusTypeId()).setStatusType(null);

                using(new AbstractConverter<Long, User>() {
                    @Override
                    protected User convert(Long source) {
                        return userService.findById(source);
                    }
                }).map(source.getUserId()).setUser(null);
            }
        });
    }
}
