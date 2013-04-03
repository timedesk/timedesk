package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.EmployeeLeave;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "employeeleaves", formBackingObject = EmployeeLeave.class)
@RequestMapping("/employeeleaves")
@Controller
public class EmployeeLeaveController {
}
