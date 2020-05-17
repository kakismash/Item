/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.product.ServiceItem.client;

import com.kaki.product.ServiceItem.model.Product;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author alfia
 */
@FeignClient(name = "products-service", url="localhost:8001")
public interface ProductClient {
    
    
    @GetMapping("/list")
    public List<Product> list();
    
    @GetMapping("/list/{id}")
    public Product detail(@PathVariable Long id);
    
}
