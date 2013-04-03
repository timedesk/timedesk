package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.ApplicationFeature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "applicationfeatures", formBackingObject = ApplicationFeature.class)
@RequestMapping("/applicationfeatures")
@Controller
public class ApplicationFeatureController {
}
