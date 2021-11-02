package com.ecommerce.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.JWTConfiguration.AuthManager;
import com.ecommerce.JWTConfiguration.JwtTokenProvider;
import com.ecommerce.JWTConfiguration.UserPrincipal;
import com.ecommerce.controller.RequestPojo.ApiResponse;
import com.ecommerce.controller.RequestPojo.LoginRequest;
import com.ecommerce.model.User;
import com.ecommerce.service.UserServices.UserService;




@RestController
@RequestMapping("api")
public class LoginController {
	  @Autowired
	  UserDetailsService userDetailservice;
	  @Autowired
	  UserService userservice;
	  @Autowired
	  AuthManager aMan;
	  @Autowired
	 
      private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

      @RequestMapping("status")//post and get
  	public ResponseEntity<?> serverStatus() {
    	  return new ResponseEntity<>(new ApiResponse("Server is running.", ""), HttpStatus.OK);
   }
	@RequestMapping("login/user")//post and get
	public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest) {
		
		try {
			
     
    		
	        return new ResponseEntity<String>("login successfully", HttpStatus.OK);
    	}catch(Exception e ) {
    		logger.info("Error in authenticateUser ",e);
    		return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
    	}
		
	}	 
	
	private JSONObject getUserResponse(long token) {
		try {
	User user = userservice.getUserDetailById(token());
				HashMap<String,String> response = new HashMap<String,String>();
				response.put("user_id", ""+_getUserId());
				response.put("email", user.getEmail());
				response.put("name", user.getName());
				response.put("mobile", user.getMobile());
				
			
				JSONObject obj = new JSONObject();
				
				obj.put("user_profile_details",response);
				obj.put("token", token);
				return obj;
			} catch (Exception e) {
				logger.info("Error in getUserResponse ",e);
			}
	    	return null;
	    }
	 
	 	
	    
}
