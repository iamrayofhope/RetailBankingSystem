package com.tcs.ilp.VendorManagement.VendorManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ilp.VendorManagement.VendorManagement.Model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, String> {

}
