package com.example.app.SpringBootWebNaturix.controller;

import com.example.app.SpringBootWebNaturix.entity.Order;
import com.example.app.SpringBootWebNaturix.service.OrderService;
import com.example.app.SpringBootWebNaturix.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class UserController {

    private static final Logger LOGGER =
            Logger.getLogger(UserController.class.getName());

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("fragmentName", "home");
        return "layout";
    }

    @GetMapping("/contact")
    public String getContact(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("fragmentName", "contact");
        return "layout";
    }

    @GetMapping("/shop")
    public String getShop(Model model) {
        model.addAttribute("title", "Shop");
        model.addAttribute("products", productService.getAll());
        model.addAttribute("fragmentName", "shop");
        return "layout";
    }

    @PostMapping("/order")
    public ModelAndView makeOrder(@ModelAttribute Order order) {
        order.setStatus("NotDelivered");
        // Check data in logs
        LOGGER.info("User order data: " + order);
        orderService.makeOrder(order);
        return new ModelAndView("redirect:/contact");
    }
}
