package com.example.model;

import java.util.ArrayList;
import java.util.List;


public class Basket {
	
	private int id;
	private List<Product> productList=new ArrayList<Product>();
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
