package org.timedesk.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.timedesk.entity.Employee;
import org.timedesk.entity.ProjectPhaseMember;
import org.timedesk.web.util.UrlEncoder;

@RooWebScaffold(path = "projectphasemembers", formBackingObject = ProjectPhaseMember.class)
@RequestMapping("/projectphasemembers")
@Controller
public class ProjectPhaseMemberController 
{
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid ProjectPhaseMember projectPhaseMember, BindingResult result, Model model, HttpServletRequest request) 
    {
        if (result.hasErrors()) 
        {
            model.addAttribute("projectPhaseMember", projectPhaseMember);
            addDateTimeFormatPatterns(model);
            return "projectphasemembers/create";
        }
        
        Employee employee = projectPhaseMember.getProjectMember().getEmployee();
        if(employee != null)
        {
        	// Check employee max allocation
	        Integer maxAllocation = employee.getMaxAllocation();
	        if(maxAllocation != null)
	        {
		        if(projectPhaseMember.getAllocation().intValue() > maxAllocation.intValue())
		        {
		        	ObjectError error = new ObjectError(projectPhaseMember.toString(), "Allocation should be less than or equal to Employee Max Allocation " + maxAllocation.intValue() + ".");
		        	result.addError(error);
		        	model.addAttribute("projectPhaseMember", projectPhaseMember);
		            addDateTimeFormatPatterns(model);
		            return "projectphasemembers/create";
		        }
		        // Check current allocation
		        Integer currentAllocation = employee.getCurrentAllocation();
		        if(currentAllocation != null)
		        {
			        int allowed = maxAllocation.intValue() - currentAllocation.intValue();
			        if((currentAllocation != null) && (projectPhaseMember.getAllocation().intValue() > allowed))
			        {
			        	ObjectError error = new ObjectError(projectPhaseMember.toString(), "Allocation should be less than or equal to Employee Remaining Allocation " + allowed + ".");
			        	result.addError(error);
			        	model.addAttribute("projectPhaseMember", projectPhaseMember);
			            addDateTimeFormatPatterns(model);
			            return "projectphasemembers/create";
			        }	 
		        }
	        }
        }        
        projectPhaseMember.persist();
        // Update employee current allocation
        int newAllocation = ((employee.getCurrentAllocation() != null) ? employee.getCurrentAllocation().intValue() : 0) + projectPhaseMember.getAllocation().intValue();
        employee.setCurrentAllocation(newAllocation);
        employee.persist();
        
        return "redirect:/projectphasemembers/" + UrlEncoder.encodeUrlPathSegment(projectPhaseMember.getId().toString(), request);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid ProjectPhaseMember projectPhaseMember, BindingResult result, Model model, HttpServletRequest request) 
    {
        if (result.hasErrors()) 
        {
            model.addAttribute("projectPhaseMember", projectPhaseMember);
            addDateTimeFormatPatterns(model);
            return "projectphasemembers/update";
        }
        
        Employee employee = projectPhaseMember.getProjectMember().getEmployee();
        if(employee != null)
        {
        	// Check employee max allocation
	        Integer maxAllocation = employee.getMaxAllocation();
	        if(maxAllocation != null)
	        {
		        if(projectPhaseMember.getAllocation().intValue() > maxAllocation.intValue())
		        {
		        	ObjectError error = new ObjectError(projectPhaseMember.toString(), "Allocation should be less than or equal to Employee Max Allocation " + maxAllocation.intValue() + ".");
		        	result.addError(error);
		        	model.addAttribute("projectPhaseMember", projectPhaseMember);
		            addDateTimeFormatPatterns(model);
		            return "projectphasemembers/create";
		        }
		        // Check current allocation
		        Integer currentAllocation = employee.getCurrentAllocation();
		        if(currentAllocation != null)
		        {
			        int allowed = maxAllocation.intValue() - currentAllocation.intValue();
			        if((currentAllocation != null) && (projectPhaseMember.getAllocation().intValue() > allowed))
			        {
			        	ObjectError error = new ObjectError(projectPhaseMember.toString(), "Allocation should be less than or equal to Employee Remaining Allocation " + allowed + ".");
			        	result.addError(error);
			        	model.addAttribute("projectPhaseMember", projectPhaseMember);
			            addDateTimeFormatPatterns(model);
			            return "projectphasemembers/create";
			        }	 
		        }
	        }
        }
        
        projectPhaseMember.merge();
        // Update employee current allocation
        int newAllocation = ((employee.getCurrentAllocation() != null) ? employee.getCurrentAllocation().intValue() : 0) + projectPhaseMember.getAllocation().intValue();
        employee.setCurrentAllocation(newAllocation);
        employee.persist();
        return "redirect:/projectphasemembers/" + UrlEncoder.encodeUrlPathSegment(projectPhaseMember.getId().toString(), request);
    }
}
