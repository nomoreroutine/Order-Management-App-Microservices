package com.elcproject.ProductService.controller;


import com.elcproject.ProductService.model.dto.ProductDto;
import com.elcproject.ProductService.model.dto.ResponseDto;
import com.elcproject.ProductService.service.IProductService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
@Validated
public class ProductController {
    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addProduct(@Valid @RequestBody ProductDto productDto) {

        long productId = iProductService.addProduct(productDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("Product added successfully. Product Id : " + Long.toString(productId), 201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") long productId) {

        ProductDto productDto = iProductService.getProductById(productId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productDto);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ProductDto>> getProductsByPrice(@RequestParam("type") String type,
                                                               @RequestParam(value = "min") BigDecimal price,
                                                               @RequestParam(value = "max", required = false) BigDecimal max) {
        List<ProductDto> productDto = null;

        switch (type.toLowerCase()) {
            case "between" -> productDto = iProductService.getProductsBetweenPrice(price, max);
            case "lower" -> productDto = iProductService.getProductsLowerPrice(price);
            case "higher" -> productDto = iProductService.getProductsHigherPrice(price);
            default -> {
                return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
            }

        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productDto);
    }

    @PutMapping("/reduceStock/{id}")
    public ResponseEntity<Void> reduceStockById(@PathVariable("id") long productId,
                                                @RequestParam int quantity) {

        iProductService.reduceStockById(productId, quantity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteProductById(@PathVariable("id") long productId) {

       iProductService.deleteProductById(productId);

       return ResponseEntity
               .status(HttpStatus.OK)
               .body(new ResponseDto("Product deleted successfully", 200));
    }
}
