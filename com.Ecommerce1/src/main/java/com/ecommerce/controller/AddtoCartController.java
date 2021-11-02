package com.ecommerce.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.RequestPojo.ApiResponse;
import com.ecommerce.model.AddtoCart;
import com.ecommerce.service.CartService.CartService;

@RestController
@RequestMapping("/api/")
public class AddtoCartController {
	
	@Autowired
	CartService cartService;
	@RequestMapping("addProduct")
  	public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"productId","userId","qty","price"};
			
			long productId = Long.parseLong(addCartRequest.get("productId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			List<AddtoCart> obj = cartService.addCartbyUserIdAndProductId(productId,userId,qty,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
   }
	
	@RequestMapping("updateQtyForCart")
  	public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"cartId","userId","qty","price"};
			
			long cartId = Long.parseLong(addCartRequest.get("cartId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			 cartService.updateQtyByCartId(cartId, qty, price);
			 List<AddtoCart> obj = cartService.getCartByUserId(userId);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
   }
	
	
	@RequestMapping("removeProductFromCart")
  	public ResponseEntity<?> removeCartwithProductId(@RequestBody HashMap<String,String> removeCartRequest) {
		try {
			String keys[] = {"userId","cartId"};
			
			List<AddtoCart> obj = cartService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Long.parseLong(removeCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}		
   }
	
	@RequestMapping("getCartsByUserId")
  	public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String,String> getCartRequest) {
		try {
			String keys[] = {"userId"};
			
			List<AddtoCart> obj = cartService.getCartByUserId(Long.parseLong(getCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}	
   }
}
