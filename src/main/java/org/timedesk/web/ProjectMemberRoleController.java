package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.ProjectMemberRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "projectmemberroles", formBackingObject = ProjectMemberRole.class)
@RequestMapping("/projectmemberroles")
@Controller
public class ProjectMemberRoleController {
}
