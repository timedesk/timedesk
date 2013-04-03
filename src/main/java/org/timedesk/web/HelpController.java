package org.timedesk.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/help/**")
@Controller
public class HelpController {

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        return "help/index";
    }
}
