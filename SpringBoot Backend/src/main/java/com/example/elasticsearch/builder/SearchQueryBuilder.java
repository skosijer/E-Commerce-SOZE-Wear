package com.example.elasticsearch.builder;

import java.util.Collection;
import java.util.Iterator;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.example.domain.Product;
import com.example.elasticsearch.model.EsProduct;
import com.example.elasticsearch.model.Users;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


//    public Collection<Users> getAll(String text) {
//
//        QueryBuilder query = QueryBuilders.boolQuery()
//                .should(
//                        QueryBuilders.queryStringQuery(text)
//                                .lenient(true)
//                                .field("name")
//                                .field("teamName")
//                ).should(QueryBuilders.queryStringQuery("*" + text + "*")
//                        .lenient(true)
//                        .field("name")
//                        .field("teamName"));
//
//        NativeSearchQuery build = new NativeSearchQueryBuilder()
//                .withQuery(query)
//                .build();
//
//        Collection<Users> userses = elasticsearchTemplate.queryForList(build, Users.class);
//
//        return userses;
//    }
    
    public Collection<EsProduct> getAllProducts(String text) {

        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                                .lenient(true)
                                .field("name")
                                .field("description")
                ).should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true)
                        .field("name")
                        .field("description"));
        
        //frases matching - (mozes da navodis i naziv i description rasparcan, hvata po recima (CELIM) -> moze i kombinacija za category npr;
        QueryBuilder qb = QueryBuilders.multiMatchQuery(text, "name", "description");
        
        //samo radi wildcard na jednu rec, vec na niz reci ne radi
        QueryBuilder qb1 = QueryBuilders.wildcardQuery("description", "*" + text + "*");
        
        //Combined search, radi lepo za range i radi sa jos jednim queriem
        RangeQueryBuilder qb2 = QueryBuilders.rangeQuery("price").from(10).to(2999).includeLower(true).includeUpper(true);
        BoolQueryBuilder combined = QueryBuilders.boolQuery();
        
        combined.must(qb1)
				.must(qb2);
        
        

        //you can add withMinScore here
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(combined)
                .build();

        Collection<EsProduct> products = elasticsearchTemplate.queryForList(build, EsProduct.class);

        return products;
    }
    
    public Collection<EsProduct> productsFirstSearch(String text, boolean name, boolean description, boolean category) {
    	
    	//if we search for classic + yours on fields description and category, the es will give advantage to the item that is least common 
    	
    	//phrases matching - (mozes da navodis i naziv i description rasparcan, hvata po recima (CELIM) -> moze i kombinacija za category npr;
    	QueryBuilder qb = null;
    	
    	
    	if(name)
    	{
    		qb = null;
    		qb = QueryBuilders.multiMatchQuery(text, "name");
    	}
    	
    	if(description)
    	{
    		qb = null;
    		qb = QueryBuilders.multiMatchQuery(text, "description");
    	}
    	
    	if(category)
    	{
    		qb = null;
    		qb = QueryBuilders.multiMatchQuery(text, "category");
    	}
    	
    	if(name & description)
    	{
    		qb = null;
    		qb = QueryBuilders.multiMatchQuery(text, "name", "description");
    	}
        
    	if(name & category)
    	{
    		qb = null;
    		qb = QueryBuilders.multiMatchQuery(text, "name", "category");
    	}
    	
    	if(description & category)
    	{
    		qb = null;
    		qb = QueryBuilders.multiMatchQuery(text, "description", "category");
    	}
    	
    	if(name & description & category)
    	{
    		qb = null;
    		qb = QueryBuilders.multiMatchQuery(text, "name", "description", "category");
    	}
    	
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(qb)
                .build();

        Collection<EsProduct> products = elasticsearchTemplate.queryForList(build, EsProduct.class);
        
    	return products;
    }
    
	public Collection<EsProduct> productsSecondSearch(String text, boolean name, boolean description, boolean category) {
	    	
//		 QueryBuilder qb = null;
//		 
//		 if(name)
//		 {
//			 qb = QueryBuilders.wildcardQuery("name", "*" + text + "*");
//		 }
//		 
//		 if(description)
//		 {
//			 qb = QueryBuilders.wildcardQuery("description", "*" + text + "*");
//		 }
//		 
//		 if(category)
//		 {
//			 qb = QueryBuilders.wildcardQuery("category", "*" + text + "*");
//		 }
		
		String[] substring = text.split(" ");
		String query = "";
		
		for (String string : substring) {
			query = query.concat(string.concat("~2 "));
		}
		
		QueryBuilder qb = QueryBuilders.simpleQueryStringQuery(query);
		 
		 NativeSearchQuery build = new NativeSearchQueryBuilder()
	                .withQuery(qb)
	                .build();

        Collection<EsProduct> products = elasticsearchTemplate.queryForList(build, EsProduct.class);
        
    	return products;
	}
	
	public Collection<EsProduct> productsThirdSearch(String text) {
		
		//example
		//godfather+part
		//Now, because we're "AND"ing together our two search terms by default, 
		//we'll only get The Godfather: Part II back since it's the only film that contains both terms.
		
		QueryBuilder simple = QueryBuilders.simpleQueryStringQuery(text);
				
		NativeSearchQuery build = new NativeSearchQueryBuilder()
        .withQuery(simple)
        .build();

	    Collection<EsProduct> products = elasticsearchTemplate.queryForList(build, EsProduct.class);
	    
		return products;		
	}
   
}