package com.tcs.ilp.VendorManagement.VendorManagement.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ilp.VendorManagement.VendorManagement.Model.Vendor;
import com.tcs.ilp.VendorManagement.VendorManagement.Service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Hi";
	}

	@RequestMapping(value = "/addVendor", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addVendor(@RequestBody Vendor vendor) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = vendorService.addVendor(vendor);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/updateVendor", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateVendor(@RequestBody Vendor vendor) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = vendorService.updateVendor(vendor);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/deleteVendor", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteVendor(@RequestBody Vendor vendor) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = vendorService.deleteVendor(vendor);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/checkVendor/{vendorId}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> checkVendor(@PathVariable("vendorId") String vendorId) {
		ResponseEntity<Boolean> res = null;
		boolean result = false;
		result = vendorService.checkVendor(vendorId);
		if (result) {
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} else
			res = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return res;
	}

	@RequestMapping(value = "/viewVendor/{vendorId}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> viewVendor(@PathVariable("vendorId") String vendorId) {
		ResponseEntity<Vendor> res = null;
		Vendor tempVendor = vendorService.viewVendor(vendorId);
		if (tempVendor != null) {
			res = new ResponseEntity<Vendor>(tempVendor, HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping(value = "/viewVendors", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Vendor>> viewVendors() {
		ResponseEntity<ArrayList<Vendor>> res = null;
		ArrayList<Vendor> tempList = vendorService.viewVendors();
		if (tempList != null) {
			res = new ResponseEntity<ArrayList<Vendor>>(tempList, HttpStatus.OK);
		}
		return res;
	}

}
