package com.tcs.ilp.VendorManagement.VendorManagement.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.ilp.VendorManagement.VendorManagement.Model.Vendor;
import com.tcs.ilp.VendorManagement.VendorManagement.Repo.VendorRepository;

@Component
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	public boolean addVendor(Vendor vendor) {
		Vendor addedVendor = null;
		boolean result = false;
		addedVendor = vendorRepository.save(vendor);
		if (addedVendor != null) {
			result = true;
		}
		return result;
	}

	public boolean deleteVendor(Vendor vendor) {
		boolean result = false;
		if (vendor != null) {
			vendorRepository.delete(vendor);
			result = true;
		}
		return result;
	}

	public boolean updateVendor(Vendor vendor) {
		boolean result = false;
		if (vendor != null) {
			vendorRepository.save(vendor);
			result = true;
		}
		return result;
	}

	public boolean checkVendor(String vendorId) {
		boolean result = false;
		result = vendorRepository.existsById(vendorId);
		return result;
	}

	public Vendor viewVendor(String vendorId) {
		Vendor vendor = null;
		if (vendorId != null) {
			vendor = vendorRepository.getOne(vendorId);
		}
		return vendor;
	}

	public ArrayList<Vendor> viewVendors() {
		ArrayList<Vendor> vendorList = new ArrayList<>();
		vendorList = (ArrayList<Vendor>) vendorRepository.findAll();
		return vendorList;
	}

}
