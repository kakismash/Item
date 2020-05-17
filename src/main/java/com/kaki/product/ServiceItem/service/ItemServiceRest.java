/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.product.ServiceItem.service;

import com.kaki.product.ServiceItem.model.Item;
import com.kaki.product.ServiceItem.model.Product;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author alfia
 */
@Service
public class ItemServiceRest implements ItemService{

    @Autowired
    private RestTemplate restTemplate;
    
    
    @Override
    public List<Item> findAll() {
        
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://localhost:8001/list", Product[].class));
        
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        
        Map<String, String> pathVariable = new HashMap<String, String>();
        pathVariable.put("id", id.toString());
        
        Product product = restTemplate.getForObject("http://localhost:8001/list/{id}", Product.class, pathVariable);
        
        return new Item(product, quantity);
    }
    
    
    
}
