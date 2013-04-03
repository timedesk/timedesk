package org.timedesk.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.timedesk.entity.CompanySite;
import org.timedesk.web.util.ErrorHandler;
import org.timedesk.web.util.UrlEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "companysites", formBackingObject = CompanySite.class)
@RequestMapping("/companysites")
@Controller
public class CompanySiteController 
{
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid CompanySite companySite, BindingResult result, Model model, HttpServletRequest request) 
    {
        try
        {
        	if (!result.hasErrors()) 
        	{
        		companySite.persist();
        		return "redirect:/companysites/" + UrlEncoder.encodeUrlPathSegment(companySite.getId().toString(), request);
        	}
        }
        catch(Exception e)
        {
        	ErrorHandler.addError(companySite, result, e);        	
        }
        model.addAttribute("companySite", companySite);
        return "companysites/create";
    }
}
