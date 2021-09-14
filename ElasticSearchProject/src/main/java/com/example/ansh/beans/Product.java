package com.example.ansh.beans;

import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(indexName = "product_it", type = "it")
public class Product {
	@ApiModelProperty(notes = "Product Id", name = "id", required = false)
	private String id;
	@ApiModelProperty(notes = "Product Name", name = "id", required = true)
	private String productName;
	@ApiModelProperty(notes = "Product Price", name = "id", required = true)
	private Long productPrice;
	@ApiModelProperty(notes = "Product Description", name = "id", required = true)
	private String productDesc;
	@ApiModelProperty(notes = "Product Qty", name = "id", required = true)
	private Long productTQty;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Long getProductTQty() {
		return productTQty;
	}
	public void setProductTQty(Long productTQty) {
		this.productTQty = productTQty;
	}
	
	
	
}
