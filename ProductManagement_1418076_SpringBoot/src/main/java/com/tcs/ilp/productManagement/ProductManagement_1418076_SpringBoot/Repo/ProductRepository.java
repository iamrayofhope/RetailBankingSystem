package com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ilp.productManagement.ProductManagement_1418076_SpringBoot.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
