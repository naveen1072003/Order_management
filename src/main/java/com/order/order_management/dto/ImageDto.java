package com.order.order_management.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class imageDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(length = 100000)
    private byte[] imageData;

    public imageDto(byte[] imageData,String name){
        this.imageData = imageData;
        this.name = name;
    }
}
