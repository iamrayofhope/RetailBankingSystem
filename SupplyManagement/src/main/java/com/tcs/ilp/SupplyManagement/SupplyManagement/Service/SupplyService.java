package com.tcs.ilp.SupplyManagement.SupplyManagement.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tcs.ilp.SupplyManagement.SupplyManagement.Model.Supply;
import com.tcs.ilp.SupplyManagement.SupplyManagement.Repo.SupplyRepository;

@Component
public class SupplyService {

	@Autowired
	private SupplyRepository supplyRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancer;

	public boolean addSupply(Supply supply) {
		boolean checkVendor = false;
		boolean checkProduct = false;
		boolean result = false;

		ServiceInstance serviceInstance = loadBalancer.choose("zuul-service");
		String vendorUrl = serviceInstance.getUri().toString();
		vendorUrl = vendorUrl + "/api/vms/VendorManagement-service/" + supply.getVendorId();

		String productUrl = serviceInstance.getUri().toString();
		productUrl = productUrl + "/api/pms/ProductManagement-service/" + supply.getProductId();

		ResponseEntity<Boolean> responseEntity = restTemplate
				.getForEntity(vendorUrl, Boolean.class);
		checkVendor = responseEntity.getBody();
		ResponseEntity<Boolean> responseEntity1 = restTemplate
				.getForEntity(productUrl, Boolean.class);
		checkProduct = responseEntity1.getBody();
		if (checkVendor && checkProduct) {
			supplyRepository.save(supply);
			result = true;
		}
		return result;
	}

	public boolean deleteSupply(Supply supply) {
		boolean result = false;
		if (supply != null) {
			supplyRepository.delete(supply);
			result = true;
		}
		return result;
	}

	public boolean checkProduct(String productId) {
		boolean result = false;
		if (productId != null) {
			supplyRepository.findByProductId(productId);
			result = true;
		}
		return result;
	}

	public boolean checkVendor(String vendorId) {
		boolean result = false;
		if (vendorId != null) {
			supplyRepository.findByVendorId(vendorId);
			result = true;
		}
		return result;
	}

	public Supply viewSupply(String supplyId) {
		Supply supply = null;
		if (supplyId != null) {
			supply = supplyRepository.getOne(supplyId);
		}
		return supply;
	}

	public ArrayList<Supply> viewSupplies() {
		ArrayList<Supply> supplyList = new ArrayList<>();
		supplyList = (ArrayList<Supply>) supplyRepository.findAll();
		return supplyList;
	}

}
