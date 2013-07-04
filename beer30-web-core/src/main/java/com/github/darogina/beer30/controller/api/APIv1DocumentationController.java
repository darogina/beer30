package com.github.darogina.beer30.controller.api;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/documentation")
public class APIv1DocumentationController extends ApiDocumentationController {

    public APIv1DocumentationController() {
        setBaseControllerPackage("com.github.darogina.beer30.controller.api");
//        List<String> controllerPackages = new ArrayList<String>();
//        controllerPackages.add("com.knappsack.swagger4springweb.controllers.additionalApi");
//        setAdditionalControllerPackages(controllerPackages);

        setBaseModelPackage("com.github.darogina.beer30.model.api");
//        List<String> modelPackages = new ArrayList<String>();
//        controllerPackages.add("com.knappsack.swagger4springweb.additionalModels");
//        setAdditionalModelPackages(modelPackages);

        setApiVersion("v1");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String documentation() {
        return "documentation";
    }
}