package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BasketDAORespository;
import com.example.model.Product;

@Service
public class BasketServiceImpl implements BaketService {
	
	@Autowired
	BasketDAORespository dao;

	@Override
	public void addItem(Product product) {
		return dao.save(product);
	}

	@Override
	public Product getItem(int productId) {
		return dao.findById(productId);
	}

	@Override
	public void removeItem(int productId) {
		dao.deleteById(productId);
	}

}
