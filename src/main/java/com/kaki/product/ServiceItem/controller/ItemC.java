/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.product.ServiceItem.controller;

import com.kaki.product.ServiceItem.model.Item;
import com.kaki.product.ServiceItem.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alfia
 */
@RestController
public class ItemC {
    
    @Autowired
    @Qualifier("serviceFeign")//select what service we should be use for ItemService Imple **@Primary 
    private ItemService itemService;
    
    
    @GetMapping("/list")
    public List<Item> list(){
        return itemService.findAll();
    }
    
    
    @GetMapping("list/{id}/quantity/{quantity}")
    public Item detail(@PathVariable Long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }
    
}
