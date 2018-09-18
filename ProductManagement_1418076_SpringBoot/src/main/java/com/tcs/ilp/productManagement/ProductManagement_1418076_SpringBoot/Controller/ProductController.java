package com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Model.Product;
import com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Hi";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addProduct(@RequestBody Product product) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = productService.addProduct(product);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = productService.updateProduct(product);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProduct(@RequestBody Product product) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = productService.deleteProduct(product);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/checkProduct/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkProduct(@PathVariable("productId") int productId) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = productService.checkProduct(productId);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
			return res;
		} else {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
			return res;
		}
	}

	@RequestMapping(value = "/viewProduct/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> viewProduct(@PathVariable("productId") int productId) {
		ResponseEntity<Product> res = null;
		Product tempProduct = productService.viewProduct(productId);
		if (tempProduct != null) {
			res = new ResponseEntity<Product>(tempProduct, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Product>> viewProducts() {
		ResponseEntity<ArrayList<Product>> res = null;
		ArrayList<Product> tempList = productService.viewProducts();
		if (tempList != null) {
			res = new ResponseEntity<ArrayList<Product>>(tempList, HttpStatus.OK);
		}
		return res;
	}

}
