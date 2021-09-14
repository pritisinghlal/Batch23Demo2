package com.example.ansh.services;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.ansh.beans.Product;
import com.example.ansh.repositorys.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	
	public Product create(Product product) {  
		return productRepository.save(product);
	}

	public Iterable<Product> findAllProduct() {
		return productRepository.findAll();
	}
	
	public Iterable<Product> findByProductName(String item) {
		return productRepository.findByProductName(item);
	}
	public Iterable<Product> findByProductDesc(String item) {
		return productRepository.search(QueryBuilders.matchQuery("productDesc", item ));
	}

	public List<Product> findByProductDescBytext(String item) {
		
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("productDesc", item)).build();
		
		List<Product> products = elasticsearchRestTemplate.queryForList(searchQuery, Product.class, IndexCoordinates.of("product_it"));
		
		return products;
	}
	
	
	public List<Product> findByProductPrice(String item) {
		
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("productPrice", item)).build();
		
		List<Product> products = elasticsearchRestTemplate.queryForList(searchQuery, Product.class, IndexCoordinates.of("product_it"));
		
		return products;
	}
	
	public List<Product> findByProductTQty(String item) {
		
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.rangeQuery("productTQty").gte(item)).build();
		
		List<Product> products = elasticsearchRestTemplate.queryForList(searchQuery, Product.class, IndexCoordinates.of("product_it"));
		
		return products;
	}
	
	
	public List<Product> findByProductDetail(String itemName, String itemQty) {
		
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery("productTQty").gte(itemQty))
													  .should(QueryBuilders.matchQuery("productDesc", itemName));
													//.mustNot(QueryBuilders.matchQuery("productDesc", itemName));
		
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		
		List<Product> products = elasticsearchRestTemplate.queryForList(searchQuery, Product.class, IndexCoordinates.of("product_it"));
		
		return products;
	}
}
