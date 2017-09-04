package com.example.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elasticsearch.model.EsProduct;

public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long>{

}
