package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.response.RestResponse;
import com.example.service.BaketService;
import com.example.util.MyAppConstants;

@RestController
@RequestMapping("v1/basket")
public class MyAppController {

	@Autowired
	BaketService service;
	
	@Autowired
	RestResponse restReponse;
	
	@RequestMapping(value= "/add", method= RequestMethod.POST)
	public ResponseEntity<RestResponse> addProductToBasket(@RequestBody Product newProduct) {
		ResponseEntity<RestResponse> responseEntity = null;
		try {
			service.addItem(newProduct);
			responseEntity = new ResponseEntity<>(
					restReponse.build(HttpStatus.OK.value(),
							MyAppConstants.SUCCESS_ADDING_PRODUCT_CODE,
                            MyAppConstants.SUCCESS_ADDING_PRODUCT_MESSAGE,MyAppConstants.SUCCESS_ADDING_PRODUCT_MESSAGE),
                    HttpStatus.OK);
		}catch (Exception e) {
			responseEntity = new ResponseEntity<>(
					restReponse.build(HttpStatus.BAD_REQUEST.value(),
							MyAppConstants.FAILURE_ADDING_PRODUCT_CODE,
                            MyAppConstants.FAILURE_ADDING_PRODUCT_MESSAGE,e.getMessage()),
                    HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(value= "/{id}", method= RequestMethod.GET)
	public ResponseEntity<RestResponse> getProductFromBasket(@PathVariable int productId) {
		System.out.println("Getting Product from Basket");
		ResponseEntity<RestResponse> responseEntity = null;
		try {
			Product product=service.getItem(productId);
			responseEntity = new ResponseEntity<>(
					restReponse.build(HttpStatus.OK.value(),
							MyAppConstants.SUCCESS_GETTING_PRODUCT_CODE,
							product.toString(),MyAppConstants.SUCCESS_GETTING_PRODUCT_MESSAGE),
	                HttpStatus.OK);
			
		}catch (Exception e) {
			responseEntity = new ResponseEntity<>(
					restReponse.build(HttpStatus.BAD_REQUEST.value(),
							MyAppConstants.FAILURE_GETTING_PRODUCT_CODE,
                            MyAppConstants.FAILURE_GETTING_PRODUCT_MESSAGE,e.getMessage()),
                    HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value= "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<RestResponse> removeProductFromBasket(@PathVariable int id) {
		System.out.println("Remove Product from Basket");
		ResponseEntity<RestResponse> responseEntity = null;
		try {
			service.removeItem(id);
			responseEntity = new ResponseEntity<>(
					restReponse.build(HttpStatus.OK.value(),
							MyAppConstants.SUCCESS_DELETING_PRODUCT_CODE,
                            MyAppConstants.SUCCESS_DELETING_PRODUCT_MESSAGE,MyAppConstants.SUCCESS_DELETING_PRODUCT_MESSAGE),
                    HttpStatus.OK);
		}catch (Exception e) {
			responseEntity = new ResponseEntity<>(
					restReponse.build(HttpStatus.BAD_REQUEST.value(),
							MyAppConstants.FAILURE_DELETING_PRODUCT_CODE,
                            MyAppConstants.FAILURE_DELETING_PRODUCT_MESSAGE,e.getMessage()),
                    HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
}
