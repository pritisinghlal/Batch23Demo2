package com.example.ansh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ansh.beans.Product;
import com.example.ansh.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/product")
@Api(value = "ProductController", description = "Rest api for search service by ")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	@ApiOperation(value = "Create product Information ", response = Product.class)
	public Product createProduct(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@GetMapping("/findAll")
	@ApiOperation(value = "Fetch all product Information ", response = Iterable.class)
	public Iterable<Product> findAllProduct() {
		return productService.findAllProduct();
	}
	
	@GetMapping("/findByProductName/{item}")
	@ApiOperation(value = "Fetch all product Information by product id ", response = Iterable.class)
	public Iterable<Product> findByProductName(@PathVariable String item) {
		return productService.findByProductName(item);
	}
	
	@GetMapping("/findByProductDesc/{item}")
	@ApiOperation(value = "Fetch all product Information by prodcut description ", response = Iterable.class)
	public Iterable<Product> findByProductDesc(@PathVariable String item) {
		return productService.findByProductDesc(item);
	}
	@GetMapping("/findByProductDescBytext/{item}")
	@ApiOperation(value = "Fetch all product Information by text", response = Iterable.class)
	public Iterable<Product> findByProductDescBytext(@PathVariable String item) {
		return productService.findByProductDescBytext(item);
	}
	@GetMapping("/findByProductPrice/{item}")
	@ApiOperation(value = "Fetch all product Information by product price ", response = Iterable.class)
	public Iterable<Product> findByProductPrice(@PathVariable String item) {
		return productService.findByProductPrice(item);
	}
	@GetMapping("/findByProductTQty/{item}")
	@ApiOperation(value = "Fetch all product Information by product quantity ", response = Iterable.class)
	public Iterable<Product> findByProductTQty(@PathVariable String item) {
		return productService.findByProductTQty(item);
	}
	
	@GetMapping("/findByProductDetail")
	@ApiOperation(value = "Fetch all product Information by multiple input parameter", response = Iterable.class)
	public Iterable<Product> findByProductDetail(@RequestParam String itemName, @RequestParam String itemQty ) {
		return productService.findByProductDetail(itemName, itemQty);
	}
}
