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
public class ImageDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageData;

    public ImageDto(String imageData, String name){
        this.imageData = imageData;
        this.name = name;
    }
}
