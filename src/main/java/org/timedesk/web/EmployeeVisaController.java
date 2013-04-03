package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.EmployeeVisa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "employeevisas", formBackingObject = EmployeeVisa.class)
@RequestMapping("/employeevisas")
@Controller
public class EmployeeVisaController {
}
