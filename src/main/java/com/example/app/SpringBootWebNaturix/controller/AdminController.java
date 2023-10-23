package com.example.app.SpringBootWebNaturix.controller;

import com.example.app.SpringBootWebNaturix.entity.Order;
import com.example.app.SpringBootWebNaturix.entity.Product;
import com.example.app.SpringBootWebNaturix.entity.ProductDTO;
import com.example.app.SpringBootWebNaturix.service.OrderService;
import com.example.app.SpringBootWebNaturix.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("title", "Admin");
        model.addAttribute("orders", orderService.getAll());
        model.addAttribute("fragmentName", "admin-orders");
        return "layout";
    }

    @PostMapping("/changeOrderStatus")
    public ModelAndView changeOrderStatus(@ModelAttribute Order order) {
        orderService.changeStatus(order.getId());
        return new ModelAndView("redirect:/admin/orders");
    }

    @PostMapping("/deleteOrder")
    public ModelAndView deleteOrder(@ModelAttribute Order order) {
        orderService.delete(order.getId());
        return new ModelAndView("redirect:/admin/orders");
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("title", "Admin");
        model.addAttribute("products", productService.getAll());
        model.addAttribute("fragmentName", "admin-products");
        return "layout";
    }

    @PostMapping("/newProduct")
    public ModelAndView newProduct(@ModelAttribute ProductDTO product) {
        try {
            productService.add(product);
        } catch (IOException ignored) {
        }
        return new ModelAndView("redirect:/admin/products");
    }

    @PostMapping("/updateProduct")
    public ModelAndView updateProduct(@ModelAttribute ProductDTO product) {
        try {
            productService.update(product);
        } catch (IOException ignored) {
        }
        return new ModelAndView("redirect:/admin/products");
    }

    @PostMapping("/deleteProduct")
    public ModelAndView deleteProduct(@ModelAttribute Product product) {
        productService.delete(product.getId());
        return new ModelAndView("redirect:/admin/products");
    }

}
