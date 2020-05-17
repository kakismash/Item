/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.product.ServiceItem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author alfia
 */

@Configuration
public class AppConfig {
    
    @Bean(name = "restClient")
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }
    
}
