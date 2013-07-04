package com.github.darogina.beer30.controller.api;

import com.github.darogina.beer30.entity.BaseEntity;
import com.github.darogina.beer30.model.api.ApiModel;
import org.jodah.typetools.TypeResolver;
import org.modelmapper.ModelMapper;
import org.resthub.common.service.CrudService;
import org.resthub.web.controller.ServiceBasedRestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Beer30ServiceBasedRestController<T extends ApiModel, ID extends Serializable, S extends CrudService> extends ServiceBasedRestController<T, ID, S> {

    Class<T> resourceClass;
    Class<ID> resourceIdClass;
    Class<S> serviceClass;
    protected ModelMapper modelMapper;

    @Override
    public T create(@RequestBody T resource) {
        return mapEntityToResourceClass((BaseEntity) service.create(toEntity(resource)));
    }

    @Override
    public T update(@PathVariable ID id, @RequestBody T resource) {
        return mapEntityToResourceClass((BaseEntity) super.update(id, resource));    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Iterable<T> findAllXml() {
        List<T> returnValues = new ArrayList<T>();

        for (Object element : super.findAllXml()) {
            returnValues.add(modelMapper.map(element, resourceClass));
        }

        return returnValues;
    }

    @Override
    public Iterable<T> findAll() {
        List<T> returnValues = new ArrayList<T>();

        for (Object element : service.findAll()) {
            returnValues.add(modelMapper.map(element, resourceClass));
        }

        return returnValues;
    }

    @Override
    public Page<T> findPaginated(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                 @RequestParam(value = "direction", required = false, defaultValue = "") String direction,
                                 @RequestParam(value = "properties", required = false) String properties) {
        Page unmappedPage = super.findPaginated(page, size, direction, properties);

        PageRequest pageRequest;
        if(direction.isEmpty()) {
            pageRequest = new PageRequest(page - 1, size);
        } else {
            Assert.notNull(properties);
            pageRequest = new PageRequest(page - 1, size, new Sort(Sort.Direction.fromString(direction.toUpperCase()), properties.split(",")));
        }

        List<T> returnValues = new ArrayList<T>();
        for (Object element : unmappedPage.getContent()) {
            returnValues.add(mapEntityToResourceClass((BaseEntity) element));
        }

        return new PageImpl<T>(returnValues, pageRequest, unmappedPage.getTotalElements());
    }

    @Override
    public T findById(@PathVariable ID id) {
        return mapEntityToResourceClass((BaseEntity) super.findById(id));
    }

    protected T mapEntityToResourceClass(BaseEntity entity) {
        return entity == null ? null : modelMapper.map(entity, resourceClass);
    }

    @PostConstruct
    private void init() {
        modelMapper = new ModelMapper();
        Class<?>[] typeArguments = TypeResolver.resolveRawArguments(Beer30ServiceBasedRestController.class, getClass());
        this.resourceClass = (Class<T>) typeArguments[0];
        this.resourceIdClass = (Class<ID>) typeArguments[1];
        this.serviceClass = (Class<S>) typeArguments[2];
    }

    public abstract BaseEntity toEntity(T model);
}
