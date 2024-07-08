package com.elcproject.ProductService.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private long productId;

    @NotEmpty(message = "Name is required")
    private String name;

    @PositiveOrZero(message = "Stock should be equal or greater than zero")
    private int stock;

    @Positive(message = "Price must be greater than zero")
    private BigDecimal price;

    @NotEmpty(message = "Manufacturer is required")
    private String manufacturer;

    private String description;
}
