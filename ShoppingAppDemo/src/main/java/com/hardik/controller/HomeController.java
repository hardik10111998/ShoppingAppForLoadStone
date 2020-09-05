package com.hardik.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hardik.model.Product;
import com.hardik.service.ProductService;



@Controller
public class HomeController {

	@Autowired
	public ProductService productService;
	
    @GetMapping("index")
    public String index(Model m){
    	List<Product> allProducts = productService.listAll();
    	m.addAttribute("products",allProducts);
    	System.out.println(allProducts);
        return "index";
    }
//    
//    @GetMapping("index")
//    public String index(Model m){
//    	Product allProducts = productService.get(1);
//    	m.addAttribute("prod",allProducts);
//    	System.out.println(allProducts);
//        return "index";
//    }
    
    @GetMapping("/addProduct")
    public String addProduct(){
        return "addProduct";
    }
}

