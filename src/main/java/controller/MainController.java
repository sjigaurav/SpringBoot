package controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import com.example.demo.Product;

@RestController
public class MainController {
	
	//Getting the value from Application.properties file
	@Value("${spring.application.name}")
	private String name;
	
	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	/*
	 * GET API
	 */
	@RequestMapping(value = "/greetings")
	public String name() {
		return "Gaurav";
	}

	/*
	 * Delete API
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		productRepo.remove(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	/*
	 * PUT API
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	/*
	 * POST API
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productRepo.put(product.getId(), product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	/*
	 * Get API
	 */
	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}

}