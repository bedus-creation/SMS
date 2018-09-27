package com.app.Controllers;


import com.api.dao.CategoryDAO;
import com.api.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/hello")
public class PageController {

    @Autowired
    private CategoryDAO categoryDAO;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("categories",categoryDAO.list());
        model.addAttribute("title", "Home Page");
        return "Hello";
    }
}