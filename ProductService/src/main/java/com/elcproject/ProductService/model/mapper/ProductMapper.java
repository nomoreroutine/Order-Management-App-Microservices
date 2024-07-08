package com.elcproject.ProductService.model.mapper;

import com.elcproject.ProductService.model.entity.Product;
import com.elcproject.ProductService.model.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static Product mapProductDtoToProduct (ProductDto productDto) {

        Product product = new Product();

        product.setProductId(productDto.getProductId());
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());
        product.setAvailability(productDto.getStock() > 0);
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setManufacturer(productDto.getManufacturer());

        return product;
    }

    public static ProductDto mapProductToProductDto(Product product) {

        ProductDto productDto = new ProductDto();

        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setStock(product.getStock());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setManufacturer(product.getManufacturer());

        return productDto;
    }

    public static List<ProductDto> mapProductsToProductDTOs(List<Product> products) {
        return products.stream()
                .map(ProductMapper::mapProductToProductDto)
                .collect(Collectors.toList());
    }
}
