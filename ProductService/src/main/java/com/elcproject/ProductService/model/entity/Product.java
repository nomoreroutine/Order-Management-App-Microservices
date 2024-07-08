package com.elcproject.ProductService.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "PRODUCTS")
@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "price", precision = 12, scale = 3)
    private BigDecimal price;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "description")
    private String description;

}
