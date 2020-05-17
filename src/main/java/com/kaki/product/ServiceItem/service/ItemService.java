/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.product.ServiceItem.service;

import com.kaki.product.ServiceItem.model.Item;
import java.util.List;

/**
 *
 * @author alfia
 */
public interface ItemService {
    
    public List<Item> findAll();
    
    public Item findById(Long id, Integer quantity);
    
}
