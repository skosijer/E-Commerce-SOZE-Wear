package com.example.elasticsearch.load;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import com.example.domain.Product;
import com.example.elasticsearch.model.EsProduct;
import com.example.elasticsearch.model.Users;
import com.example.elasticsearch.repository.EsProductRepository;
import com.example.elasticsearch.repository.UsersRepository;
import com.example.repository.ProductRepository;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;
    
    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    EsProductRepository esProductRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);
        System.out.println("Loading Data");
        
        
        List<Users> users = getData();
        
        List<Product> products = productRepository.findAll();
        Collection<EsProduct> esProducts = new ArrayList(); 
        
        for (Product product : products) {
			EsProduct p = new EsProduct();
			
			p.setId(product.getId());
			p.setName(product.getName());
			p.setDescription(product.getDescription());
			p.setCategory(product.getCategory().getName());
			p.setDiscount(product.getPrice_discount());
			p.setPrice(product.getPrice_id().getPrice_value());
			
			esProducts.add(p);
		}
        
        esProductRepository.save(esProducts);
        
        System.out.printf("Loading Completed");

    }

    private List<Users> getData() {
        List<Users> userses = new ArrayList<>();
        userses.add(new Users("Ajay",123L, "Accounting", 12000L));
        userses.add(new Users("Jaga",1234L, "Finance", 22000L));
        userses.add(new Users("Thiru",1235L, "Accounting", 12000L));
        return userses;
    }
}
