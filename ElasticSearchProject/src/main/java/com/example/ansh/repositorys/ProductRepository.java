package com.example.ansh.repositorys;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.ansh.beans.Product;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String>{

	List<Product> findByProductName(String productName);
	List<Product> findByProductDesc(String productDesc);
}
