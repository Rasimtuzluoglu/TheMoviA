package com.raspel.movia.dto;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MovieDto {
private Long id;
    private String title;
    private String type;
    private double rating;
    private String recommendedBy;
    private String note;
    private Boolean rewatchable;
}
