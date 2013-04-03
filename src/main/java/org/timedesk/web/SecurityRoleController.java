package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.SecurityRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "securityroles", formBackingObject = SecurityRole.class)
@RequestMapping("/securityroles")
@Controller
public class SecurityRoleController {
}
