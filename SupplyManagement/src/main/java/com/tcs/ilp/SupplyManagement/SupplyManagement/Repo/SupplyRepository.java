package com.tcs.ilp.SupplyManagement.SupplyManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.ilp.SupplyManagement.SupplyManagement.Model.Supply;

public interface SupplyRepository extends JpaRepository<Supply, String> {

	@Query(value="Select productId from Supply where productId = ?1", nativeQuery=true)
	Supply findByProductId(String productId);
	
	@Query(value="Select productId from Supply where productId = ?1", nativeQuery=true)
	Supply findByVendorId(String vendorId);
	
}
