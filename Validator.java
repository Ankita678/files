package com.infy.productMS.validator;

import com.infy.productMS.dto.ProductDTO;

public class Validator {
	
	public static void validateAdd(ProductDTO productDTO) throws Exception {
		
		if(!Validator.validateName(productDTO.getProductname())) {
			throw new Exception("Validator.INVALID_NAME");
		}		
		if(productDTO.getDesc().length() > 500) {
			throw new Exception("Validator.INVALID_DESCRIPTION");
		}
		if(productDTO.getPrice() < 200) {
			throw new Exception("Validator.INVALID_PRICE");
		}
		if(!Validator.validateStock(productDTO.getStock())) {
			throw new Exception("Validator.INVALID_STOCK");
		}
		if(!Validator.validateImage(productDTO.getImage())){
			throw new Exception("Validator.INVALID_IMAGE");
		}
		
	}
	
	public static boolean validateName(String productName) {
		int len = productName.length();
//		char firstChar = productName.charAt(0);
//		char lastChar = productName.charAt(len-1);
		String regex = "[a-zA-Z]+[a-zA-Z' ']+[a-zA-Z]+";
		if(productName.matches(regex) && len <= 100) {
			return true;
		}
		return false;
	}
	
	public static boolean validateImage(String image) {
		//int len = 
		//String imageType =image.substring()
		return false;
	}
	
	public static boolean validateStock(long stock) {
		if(stock >= 10) {
			return true;
		}
		return false;
	}


}
