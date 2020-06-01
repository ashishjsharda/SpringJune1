package com.example.shoppingcart.cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CartController {
    static Map<Integer,Product> productMap=new HashMap<Integer, Product>();
    static {
        Product fruits = new Product();
        fruits.setId(1);
        fruits.setName("Banana");
        productMap.put(1,fruits);

        Product grocery = new Product();
        grocery.setId(2);
        grocery.setName("Wheat");
        productMap.put(2,grocery);

    }

    @RequestMapping(value = "/productList")
    public ResponseEntity getProducts(){
        return new ResponseEntity<>(productMap.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addproduct",method = RequestMethod.POST)
    public ResponseEntity addProducts(@RequestBody Product product){
        productMap.put(product.getId(),product);
        return new ResponseEntity<>("New Product is added successfully", HttpStatus.CREATED);
    }


}
