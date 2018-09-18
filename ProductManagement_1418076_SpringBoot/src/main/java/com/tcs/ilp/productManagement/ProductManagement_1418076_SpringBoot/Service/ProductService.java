package com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Model.Product;
import com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Repo.ProductRepository;

@Component
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public boolean addProduct(Product product) {
		Product addedProduct = null;
		boolean result = false;
		addedProduct = productRepository.save(product);
		if (addedProduct != null) {
			result = true;
		}
		return result;
	}

	public boolean deleteProduct(Product product) {
		boolean result = false;
		if (product != null) {
			productRepository.delete(product);
			result = true;
		}
		return result;
	}

	public boolean updateProduct(Product product) {
		boolean result = false;
		if (product != null) {
			productRepository.save(product);
			result = true;
		}
		return result;
	}

	public boolean checkProduct(int productId) {
		boolean result = false;
		if (productId != 0) {
			result = productRepository.existsById(productId);
		}
		return result;
	}

	public Product viewProduct(int productId) {
		Product product = null;
		if (productId != 0) {
			product = productRepository.getOne(productId);
		}
		return product;
	}

	public ArrayList<Product> viewProducts() {
		ArrayList<Product> productList = new ArrayList<>();
		productList = (ArrayList<Product>) productRepository.findAll();
		return productList;
	}

}
