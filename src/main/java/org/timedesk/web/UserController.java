package org.timedesk.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.timedesk.entity.User;

@RooWebScaffold(path = "users", formBackingObject = User.class)
@RequestMapping("/users")
@Controller
public class UserController 
{	
	@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
    public String show(Model model) 
    {		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();				
		model.addAttribute("user", User.findUser(username));
	    model.addAttribute("itemId", username);
	    return "users/show";				
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") String id, Model model) 
    {		
		if(isNumber(id))
		{
			Long numberValue = Long.valueOf(id);
	        model.addAttribute("user", User.findUser(numberValue));
	        model.addAttribute("itemId", id);
	        return "users/show";
		}
		else
		{
			model.addAttribute("user", User.findUser(id));
	        model.addAttribute("itemId", id);
	        return "users/show";
		}		
    }
	
	private boolean isNumber(String value)
	{
		try
		{
			Integer.parseInt(value);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}
