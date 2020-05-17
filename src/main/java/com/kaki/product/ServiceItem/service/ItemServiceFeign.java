/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.product.ServiceItem.service;

import com.kaki.product.ServiceItem.model.Item;
import com.kaki.product.ServiceItem.service.ItemService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.kaki.product.ServiceItem.client.ProductClient;

/**
 *
 * @author alfia
 */
@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService{

    
    @Autowired
    private ProductClient clientRest;
    
    @Override
    public List<Item> findAll() {
        return clientRest.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(clientRest.detail(id), quantity);
    }
    
}
