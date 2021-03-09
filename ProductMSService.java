package com.infy.productMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.productMS.dto.ProductDTO;
import com.infy.productMS.entity.Product;
import com.infy.productMS.repository.ProductMSRepository;

@Service
public class ProductMSService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductMSRepository productRepo;
	
	public void addProduct(ProductDTO productDTO) {
		logger.info("Add request for product {}", productDTO);
		Product product = productDTO.createEntity();
		productRepo.save(product);
	}
	
	public void removeProduct(long prodId) {
		logger.info("Remove request for product {}", prodId);
		Optional<Product> product = productRepo.findById(prodId);
		if (product.isPresent()) {
			productRepo.deleteById(prodId);
		}
	}
	
//	public void updateStock(long prodId, long updatedStock) {
//		logger.info("Update Stock request for product {}", prodId);
//		Optional<Product> product = productRepo.findById(prodId);
//		if(product.isPresent()) {
//			productRepo.updateStock(prodId, updatedStock);
//		}		
//	}
		
	public List<ProductDTO> getAllProducts(){
		List<Product> products = productRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product product: products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}

		logger.info("Product details : {}", productDTOs);
		return productDTOs;
	}
	
	public List<ProductDTO> getSpecificProductByCategory(String category) {
		logger.info("Product details : {}", category);
		
		List<Product> products = productRepo.findByCategory(category);
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product product: products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}		
		return productDTOs;
		
	}
	
	public ProductDTO getSpecificProductById(long prodId) {
		logger.info("Product details : {}", prodId);
		ProductDTO productDTO = null;
		Optional<Product> optProduct = productRepo.findById(prodId);
		if (optProduct.isPresent()) {
			Product product = optProduct.get();
			productDTO = ProductDTO.valueOf(product);
		}
		return productDTO;

	}

	
	public List<ProductDTO> getSpecificProductByName(String productName) {
		logger.info("Product details : {}", productName);
		
		List<Product> products = productRepo.findByProductName(productName);
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product product: products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}		
		return productDTOs;
	}

}
