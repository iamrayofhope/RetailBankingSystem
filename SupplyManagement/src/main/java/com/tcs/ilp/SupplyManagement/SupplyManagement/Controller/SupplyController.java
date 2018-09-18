package com.tcs.ilp.SupplyManagement.SupplyManagement.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ilp.SupplyManagement.SupplyManagement.Model.Supply;
import com.tcs.ilp.SupplyManagement.SupplyManagement.Service.SupplyService;

@RestController
public class SupplyController {

	@Autowired
	private SupplyService supplyService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Hi";
	}

	@RequestMapping(value = "/addSupply", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addProduct(@RequestBody Supply supply) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = supplyService.addSupply(supply);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return res;
	}

	@RequestMapping(value = "/checkProduct/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteProduct(@PathVariable String productId) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = supplyService.checkProduct(productId);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return res;
	}

	@RequestMapping(value = "/checkVendor/{vendorId}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkProduct(@PathVariable("vendorId") String vendorId) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = supplyService.checkVendor(vendorId);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return res;
	}

	@RequestMapping(value = "/viewSupply/{supplyId}", method = RequestMethod.GET)
	public ResponseEntity<Supply> viewProduct(@PathVariable("supplyId") String supplyId) {
		ResponseEntity<Supply> res = null;
		Supply tempProduct = supplyService.viewSupply(supplyId);
		if (tempProduct != null) {
			res = new ResponseEntity<Supply>(tempProduct, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/viewSupplies", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Supply>> viewProducts() {
		ResponseEntity<ArrayList<Supply>> res = null;
		ArrayList<Supply> tempList = supplyService.viewSupplies();
		if (tempList != null) {
			res = new ResponseEntity<ArrayList<Supply>>(tempList, HttpStatus.OK);
		}
		return res;
	}

}
