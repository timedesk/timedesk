/*
 *  Time Desk
 *  Project Resource Management System
 *  http://code.google.com/p/timedesk
 *   
 *  Masters in Enterprise Applications Development
 *  Sri Lanka Institute of Information Technology, Sri Lanka
 *  Sheffield Hallam University, United Kingdom
 *  
 *  History:
 *  2010 Dec 27 - Imesh - Created
 *
 */

package org.timedesk.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.timedesk.entity.Company;
import org.timedesk.web.util.ErrorHandler;
import org.timedesk.web.util.UrlEncoder;

@RooWebScaffold(path = "companies", formBackingObject = Company.class)
@RequestMapping("/companies")
@Controller
public class CompanyController 
{
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Company company, BindingResult result, Model model, HttpServletRequest request) 
	{
        try
        {
        	if (!result.hasErrors())
        	{
        		company.persist();
        		return "redirect:/companies/" + UrlEncoder.encodeUrlPathSegment(company.getId().toString(), request);
        	}
        }
        catch(Exception e)
        {
        	ErrorHandler.addError(company, result, e);        	
        }
        model.addAttribute("company", company);
        return "companies/create";
    }
}
