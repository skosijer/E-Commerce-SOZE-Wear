package com.example.controller;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Category;
import com.example.service.CategoryService;
import com.example.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService = new CategoryService();
	
	@Autowired
	ProductService productService = new ProductService();
	
	 @RequestMapping(
		 		value = "/getCategories",
		 		method = RequestMethod.GET,
		 		produces = MediaType.APPLICATION_JSON_VALUE
		 		)
		 public ResponseEntity<Collection<Category>> getAllProducts(){
			
		 	Collection<Category> categories = categoryService.findAll();
			
		 	if(categories == null){
		 		return new ResponseEntity<Collection<Category>>(HttpStatus.NOT_FOUND);
		 	}
		 	return new ResponseEntity<Collection<Category>>(categories,HttpStatus.OK);
		 }
	 
	@RequestMapping(value="/addCategory",
				method = RequestMethod.POST,
				produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean addCategory(@RequestBody Category category)
	{
		 System.out.println(category.getId() + "Cat name " + category.getName() + " desc " + category.getDescription());
		 categoryService.create(category);
		 
		 return true;
	}
	 
	@RequestMapping(value="/deleteCategory",
				method = RequestMethod.POST,
				produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean deleteCategory(@RequestBody String category_id)
	{
//		 Page<Product> products = productService.findAllByCategory(Long.decode(category_id));
//		 
//		 Iterator<Product> iterator = products.iterator();
//		 
//		 while(iterator.hasNext())
//			{
//				productService.delete(iterator.next().getId());
//			}

		 categoryService.delete(Long.decode(category_id));
		 return true;
	} 
}
