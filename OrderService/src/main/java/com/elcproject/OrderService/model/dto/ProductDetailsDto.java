package com.elcproject.OrderService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailsDto {

    private long productId;

    private String name;

    private long price;

    private String manufacturer;

    private String description;
}
