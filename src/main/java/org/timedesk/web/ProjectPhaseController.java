package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.ProjectPhase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "projectphases", formBackingObject = ProjectPhase.class)
@RequestMapping("/projectphases")
@Controller
public class ProjectPhaseController {
}
