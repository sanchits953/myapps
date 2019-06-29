package com.example.service;

import com.example.model.Product;

public interface BaketService {
	
	public void addItem(Product product);
	
	public Product getItem(int productId);
	
	public void removeItem(int productId);

}
