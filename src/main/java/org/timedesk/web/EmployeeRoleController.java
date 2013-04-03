package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.EmployeeRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "employeeroles", formBackingObject = EmployeeRole.class)
@RequestMapping("/employeeroles")
@Controller
public class EmployeeRoleController {
}
